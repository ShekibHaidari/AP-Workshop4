import java.util.Objects;

public class Vote {
    // ======================== abb
    private final Person voter;
    private final String date;
    //======================== cons
    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }
    // ==================== getter and setter

    public Person getVoter() {
        return voter;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voter, vote.voter) && Objects.equals(date, vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }
}
