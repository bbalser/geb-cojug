package pages

import geb.Page

class LoginPage extends Page {

    static url = 'login/index'
    static at = { title == 'Login' }

    static content = {
        loginForm { $('form', name:"loginForm") }
        loginButton(to: [LoginFailurePage, DashboardPage]) { $('input', type:'submit') }
    }

}
