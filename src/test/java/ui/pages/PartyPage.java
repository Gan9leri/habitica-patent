package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PartyPage {
    private final SelenideElement textArea = $("textarea"),
            sendButton = $(".send-chat"),
            containerField = $(".container-fluid"),
            shield = $(".shield"),
            characterName = $(".character-name"),
            leader = $(".leader");

    @Step("Открытие страницы с командой")
    public PartyPage openPartyPage() {
        open("/party");
        return this;
    }

    @Step("Ввод сообщения в чат")
    public PartyPage enteringAMessageInChat(String value) {
        textArea.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку Отправить")
    public PartyPage clickSendButton() {
        sendButton.click();
        return this;
    }

    @Step("Проверка чата")
    public PartyPage checkPartyChat(String value) {
        containerField.shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на Щит")
    public PartyPage buttonShieldClick(){
        shield.click();
        return this;
    }

    @Step("Проверка имени в профиле")
    public PartyPage checkNameInProfile(String value){
        characterName.shouldHave(text(value));
        return this;
    }

    @Step("Проверка имени лидера команды")
    public PartyPage checkLeaderName(String value){
        leader.shouldHave(text(value));
        return this;
    }

    @Step("Открытие профиля лидера команды")
    public PartyPage leaderProfileOpen(){
        leader.click();
        return this;
    }
}
