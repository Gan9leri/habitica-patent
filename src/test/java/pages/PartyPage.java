package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PartyPage {

    SelenideElement textArea = $("textarea[placeholder='Введите здесь сообщение для членов команды']"),
                    sendButton = $(byTagAndText("button", "Отправить")),
                    containerField = $(".container-fluid");

    @Step("Открытие страницы с командой")
    public PartyPage openPartyPage(){
        open("/party");
        return this;
    }

    @Step("Ввод сообщения в чат")
    public PartyPage enteringAMessageInChat(String value){
        textArea.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку Отправить")
    public PartyPage sendingAMessage(){
        sendButton.click();
        return this;
    }

    @Step("Проверка, что сообщение отправлено")
    public PartyPage checkPartyChat(String value){
        containerField.shouldHave(text(value));
        return this;
    }
}
