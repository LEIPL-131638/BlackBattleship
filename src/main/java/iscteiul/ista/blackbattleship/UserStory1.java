package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class correspondente ao cenário {@code UserStory Test1} do ficheiro
 * {@code TestSuite_131638.side}: abrir a página do jogo de Batalha Naval.
 */
public class UserStory1 {

    private static final String BATTLESHIP_URL = "https://papergames.io/en/battleship";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageBodyCss = By.cssSelector("body");
    private final By pageBodyXpath = By.xpath("//body");

    /**
     * Inicializa o Page Object com a instância ativa do {@link WebDriver}
     * e configura a espera explícita.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStory1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
     * Abre a página do jogo de Batalha Naval ({@code https://papergames.io/en/battleship})
     * e aguarda que o corpo da página esteja presente.
     */
    public void openBattleshipPage() {
        driver.get(BATTLESHIP_URL);
        WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(pageBodyCss));
        if (body == null) {
            wait.until(ExpectedConditions.presenceOfElementLocated(pageBodyXpath));
        }
        humanPause(1500);
    }

    /**
     * Obtém o URL atual carregado no browser.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Obtém o título da página atual.
     *
     * @return título da página
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}