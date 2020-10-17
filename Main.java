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

import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String input = "";

    public static void main(String[] args) {
        SongDatabase songCollection = new SongDatabase();//new songDatabase
        while (true) {
            do {
                goHome();
                System.out.println("Select an option (1-6): ");
                input = scanner.nextLine();
            } while (!input.equalsIgnoreCase("1")  // rule out the possibility of user typing errors in the next few lines
                    && !input.equalsIgnoreCase("2")
                    && !input.equalsIgnoreCase("3")
                    && !input.equalsIgnoreCase("4")
                    && !input.equalsIgnoreCase("5")
                    && !input.equalsIgnoreCase("6"));

            if (input.equalsIgnoreCase("6")) { // if the user enter 5, stop the program
                break;
            }

            if (input.equals("1")) { //try to add song to database
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Add a song to the Song Database with the following info:");
                System.out.println("Song title: ");
                String title = scanner.nextLine();
                System.out.println("Artist: ");
                String artist = scanner.nextLine();
                System.out.println("Song Genre: ");
                String genre = scanner.nextLine();
                System.out.println("Song Year: ");
                String year = scanner.nextLine();
                System.out.println("Song Bpm: ");
                String bpm = scanner.nextLine();
                System.out.println("Song Duration: ");
                String duration = scanner.nextLine();
                try {
                    songCollection.addSong(title, artist, genre, Integer.parseInt(year), Integer.parseInt(bpm), Integer.parseInt(duration));
                    System.out.println("Added successfully!");
                } catch (Exception e){
                    System.out.println("Add fails");
                }
            } else if (input.equals("2")) {// check if song is in the database
                System.out.println("Enter the song title: ");
                String title = scanner.nextLine();
                if (songCollection.hasSong(title)) {
                    System.out.println("The song is in the database!");
                } else {
                    System.out.println("No Match Found!");
                }
            } else if (input.equals("3")) {// try to get song's info from database
                System.out.println("Enter the song title: ");
                String title = scanner.nextLine();
                if (!songCollection.hasSong(title)) {
                    System.out.println("Sorry this song is not in the Song Database :(");
                } else {
                    Song song = songCollection.getSong(title);
                    System.out.println("Here is the song you were looking for:");
                    System.out.print("Song title: ");
                    System.out.println(song.getSongTitle());
                    System.out.print("Artist: ");
                    System.out.println(song.getArtist());
                    System.out.print("Song Genre: ");
                    System.out.println(song.getGenre());
                    System.out.print("Song Year: ");
                    System.out.println(song.getYear());
                    System.out.print("Song Bpm: ");
                    System.out.println(song.getBpm());
                    System.out.print("Song Duration: ");
                    System.out.println(song.getDuration());
                }
            } else if (input.equals("4")) { // updata a song's info in the database
                System.out.println("-----------------------------------------------------------------");
                System.out.println("To update a song in the Song Database, enter " + "/n"
                        + "the song's title:");
                String title = scanner.nextLine();
                if (!songCollection.hasSong(title)) {
                    System.out.println("Sorry this song is not in the Song Database :(");
                    continue;
                }
                System.out.println("We found the song in the database! \nNow what did you want to change?");
                do {
                    System.out.println("1: Song Artist");
                    System.out.println("2: Song Genre");
                    System.out.println("3: Song Year");
                    System.out.println("4: Song BPM");
                    System.out.println("5: Song Duration");
                    input = scanner.nextLine();
                }while (!input.equalsIgnoreCase("1")
                        && !input.equalsIgnoreCase("2")
                        && !input.equalsIgnoreCase("3")
                        && !input.equalsIgnoreCase("4")
                        && !input.equalsIgnoreCase("5"));
                if (input.equals("1")) {
                    System.out.println("Enter new artist:");
                    String artist = scanner.nextLine();
                    if(songCollection.updateArtist(title, artist)){
                        System.out.println("update successfully!");
                    }else{
                        System.out.println("update failed!");
                    }
                } else if (input.equals("2")) {
                    System.out.println("Enter new genre:");
                    String genre = scanner.nextLine();
                    if(songCollection.updateGenre(title, genre) ){
                        System.out.println("update successfully!");
                    }else{
                        System.out.println("update failed!");
                    }

                } else if (input.equals("3")) {
                    System.out.println("Enter new year:");
                    try {
                        String year = scanner.nextLine();
                        if (songCollection.updateYear(title, Integer.parseInt(year))) {
                            System.out.println("update successfully!");
                        } else {
                            System.out.println("update failed!");
                        }
                    }catch (Exception e){
                        System.out.println("update failed!");
                    }
                } else if (input.equals("4")) {
                    System.out.println("Enter new BPM:");
                    try {
                        String bpm = scanner.nextLine();
                        if (songCollection.updateBpm(title, Integer.parseInt(bpm))) {
                            System.out.println("update successfully!");
                        } else {
                            System.out.println("update failed!");
                        }
                    }catch (Exception e){
                        System.out.println("update failed!");
                    }
                } else if (input.equals("5")) {
                    System.out.println("Enter new duration:");
                    try {
                        String duration = scanner.nextLine();
                        if (songCollection.updateDuration(title, Integer.parseInt(duration))) {
                            System.out.println("update successfully!");
                        } else {
                            System.out.println("update failed!");
                        }
                    }catch (Exception e){
                        System.out.println("update failed!");
                    }
                }
            } else if (input.equals("5")) {// print frequency of a genre
                System.out.println("-----------------------------------------------------------------");
                String genre = "";
                System.out.println("Enter the genre you want to search: ");
                genre = scanner.nextLine();
                System.out.print("Here is frequency of the genre in the Song Database: ");
                System.out.println(songCollection.getGenreFrequency(genre));
            }
            System.out.println();
        }
    }

    public static void goHome() {
        System.out.println("---- Welcome to the database System ----");
        System.out.println("1: Add a song to the database");
        System.out.println("2: Check if a song is in the database");
        System.out.println("3: Get a song from the database");
        System.out.println("4: Update a song in the database");
        System.out.println("5: Check the total number of songs in the database");
        System.out.println("6: Exit the song Database");
    }
}
