package ui.tests;

import common.data.DataGeneration;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.PartyPage;

@Tag("web")
@Owner("Овсянников Александр")
@Feature("Party")
@DisplayName("UI: Тесты для страницы команды")
public class PartyTests extends TestBaseUi {
    DataGeneration data = new DataGeneration();
    PartyPage partyPage = new PartyPage();

    @Test
    @WithLogin
    @DisplayName("UI: Проверка отправки сообщения в чат команды")
    void sendingAMessageToTeamChatTest() {
        String message = data.getMessage();
        partyPage.openPartyPage()
                .enteringAMessageInChat(message)
                .clickSendButton()
                .checkPartyChat(message);
    }
}
