import geb.junit4.GebReportingTest
import org.junit.Before
import org.junit.Test
import pages.DashboardPage
import pages.LoginFailurePage
import pages.LoginPage

class LoginTests extends GebReportingTest {

    LoginPage loginPage

    @Before
    void setUp() {
        loginPage = to LoginPage
    }

    @Test
    void badLoginShouldSendUserToLoginFailurePage() {
        loginPage.login('chucky', 'chucky')

        at LoginFailurePage
    }

    @Test
    void goodLoginShouldSendUserToDashboard() {
        loginPage.login('bbalser', 'password')

        at DashboardPage
    }

    @Test
    void logoutShouldReturnUserToLoginPage() {
        DashboardPage dashboard = loginPage.login()
        dashboard.logout()

        at LoginPage
    }

}
