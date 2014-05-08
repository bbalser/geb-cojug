import geb.junit4.GebReportingTest
import org.junit.Before
import org.junit.Test
import pages.DashboardPage
import pages.LoginPage

class DashboardTabsTests extends GebReportingTest {

    DashboardPage dashboard

    @Before
    void setUp() {
        dashboard = to(LoginPage).login()
    }

    @Test
    void informationTabShouldBeDefault() {
        assert dashboard.informationTab().isVisible()
    }

    @Test
    void searchTabCanBeClickedToMakeVisible() {
        dashboard.searchTab().select()

        assert dashboard.searchTab().isVisible()
    }

    @Test
    void logoutTabCanBeClickedToMakeVisible() {
        dashboard.logoutTab().select()

        assert dashboard.logoutTab().isVisible()
    }

    @Test
    void informationTabCanBeClickedToMakeVisible() {
        dashboard.informationTab().select()

        assert dashboard.informationTab().isVisible()
    }

}
