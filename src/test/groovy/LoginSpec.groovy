import geb.spock.GebReportingSpec
import pages.DashboardPage
import pages.LoginFailurePage
import pages.LoginPage
import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebReportingSpec {

    @Shared LoginPage loginPage
    @Shared DashboardPage dashboardPage

    def "good login should land user on DashboardPage"() {
        given:
        loginPage = to(LoginPage)

        when:
        dashboardPage = loginPage.login('bbalser', 'password')

        then:
        at DashboardPage
    }

    def "logout should return user to LoginPage"() {
        given:
        dashboardPage.logoutTab().select()

        when:
        dashboardPage.logout()

        then:
        at LoginPage
    }

    def "bad login should send user to LoginFailurePage"() {
        when:
        loginPage.login('chucky', 'chucky')

        then:
        at LoginFailurePage
    }

}
