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

        searchForm(wait: true) { searchTab.body().find('#searchForm') }
        searchButton(wait: true) { searchForm.find('input', type: 'submit') }
    }

    JqueryUITab informationTab() {
        informationTab
    }

    JqueryUITab searchTab() {
        searchTab
    }

    JqueryUITab logoutTab() {
        logoutTab
    }

    def openArticleEditor() {
        addArticleButton.click()
    }

    boolean isArticleEditorOpen() {
        articleDialog.isVisible()
    }

    ArticleRow findArticle(Closure closure) {
        articleRows.find(closure)
    }

    List<ArticleRow> articles() {
        articleRows
    }

    def saveArticle(Map params) {
        params.each { name, value ->
            articleForm[name] = value
        }
        articleDialog.ok()
    }

    def logout() {
        logoutTab().select()
        logoutButton.click()

        browser.page
    }

    def search(String searchTerm) {
        searchForm.searchTerm = searchTerm
        searchButton.click()
    }


}

class ArticleRow extends Module {

    static content = {
        title { $('td',0).find('a').text() }
        author { $('td',1).text() }
        date { $('td', 2).text() }
        editLink { $('a') }
    }

    def edit() {
        editLink.click()
    }

}