// --== CS400 File Header Information ==--
// Name: Dawson Bauer
// Email: djbauer2@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: none

import java.util.Scanner;

public class Main {

    private static SongDatabase songCollection = new SongDatabase();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = "";
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

            if (input.equalsIgnoreCase("6")) {      // if the user enter 5, stop the program
                scanner.close();
                break;
            }

            if (input.equals("1")) {    //try to add song to database
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Add a song to the Song Database with the following info:");
                String title = "";
                do {
                    System.out.println("Song title: ");
                    title = scanner.nextLine();
                } while (title == null || title.equals(""));

                String artist = "";
                do {
                    System.out.println("Artist: ");
                    artist = scanner.nextLine();
                } while (artist == null || artist.equals(""));

                String genre = "";
                do {
                    System.out.println("Song Genre: ");
                    genre = scanner.nextLine();
                } while (genre == null || genre.equals(""));

                String year = "";
                while (true) {
                    try {
                        System.out.println("Song Year: ");
                        year = scanner.nextLine();
                        int test = Integer.parseInt(year);
                        if (test <= 0) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception ignored) {
                    }
                }

                String bpm = "";
                while (true) {
                    try {
                        System.out.println("Song Bpm: ");
                        bpm = scanner.nextLine();
                        int test = Integer.parseInt(bpm);
                        if (test <= 0) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception ignored) {
                    }
                }

                String duration = "";
                while (true) {
                    try {
                        System.out.println("Song Duration: ");
                        duration = scanner.nextLine();
                        int test = Integer.parseInt(duration);
                        if (test <= 0) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception ignored) {
                    }
                }

                if (addSong(title, artist, genre, year, bpm, duration)) {
                    System.out.println("Added successfully!");
                } else {
                    System.out.println("Added Failed!");
                }
            } else if (input.equals("2")) {     // check if song is in the database
                System.out.println("Enter the song title: ");
                String title = scanner.nextLine();
                if (contains(title)) {
                    System.out.println("The song is in the database!");
                } else {
                    System.out.println("No Match Found!");
                }
            } else if (input.equals("3")) {     // try to get song's info from database
                System.out.println("Enter the song title: ");
                String title = scanner.nextLine();
                Song song = getSong(title);
                if (song == null) {
                    System.out.println("Sorry this song is not in the Song Database :(");
                } else {
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
            } else if (input.equals("4")) {     // updata a song's info in the database
                System.out.println("-----------------------------------------------------------------");
                System.out.println("To update a song in the Song Database, \nenter the song's title:");
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
                } while (!input.equalsIgnoreCase("1")
                        && !input.equalsIgnoreCase("2")
                        && !input.equalsIgnoreCase("3")
                        && !input.equalsIgnoreCase("4")
                        && !input.equalsIgnoreCase("5"));
                if (input.equals("1")) {
                    System.out.println("Enter new artist:");
                    String artist = scanner.nextLine();
                    if (updateArtist(title, artist)) {
                        System.out.println("update successfully!");
                    } else {
                        System.out.println("update failed!");
                    }
                } else if (input.equals("2")) {
                    System.out.println("Enter new genre:");
                    String genre = scanner.nextLine();
                    if (updateGenre(title, genre)) {
                        System.out.println("update successfully!");
                    } else {
                        System.out.println("update failed!");
                    }

                } else if (input.equals("3")) {
                    System.out.println("Enter new year:");
                    String year = scanner.nextLine();
                    if (updateYear(title, year)) {
                        System.out.println("update successfully!");
                    } else {
                        System.out.println("update failed!");
                    }

                } else if (input.equals("4")) {
                    System.out.println("Enter new BPM:");
                    String bpm = scanner.nextLine();
                    if (updateBpm(title, bpm)) {
                        System.out.println("update successfully!");
                    } else {
                        System.out.println("update failed!");
                    }
                } else if (input.equals("5")) {
                    System.out.println("Enter new duration:");
                    String duration = scanner.nextLine();
                    if (updateDuration(title, duration)) {
                        System.out.println("update successfully!");
                    } else {
                        System.out.println("update failed!");
                    }
                }
            } else if (input.equals("5")) {     // print frequency of a genre
                System.out.println("-----------------------------------------------------------------");
                String genre = "";
                System.out.println("Enter the genre you want to search: ");
                genre = scanner.nextLine();
                System.out.print("Here is frequency of the genre in the Song Database: ");
                System.out.println(getGenreFrequencyInPercent(genre));
            }
            System.out.println();
        }
    }

    public static void goHome() {
        System.out.println("---- Welcome to the database System ----");
        System.out.println("---- Currently, there are " + songCollection.getNumOfSong() + " songs in the database ----");
        System.out.println("1: Add a song to the database");
        System.out.println("2: Check if a song is in the database");
        System.out.println("3: Get a song from the database");
        System.out.println("4: Update a song in the database");
        System.out.println("5: Check the frequency of genre in the database");
        System.out.println("6: Exit the song Database");
    }

    /**
     * This method tries using the addSong method and
     * catches an exception is thrown. This could be
     * if the song is already in the data base or if invalid info was
     * added to the the adding method.
     *
     * @return: boolean return false if exception was caught
     * and true if song was added
     **/
    public static boolean addSong(String title, String artist, String genre, String year, String bpm, String duration) {
        try {
            return songCollection.addSong(title, artist, genre, Integer.parseInt(year), Integer.parseInt(bpm), Integer.parseInt(duration));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean contains(String title) {
        return songCollection.hasSong(title);
    }

    public static Song getSong(String title) {
        try {
            return songCollection.getSong(title);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean updateArtist(String title, String artist) {
        return songCollection.updateArtist(title, artist);
    }

    public static boolean updateGenre(String title, String genre) {
        return songCollection.updateGenre(title, genre);
    }

    public static boolean updateBpm(String title, String bpm) {
        try {
            return songCollection.updateBpm(title, Integer.parseInt(bpm));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean updateYear(String title, String year) {
        try {
            return songCollection.updateYear(title, Integer.parseInt(year));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean updateDuration(String title, String duration) {
        try {
            return songCollection.updateDuration(title, Integer.parseInt(duration));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getGenreFrequencyInPercent(String genre) {
        return String.valueOf((int) (songCollection.getGenreFrequency(genre) * 1000) / 10.0 + "%");
    }

    public static void clear() {
        songCollection.clearDatabase();
    }
}
