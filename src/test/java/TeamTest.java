import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {
    @Test
    public void testAddMember() {

        //given
        Team team = new Team();
        Individual individual1 = new Individual("Johnny", 8);
        Individual individual2 = new Individual("Robbie", 5);
        List<Individual> members1 = new ArrayList<>();

        //when
        team.addMember(individual1);
        team.addMember(individual2);

        //then
        List<Individual> members = team.getMembers();
        assertEquals(2, members.size(), "Team should have 2 members");
        assertTrue(members.contains(individual1), "Team should contain individual1");
        assertTrue(members.contains(individual2), "Team should contain individual2");

        int sumOfRates = team.getSumOfRates();
        assertEquals(13, sumOfRates, "Sum of rates should be 13");

    }
}
