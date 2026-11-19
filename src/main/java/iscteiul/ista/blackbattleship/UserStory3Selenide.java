package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

/**
 * Versão Selenide do cenário {@code UserStory Test3}:
 * iniciar o fluxo a partir da página de Batalha Naval, interagir com o campo
 * {@code #tf-name}, escolher uma sugestão e acionar {@code Create and share}.
 */
public class UserStory3Selenide {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final SelenideElement actionFrontCss = $(".position-relative > .front");
    private final SelenideElement actionFrontXpath = $x("//a/span[2]");

    private final SelenideElement tournamentNameCss = $("#tf-name");
    private final SelenideElement tournamentNameXpath = $x("//input[@id='tf-name']");

    private final SelenideElement suggestionCss = $(".tf__suggestion:nth-child(2)");
    private final SelenideElement suggestionXpath = $x("//button[contains(.,'Battleship Friday Cup')]");

    private final SelenideElement createAndShareCss = $(".btn-secondary");
    private final SelenideElement createAndShareXpath = $x("//button[contains(.,'Create and share')]");

    /**
     * Abre a página do jogo de Batalha Naval.
     */
    public void openBattleshipPage() {
        open(BATTLESHIP_URL);
        Selenide.sleep(1500);
    }

    private SelenideElement resolveElement(SelenideElement cssEl, SelenideElement xpathEl) {
        return cssEl.exists() ? cssEl.shouldBe(visible) : xpathEl.shouldBe(visible);
    }

    /**
     * Clica no elemento principal de ação na página inicial do jogo.
     */
    public void clickPrimaryAction() {
        SelenideElement element = resolveElement(actionFrontCss, actionFrontXpath);
        element.click();
        Selenide.sleep(1200);
    }

    /**
     * Aguarda e clica no campo do nome do torneio.
     *
     * @return elemento do campo do nome do torneio
     */
    public SelenideElement waitAndClickTournamentNameField() {
        SelenideElement input = resolveElement(tournamentNameCss, tournamentNameXpath);
        input.click();
        Selenide.sleep(900);
        return input;
    }

    /**
     * Seleciona a sugestão de torneio.
     */
    public void selectTournamentSuggestion() {
        SelenideElement suggestion = resolveElement(suggestionCss, suggestionXpath);
        suggestion.click();
        Selenide.sleep(1000);
    }

    /**
     * Executa {@code mouseDown} e {@code click} no botão {@code Create and share}.
     */
    public void clickCreateAndShare() {
        SelenideElement button = resolveElement(createAndShareCss, createAndShareXpath);
        actions().moveToElement(button).clickAndHold().pause(600).release().perform();
        button.click();
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
}