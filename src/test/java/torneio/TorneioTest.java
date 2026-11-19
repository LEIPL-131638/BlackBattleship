package iscteiul.ista.blackbattleship.torneio.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.torneio.pages.TorneioPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes Selenide (POM + Page Factory) para as histórias US01 a US04.
 */
@Feature("Test Suite Torneio e Batalha Naval (Selenide)")
public class TorneioTest {

    private TorneioPage torneioPage;

    /**
     * Configura o Selenide e o listener do Allure antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false)
        );
        torneioPage = new TorneioPage();
    }

    /**
     * Remove o listener do Allure após cada teste.
     */
    @AfterEach
    public void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    /**
     * US01: Aceder à página inicial (/en/) e ao jogo de Batalha Naval (/en/battleship).
     */
    @Test
    @Story("US01 - Aceder à página inicial e ao jogo de Batalha Naval")
    @DisplayName("US01 - Navegação para /en/ e /en/battleship")
    public void testUS01() {
        torneioPage = torneioPage.openHome();
        assertFalse(torneioPage.getBodyText().isBlank());

        torneioPage = torneioPage.openBattleship();
        assertTrue(torneioPage.getCurrentUrl().toLowerCase().contains("battleship"));
        assertFalse(torneioPage.getBodyText().isBlank());
    }

    @Test
    @Story("US02 - Consultar guias e regras do jogo")
    @DisplayName("US02 - Consultar documentação em /docs/game-guides/")
    public void testUS02() {
        torneioPage = torneioPage.openGameGuides();
        assertTrue(torneioPage.getCurrentUrl().contains("guides"));
        assertFalse(torneioPage.getBodyText().isBlank());
    }

    @Test
    @Story("US03 - Criar um torneio de Batalha Naval")
    @DisplayName("US03 - Aceder à criação de torneio de Batalha Naval")
    public void testUS03() {
        torneioPage = torneioPage.openCreateTournament();
        assertTrue(torneioPage.getCurrentUrl().contains("create-tournament"));
        torneioPage.fillAndSubmitTournamentIfPossible("Torneio Batalha Naval");
        assertFalse(torneioPage.getBodyText().isBlank());
    }

    @Test
    @Story("US04 - Consultar e gerir os meus torneios")
    @DisplayName("US04 - Consultar /en/t/my-tournaments e abrir torneio se existir")
    public void testUS04() {
        torneioPage = torneioPage.openMyTournamentsAndFirstItemIfPresent();
        assertTrue(torneioPage.getCurrentUrl().contains("/en/t/"));
        assertFalse(torneioPage.getBodyText().isBlank());
    }
}