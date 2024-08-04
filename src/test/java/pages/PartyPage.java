package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PartyPage {
    SelenideElement textArea = $("textarea"),
            sendButton = $(".send-chat"),
            containerField = $(".container-fluid");

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
}
