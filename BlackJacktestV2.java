import java.util.Scanner;
import java.util.Random;

class BlackJacktestV2 {
    
    static String firstName;
    public static void main(String[] args) {
        System.out.println("                                      ");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("*****       Wild Black Jack      *****");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("     _____");
        System.out.println("    |A .  | _____");
        System.out.println("    | /.\\ ||A ^  | _____");
        System.out.println("    |(_._)|| / \\ ||A _  | _____");
        System.out.println("    |  |  || \\ / || ( ) ||A_ _ |");
        System.out.println("    |____V||  .  ||(_'_)||( v )|");
        System.out.println("           |____V||  |  || \\ / |");
        System.out.println("                  |____V||  .  |");
        System.out.println("                         |____V|");
        System.out.println("                                ");
        System.out.println("                                ");
        System.out.println("                                ");
        System.out.println("Please type your name to start the game:");
        Scanner newName = new Scanner(System.in);
        firstName = newName.nextLine();
        totalPlayer(0);
    }
    public static void totalPlayer(int totalCardsPlayer) {
        totalCardsPlayer = totalCardsPlayer + drawCardPlayer();
        resultsCheckPlayer(totalCardsPlayer);
    }
    public static int drawCardPlayer() {
        Random randomCard = new Random();
        int playerCard =  1 + randomCard.nextInt(11 - 1);
        if ((playerCard == 1) && (firstName.length() >=5)) {
            Scanner playersResolution = new Scanner(System.in);
            System.out.println("You drew 1, you have to pick between 1 and 11: ");
            String playersChoice = playersResolution.nextLine();
            if (playersChoice.equals("1")) {
                playerCard = 1;
            }
            else if (playersChoice.equals("11")) {
                playerCard = 11;
            }
            else {
                playerCard = rightPickForONe(playerCard);
            }
        }
        if (firstName.length() < 5) {
            playerCard = 10;
        }
        return playerCard;

    }
    public static int rightPickForONe(int playerCard) {
        Scanner playersAnswer = new Scanner(System.in);
        System.out.println("Please pick between 1 and 11 !");
        String playersChoice = playersAnswer.nextLine();
        if (playersChoice.equals("1")) {
            playerCard = 1;
        } else if (playersChoice.equals("11")) {
            playerCard = 11;
        } else {
            playerCard = rightPickForONe(playerCard);
        }
    return playerCard;
    }

    public static int drawCardDealer(int totalDealer) {
        Random randomCard = new Random();
        int playerCard =  1 + randomCard.nextInt(11 - 1);
        if (playerCard == 1) {
            if (((totalDealer + 11) >= 17) && ((totalDealer + 11) <= 21)){
                playerCard = 11;
                System.out.println("The dealer drew 1. He has to use at 11.");
            }
            else {
                System.out.println("The dealer drew 1, he chose to use it as 1.");
                playerCard = 1;
            }
        }
        return playerCard;
    }
    public static void resultsCheckPlayer(int totalPlayer) {
        if (totalPlayer == 21) {
            System.out.println("                                      ");
            System.out.println("**************************************");
            System.out.println("******      You reached 21 !    ******");
            System.out.println("******        You win :D        ******");
            System.out.println("**************************************");
            System.out.println("                                      ");
            playAgain();
        } else if (totalPlayer > 21) {
            System.out.println("                                      ");
            System.out.println("**************************************");
            System.out.println("******      You got over 21...  ******");
            System.out.println("******        You lost :(       ******");
            System.out.println("**************************************");
            System.out.println("                                      ");
            playAgain();
        } else {
            System.out.println("Your current score is: " + totalPlayer + ".");
            System.out.println("                                           ");
            askForCard(totalPlayer);
        }
    }
    public static void askForCard(int totalCardsPlayer) {
        Scanner playersResolution = new Scanner(System.in);
        System.out.println("Would you like to draw another card ? (Y/N)");
        String playersChoice = playersResolution.nextLine();
        if (playersChoice.equalsIgnoreCase("y") || playersChoice.equalsIgnoreCase("yes")) {
            System.out.println("                                      ");
            System.out.println("*****    One more card then...   *****");
            System.out.println("                                      ");
            totalPlayer(totalCardsPlayer);
        } else {
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("***   It's the dealer's turn now   ***");
            System.out.println("***               ...              ***");
            System.out.println("**************************************");
            totalDealer(0, totalCardsPlayer);
        }
    }
    public static void totalDealer(int totalCardsDealer, int totalCardsPlayer) {
        totalCardsDealer = totalCardsDealer + drawCardDealer(totalCardsDealer);
        resultsCheckDealer(totalCardsDealer, totalCardsPlayer);
    }
    public static void resultsCheckDealer(int totalDealer, int totalPlayer) {
        if (totalDealer == 21) {
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("****   The dealer reached 21 !    ****");
            System.out.println("****          You lost :(         ****");
            System.out.println("**************************************");
            System.out.println("                                           ");
            playAgain();
        }
        else if (totalDealer > 21) {
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("****   The dealer got over 21...  ****");
            System.out.println("****          You win :D          ****");
            System.out.println("**************************************");
            System.out.println("                                           ");
            playAgain();
        }
        else if (totalDealer >= 17 && totalDealer > totalPlayer) {
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("*** The dealer got a higher score  ***");
            System.out.println("***           He wins :(           ***");
            System.out.println("**************************************");
            System.out.println("                                           ");
            playAgain();
        }
        else if (totalDealer >= 17 && totalDealer <= totalPlayer) {
            System.out.println("The current score of the dealer is: " + totalDealer + ".");
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("***    You got a higher score !    ***");
            System.out.println("***           You win :D           ***");
            System.out.println("**************************************");
            System.out.println("                                           ");
            playAgain();
        }
        else {
            System.out.println("                    *                      ");
            System.out.println("                                           ");
            System.out.println("The current score of the dealer is: " + totalDealer + ". Your score is still " + totalPlayer + ".");
            System.out.println("                                           ");
            System.out.println("                    *                      ");
            System.out.println("                                           ");            
            totalDealer(totalDealer, totalPlayer);
        }
    }
    public static void playAgain() {
        Scanner playersResolution = new Scanner(System.in);
        System.out.println("Would you like to play again ? (Y/N)");
        String playersChoice = playersResolution.nextLine();
        if (playersChoice.equalsIgnoreCase("y") || playersChoice.equalsIgnoreCase("yes")) {
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("**************************************");
            System.out.println("*****      Wilde Black Jack      *****");
            System.out.println("**************************************");
            System.out.println("**************************************");
            System.out.println("                                           ");
            totalPlayer(0);
        } 
        else {
            System.out.println("                                           ");
            System.out.println("**************************************");
            System.out.println("**************************************");
            System.out.println("*****          Bye bye !         *****");
            System.out.println("**************************************");
            System.out.println("**************************************");
            System.out.println("                                           ");
        }
    }
} 


    
    
    // MAIN 
    // print: Hello ! Welcome to the Wild Jack !
    // method: drawCard(input)
    // if cardTotal < 21 -> print total + method: drawCard or stop(input) + method: ifAce -> if stop: method dealersPlay / if more: method drawCard(input) + method ifAce(input)
    // if cardTotal > 21 -> print: you lost :( -> method: ask to leave or restart(input)
    // if cardTotal = 21 -> you win :D 
    // 
    // method dealersPlay (if cardTotal < 21 and player stopped):
    // 
    // if dealersTotal < 17 -> method: add more cards + method: ifAceDealer + print dealersTotal
    // if dealersTotal > 21 -> you win :D 
    // if dealersTotal >= 17 -> stop + print dealersTotal + method: compareResults(input) -> print winner
