package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenSoftAssertionsInWikiTest {
    String jUnit5CodeExample = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";
    @Test
    void openSoftAssertionsInWiki() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#js-repo-pjax-container").shouldHave(text("Soft assertions"));
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#repo-content-pjax-container").shouldHave(text(jUnit5CodeExample));
    }
}
