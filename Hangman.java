
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    // Instance variable
    String word[] = { "australia", "japan", "qatar", "syria", "mongolia", "bahrain", "india" };

    public void showMenu() {
        int option = 0;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("---------Menu---------");
        System.out.println("1. Play");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
        System.out.print("\nChoose the option : ");
        try {
            option = sc1.nextInt();
        } catch (RuntimeException e) {
            System.out.println("Please provide a valid numeric input");
            showMenu();
        }
        switch (option) {
            case 1:
                playGame();
                break;
            case 2:
                instructGame();
                break;
            case 3:
                exitGame();
                break;
            default:
                try {
                    throw new MenuInputException();
                } catch (Exception e) {
                    showMenu();
                }
        }

    }

    public void playGame() {
        // Play game functionality
        int len, i, count = 0, rnd, flag = 0;
        String choice, temp;
        Random rd = new Random();
        Scanner input = new Scanner(System.in); // scanner obj
        rnd = rd.nextInt(6);// generates a random no. b/w -1 & 7
        len = word[rnd].length();
        char[] newstring = new char[len];
        StringBuffer wrgString = new StringBuffer();
        for (int j = 0; j < len; j++) {
            System.out.print("_ ");
        }
        System.out.println();

        do {
            flag = 0;
            System.out.print("\nEnter your guess letter : ");
            try {
                String ch = input.nextLine().toLowerCase();
                if (ch.length() != 1) {
                    throw new WrongInputException();
                }
                count++;

                for (i = 0; i < len; i++) {
                    if (word[rnd].charAt(i) == ch.charAt(0)) {
                        newstring[i] = word[rnd].charAt(i);
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    flag = 1;
                    wrgString.append(ch + ",");
                    System.out.println("\nMisses : " + wrgString);
                }
                System.out.println(newstring);
                temp = new String(newstring);
                if (word[rnd].equals(temp)) {
                    System.out.println("-----------Congrats You Won!!--------------");
                    System.out.println("Do you want to play again(y/n) : ");
                    choice = input.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        playGame();
                    } else {
                        showMenu();
                    }
                }
            } catch (WrongInputException e) {
                flag = 1;
            }

        } while (flag != 0);
    }

    public void instructGame() {
        System.out.println("let's instructGame");

    }

    public void exitGame() {
        System.out.println("let's exitGame");

    }

    public static void main(String[] args) {
        // Hangman hg = new Hangman();
        // hg.showMenu();
        // GameWindow gobj = new GameWindow();
        // gobj.addComponent();

    }
}