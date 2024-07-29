package tests.web;

import config.AuthConfig;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChallengesPage;

@DisplayName("Тесты для страницы испытаний")
@Tag("web")
@Owner("Овсянников Александр")
@Feature("Challenges")
public class ChallengesTests extends TestBase {

    ChallengesPage challengesPage = new ChallengesPage();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @DisplayName("Проверка владельца испытания")
    @Test
    @WithLogin
    void ownerOfChallengeTest(){
        challengesPage.openChallengePage()
                        .checkOwnerOfChallenge(authConfig.login());
    }
}
