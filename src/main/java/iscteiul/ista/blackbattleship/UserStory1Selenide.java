package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.open;

/**
 * Versão Selenide do cenário {@code UserStory Test1}:
 * abrir a página do jogo de Batalha Naval.
 */
public class UserStory1Selenide {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    /**
     * Abre a página do jogo de Batalha Naval e aguarda brevemente.
     */
    public void openBattleshipPage() {
        open(BATTLESHIP_URL);
        Selenide.sleep(1500);
    }

    /**
     * Devolve o URL atual do browser.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }

    /**
     * Devolve o título da página atual.
     *
     * @return título da página
     */
    public String getPageTitle() {
        return Selenide.title();
    }
}