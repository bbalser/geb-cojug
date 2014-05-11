package support

import geb.Browser
import geb.binding.BindingUpdater
import org.openqa.selenium.chrome.ChromeDriver

this.metaClass.mixin(cucumber.api.groovy.Hooks)

BindingUpdater bindingUpdater

Before("@web") {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
}

After("@web") {
    bindingUpdater.remove()
}