package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterpriseTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }
    @Test
    void verifyEnterpriseLinkTest(){
        open("/");

        $(".HeaderMenu-wrapper").$(byText("Solutions")).hover();
        $(By.linkText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
