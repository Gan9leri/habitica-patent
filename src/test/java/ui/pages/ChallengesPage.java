package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChallengesPage {

    private final SelenideElement ownerOfChallenge = $(".owner");

    @Step("Открытие страницы испытаний")
    public ChallengesPage openChallengePage() {
        open("/challenges/myChallenges");
        return this;
    }

    @Step("Проверка владельца испытания")
    public ChallengesPage checkOwnerOfChallenge(String name) {
        ownerOfChallenge.shouldHave(text(name));
        return this;
    }
}
