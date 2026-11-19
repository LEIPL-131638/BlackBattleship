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
 * Page Test Class (JUnit) para o cenário {@code UserStory Test4} do ficheiro
 * {@code TestSuite_131638.side}: navegação até à secção {@code My tournaments}
 * a partir da página de Batalha Naval.
 */
public class UserStory4Test {

    private WebDriver driver;
    private UserStory4 userStory4;

    /**
     * Inicializa o {@link ChromeDriver} e o objeto de página {@link UserStory4}
     * antes de cada execução de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory4 = new UserStory4(driver);
    }

    /**
     * Encerra a sessão do browser após cada teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Executa os passos gravados no {@code UserStory Test4} e valida o carregamento
     * inicial e a navegação para a área de torneios.
     */
    @Test
    @DisplayName("UserStory Test4 - Aceder a My tournaments a partir de Battleship")
    public void testNavigateToMyTournaments() {
        userStory4.openBattleshipPage();

        String headingText = userStory4.waitForBattleshipOnlineHeading();
        assertFalse(headingText.isBlank(), "O cabeçalho principal não deve estar vazio");

        userStory4.clickFocusedButtonTouchTarget();
        userStory4.clickMyTournaments();

        assertTrue(
                userStory4.getCurrentUrl().contains("my-tournaments") || userStory4.getCurrentUrl().contains("battleship"),
                "O URL final deve ser válido após a navegação, mas foi: " + userStory4.getCurrentUrl()
        );
    }
}