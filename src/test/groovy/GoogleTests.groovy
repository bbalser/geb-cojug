import geb.Page
import geb.junit4.GebReportingTest
import org.junit.Test

class GoogleTests extends GebReportingTest {

    @Test
    void searchForGrailsShouldReturnGrailsHomePageFirst() {

        to GoogleHomePage
        at GoogleHomePage

        searchField.value("grails\n")
        at GoogleSearchResultsPage
        searchResults(0).click()

        at GrailsHomePage
    }

}

class GoogleHomePage extends Page {

    static url = 'http://google.com'
    static at = { waitFor { title == 'Google' } }

    static content = {
        searchField(wait: true) { $('input', name: 'q') }
    }
}


class GoogleSearchResultsPage extends Page {
    static at = { waitFor(20) { title.endsWith('Google Search') } }

    static content = {
        searchResults(wait: true) { index -> $('li.g',index).find('a',0) }
    }
}

class GrailsHomePage extends Page {
    static url = "http://grails.org"
    static at = { waitFor { title.startsWith('Grails') } }
}