package pages

import geb.Module
import geb.Page
import modules.JqueryUIDialog
import modules.JqueryUITab

class DashboardPage extends Page {

    static url = "dashboard/index"
    static at = { title == 'Dashboard' }

    static content = {
        logoutButton(wait: true) { $('#logout-button') }

        informationTab(wait: true) { module JqueryUITab, tabId: 'tab-info' }
        searchTab(wait: true) { module JqueryUITab, tabId: 'tab-search' }
        logoutTab(wait: true) { module JqueryUITab, tabId: 'tab-logout' }

        addArticleButton(wait: true) { $('#add-article-button') }
        articleForm(wait: true) { $('#articleForm') }

        articleDialog(wait: true) { module JqueryUIDialog, dialogId: 'article-dialog' }

        articleLink(wait: true) { id -> $("#article-${id}") }
        articleRows(wait: true) { moduleList ArticleRow, $('table.search-results tr').has('td') }

    }

}

class ArticleRow extends Module {

    static content = {
        title { $('td',0).find('a').text() }
        author { $('td',1).text() }
        date { $('td', 2).text() }
    }

}