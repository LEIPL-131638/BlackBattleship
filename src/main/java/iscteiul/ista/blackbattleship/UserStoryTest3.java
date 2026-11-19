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
 * Page Object correspondente à US03: aceder à criação de torneios configurada
 * para Batalha Naval e interagir com os campos do formulário.
 */
public class UserStoryTest3 {

    private static final String CREATE_TOURNAMENT_URL =
            "https://papergames.io/en/t/create-tournament?game=Battleships";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By tournamentNameInput = By.cssSelector(
            "input[type='text'], input[name*='name' i], input[placeholder*='name' i], input[placeholder*='tournament' i]"
    );
    private final By pageBody = By.tagName("body");

    /**
     * Inicializa o Page Object com o WebDriver ativo e configura a espera explícita.
     *
     * @param driver instância ativa do Selenium WebDriver
     */
    public UserStoryTest3(WebDriver driver) {
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
     * Abre a página de criação de torneios para Batalha Naval.
     */
    public void openCreateTournamentPage() {
        driver.get(CREATE_TOURNAMENT_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(pageBody));
        humanPause(1200);
    }

    /**
     * Preenche o primeiro campo de texto disponível (como o nome do torneio) se existir.
     *
     * @param name nome a inserir no campo
     * @return {@code true} se algum campo de texto foi preenchido, {@code false} caso contrário
     */
    public boolean fillTournamentNameIfPresent(String name) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            List<WebElement> inputs = shortWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tournamentNameInput));
            for (WebElement input : inputs) {
                if (input.isDisplayed() && input.isEnabled()) {
                    input.clear();
                    input.sendKeys(name);
                    humanPause(800);
                    return true;
                }
            }
        } catch (TimeoutException ignored) {
            // Página pode exigir sessão iniciada ou ter outra estrutura de campos
        }
        return false;
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