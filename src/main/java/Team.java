import java.util.ArrayList;
import java.util.List;

/**
 * The main.Team class represents a group of people. It consists of a list of main.Individual objects and the sum of rates
 * of all members.
 */
public class Team {
    public List<Individual> members;
    int sumOfRates;
    /**
     * Constructs a new main.Team object with an empty list of members and a sum of rates initialized to 0.
     */
    Team()  {
        this.members = new ArrayList<>();
        sumOfRates = 0;
    }
    /**
     * Adds a member to the team and updates the sum of rates.
     *
     * @param member The main.Individual object to add to the team.
     */
    public void addMember(Individual member) {
        members.add(member);
        sumOfRates += member.getRate();
    }
    /**
     * Gets the sum of rates for all members of the team.
     *
     * @return The sum of rates.
     */
    public int getSumOfRates()    {
        return sumOfRates;
    }

    /**
     * Gets the list of all members of the team.
     *
     * @return The sum of rates.
     */
    public List<Individual> getMembers() {
        return members;
    }
}
