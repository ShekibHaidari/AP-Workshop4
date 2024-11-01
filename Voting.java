import java.util.*;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.choices = new HashMap<>();
        this.voters = new ArrayList<>();
    }

    public ArrayList<String> getChoices() {
        return new ArrayList<>(choices.keySet());
    }

    public void createChoice(String choice) {
        choices.putIfAbsent(choice, new HashSet<>());
    }

    public void vote(Person voter, ArrayList<String> voter_choices) {
        if (!voters.contains(voter)) {
            voters.add(voter);
        }
        if (type == 0 && !choices.isEmpty()) {
            for (String choice : choices.keySet()) {
                HashSet<Vote> votes = choices.get(choice);
                votes.removeIf(vote -> vote.getVoter().equals(voter));
            }
        }
        for (String choice : voter_choices) {
            if (choices.containsKey(choice)) {
                choices.get(choice).add(new Vote(voter, new Date().toString()));
            }
        }
    }

    public void vote(Person person) {
        Random rand = new Random();
        ArrayList<String> choiceList = new ArrayList<>(choices.keySet());
        String randomChoice = choiceList.get(rand.nextInt(choiceList.size()));
        vote(person, new ArrayList<>(Collections.singletonList(randomChoice)));
    }

    public void printResults() {
        System.out.println("Results for the question: " + question);
        for (Map.Entry<String, HashSet<Vote>> entry : choices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " votes");
        }
    }

    public void printVoters() {
        if (!isAnonymous) {
            System.out.println("about voter :");
            for (Map.Entry<String, HashSet<Vote>> entry : choices.entrySet()) {
                System.out.print(entry.getKey() + " : ");
                for (Vote vote : entry.getValue()) {
                    System.out.print(vote.getVoter() + ", ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Voting in anonymous type.");
        }
    }

    public String getQuestion() {
        return question;
    }
}
