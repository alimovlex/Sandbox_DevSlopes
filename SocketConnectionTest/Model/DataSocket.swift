//
//  DataSocket.swift
//  SocketConnectionTest
//
//  Created by alimovlex on 30/03/18.
//  Copyright © 2021 alimovlex. All rights reserved.
//

import Foundation

struct DataSocket {
    
    let ipAddress: String!
    let port: Int!
    
    init(ip: String, port: String){        
        self.ipAddress = ip
        self.port      = Int(port)
    }
}
