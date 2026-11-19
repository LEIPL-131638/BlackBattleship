package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste JUnit com Selenide para o cenário {@code UserStory Test2}.
 */
public class UserStory2SelenideTest {

    private UserStory2Selenide page;

    /**
     * Configura o Selenide antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        page = new UserStory2Selenide();
    }

    /**
     * Valida os elementos de regras e informação da página de Batalha Naval.
     */
    @Test
    @DisplayName("Selenide - UserStory Test2: Regras do jogo de Batalha Naval")
    public void testBattleshipRulesAndFreePlayInfo() {
        page.openSite();
        assertTrue(page.getCurrentUrl().contains("battleship"));

        String headingText = page.mouseDownRulesHeading();
        assertFalse(headingText.isBlank());
        assertTrue(headingText.toLowerCase().contains("rules") || headingText.toLowerCase().contains("battleship"));

        String paragraphText = page.mouseDownFreePlayParagraph();
        assertFalse(paragraphText.isBlank());
        assertTrue(paragraphText.toLowerCase().contains("free") || paragraphText.toLowerCase().contains("browser"));
    }
}