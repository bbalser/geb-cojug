
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    new FirefoxDriver()
}

reportsDir = "build/geb-reports"

waiting {
    timeout = 10
    retryInterval = 0.5
}

baseUrl = "http://localhost:8080/geb-examples/"


environments {

    chrome {
        driver = { new ChromeDriver() }
    }

    firefox {
        driver = { new FirefoxDriver() }
    }

    phantomjs {
        driver = { new PhantomJSDriver(new DesiredCapabilities()) }
    }

}