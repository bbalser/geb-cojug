package modules

import geb.Module

class JqueryUITab extends Module {

    def tabId

    static content = {
        tabLink(wait: true) { $('a.ui-tabs-anchor', href: endsWith(tabId)) }
        tabBody(wait: true) { $("div#${tabId}") }
    }

    def select() {
        tabLink.click()
    }

    def isVisible() {
        tabBody.displayed
    }

    def body() {
        tabBody
    }

    def content() {
        tabBody.text()
    }
}
