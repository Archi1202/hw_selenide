package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void assertSelenidePageTest(){

        String JUnit5Code =
                """
                        @ExtendWith({SoftAssertsExtension.class})
                         class Tests {
                           @Test
                           void test() {
                             Configuration.assertionMode = SOFT;
                             open("page.html");
                         
                             $("#first").should(visible).click();
                             $("#second").should(visible).click();
                           }
                         }
                    """;

        open("/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("li.Box-row.wiki-more-pages")
                .filterBy(Condition.text("SoftAssertions"))
                .first()
                .shouldBe(Condition.visible);
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-body .highlight.highlight-source-java")
                .shouldHave(partialText(JUnit5Code.trim()));
    }


}
