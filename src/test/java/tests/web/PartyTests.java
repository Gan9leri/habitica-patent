package tests.web;
import data.DataGeneration;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PartyPage;

@DisplayName("Тесты для страницы команды")
@Tag("web")
@Owner("Овсянников Александр")
@Feature("Party")
public class PartyTests extends TestBase{
    DataGeneration data = new DataGeneration();
    PartyPage partyPage = new PartyPage();

    @DisplayName("Проверка отправки сообщения в чат команды")
    @Test
    @WithLogin
    void sendingAMessageToTeamChatTest(){
        String message = data.message;
        partyPage.openPartyPage()
                .enteringAMessageInChat(message)
                .clickSendButton()
                .checkPartyChat(message);
    }
}
