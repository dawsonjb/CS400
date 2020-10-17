// --== CS400 File Header Information ==--
// Name: Dawson Bauer
// Email: djbauer2@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: none

/**
 * @program: SongDatabase
 * @description: This is the main interface of the program
 * @author: Dawson Bauer
 **/
import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static String input = "";
    
    public static void main (String[] args){
        SongDatabase songCollection = new SongDatabase();//new songDatabase
        System.out.println("Welcome to the Song Database!");
        goHome();
        input = scanner.nextLine();
        if (input ==  "1"){ //try to add song to database
            retryAdd();
            if (songCollection.contains (input)){
                System.out.println("Sorry this song can not be added since it is" + "/n" 
                + "already in the database :(");
                retryAdd();
            }
            else if (information is missing){
                System.out.println("Sorry this song could not be added " +"/n" + 
                "since this information is incomplete or incorrect :(");
                retryAdd();
            }
            else {//song is added
                System.out.println("Congrats! The song was successfully added :)");
                goHome();
        }
    }
    if (input == "2"){// check if song is in the database
        retryContains();
        if (!songCollection.contains(input)){
            System.out.println("Sorry this song is not in the Song Database :(");
            retryContains();
        }
        else if (information is missing){
            System.out.println("The information you entered is incorrect :(");
            retryContains();
        }
        else {
            System.out.println("Yes this song is in the Song Database!");
            goHome();
        }
    }
    if (input == "3"){// try to get song's info from database
        retryGet();
        if (!songCollection.contains(input)){
            System.out.println("Sorry this song is not in the Song Database :(");
            retryGet();
        }
        else if (information is missing){
            System.out.println("The information you entered is incorrect :(");
            retryGet();
        }
        else {
            System.out.println("Here is the song you were looking for:");
            System.out.println(songCollection.get(input));
            goHome();
        }
    }
    if (input == "4"){// updata a song's info in the database
        System.out.println("-----------------------------------------------------------------");
        System.out.println("To update a song in the Song Database, enter " + "/n" 
        + "the song's title:");
        input = scanner.nextLine();
        String title= input;
        if (!songCollection.contains(input)){
            System.out.println("Sorry this song is not in the Song Database :(");
            goHome();
        }
        System.out.println("We found the song in the database! Now what " + "/n"
        + "did you want to change?");
        System.out.println("1: Song Title");
        System.out.println("2: Song Artist");
        System.out.println("3: Song Genre");
        System.out.println("4: Song Year");
        System.out.println("5: Song BPM");
        System.out.println("6: Song Duration");
        input = scanner.nextLine();
        if (input == "1"){
            System.out.println("Enter new title:");
            input = scanner.nextLine();
            songCollection.updateSongTitle(title, input);
        }
        else if (input == "2"){
            System.out.println("Enter new artist:");
            input = scanner.nextLine();
            songCollection.updateArtist(title, input);
        }
        else if (input == "3"){
            System.out.println("Enter new genre:");
            input = scanner.nextLine();
            songCollection.updateGenre(title, input);
        }
        else if (input == "4"){
            System.out.println("Enter new year:");
            input = scanner.nextLine();
            songCollection.updateYear(title, input);
        }
        else if (input == "5"){
            System.out.println("Enter new BPM:");
            input = scanner.nextLine();
            songCollection.updateBpm(title, input);
        }
        else if (input == "6"){
            System.out.println("Enter new duration:");
            input = scanner.nextLine();
            songCollection.updateDuration(title, input);
        }
        System.out.println("Update complete!");
        goHome();
    }
    if (input == "5"){// print total number of songs in database
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Here is how many songs are in the Song Database:");
        System.out.println(songCollection.numOfSongs());
        goHome();
    }
    if (input == "6"){// go back to the home screen 
       goHome();
    }
    if (input == "7"){// end the session
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Thank for using the Song Database!");
    }
  }
  public static void goHome(){
    System.out.println("Below you will see options on what you would like to do");
    System.out.println("with this database:");
    System.out.println("(Press the number of the option you would like to use.)");
    System.out.println("1: Add a song to the database");
    System.out.println("2: Check if a song is in the database");
    System.out.println("3: Get a song from the database");
    System.out.println("4: Update a song in the database");
    System.out.println("5: Check the total number of songs in the database");
    System.out.println("6: Go back to Home menu");
    System.out.println("7: Exit the song Database");
}
private static void retryAdd(){
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Add a song to the Song Database with the following info:");
    input = scanner.nextLine();
}
private static void retryContains(){
    System.out.println("-----------------------------------------------------------------");
    System.out.println("To check if a song is in the Song Database, " + "/n" 
    + "enter the song's following info:");
    input = scanner.nextLine();
}
private static void retryGet(){
    System.out.println("-----------------------------------------------------------------");
    System.out.println("To get song from the Song Database, enter " + "/n" 
    + "the song's following info:");
    input = scanner.nextLine();
}
}