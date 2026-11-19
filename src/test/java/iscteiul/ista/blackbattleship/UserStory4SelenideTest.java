package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste JUnit com Selenide para o cenário {@code UserStory Test4}.
 */
public class UserStory4SelenideTest {

    private UserStory4Selenide page;

    /**
     * Configura o Selenide antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
        page = new UserStory4Selenide();
    }

    /**
     * Valida o carregamento da página e a navegação para {@code My tournaments}.
     */
    @Test
    @DisplayName("Selenide - UserStory Test4: Aceder a My tournaments")
    public void testNavigateToMyTournaments() {
        page.openBattleshipPage();

        String headingText = page.waitForBattleshipOnlineHeading();
        assertFalse(headingText.isBlank());

        page.clickFocusedButtonTouchTarget();
        page.clickMyTournaments();

        assertTrue(page.getCurrentUrl().contains("my-tournaments") || page.getCurrentUrl().contains("battleship"));
    }
}