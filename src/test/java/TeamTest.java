import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        int sumOfRates = team.getSumOfRates();
        assertEquals(13, sumOfRates);

    }
}
