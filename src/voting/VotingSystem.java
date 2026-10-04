package voting;

import java.util.HashMap;
import java.util.Map;

public class VotingSystem {

    private Map<String, User> users = new HashMap<>();
    private Map<String, Boolean> userVotes = new HashMap<>();
    private Map<String, Integer> candidateVotes = new HashMap<>();

    public VotingSystem() {

        candidateVotes.put("Rahul", 0);
        candidateVotes.put("Priya", 0);
        candidateVotes.put("Kiran", 0);
    }

    public void registerUser(String username, String password) {

        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }

        User user = new User(username, password);

        users.put(username, user);
        userVotes.put(username, false);

        System.out.println("Registration successful.");
    }

    public User loginUser(String username, String password) {

        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            return user;
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    public void displayCandidates() {

        System.out.println();
        System.out.println("========== CANDIDATES ==========");

        for (String candidate : candidateVotes.keySet()) {
            System.out.println(candidate);
        }
    }

    public void castVote(User user, String candidateName) {

        String username = user.getUsername();

        if (userVotes.get(username)) {
            System.out.println("You have already voted.");
            return;
        }

        if (!candidateVotes.containsKey(candidateName)) {
            System.out.println("Invalid candidate.");
            return;
        }

        int currentVotes = candidateVotes.get(candidateName);

        candidateVotes.put(candidateName, currentVotes + 1);

        userVotes.put(username, true);

        System.out.println("Vote cast successfully.");
    }

    public void displayTotalVotes() {

        System.out.println();
        System.out.println("========== TOTAL VOTES ==========");

        for (String candidate : candidateVotes.keySet()) {

            int votes = candidateVotes.get(candidate);

            System.out.println(candidate + " : " + votes);
        }
    }

    public void displayResult() {

        String finalist = "";
        String runnerUp = "";

        int highestVotes = -1;
        int secondHighestVotes = -1;

        for (String candidate : candidateVotes.keySet()) {

            int votes = candidateVotes.get(candidate);

            if (votes > highestVotes) {

                secondHighestVotes = highestVotes;
                runnerUp = finalist;

                highestVotes = votes;
                finalist = candidate;

            } else if (votes > secondHighestVotes) {

                secondHighestVotes = votes;
                runnerUp = candidate;
            }
        }

        System.out.println();
        System.out.println("========== ELECTION RESULT ==========");
        System.out.println("Finalist: " + finalist);
        System.out.println("Votes: " + highestVotes);
        System.out.println("Runner-Up: " + runnerUp);
        System.out.println("Votes: " + secondHighestVotes);
    }
}
