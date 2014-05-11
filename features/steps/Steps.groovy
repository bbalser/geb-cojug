import pages.DashboardPage
import pages.LoginPage

this.metaClass.mixin(cucumber.api.groovy.EN)

def timeInMillis

def getActualTitle = { String title, boolean forceNew = false  ->
    if (!timeInMillis || forceNew) {
        timeInMillis = System.currentTimeMillis()
    }
    title + timeInMillis
}

Given(~"navigate to (.+)") { Class page ->
    to page
}

Given(~"select (.+)") { String tabName ->
    DashboardPage dashboardPage = to(LoginPage).login()
    dashboardPage."${tabName}"().select()
}

When(~"login attempt with (.+),\\s*(.+)") { String username, String password ->
    LoginPage loginPage = browser.page
    loginPage.login(username, password)
}

When(~"click logout button") { ->
    DashboardPage dashboardPage = browser.page
    dashboardPage.logout()
}

When(~"add article (.+), (.+), (.+), (.+)") { String title, String author, String text, String date ->
    DashboardPage dashboardPage = browser.page
    dashboardPage.openArticleEditor()
    dashboardPage.saveArticle([title: getActualTitle(title, true), author: author, text: text, date: date])
}

When(~"search by title (.+)") { String title ->
    DashboardPage dashboardPage = browser.page
    dashboardPage.search(getActualTitle(title))
}

When(~"edit article with title (.+)") { String title ->
    DashboardPage dashboardPage = browser.page
    dashboardPage.findArticle { it.title == getActualTitle(title) }.edit()
}

When(~"update title to (.+)") { String title ->
    DashboardPage dashboardPage = browser.page
    dashboardPage.saveArticle([title: getActualTitle(title)])
}

Then(~"current page is (.+)") { Class page ->
    at page
}

Then(~"find article with title (.+)") { String title ->
    DashboardPage dashboardPage = browser.page
    waitFor { dashboardPage.findArticle { it.title == getActualTitle(title) } }
}
