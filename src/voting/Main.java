package voting;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static int getIntInput(Scanner sc) {

        while (true) {

            try {

                return sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VotingSystem votingSystem = new VotingSystem();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       ONLINE VOTING SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = getIntInput(sc);

            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                votingSystem.registerUser(username, password);

            } else if (choice == 2) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                User user = votingSystem.loginUser(username, password);

                if (user != null) {

                    boolean loggedIn = true;

                    while (loggedIn) {

                        System.out.println();
                        System.out.println("========== VOTING MENU ==========");
                        System.out.println("1. View Candidates");
                        System.out.println("2. Cast Vote");
                        System.out.println("3. View Total Votes");
                        System.out.println("4. View Result");
                        System.out.println("5. Logout");

                        System.out.print("Enter your choice: ");

                        int votingChoice = getIntInput(sc);

                        sc.nextLine();

                        if (votingChoice == 1) {

                            votingSystem.displayCandidates();

                        } else if (votingChoice == 2) {

                            votingSystem.displayCandidates();

                            System.out.print("Enter candidate name: ");

                            String candidateName = sc.nextLine();

                            votingSystem.castVote(user, candidateName);

                        } else if (votingChoice == 3) {

                            votingSystem.displayTotalVotes();

                        } else if (votingChoice == 4) {

                            votingSystem.displayResult();

                        } else if (votingChoice == 5) {

                            System.out.println("Logged out successfully.");

                            loggedIn = false;

                        } else {

                            System.out.println("Invalid choice.");

                        }
                    }
                }

            } else if (choice == 3) {

                System.out.println("Thank you for using Online Voting System.");

                running = false;

            } else {

                System.out.println("Invalid choice.");

            }
        }

        sc.close();
    }
}