package pages

import geb.Page

class LoginFailurePage extends Page {

    static url = "login/login"
    static at = {
        title == 'Login' && errorDiv.text() == "Invalid Username or Password"
    }

    static content = {
        errorDiv { $('div.errors') }
    }

}
