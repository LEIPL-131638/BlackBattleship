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
 * Classe de testes de aceitação (JUnit) para a US02:
 * consultar guias e regras do jogo.
 */
public class UserStoryTest2Test {

    private WebDriver driver;
    private UserStoryTest2 userStory2;

    /**
     * Prepara o browser Chrome antes da execução do teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory2 = new UserStoryTest2(driver);
    }

    /**
     * Encerra o browser após a execução do teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Verifica que os guias de jogo carregam e apresentam conteúdo informativo.
     */
    @Test
    @DisplayName("US02 - Consultar guias e regras do jogo")
    public void consultGameGuidesAndRules() {
        userStory2.openGameGuides();
        userStory2.openBattleshipGuideIfAvailable();

        assertTrue(
                userStory2.getCurrentUrl().toLowerCase().contains("guides")
                        || userStory2.getCurrentUrl().toLowerCase().contains("battleship"),
                "O URL deve corresponder aos guias ou ao jogo de Batalha Naval, mas foi: " + userStory2.getCurrentUrl()
        );
        assertFalse(userStory2.getBodyText().isBlank(), "A página de guias deve apresentar conteúdo");
    }
}