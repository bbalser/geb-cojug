import geb.Browser
import org.junit.Test

class SimpleGoogleTests {

    @Test
    void searchForGrailsShouldReturnGrailsHomePageFirst() {

        Browser.drive {
            go 'http://google.com'

            assert title == 'Google'

            $('input', name: 'q').value("grails\n")

            waitFor(20) { title.endsWith("Google Search") }

            waitFor(20) { $('li.g',0).find('a',0) }

            def firstLink = $("li.g", 0).find('a',0)

            firstLink.click()

            waitFor(20) { title.startsWith("Grails") }

        }

    }

}
