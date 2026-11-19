package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object correspondente à US01: aceder à página inicial da aplicação
 * e navegar até à secção do jogo de Batalha Naval (Battleship).
 */
public class UserStoryTest1 {

    private static final String HOME_URL = "https://papergames.io/en/";
    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieAcceptButton = By.cssSelector(
            "button[id*='accept'], button[class*='accept'], button[aria-label*='accept' i], button[aria-label*='agree' i]"
    );
    private final By battleshipLinkOrCard = By.cssSelector(
            "a[href*='/en/battleship'], a[href*='battleship']"
    );
    private final By pageBody = By.tagName("body");

    /**
     * Inicializa o Page Object com o WebDriver ativo e configura a espera explícita.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStoryTest1(WebDriver driver) {
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
     * Abre a página inicial da plataforma.
     */
    public void openHomePage() {
        driver.get(HOME_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        humanPause(1200);
    }

    /**
     * Fecha eventuais banners de consentimento de cookies se estiverem visíveis.
     */
    public void dismissCookiesIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement btn = shortWait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            btn.click();
            humanPause(800);
        } catch (TimeoutException ignored) {
            // Banner não apresentado ou já fechado
        }
    }

    /**
     * Navega para o jogo de Batalha Naval, clicando na ligação disponível ou abrindo o URL direto.
     */
    public void navigateToBattleship() {
        try {
            WebDriverWait linkWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement link = linkWait.until(ExpectedConditions.elementToBeClickable(battleshipLinkOrCard));
            link.click();
        } catch (TimeoutException e) {
            driver.get(BATTLESHIP_URL);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        humanPause(1500);
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
     * Devolve o título da página atual.
     *
     * @return título da página
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}