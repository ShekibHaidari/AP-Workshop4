import java.util.*;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question, isAnonymous);
        for (String choice : choices) {
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }

    public Voting getVoting(int index) {
        if (index >= 0 && index < votingList.size()) {
            return votingList.get(index);
        }
        return null;
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    public void printResults(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.printResults();
        } else {
            System.out.println("not found!");
        }
    }

    public void printVoters(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.printVoters();
        } else {
            System.out.println("not found.");
        }
    }

    public void printVoting(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            System.out.println("Question: " + voting.getQuestion());
            System.out.println("Choices: " + voting.getChoices());
        } else {
            System.out.println("Voting not found.");
        }
    }

    public void vote(int index, Person voter) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.vote(voter);
        } else {
            System.out.println("    not found.");
        }
    }
}
