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
 * Classe de testes de aceitação (JUnit) para a US03:
 * criar um torneio de Batalha Naval.
 */
public class UserStoryTest3Test {

    private WebDriver driver;
    private UserStoryTest3 userStory3;

    /**
     * Prepara o browser Chrome antes da execução do teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory3 = new UserStoryTest3(driver);
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
     * Verifica que a página de criação de torneios para Batalha Naval carrega
     * e permite interagir com campos disponíveis.
     */
    @Test
    @DisplayName("US03 - Criar um torneio de Batalha Naval")
    public void createBattleshipTournament() {
        userStory3.openCreateTournamentPage();

        assertTrue(
                userStory3.getCurrentUrl().toLowerCase().contains("create-tournament"),
                "O URL deve corresponder à criação de torneios, mas foi: " + userStory3.getCurrentUrl()
        );
        assertFalse(userStory3.getBodyText().isBlank(), "A página de criação de torneios deve apresentar conteúdo");

        userStory3.fillTournamentNameIfPresent("Torneio Batalha Naval ISCTE");
    }
}