import SwiftUI
import shared

struct ContentView: View {

	@StateObject var loginViewModel = LoginViewModel()

	var body: some View {
		if loginViewModel.isLoggedIn {
			DashboardView()
		} else {
			LoginView(loginViewModel: loginViewModel)
		}
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
