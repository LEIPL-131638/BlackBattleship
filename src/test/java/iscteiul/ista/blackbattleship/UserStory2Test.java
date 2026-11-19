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
 * Page Test Class (JUnit) para o cenário {@code UserStory Test2} do ficheiro
 * {@code TestSuite_131638.side}: validação das regras e informações da página de Batalha Naval.
 */
public class UserStory2Test {

    private WebDriver driver;
    private UserStory2 userStory2;

    /**
     * Inicializa o {@link ChromeDriver} e o objeto de página {@link UserStory2}
     * antes de cada execução de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory2 = new UserStory2(driver);
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
     * Executa os passos do {@code UserStory Test2} e valida os textos dos elementos
     * inspecionados na página.
     */
    @Test
    @DisplayName("UserStory Test2 - Regras do jogo de Batalha Naval e informação de acesso")
    public void testBattleshipRulesAndFreePlayInfo() {
        userStory2.openSite();
        assertTrue(
                userStory2.getCurrentUrl().contains("battleship"),
                "O URL deve conter 'battleship', mas foi: " + userStory2.getCurrentUrl()
        );

        String headingText = userStory2.mouseDownRulesHeading();
        assertFalse(headingText.isBlank(), "O título das regras não deve estar vazio");
        assertTrue(
                headingText.toLowerCase().contains("rules") || headingText.toLowerCase().contains("battleship"),
                "O título deve referir as regras ou Battleship, mas foi: " + headingText
        );

        String paragraphText = userStory2.mouseDownFreePlayParagraph();
        assertFalse(paragraphText.isBlank(), "O parágrafo informativo não deve estar vazio");
        assertTrue(
                paragraphText.toLowerCase().contains("free") || paragraphText.toLowerCase().contains("browser"),
                "O parágrafo deve referir o acesso gratuito ou no browser, mas foi: " + paragraphText
        );
    }
}