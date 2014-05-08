package pages

import geb.Page

class DashboardPage extends Page {

    static url = "dashboard/index"
    static at = { title == 'Dashboard' }

    static content = {
        logoutButton(wait: true) { $('#logout-button') }

        tabLink(wait: true) { tabId -> $('a.ui-tabs-anchor', href: endsWith(tabId)) }
        tabBody(wait: true) { tabId -> $("div#${tabId}") }

        informationTabLink(wait: true) { tabLink('tab-info') }
        informationTabBody(wait: true) { tabBody('tab-info') }

        searchTabLink(wait: true) { tabLink('tab-search') }
        searchTabBody(wait: true) { tabBody('tab-search') }

        logoutTabLink { tabLink('tab-logout') }
        logoutTabBody { tabLink('tab-logout') }
    }

}