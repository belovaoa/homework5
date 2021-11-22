package com.github.belovaoa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    SelenideElement requestInput = $(".header-search-input");

    @Test
    public void testGithub() {
        open("https://github.com");
        requestInput.click();
        requestInput.sendKeys("eroshenkoam/allure-example");
        requestInput.submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#68")).should(Condition.visible);
    }
}
