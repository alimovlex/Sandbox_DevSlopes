//
//  ViewController.swift
//  SocketConnectionTest
//
//  Created by alimovlex on 30/03/18.
//  Copyright © 2021 alimovlex. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate{

    var socketConnector:SocketDataManager!
    @IBOutlet weak var ipAddressField: UITextField!
    @IBOutlet weak var portField: UITextField!
    @IBOutlet weak var messageField: UITextField!
    @IBOutlet weak var messageHistoryView: UITextView!
    @IBOutlet weak var connectBtn: UIButton!
    @IBOutlet weak var sendBtn: UIButton!
    @IBOutlet weak var statusView: UIView!
    @IBOutlet weak var statusLabl: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        socketConnector = SocketDataManager(with: self)
        resetUIWithConnection(status: false)
        let tap = UITapGestureRecognizer(target: view, action: #selector(UIView.endEditing));
        view.addGestureRecognizer(tap);
        messageField.delegate = self;
        portField.delegate = self;
        ipAddressField.delegate = self;
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    @IBAction func connect(){
        //http://localhost:50694/
        guard let ipAddr = ipAddressField.text, let portVal = portField.text  else {
            return
        }
        let soc = DataSocket(ip: ipAddr, port: portVal)
        socketConnector.connectWith(socket: soc)
        
    }
    @IBAction func send(){
        guard let msg = messageField.text else {
            return
        }
        send(message: msg)
        messageField.text = ""
    }
    func send(message: String){
        
        socketConnector.send(message: message)
        update(message: "me:\(message)")
    }
    
    
}

extension ViewController: PresenterProtocol{
    
    func resetUIWithConnection(status: Bool){
        
        ipAddressField.isEnabled = !status
        portField.isEnabled = !status
        messageField.isEnabled = status
        connectBtn.isEnabled = !status
        sendBtn.isEnabled = status
        
        if (status){
            updateStatusViewWith(status: "Connected")
        }else{
            updateStatusViewWith(status: "Disconnected")
        }
    }
    func updateStatusViewWith(status: String){
        
        statusLabl.text = status
    }
    
    func update(message: String){
        
        if let text = messageHistoryView.text{
            let newText = """
            \(text)            
            \(message)
            """
            messageHistoryView.text = newText
        }else{
            let newText = """
            \(message)
            """
            messageHistoryView.text = newText
        }

        let myRange=NSMakeRange(messageHistoryView.text.count-1, 0);
        messageHistoryView.scrollRangeToVisible(myRange)
    }
    
    //hiding the keyboard on return
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        switch textField {
        case ipAddressField:
            textField.resignFirstResponder();
            portField.becomeFirstResponder();
        case portField:
            textField.resignFirstResponder();
            connect();
            case messageField:
                textField.resignFirstResponder();
                send();
        default:
            break;
        }
     return true
    }

    
}

