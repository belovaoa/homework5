package com.github.belovaoa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepAnnotatedTest {
    SelenideElement requestInput = $(".header-search-input");

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            requestInput.click();
            requestInput.sendKeys(REPOSITORY);
            requestInput.submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
           $(linkText("eroshenkoam/allure-example")).click();
       });
        step("Открываем таб Issues", () -> {
           $(partialLinkText("Issues")).click();
       });
        step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
