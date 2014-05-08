import geb.junit4.GebReportingTest
import org.junit.Before
import org.junit.Test
import pages.DashboardPage
import pages.LoginPage

class DashboardTests extends GebReportingTest {

    DashboardPage dashboard

    @Before
    void setUp() {
        dashboard = to(LoginPage).login()
    }

    @Test
    void addArticleShouldSaveArticle() {
        dashboard.searchTab().select()
        dashboard.openArticleEditor()

        dashboard.saveArticle([title: 'New Title', author: 'Larry', text: 'txt to phone', date: '2014-05-13'])

        waitFor { !dashboard.isArticleEditorOpen() }
        waitFor { dashboard.findArticle { it.title == 'New Title' } }
    }

}
