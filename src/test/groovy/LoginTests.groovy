import geb.junit4.GebReportingTest
import org.junit.Test
import pages.DashboardPage
import pages.LoginFailurePage
import pages.LoginPage

class LoginTests extends GebReportingTest {

    @Test
    void badLoginShouldSendUserToLoginFailurePage() {

        to LoginPage
        loginForm.username = 'chucky'
        loginForm.password = 'chucky'

        loginButton.click()

        at LoginFailurePage
    }

    @Test
    void goodLoginShouldSendUserToDashboard() {

        to LoginPage
        loginForm.username = 'bbalser'
        loginForm.password = 'password'

        loginButton.click()

        at DashboardPage
    }

    @Test
    void logoutShouldReturnUserToLoginPage() {

        to LoginPage
        loginForm.username = 'bbalser'
        loginForm.password = 'password'
        loginButton.click()
        at DashboardPage
        logoutTab.select()

        logoutButton.click()

        at LoginPage
    }

}
