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

        assert informationTab.isVisible()
    }

    @Test
    void searchTabCanBeClickedToMakeVisible() {
        at DashboardPage
        searchTab.select()

        assert searchTab.isVisible()
    }

    @Test
    void logoutTabCanBeClickedToMakeVisible() {
        at DashboardPage
        logoutTab.select()

        assert logoutTab.isVisible()
    }

    @Test
    void informationTabCanBeClickedToMakeVisible() {
        at DashboardPage
        informationTab.select()

        assert informationTab.isVisible()
    }

}
