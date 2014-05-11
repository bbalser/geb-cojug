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
        def title = "New Title ${System.currentTimeMillis()}"
        dashboard.saveArticle([title: title, author: 'Larry', text: 'txt to phone', date: '2014-05-13'])

        waitFor { !dashboard.isArticleEditorOpen() }
        waitFor { dashboard.findArticle { it.title == title } }
    }

    @Test
    void searchArticleShouldFindArticleByTitle() {
        dashboard.searchTab().select()
        dashboard.openArticleEditor()
        def title = "Search Title ${System.currentTimeMillis()}"
        dashboard.saveArticle([title: title, author: 'Larry', text: 'txt to phone', date: '2014-05-13'])

        dashboard.search(title)

        waitFor { dashboard.findArticle { it.title == title } }
    }

    @Test
    void editTest() {
        dashboard.searchTab().select()
        dashboard.openArticleEditor()
        def title = "Edit Title ${System.currentTimeMillis()}"
        dashboard.saveArticle([title: title, author: 'Larry', text: 'txt to phone', date: '2014-05-13'])

        dashboard.articles()[0].edit()

        def modifiedTitle = title.replaceFirst('Edit', 'Edit2')
        dashboard.saveArticle([title: modifiedTitle])

        waitFor { dashboard.findArticle { it.title == modifiedTitle } }
    }


}
