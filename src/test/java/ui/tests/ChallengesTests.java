package ui.tests;

import common.config.AuthConfig;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.ChallengesPage;

@Tag("web")
@Owner("Овсянников Александр")
@Feature("Challenges")
@DisplayName("UI: Тесты для страницы испытаний")
public class ChallengesTests extends TestBaseUi {
    ChallengesPage challengesPage = new ChallengesPage();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Test
    @WithLogin
    @DisplayName("UI: Проверка владельца испытания")
    void ownerOfChallengeTest() {
        challengesPage.openChallengePage()
                .checkOwnerOfChallenge(authConfig.login());
    }
}
