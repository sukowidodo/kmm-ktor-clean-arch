//
// Created by Suko Widodo on 10/5/22.
// Copyright (c) 2022 sukowidodo.com. All rights reserved.
//

import SwiftUI
import shared

struct LoginView: View {
    @ObservedObject var loginViewModel: LoginViewModel

    @State
    private var email: String = ""

    @State
    private var password: String = ""

    var body: some View {
        VStack {
            HStack {
                Text("Email")
                Spacer()
            }.padding(EdgeInsets(top: 0, leading: 10, bottom: 0, trailing: 10))
            TextField("email", text:$email)
                    .textFieldStyle(RoundedBorderTextFieldStyle())
                    .padding(EdgeInsets(top: 0, leading: 10, bottom: 0, trailing: 10))
            HStack {
                Text("Password")
                Spacer()
            }.padding(EdgeInsets(top: 0, leading: 10, bottom: 0, trailing: 10))
            SecureField("email", text:$password)
                    .textFieldStyle(RoundedBorderTextFieldStyle())
                    .padding(EdgeInsets(top: 0, leading: 10, bottom: 0, trailing: 10))
            Button("Send", action: {
                loginViewModel.doLogin(email: email, password: password)

            })
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView(loginViewModel: LoginViewModel())
    }
}