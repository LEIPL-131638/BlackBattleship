package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object correspondente à US04: consultar e gerir a lista de torneios
 * do utilizador na plataforma.
 */
public class UserStoryTest4 {

    private static final String MY_TOURNAMENTS_URL = "https://papergames.io/en/t/my-tournaments";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By tournamentLinks = By.cssSelector("a[href*='/en/t/']");
    private final By pageBody = By.tagName("body");

    /**
     * Inicializa o Page Object com o WebDriver ativo e configura a espera explícita.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStoryTest4(WebDriver driver) {
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
     * Abre a página "My Tournaments".
     */
    public void openMyTournamentsPage() {
        driver.get(MY_TOURNAMENTS_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        humanPause(1200);
    }

    /**
     * Verifica se existem ligações de torneios visíveis na página.
     *
     * @return {@code true} se encontrar pelo menos uma ligação visível para torneios
     */
    public boolean hasTournamentLinks() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            List<WebElement> links = shortWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tournamentLinks));
            return links.stream().anyMatch(WebElement::isDisplayed);
        } catch (TimeoutException e) {
            return false;
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
     * Devolve o texto visível do corpo da página.
     *
     * @return texto do elemento body
     */
    public String getBodyText() {
        WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        return body.getText();
    }
}