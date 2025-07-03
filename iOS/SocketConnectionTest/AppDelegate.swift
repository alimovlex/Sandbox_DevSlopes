//
//  AppDelegate.swift
//  SocketConnectionTest
//  Created by alimovlex on 30/03/18.
//  Copyright © 2021 alimovlex. All rights reserved.

import UIKit
import CoreData

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

     func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
            // Override point for customization after application launch.
            return true
        }
    
    func applicationWillResignActive(_ application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(_ application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
    }

    func applicationWillEnterForeground(_ application: UIApplication) {
        // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(_ application: UIApplication) {
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(_ application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }

        var window: UIWindow?;
        
        // MARK: - Core Data stack
        @available(iOS 10.0, *)
        lazy var persistentContainer: NSPersistentContainer = {
            //goalpost.xcdatamodeld  The name of the CoreData model
            let container = NSPersistentContainer(name: "DreamLister")
            container.loadPersistentStores(completionHandler: { (storeDescription, error) in
                if let error = error as NSError? {
                    fatalError("Unresolved error \(error), \(error.userInfo)")
                }
            })
            return container
        }()
        //iOS 9 coredata
        lazy var applicationDocumentsDirectory: URL = {
               let urls = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
               return urls[urls.count-1]
           }()

           lazy var managedObjectModel: NSManagedObjectModel = {
               //goalpost.xcdatamodeld  The name of the CoreData model
               let modelURL = Bundle.main.url(forResource: "DreamLister", withExtension: "momd")!
               return NSManagedObjectModel(contentsOf: modelURL)!
           }()

           lazy var persistentStoreCoordinator: NSPersistentStoreCoordinator = {
               let coordinator = NSPersistentStoreCoordinator(managedObjectModel: self.managedObjectModel)
               //goalpost.xcdatamodeld  The name of the CoreData model
               let url = self.applicationDocumentsDirectory.appendingPathComponent("DreamLister.sqlite")
               var failureReason = "There was an error creating or loading the application's saved data."
               do {
                   try coordinator.addPersistentStore(ofType: NSSQLiteStoreType, configurationName: nil, at: url, options: nil)
               } catch {
                   var dict = [String: AnyObject]()
                   dict[NSLocalizedDescriptionKey] = "Failed to initialize the application's saved data" as AnyObject?
                   dict[NSLocalizedFailureReasonErrorKey] = failureReason as AnyObject?

                   dict[NSUnderlyingErrorKey] = error as NSError
                   let wrappedError = NSError(domain: "YOUR_ERROR_DOMAIN", code: 9999, userInfo: dict)
                   NSLog("Unresolved error \(wrappedError), \(wrappedError.userInfo)")
                   abort()
               }

               return coordinator
           }()

           lazy var managedObjectContext: NSManagedObjectContext = {
               let coordinator = self.persistentStoreCoordinator
               var managedObjectContext = NSManagedObjectContext(concurrencyType: .mainQueueConcurrencyType)
               managedObjectContext.persistentStoreCoordinator = coordinator
               managedObjectContext.mergePolicy = NSMergeByPropertyObjectTrumpMergePolicy
               return managedObjectContext
           }()

        // MARK: - Core Data Saving support
        func saveContext () {
            if #available(iOS 10.0, *) {
                let context = persistentContainer.viewContext
                if context.hasChanges {
                    do {
                        try context.save()
                    } catch {
                        let nserror = error as NSError
                        fatalError("Unresolved error \(nserror), \(nserror.userInfo)")
                    }
                }
            } else {
                if managedObjectContext.hasChanges {
                    do {
                        try managedObjectContext.save()
                    } catch {
                        let nserror = error as NSError
                        NSLog("Unresolved error \(nserror), \(nserror.userInfo)")
                        abort()
                    }
                }
            }
        }

    }

    let ad = UIApplication.shared.delegate as! AppDelegate;

    var context: NSManagedObjectContext {
        if #available(iOS 10.0, *) {
        return ad.persistentContainer.viewContext;
        } else {
        return ad.managedObjectContext;
        }

}

