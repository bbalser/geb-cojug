import geb.junit4.GebReportingTest
import org.junit.Before
import org.junit.Test
import pages.DashboardPage
import pages.LoginPage

class DashboardTests extends GebReportingTest {

    @Before
    void setUp() {
        to(LoginPage).login()
    }

    @Test
    void addArticleShouldSaveArticle() {
        at DashboardPage

        searchTab.select()
        addArticleButton.click()

        articleForm.title = "New Title"
        articleForm.author = "Larry"
        articleForm.text = "txt to phone"
        articleForm.date = "2012-08-02"
        articleDialog.ok()

        waitFor { !articleDialog.isVisible() }

        waitFor { articleRows.find { it.title == 'New Title' } }
    }

}
