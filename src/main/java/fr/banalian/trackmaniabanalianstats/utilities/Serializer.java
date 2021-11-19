package fr.banalian.trackmaniabanalianstats.utilities;

import fr.banalian.trackmaniabanalianstats.Data.PlayerCOTDData;
import org.json.JSONObject;
import fr.banalian.trackmaniabanalianstats.utilities.JsonParser;

import java.io.*;

/**
 * Class to serialize and deserialize data, like the player's data.
 */
public class Serializer {

    /**
     * The input stream that will read from files
     */
    private ObjectInputStream iS;
    /**
     * The output stream that will write to files
     */
    private ObjectOutputStream oS;

    /**
     * Open a file and create it if it doesn't exist
     * @param fileName the name of the file to open or create and open
     * @return a File object with the file open
     */
    public File createOpenFile(String fileName) {

        File nameFile = null;

        //create a file
        try {
            nameFile = new File(fileName);
            if (nameFile.createNewFile()) {
                System.out.println("File created: " + nameFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return nameFile;
    }


    /**
     * Open or directory and create it if it doesn't exist
     * @param dirName the name of the directory
     * @return a File object with the directory open
     */
    public File createOpenDir(String dirName) {

        File directory = new File(dirName);
        if (! directory.exists()){
            //noinspection ResultOfMethodCallIgnored
            directory.mkdir();
        }

        return directory;
    }


    /**
     * Serialize the PlayerCOTDData object into a file named "playerCOTDData.dat"
     * Will be stored in the directory "data"
     * @param playerCOTDData the PlayerCOTDData object to serialize
     */
    public void serializePlayerCOTDData(PlayerCOTDData playerCOTDData) {

        File dir = createOpenDir("data");

        File playerCOTDDataFile = createOpenFile("data"+File.separator+"playerCOTDData.dat");

        try {
            oS = new ObjectOutputStream(new FileOutputStream(playerCOTDDataFile));
            oS.writeObject(playerCOTDData);
            oS.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Deserialize the PlayerCOTDData object from a file named "playerCOTDData.dat"
     * Will be read from the directory "data"
     * @return the PlayerCOTDData object
     */
    public PlayerCOTDData deserializePlayerCOTDData() {

        File dir = createOpenDir("data");

        File playerCOTDDataFile = createOpenFile("data"+File.separator+"playerCOTDData.dat");

        PlayerCOTDData playerCOTDData;

        try {
            iS = new ObjectInputStream(new FileInputStream(playerCOTDDataFile));
            playerCOTDData = (PlayerCOTDData) iS.readObject();
            iS.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

        return playerCOTDData;
    }

    public static void main(String[] args) {

    	Serializer serializer = new Serializer();

        JSONObject json;
        PlayerCOTDData playerCOTDData;
        PlayerCOTDData playerCOTDData2;

        try {
            json = JsonParser.parseJsonFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");

            playerCOTDData = JsonParser.createPlayerCOTDDataFromJSON(json);

            serializer.serializePlayerCOTDData(playerCOTDData);

            playerCOTDData2 = serializer.deserializePlayerCOTDData();
            System.out.println(playerCOTDData2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
