import geb.spock.GebReportingSpec
import pages.DashboardPage
import pages.LoginPage
import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class DashboardSpec extends GebReportingSpec {

    @Shared DashboardPage dashboardPage
    @Shared String title = "New Title ${System.currentTimeMillis()}"

    def "add article should save an article"() {
        given:
        dashboardPage = to(LoginPage).login()
        dashboardPage.searchTab().select()
        dashboardPage.openArticleEditor()

        when:
        dashboardPage.saveArticle([title: title, author: 'Larry', text: 'txt to phone', date: '2014-05-13'])

        then:
        waitFor { !dashboardPage.isArticleEditorOpen() }
        waitFor { dashboardPage.findArticle { it.title == title } }
    }

    def "search article should find article by title"() {
        given:
        dashboardPage = to(DashboardPage)
        dashboardPage.searchTab().select()

        when:
        dashboardPage.search(title)

        then:
        waitFor { dashboardPage.findArticle { it.title == title} }
    }

    def "edit article should save changes to article"() {
        given:
        dashboardPage.findArticle { it.title == title }.edit()
        def modifiedTitle = "Edit Title ${System.currentTimeMillis()}"

        when:
        dashboardPage.saveArticle([title: modifiedTitle])

        then:
        waitFor { dashboardPage.findArticle { it.title == modifiedTitle} }
    }

}
