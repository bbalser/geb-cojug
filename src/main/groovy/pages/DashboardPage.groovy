package pages

import geb.Page
import modules.JqueryUITab

class DashboardPage extends Page {

    static url = "dashboard/index"
    static at = { title == 'Dashboard' }

    static content = {
        logoutButton(wait: true) { $('#logout-button') }

        informationTab(wait: true) { module JqueryUITab, tabId: 'tab-info' }
        searchTab(wait: true) { module JqueryUITab, tabId: 'tab-search' }
        logoutTab(wait: true) { module JqueryUITab, tabId: 'tab-logout' }
    }

}