package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class correspondente ao cenário {@code UserStory Test4} do ficheiro
 * {@code TestSuite_131638.side}: abrir a página de Batalha Naval, aguardar o título
 * principal e navegar para a secção {@code My tournaments}.
 */
public class UserStory4 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By mainHeadingCss = By.cssSelector(".h3");
    private final By mainHeadingXpath = By.xpath("//h1[contains(.,'Battleship Online')]");

    private final By menuButtonTouchTargetCss = By.cssSelector(".cdk-focused > .mat-mdc-button-touch-target");
    private final By menuButtonTouchTargetXpath = By.xpath("//span/button/span[3]");

    private final By myTournamentsLinkText = By.linkText("My tournaments");
    private final By myTournamentsLinkCss = By.cssSelector(".cdk-focused");
    private final By myTournamentsLinkXpath = By.xpath("//a[contains(@href, '/en/t/my-tournaments')]");

    /**
     * Inicializa o Page Object com o {@link WebDriver} ativo e configura a espera explícita.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStory4(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
     * Abre a página do jogo de Batalha Naval ({@code https://papergames.io/en/battleship}).
     */
    public void openBattleshipPage() {
        driver.get(BATTLESHIP_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        humanPause(1500);
    }

    /**
     * Localiza um elemento visível usando primeiro o seletor CSS e, se necessário, o XPath.
     *
     * @param cssLocator   localizador CSS principal
     * @param xpathLocator localizador XPath alternativo
     * @return {@link WebElement} visível
     */
    private WebElement findVisibleElement(By cssLocator, By xpathLocator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cssLocator));
        } catch (Exception ignored) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(xpathLocator));
        }
    }

    /**
     * Aguarda que o cabeçalho principal {@code Battleship Online} esteja visível.
     *
     * @return texto do cabeçalho principal
     */
    public String waitForBattleshipOnlineHeading() {
        WebElement heading = findVisibleElement(mainHeadingCss, mainHeadingXpath);
        humanPause(1000);
        return heading.getText();
    }

    /**
     * Clica no alvo de toque/botão focado da barra de navegação.
     */
    public void clickFocusedButtonTouchTarget() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(menuButtonTouchTargetCss));
            button.click();
        } catch (Exception ignored) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(menuButtonTouchTargetXpath));
            button.click();
        }
        humanPause(1000);
    }

    /**
     * Clica na ligação {@code My tournaments} para navegar para a lista de torneios.
     */
    public void clickMyTournaments() {
        try {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(myTournamentsLinkText));
            link.click();
        } catch (Exception firstError) {
            try {
                WebElement link = wait.until(ExpectedConditions.elementToBeClickable(myTournamentsLinkXpath));
                link.click();
            } catch (Exception ignored) {
                WebElement link = wait.until(ExpectedConditions.elementToBeClickable(myTournamentsLinkCss));
                link.click();
            }
        }
        humanPause(1500);
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