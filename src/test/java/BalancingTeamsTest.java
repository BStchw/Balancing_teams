import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BalancingTeamsTest {
    private List<Individual> individuals;

    @Before
    public void setUp() {
        individuals = new ArrayList<>();
        individuals.add(new Individual("Johnny", 8));
        individuals.add(new Individual("Robbie", 5));
        individuals.add(new Individual("Juliet", 3));
        individuals.add(new Individual("Scarlet", 5));
        individuals.add(new Individual("Jude", 9));
        individuals.add(new Individual("Deborah", 6));
    }

    @Test
    public void testCreateTeams() throws NotEqualSizeOfGroups {
        // Given
        BalancingTeams balancingTeams = new BalancingTeams(individuals);

        // When
        List<Team> teams = balancingTeams.createTeams(3);

        // Then
        assertEquals(3, teams.size());
        for (Team team : teams) {
            assertFalse(team.getMembers().isEmpty());
        }
    }

    @Test
    public void testCreateTeamsThrowsException() {
        // Given
        BalancingTeams balancingTeams = new BalancingTeams(individuals);
        Integer numberOfTeams = 5;

        // Then
        assertThrows(NotEqualSizeOfGroups.class, () -> {
            // When
            balancingTeams.createTeams(numberOfTeams);
        });
    }
    @Test
    public void testCalculateStandardDeviation() {
        // Given
        BalancingTeams balancingTeams = new BalancingTeams(individuals);

        // When
        float[] means = {8.0f, 5.0f, 3.0f, 5.0f, 9.0f, 6.0f};
        float standardDeviation = balancingTeams.calculateStandardDeviation(means);

        // Then
        assertEquals(2.0, standardDeviation, 0.01f);
    }

    @Test
    public void testPrintTeams() throws NotEqualSizeOfGroups {
        // Given
        BalancingTeams balancingTeams = new BalancingTeams(individuals);

        // When
        List<Team> teams = balancingTeams.createTeams(2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        balancingTeams.printTeams(teams);

        String output = outputStream.toString();
        System.setOut(originalOut);

        // Then
        assertTrue(output.contains("Team no 1 has"));
        assertTrue(output.contains("Teams rate standard deviation"));
    }
}
