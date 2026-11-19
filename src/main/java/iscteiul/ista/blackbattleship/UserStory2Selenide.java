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
 * Versão Selenide do cenário {@code UserStory Test2}:
 * abrir a página de Batalha Naval e interagir com o título das regras
 * e o parágrafo informativo.
 */
public class UserStory2Selenide {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final SelenideElement rulesHeadingCss = $(".col-12 > div > h2:nth-child(2)");
    private final SelenideElement rulesHeadingXpath = $x("//h2[contains(.,'Rules of Battleship game online')]");

    private final SelenideElement freePlayParagraphCss = $("p:nth-child(16)");
    private final SelenideElement freePlayParagraphXpath = $x(
            "//p[contains(.,'Yes, 100% free. You play directly in your browser')]"
    );

    /**
     * Abre o site na página do jogo de Batalha Naval.
     */
    public void openSite() {
        open(BATTLESHIP_URL);
        Selenide.sleep(1500);
    }

    private SelenideElement resolveElement(SelenideElement cssEl, SelenideElement xpathEl) {
        return cssEl.exists() ? cssEl.shouldBe(visible) : xpathEl.shouldBe(visible);
    }

    /**
     * Executa {@code mouseDown} no cabeçalho das regras e devolve o respetivo texto.
     *
     * @return texto do cabeçalho das regras
     */
    public String mouseDownRulesHeading() {
        SelenideElement heading = resolveElement(rulesHeadingCss, rulesHeadingXpath);
        actions().moveToElement(heading).clickAndHold().pause(1000).release().perform();
        Selenide.sleep(800);
        return heading.getText();
    }

    /**
     * Executa {@code mouseDown} no parágrafo informativo e devolve o respetivo texto.
     *
     * @return texto do parágrafo
     */
    public String mouseDownFreePlayParagraph() {
        SelenideElement paragraph = resolveElement(freePlayParagraphCss, freePlayParagraphXpath);
        actions().moveToElement(paragraph).clickAndHold().pause(1000).release().perform();
        Selenide.sleep(800);
        return paragraph.getText();
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