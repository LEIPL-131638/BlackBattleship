package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object correspondente à US02: consultar os guias e regras do jogo
 * na secção de documentação da plataforma.
 */
public class UserStoryTest2 {

    private static final String GUIDES_URL = "https://papergames.io/docs/game-guides/";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By battleshipGuideLink = By.cssSelector(
            "a[href*='battleship' i], a[href*='battleships' i]"
    );
    private final By pageBody = By.tagName("body");

    /**
     * Inicializa o Page Object com o WebDriver ativo e configura a espera explícita.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStoryTest2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Pausa a execução durante um intervalo curto para simular ritmo de utilização humano.
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
     * Abre a página principal dos guias de jogo.
     */
    public void openGameGuides() {
        driver.get(GUIDES_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        humanPause(1200);
    }

    /**
     * Tenta abrir o guia específico de Batalha Naval caso exista uma ligação visível.
     */
    public void openBattleshipGuideIfAvailable() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement link = shortWait.until(ExpectedConditions.elementToBeClickable(battleshipGuideLink));
            link.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
            humanPause(1200);
        } catch (TimeoutException ignored) {
            // Mantém na página geral de guias caso o link específico não esteja visível
        }
    }

    /**
     * Devolve o URL atual do browser.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Devolve o texto visível do corpo da página para validação de conteúdo.
     *
     * @return texto do elemento body
     */
    public String getBodyText() {
        WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        return body.getText();
    }
}