package iscteiul.ista.blackbattleship.torneio.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object (Selenide + Page Factory) para os fluxos US01 a US04
 * relacionados com Batalha Naval, guias e torneios.
 */
public class TorneioPage {

    private static final String HOME_URL = "https://papergames.io/en/battleship";
    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";
    private static final String GUIDES_URL = "https://papergames.io/docs/game-guides/";
    private static final String CREATE_TOURNAMENT_URL =
            "https://papergames.io/en/t/create-tournament?game=Battleships";
    private static final String MY_TOURNAMENTS_URL = "https://papergames.io/en/t/my-tournaments";

    @FindBy(css = "body")
    private SelenideElement pageBody;

    @FindBy(css = "a[href*='/en/battleship']")
    private SelenideElement battleshipLink;

    @FindBy(css = "#tf-name")
    private SelenideElement tournamentNameInput;

    @FindBy(css = ".tf__suggestion:nth-child(2)")
    private SelenideElement secondSuggestion;

    @FindBy(css = ".btn-secondary")
    private SelenideElement createAndShareButton;

    private final SelenideElement fallbackBody = $("body");
    private final SelenideElement createAndShareByText =
            $x("//button[contains(.,'Create and share')]");
    private final ElementsCollection tournamentLinks = $$("a[href*='/en/t/']");

    private SelenideElement bodyElement() {
        return pageBody != null ? pageBody : fallbackBody;
    }

    /**
     * Abre a página inicial ({@code /en/}) e inicializa a página via Page Factory.
     *
     * @return instância inicializada via Page Factory
     */
    public TorneioPage openHome() {
        open(HOME_URL);
        TorneioPage initialized = Selenide.page(TorneioPage.class);
        initialized.bodyElement().shouldBe(visible);
        Selenide.sleep(1000);
        return initialized;
    }

    /**
     * Abre a página específica do jogo de Batalha Naval ({@code /en/battleship}).
     *
     * @return instância atualizada via Page Factory
     */
    public TorneioPage openBattleship() {
        if (battleshipLink != null && battleshipLink.exists() && battleshipLink.isDisplayed()) {
            battleshipLink.click();
        } else {
            open(BATTLESHIP_URL);
        }
        TorneioPage initialized = Selenide.page(TorneioPage.class);
        initialized.bodyElement().shouldBe(visible);
        Selenide.sleep(1000);
        return initialized;
    }

    /**
     * Abre a página de guias do jogo ({@code /docs/game-guides/}).
     *
     * @return instância atualizada via Page Factory
     */
    public TorneioPage openGameGuides() {
        open(GUIDES_URL);
        TorneioPage initialized = Selenide.page(TorneioPage.class);
        initialized.bodyElement().shouldBe(visible);
        Selenide.sleep(1000);
        return initialized;
    }

    /**
     * Abre a página de criação de torneio para Batalha Naval.
     *
     * @return instância atualizada via Page Factory
     */
    public TorneioPage openCreateTournament() {
        open(CREATE_TOURNAMENT_URL);
        TorneioPage initialized = Selenide.page(TorneioPage.class);
        initialized.bodyElement().shouldBe(visible);
        Selenide.sleep(1200);
        return initialized;
    }

    /**
     * Preenche o nome do torneio, seleciona sugestão se existir e tenta submeter.
     *
     * @param name nome do torneio
     */
    public void fillAndSubmitTournamentIfPossible(String name) {
        if (tournamentNameInput != null && tournamentNameInput.exists() && tournamentNameInput.isDisplayed()) {
            tournamentNameInput.shouldBe(visible, enabled).click();
            tournamentNameInput.setValue(name);
            Selenide.sleep(700);
        }
        if (secondSuggestion != null && secondSuggestion.exists() && secondSuggestion.isDisplayed()) {
            secondSuggestion.click();
            Selenide.sleep(700);
        }
        if (createAndShareButton != null && createAndShareButton.exists() && createAndShareButton.isDisplayed()) {
            createAndShareButton.shouldBe(enabled).click();
            Selenide.sleep(1000);
        } else if (createAndShareByText.exists() && createAndShareByText.isDisplayed()) {
            createAndShareByText.shouldBe(enabled).click();
            Selenide.sleep(1000);
        }
    }

    /**
     * Abre a página {@code /en/t/my-tournaments} e tenta abrir o primeiro torneio visível.
     *
     * @return instância atualizada via Page Factory
     */
    public TorneioPage openMyTournamentsAndFirstItemIfPresent() {
        open(MY_TOURNAMENTS_URL);
        TorneioPage initialized = Selenide.page(TorneioPage.class);
        initialized.bodyElement().shouldBe(visible);
        Selenide.sleep(1000);

        for (SelenideElement link : initialized.tournamentLinks) {
            String href = link.getAttribute("href");
            if (link.isDisplayed() && href != null
                    && !href.endsWith("/my-tournaments")
                    && !href.contains("create-tournament")) {
                link.click();
                Selenide.sleep(1000);
                break;
            }
        }
        return initialized;
    }

    /**
     * Devolve o URL atual.
     *
     * @return URL atual no browser
     */
    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }

    /**
     * Devolve o texto visível da página.
     *
     * @return texto do corpo da página
     */
    public String getBodyText() {
        return bodyElement().shouldBe(visible).getText();
    }
}