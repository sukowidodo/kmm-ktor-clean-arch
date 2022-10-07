//
// Created by Suko Widodo on 10/5/22.
// Copyright (c) 2022 sukowidodo.com. All rights reserved.
//

import Foundation
import shared

class LoginViewModel: ObservableObject {
    @Published var isLoggedIn = false

    func doLogin(email: String, password: String) {
        AuthPresenterHelper().doLogin(email: email, password: password) { resp in
            if(resp.loading ?? false == true){
                //Loading
                debugPrint("Loading..")
            } else if(resp.data != nil){
                self.isLoggedIn = true
            } else {
                debugPrint(resp.message)
            }
        }
    }
}