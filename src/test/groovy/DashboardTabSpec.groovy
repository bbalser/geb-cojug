import geb.spock.GebReportingSpec
import pages.DashboardPage
import pages.LoginPage
import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class DashboardTabSpec extends GebReportingSpec {

    @Shared DashboardPage dashboardPage

    def "information tab should be visible by default"() {
        given:
        LoginPage loginPage = to(LoginPage)

        when:
        dashboardPage = loginPage.login()

        then:
        dashboardPage.informationTab().isVisible()
    }

    def "search tab should be visible when selected"() {
        when:
        dashboardPage.searchTab().select()

        then:
        dashboardPage.searchTab().isVisible()
    }

    def "logout tab should be visible when selected"() {
        when:
        dashboardPage.logoutTab().select()

        then:
        dashboardPage.logoutTab().isVisible()
    }

    def "information tab should be visible when selected"() {
        when:
        dashboardPage.informationTab().select()

        then:
        dashboardPage.informationTab().isVisible()
    }

}
