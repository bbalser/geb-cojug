import geb.junit4.GebReportingTest
import org.junit.Before
import org.junit.Test
import pages.DashboardPage
import pages.LoginPage

class DashboardTabsTests extends GebReportingTest {

    @Before
    void setUp() {
        to(LoginPage).login()
    }

    @Test
    void informationTabShouldBeDefault() {
        at DashboardPage

        assert informationTabBody.displayed
    }

    @Test
    void searchTabCanBeClickedToMakeVisible() {
        at DashboardPage
        searchTabLink.click()

        assert searchTabBody.displayed
    }

    @Test
    void logoutTabCanBeClickedToMakeVisible() {
        at DashboardPage
        logoutTabLink.click()

        assert logoutTabBody.displayed
    }

    @Test
    void informationTabCanBeClickedToMakeVisible() {
        at DashboardPage
        informationTabLink.click()

        assert informationTabBody.displayed
    }

}
