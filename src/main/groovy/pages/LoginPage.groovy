package pages

import geb.Page

class LoginPage extends Page {

    static url = 'login/index'
    static at = { title == 'Login' }

    static content = {
        loginForm { $('form', name:"loginForm") }
        loginButton(to: [LoginFailurePage, DashboardPage]) { $('input', type:'submit') }
    }

    def login() {
        login('bbalser','password')
    }

    def login(username, password) {
        loginForm.username = username
        loginForm.password = password
        loginButton.click()

        browser.page
    }

}
