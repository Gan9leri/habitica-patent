package ui.tests;

import common.config.AuthConfig;
import common.data.DataGeneration;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
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
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

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

    @Test
    @WithLogin
    @DisplayName("UI: Проверка работы кнопки Щит")
    void shieldButtonTest(){
        partyPage.openPartyPage()
                 .buttonShieldClick()
                 .checkNameInProfile(authConfig.login());
    }

    @Test
    @WithLogin
    @DisplayName("UI: Проверка лидера команды")
    void checkLeaderPartyTest(){
        partyPage.openPartyPage()
                 .checkLeaderName(authConfig.login())
                 .leaderProfileOpen()
                 .checkNameInProfile(authConfig.login());
    }
}
