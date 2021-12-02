package tst

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeAll

abstract class Base {

    @BeforeAll
    fun setup() {
        Configuration.browser = "chrome"
        Configuration.remote = "https://host-selenoid"
        Configuration.browserVersion = "94.0"
        Configuration.headless = true
        Configuration.browserCapabilities.setCapability("font-render-hinting", "none")
    }
}