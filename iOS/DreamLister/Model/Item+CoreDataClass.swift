//
//  Item+CoreDataClass.swift
//  DreamLister
//
//  Created by robot on 5/7/21.
//  Copyright © 2021 robot. All rights reserved.
//
//

import Foundation
import CoreData

@objc(Item)
public class Item: NSManagedObject {
    public override func awakeFromInsert() {
        
        super.awakeFromInsert();
        self.created = Date();
    }
}
