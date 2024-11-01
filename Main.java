import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        ArrayList<String> choices1 = new ArrayList<>(Arrays.asList("Ali", "wali ", "nabi"));
        ArrayList<String> choices2 = new ArrayList<>(Arrays.asList("Yes", "No"));
        votingSystem.createVoting("Do you want to vote for a?", true, 0, choices1);
        votingSystem.createVoting("Do you like your ap Teacher? ", false, 1, choices2);

        Person person1 = new Person("zahid", "ali");
        Person person2 = new Person("Elone", "mask");
        Person person3 = new Person("Justin", "Baber");
        Person person4 = new Person("lamin ", "Yamal");

        Voting voting1 = votingSystem.getVoting(0);
        Voting voting2 = votingSystem.getVoting(1);
        if (voting1 != null) {
            voting1.vote(person1, new ArrayList<>(Arrays.asList("Ali")));
            voting1.vote(person2, new ArrayList<>(Arrays.asList("wali")));
            voting1.vote(person3, new ArrayList<>(Arrays.asList("nabi")));
        }

        if (voting2 != null) {
            voting2.vote(person1, new ArrayList<>(Arrays.asList("Yes")));
            voting2.vote(person2, new ArrayList<>(Arrays.asList("No")));
            voting2.vote(person4, new ArrayList<>(Arrays.asList("Yes")));
        }
        System.out.println("Results for Voting 1:");
        votingSystem.printResults(0);

        System.out.println("\nResults for Voting 2:");
        votingSystem.printResults(1);

        System.out.println("\nVoters for Voting 1:");
        votingSystem.printVoters(0);

        System.out.println("\nVoters for Voting 2:");
        votingSystem.printVoters(1);
    }
}
