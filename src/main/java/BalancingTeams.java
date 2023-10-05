import java.util.*;

/**
 * The main.BalancingTeams class is used to create a significant number of groups and divide all members
 * so that all groups would be balanced in terms of the "rate."
 */
public class BalancingTeams {

    List<Individual> individuals;
    /**
     * Constructs a main.BalancingTeams object with a list of individuals.
     *
     * @param individuals The list of individuals to be divided into teams.
     */
    BalancingTeams(List<Individual> individuals) {
        this.individuals = individuals;
    }

    /**
     * Creates a specified number of teams and divides the individuals into teams in a balanced manner.
     *
     * @param numberOfTeams The number of teams to create.
     * @return A list of main.Team objects representing the created teams.
     * @throws NotEqualSizeOfGroups If the individuals cannot be divided into equal-size groups.
     */
    public List<Team> createTeams(Integer numberOfTeams) throws NotEqualSizeOfGroups {
        if (individuals.size() % numberOfTeams != 0)    {
            throw new NotEqualSizeOfGroups("Groups must have equal size");
        }
        else {
            List<Team> Teams = new ArrayList<>();

            Collections.sort(individuals, Comparator.comparing(Individual::getRate, Collections.reverseOrder()));

            for (int i = 0; i < numberOfTeams; i++) {
                Team team = new Team();
                Teams.add(team);
            }
            for (Individual individual : individuals) {
                Team SmallestValueTeam = Teams.get(0);
                int smallestSum = SmallestValueTeam.getSumOfRates();
                for (Team team : Teams) {
                    if(team.members.size()==individuals.size()/numberOfTeams)  {
                        continue;
                    }
                    int sum = team.getSumOfRates();
                    if(sum < smallestSum)    {
                        SmallestValueTeam = team;
                        smallestSum = sum;
                    }
                }
                SmallestValueTeam.addMember(individual);

            }
                return Teams;
        }
    }

    /**
     * Calculates the standard deviation of an array of mean values.
     *
     * @param means An array of mean values for which the standard deviation will be calculated.
     * @return The calculated standard deviation as a float.
     */
    public static float calculateStandardDeviation(float[] means) {
        int n = means.length;

        if (n <= 1) {
            return 0; // If there are less than 2 points standard deviation is 0
        }
        float sum = 0.0f;
        for (float value : means) {
            sum += value;
        }
        float mean = sum / n;

        double squaredDifferencesSum = 0.0;
        for (float value : means) {
            double difference = value - mean;
            squaredDifferencesSum += difference * difference;
        }

        double standardDeviation = Math.sqrt(squaredDifferencesSum / n);


        return (float) standardDeviation;
    }

    /**
     * Prints information about the created teams, including team members and their average rate,
     * as well as the standard deviation of team rates.
     *
     * @param teams A list of main.Team objects representing the created teams.
     */
    public void printTeams(List<Team> teams) {
        float[] means = new float[teams.size()];
        for (int i=0; i<teams.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Team no " + (i+1) + " has " + (teams.get(i).members.size()) + " players (" );
            for (Individual individual : teams.get(i).members) {
                stringBuilder.append(individual.getName() + ", ");
            }
            int length = stringBuilder.length();
            stringBuilder.delete(length-2, length);
            float mean = (float)teams.get(i).getSumOfRates() / teams.get(i).members.size();
            stringBuilder.append("). Average rate: " + mean);
            System.out.println(stringBuilder);
            means[i] = mean;
        }
        String standardDeviation = String.format(Locale.US, "%.2f", calculateStandardDeviation(means));
        System.out.println("Teams rate standard deviation: " + standardDeviation);
    }




}
