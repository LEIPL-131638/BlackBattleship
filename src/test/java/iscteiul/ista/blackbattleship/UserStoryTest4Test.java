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
 * Classe de testes de aceitação (JUnit) para a US04:
 * consultar e gerir os meus torneios.
 */
public class UserStoryTest4Test {

    private WebDriver driver;
    private UserStoryTest4 userStory4;

    /**
     * Prepara o browser Chrome antes da execução do teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory4 = new UserStoryTest4(driver);
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
     * Verifica que a página de consulta/gestão dos torneios carrega corretamente.
     */
    @Test
    @DisplayName("US04 - Consultar e gerir os meus torneios")
    public void viewAndManageMyTournaments() {
        userStory4.openMyTournamentsPage();

        assertTrue(
                userStory4.getCurrentUrl().toLowerCase().contains("my-tournaments"),
                "O URL deve corresponder à lista de torneios do utilizador, mas foi: " + userStory4.getCurrentUrl()
        );
        assertFalse(userStory4.getBodyText().isBlank(), "A página de torneios deve apresentar conteúdo");
    }
}