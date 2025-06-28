package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprizePageTest {
    @Test
    void openEnterprizePage(){
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $(".HeaderMenu-nav")
                .$$("ul li").findBy(text("Solutions")).hover();
        $(".list-style-none").$(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
