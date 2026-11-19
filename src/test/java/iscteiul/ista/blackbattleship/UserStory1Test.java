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
 * Page Test Class (JUnit) para o cenário {@code UserStory Test1} do ficheiro
 * {@code TestSuite_131638.side}: verificação da abertura da página do jogo de Batalha Naval.
 */
public class UserStory1Test {

    private WebDriver driver;
    private UserStory1 userStory1;

    /**
     * Prepara o {@link ChromeDriver} e o objeto de página {@link UserStory1}
     * antes de cada execução de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory1 = new UserStory1(driver);
    }

    /**
     * Fecha o browser e encerra a sessão do WebDriver após cada teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Executa o passo {@code open} em {@code https://papergames.io/en/battleship}
     * e valida que a página abre corretamente.
     */
    @Test
    @DisplayName("UserStory Test1 - Abrir página do jogo de Batalha Naval")
    public void openBattleshipGamePage() {
        userStory1.openBattleshipPage();

        assertTrue(
                userStory1.getCurrentUrl().contains("battleship"),
                "O URL deve conter 'battleship', mas foi: " + userStory1.getCurrentUrl()
        );
        assertFalse(userStory1.getPageTitle().isBlank(), "O título da página não deve estar vazio");
    }
}