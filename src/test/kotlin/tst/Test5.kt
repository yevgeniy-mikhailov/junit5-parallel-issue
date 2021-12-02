package tst

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@Tag("UI")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Test5 : Base() {

    @Test
    fun tst1() {
        Selenide.open("http://www.google.ru")
        Selenide.sleep(100)
    }
}