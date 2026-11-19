package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class correspondente ao cenário {@code UserStory Test2} do ficheiro
 * {@code TestSuite_131638.side}: abrir a página do jogo de Batalha Naval e interagir
 * com o título das regras e o parágrafo informativo sobre jogo gratuito.
 */
public class UserStory2 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    private final By rulesHeadingCss = By.cssSelector(".col-12 > div > h2:nth-child(2)");
    private final By rulesHeadingXpath = By.xpath("//h2[contains(.,'Rules of Battleship game online')]");

    private final By freePlayParagraphCss = By.cssSelector("p:nth-child(16)");
    private final By freePlayParagraphXpath = By.xpath(
            "//p[contains(.,'Yes, 100% free. You play directly in your browser')]"
    );

    /**
     * Inicializa o Page Object com o {@link WebDriver} ativo, configura a espera explícita
     * e cria a instância de {@link Actions} para interações de rato.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStory2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    /**
     * Aguarda durante um número de milissegundos para aproximar a execução
     * do ritmo de utilização humano na interface gráfica.
     *
     * @param millis tempo de pausa em milissegundos
     */
    public void humanPause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Abre o site na página do jogo de Batalha Naval ({@code https://papergames.io/en/battleship}).
     */
    public void openSite() {
        driver.get(BATTLESHIP_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        humanPause(1500);
    }

    /**
     * Localiza um elemento usando primeiro o seletor CSS e, em caso de falha, o seletor XPath.
     *
     * @param cssLocator   localizador CSS principal
     * @param xpathLocator localizador XPath alternativo
     * @return {@link WebElement} visível na página
     */
    private WebElement findVisibleElement(By cssLocator, By xpathLocator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cssLocator));
        } catch (Exception ignored) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(xpathLocator));
        }
    }

    /**
     * Executa o evento {@code mouseDown} sobre o cabeçalho das regras do jogo online.
     *
     * @return texto do cabeçalho das regras
     */
    public String mouseDownRulesHeading() {
        WebElement heading = findVisibleElement(rulesHeadingCss, rulesHeadingXpath);
        actions.moveToElement(heading).clickAndHold().perform();
        humanPause(1000);
        actions.release().perform();
        humanPause(800);
        return heading.getText();
    }

    /**
     * Executa o evento {@code mouseDown} sobre o parágrafo que descreve o acesso gratuito no browser.
     *
     * @return texto do parágrafo selecionado
     */
    public String mouseDownFreePlayParagraph() {
        WebElement paragraph = findVisibleElement(freePlayParagraphCss, freePlayParagraphXpath);
        actions.moveToElement(paragraph).clickAndHold().perform();
        humanPause(1000);
        actions.release().perform();
        humanPause(800);
        return paragraph.getText();
    }

    /**
     * Obtém o URL atual do browser.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}