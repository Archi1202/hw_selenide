package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class EnterprizeTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void navigateToEnterprizeTest(){
        open("https://github.com");

        $(".details-overlay.summary").hover();

        // Click on the 'Enterprise' option
        $("a[href*='/enterprise']").click();

        $("h1").shouldHave(Condition.text("The AI-powered developer platform"));
    }
}
