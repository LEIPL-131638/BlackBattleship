package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Versão Selenide do cenário {@code UserStory Test4}:
 * abrir a página de Batalha Naval, aguardar o título principal e aceder
 * a {@code My tournaments}.
 */
public class UserStory4Selenide {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final SelenideElement mainHeadingCss = $(".h3");
    private final SelenideElement mainHeadingXpath = $x("//h1[contains(.,'Battleship Online')]");

    private final SelenideElement touchTargetCss = $(".cdk-focused > .mat-mdc-button-touch-target");
    private final SelenideElement touchTargetXpath = $x("//span/button/span[3]");

    private final SelenideElement myTournamentsXpath = $x("//a[contains(@href, '/en/t/my-tournaments')]");

    /**
     * Abre a página do jogo de Batalha Naval.
     */
    public void openBattleshipPage() {
        open(BATTLESHIP_URL);
        Selenide.sleep(1500);
    }

    /**
     * Aguarda o título principal e devolve o respetivo texto.
     *
     * @return texto do cabeçalho principal
     */
    public String waitForBattleshipOnlineHeading() {
        SelenideElement heading = mainHeadingCss.exists()
                ? mainHeadingCss.shouldBe(visible)
                : mainHeadingXpath.shouldBe(visible);
        Selenide.sleep(1000);
        return heading.getText();
    }

    /**
     * Clica no botão focado da interface.
     */
    public void clickFocusedButtonTouchTarget() {
        if (touchTargetCss.exists()) {
            touchTargetCss.shouldBe(visible).click();
        } else {
            touchTargetXpath.shouldBe(visible).click();
        }
        Selenide.sleep(1000);
    }

    /**
     * Clica na ligação {@code My tournaments}.
     */
    public void clickMyTournaments() {
        myTournamentsXpath.shouldBe(visible).click();
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