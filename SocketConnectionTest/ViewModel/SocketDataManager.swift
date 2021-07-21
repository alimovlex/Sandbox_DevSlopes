//
//  SocketDataManager.swift
//  SocketConnectionTest
//
//  Created by anoop mohanan on 30/03/18.
//  Copyright © 2018 com.anoopm. All rights reserved.
//

import Foundation
import CoreBluetooth

class SocketDataManager: NSObject, StreamDelegate, CBCentralManagerDelegate, CBPeripheralDelegate {
    
    var readStream: Unmanaged<CFReadStream>?
    var writeStream: Unmanaged<CFWriteStream>?
    var inputStream: InputStream?
    var outputStream: OutputStream?
    var messages = [AnyHashable]()
    weak var uiPresenter :PresenterProtocol!
    
    var centralManager: CBCentralManager!;
    var peripheral: CBPeripheral!;
    
    let DEVICE_SERVICE_UUID = CBUUID.init(string: "16916abb-f6c0-4a82-ed4e-481d439c8102");
    
    init(with presenter:PresenterProtocol) {
        super.init();
        centralManager = CBCentralManager(delegate: self, queue: nil);
        self.uiPresenter = presenter
    }
    func connectWith(socket: DataSocket) {

        CFStreamCreatePairWithSocketToHost(kCFAllocatorDefault, (socket.ipAddress! as CFString), UInt32(socket.port), &readStream, &writeStream)
        messages = [AnyHashable]()
        open()
    }
    
    func disconnect(){
        
        close()
    }
    
    func open() {
        print("Opening streams.")
        outputStream = writeStream?.takeRetainedValue()
        inputStream = readStream?.takeRetainedValue()
        outputStream?.delegate = self
        inputStream?.delegate = self
        outputStream?.schedule(in: RunLoop.current, forMode: RunLoop.Mode.default)
        inputStream?.schedule(in: RunLoop.current, forMode: RunLoop.Mode.default)
        outputStream?.open()
        inputStream?.open()
    }
    
    func close() {
        print("Closing streams.")
        uiPresenter?.resetUIWithConnection(status: false)
        inputStream?.close()
        outputStream?.close()
        inputStream?.remove(from: RunLoop.current, forMode: RunLoop.Mode.default)
        outputStream?.remove(from: RunLoop.current, forMode: RunLoop.Mode.default)
        inputStream?.delegate = nil
        outputStream?.delegate = nil
        inputStream = nil
        outputStream = nil
    }
    
    func stream(_ aStream: Stream, handle eventCode: Stream.Event) {
        print("stream event \(eventCode)")
        switch eventCode {
        case .openCompleted:
            uiPresenter?.resetUIWithConnection(status: true)
            print("Stream opened")
        case .hasBytesAvailable:
            if aStream == inputStream {
                var dataBuffer = Array<UInt8>(repeating: 0, count: 1024)
                var len: Int
                while (inputStream?.hasBytesAvailable)! {
                    len = (inputStream?.read(&dataBuffer, maxLength: 1024))!
                    if len > 0 {
                        let output = String(bytes: dataBuffer, encoding: .ascii)
                        if nil != output {
                            print("server said: \(output ?? "")")
                            messageReceived(message: output!)
                        }
                    }
                }
            }
        case .hasSpaceAvailable:
            print("Stream has space available now")
        case .errorOccurred:
            print("\(aStream.streamError?.localizedDescription ?? "")")
        case .endEncountered:
            aStream.close()
            aStream.remove(from: RunLoop.current, forMode: RunLoop.Mode.default)
            print("close stream")
            uiPresenter?.resetUIWithConnection(status: false)
        default:
            print("Unknown event")
        }
    }
    
    func messageReceived(message: String){
        
        uiPresenter?.update(message: "server said: \(message)")
        print(message)
    }
    
    func send(message: String){
        
        let response = "\(message.utf8)\n";
            outputStream?.write(response, maxLength: response.count)
    }

}

extension SocketDataManager {
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
           print("Central state update")
           if central.state != .poweredOn {
               print("Central is not powered on")
           } else {
               print("Central scanning for", DEVICE_SERVICE_UUID);
               centralManager.scanForPeripherals(withServices: [DEVICE_SERVICE_UUID],
                                                 options: [CBCentralManagerScanOptionAllowDuplicatesKey : true])
           }
       }
       
       // Handles the result of the scan
       func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String : Any], rssi RSSI: NSNumber) {
           
           // We've found it so stop scan
           self.centralManager.stopScan()
           
           // Copy the peripheral instance
           self.peripheral = peripheral
           self.peripheral.delegate = self
           
           // Connect!
           self.centralManager.connect(self.peripheral, options: nil)
           
       }
       
       // The handler if we do connect succesfully
       func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {
           if peripheral == self.peripheral {
               print("Connected to BLE device")
               peripheral.discoverServices([DEVICE_SERVICE_UUID]);
           }
       }
       
       func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral, error: Error?) {
           if peripheral == self.peripheral {
               print("Disconnected");
               self.peripheral = nil;
               // Start scanning again
               print("Central scanning for", DEVICE_SERVICE_UUID);
               centralManager.scanForPeripherals(withServices: [DEVICE_SERVICE_UUID],
                                                 options: [CBCentralManagerScanOptionAllowDuplicatesKey : true]);
           }
       }
       
       // Handles discovery event
       func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {
           if let services = peripheral.services {
               for service in services {
                   if service.uuid == DEVICE_SERVICE_UUID {
                       print("LED service found")
                       //Now kick off discovery of characteristics
                       peripheral.discoverCharacteristics([DEVICE_SERVICE_UUID], for: service)
                   }
               }
           }
       }
}
