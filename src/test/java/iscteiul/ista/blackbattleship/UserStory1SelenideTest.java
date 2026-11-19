package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste JUnit com Selenide para o cenário {@code UserStory Test1}.
 */
public class UserStory1SelenideTest {

    private UserStory1Selenide page;

    /**
     * Configura o Selenide antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        page = new UserStory1Selenide();
    }

    /**
     * Valida a abertura da página de Batalha Naval.
     */
    @Test
    @DisplayName("Selenide - UserStory Test1: Abrir página do jogo de Batalha Naval")
    public void openBattleshipGamePage() {
        page.openBattleshipPage();

        assertTrue(page.getCurrentUrl().contains("battleship"));
        assertFalse(page.getPageTitle().isBlank());
    }
}