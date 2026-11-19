package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de testes de aceitação (JUnit) para a US01:
 * aceder à página inicial e ao jogo de Batalha Naval.
 */
public class UserStoryTest1Test {

    private WebDriver driver;
    private UserStoryTest1 userStory1;

    /**
     * Prepara o browser Chrome antes de cada cenário de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory1 = new UserStoryTest1(driver);
    }

    /**
     * Encerra a sessão do WebDriver após cada teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Verifica que é possível abrir a página inicial e aceder ao jogo de Batalha Naval.
     */
    @Test
    @DisplayName("US01 - Aceder à página inicial e ao jogo de Batalha Naval")
    public void accessHomeAndBattleshipGame() {
        userStory1.openHomePage();
        assertFalse(userStory1.getCurrentUrl().isBlank(), "O URL inicial não deve estar vazio");

        userStory1.dismissCookiesIfPresent();
        userStory1.navigateToBattleship();

        assertTrue(
                userStory1.getCurrentUrl().toLowerCase().contains("battleship"),
                "O URL final deve corresponder ao jogo de Batalha Naval, mas foi: " + userStory1.getCurrentUrl()
        );
        assertFalse(userStory1.getPageTitle().isBlank(), "O título da página do jogo não deve estar vazio");
    }
}