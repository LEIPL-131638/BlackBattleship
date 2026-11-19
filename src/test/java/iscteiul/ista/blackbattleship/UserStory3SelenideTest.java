package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Teste JUnit com Selenide para o cenário {@code UserStory Test3}.
 */
public class UserStory3SelenideTest {

    private UserStory3Selenide page;

    /**
     * Configura o Selenide antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
        page = new UserStory3Selenide();
    }

    /**
     * Executa e valida o fluxo de criação e partilha de torneio.
     */
    @Test
    @DisplayName("Selenide - UserStory Test3: Fluxo de criação de torneio")
    public void testTournamentCreationFlow() {
        page.openBattleshipPage();
        page.clickPrimaryAction();

        assertNotNull(page.waitAndClickTournamentNameField());
        page.selectTournamentSuggestion();
        page.clickCreateAndShare();

        assertFalse(page.getCurrentUrl().isBlank());
    }
}