package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Page Test Class (JUnit) para o cenário {@code UserStory Test3} do ficheiro
 * {@code TestSuite_131638.side}: interação com o fluxo de torneio em Batalha Naval.
 */
public class UserStory3Test {

    private WebDriver driver;
    private UserStory3 userStory3;

    /**
     * Inicializa o {@link ChromeDriver} e o objeto de página {@link UserStory3}
     * antes de cada execução de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userStory3 = new UserStory3(driver);
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
     * Executa os passos gravados no {@code UserStory Test3} e valida que a sequência
     * de interações na interface decorre sem erros.
     */
    @Test
    @DisplayName("UserStory Test3 - Fluxo de criação e partilha de torneio em Batalha Naval")
    public void testTournamentCreationFlow() {
        userStory3.openBattleshipPage();
        userStory3.clickPrimaryAction();

        assertNotNull(userStory3.waitAndClickTournamentNameField(), "O campo do nome do torneio deve estar acessível");
        userStory3.selectTournamentSuggestion();
        userStory3.clickCreateAndShare();

        assertFalse(userStory3.getCurrentUrl().isBlank(), "O URL após a ação não deve estar vazio");
    }
}