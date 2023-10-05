import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotEqualSizeOfGroups {
        Individual myIndividual1 = new Individual("Johnny", 8);
        Individual myIndividual2 = new Individual("Robbie", 5);
        Individual myIndividual3 = new Individual("Juliet", 3);
        Individual myIndividual4 = new Individual("Scarlet", 5);
        Individual myIndividual5 = new Individual("Jude", 9);
        Individual myIndividual6 = new Individual("Deborah", 6);


        List<Individual> myIndividuals = new ArrayList<>(Arrays.asList(myIndividual1, myIndividual2, myIndividual3, myIndividual4, myIndividual5, myIndividual6));
        BalancingTeams myBalancingTeams = new BalancingTeams(myIndividuals);

        List<Team> teams;
        teams = myBalancingTeams.createTeams(3);

        myBalancingTeams.printTeams(teams);

    }
}