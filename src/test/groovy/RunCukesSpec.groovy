import cucumber.api.junit.Cucumber
import geb.junit4.GebReportingTest
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = ["pretty", "html:build/cucumber-html-report"],
        glue = ['features/steps','features/support'],
        features = 'features'
)
class RunCukesSpec extends GebReportingTest {
}