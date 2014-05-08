package pages

import geb.Page

class DashboardPage extends Page {

    static url = "dashboard/index"
    static at = { title == 'Dashboard' }

    static content = {
        logoutTabLink { $('#ui-id-3') }
        logoutButton(wait: true) { $('#logout-button') }
    }

}