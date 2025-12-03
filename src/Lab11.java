import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab11 {
    static ArrayList <String> favoriteArtists = new ArrayList<String>();

    public static void main(String[] args) {
        favoriteArtists.addAll(Arrays.asList("Adrianne Lenker", "Sign Crushes Motorist", "Radiohead", "Tyler, The Creator", "Dead Calm", "Kanye West", "Frank Ocean", "Steve Lacy", "Travis Scott", "Pinegrove"));
        Scanner scan = new Scanner(System.in);

        boolean userQuit = false;
        String userChoice;

        arrayPrint();

        do {

            System.out.println("Choose an option from the menu:");
            userChoice = InputHelper.getRegExString(scan, "A - Add an artist to the list\nD - Delete an artist from the list\nP - Print the list\nQ - Quit the program", "[AaDdPpQq]");

            if (userChoice.equalsIgnoreCase("A")) {
                arrayAdd(scan);
            }

            if (userChoice.equalsIgnoreCase("D")) {
                arrayDelete(scan);
            }

            if (userChoice.equalsIgnoreCase("P")) {
                arrayPrint();
            }

            if (userChoice.equalsIgnoreCase("Q")) {
                userQuit = programQuit(scan);
                if (!userQuit) {
                    userQuit = true;
                }
            }

        } while (!userQuit);
    }

    private static void arrayAdd(Scanner scan){
        String artist = InputHelper.getNonZeroLenString(scan, "What artist would you like to add?:");
        favoriteArtists.add(artist);
    }

    private static void arrayDelete(Scanner scan){
        int index = InputHelper.getRangeInt(scan, "Which artist would you like to remove? (Starting at 0): ", 0, favoriteArtists.size() - 1);
        favoriteArtists.remove(index);
        scan.nextLine();
    }

    private static void arrayPrint(){
        for (int i = 0; i < favoriteArtists.size(); i++) {
            System.out.println(i + " - " + favoriteArtists.get(i));
        }
    }

    private static boolean programQuit(Scanner scan) {
        boolean userYN = InputHelper.getYNConfirm(scan, "Are you sure you would like to quit?");

        return  userYN;
    }
}
