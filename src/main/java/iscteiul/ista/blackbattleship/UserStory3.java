package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class correspondente ao cenário {@code UserStory Test3} do ficheiro
 * {@code TestSuite_131638.side}: iniciar o fluxo a partir da página de Batalha Naval,
 * preencher o nome do torneio, selecionar a sugestão e acionar a criação/partilha.
 */
public class UserStory3 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    private final By actionFrontCss = By.cssSelector(".position-relative > .front");
    private final By actionFrontXpath = By.xpath("//a/span[2]");

    private final By tournamentNameInputCss = By.cssSelector("#tf-name");
    private final By tournamentNameInputXpath = By.xpath("//input[@id='tf-name']");

    private final By suggestionButtonCss = By.cssSelector(".tf__suggestion:nth-child(2)");
    private final By suggestionButtonXpath = By.xpath("//button[contains(.,'Battleship Friday Cup')]");

    private final By createAndShareButtonCss = By.cssSelector(".btn-secondary");
    private final By createAndShareButtonXpath = By.xpath("//button[contains(.,'Create and share')]");

    /**
     * Inicializa o Page Object com o {@link WebDriver} ativo, configura a espera explícita
     * e cria a instância de {@link Actions}.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
     * Abre a página do jogo de Batalha Naval ({@code https://papergames.io/en/battleship}).
     */
    public void openBattleshipPage() {
        driver.get(BATTLESHIP_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        humanPause(1500);
    }

    /**
     * Localiza um elemento clicável usando primeiro o seletor CSS e, se necessário, o XPath.
     *
     * @param cssLocator   localizador CSS principal
     * @param xpathLocator localizador XPath alternativo
     * @return {@link WebElement} clicável
     */
    private WebElement findClickableElement(By cssLocator, By xpathLocator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(cssLocator));
        } catch (Exception ignored) {
            return wait.until(ExpectedConditions.elementToBeClickable(xpathLocator));
        }
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
     * Clica no elemento principal de ação na página inicial do jogo ({@code clickAt}).
     */
    public void clickPrimaryAction() {
        WebElement element = findClickableElement(actionFrontCss, actionFrontXpath);
        actions.moveToElement(element).click().perform();
        humanPause(1200);
    }

    /**
     * Aguarda que o campo do nome do torneio ({@code #tf-name}) esteja visível e clica nele.
     *
     * @return {@link WebElement} correspondente ao campo do nome do torneio
     */
    public WebElement waitAndClickTournamentNameField() {
        WebElement input = findVisibleElement(tournamentNameInputCss, tournamentNameInputXpath);
        input.click();
        humanPause(900);
        return input;
    }

    /**
     * Seleciona a segunda sugestão apresentada no seletor de torneios.
     */
    public void selectTournamentSuggestion() {
        WebElement suggestion = findClickableElement(suggestionButtonCss, suggestionButtonXpath);
        suggestion.click();
        humanPause(1000);
    }

    /**
     * Executa {@code mouseDown} e {@code click} no botão {@code Create and share}.
     */
    public void clickCreateAndShare() {
        WebElement button = findClickableElement(createAndShareButtonCss, createAndShareButtonXpath);
        actions.moveToElement(button).clickAndHold().perform();
        humanPause(600);
        actions.release().perform();
        humanPause(500);
        button.click();
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