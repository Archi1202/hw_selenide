package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void verifySoftAssertsWithJUnit5CodeTest(){

        String JUnit5Code = """
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
                .filterBy(text("SoftAssertions"))
                .first()
                .shouldBe(visible);
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $$("div.highlight.highlight-source-java")
                .filter(Condition.text("@ExtendWith"))
                .first()
                .shouldHave(text(JUnit5Code));
    }


}
