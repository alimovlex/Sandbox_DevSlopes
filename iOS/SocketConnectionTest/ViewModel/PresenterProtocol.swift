//
//  PresenterProtocol.swift
//  SocketConnectionTest
//
//  Created by alimovlex on 30/03/18.
//  Copyright © 2021 alimovlex. All rights reserved.
//

import Foundation

protocol PresenterProtocol: class {
    
    func resetUIWithConnection(status: Bool)
    func updateStatusViewWith(status: String)
    func update(message: String)
}
