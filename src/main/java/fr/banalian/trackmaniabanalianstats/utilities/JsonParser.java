package fr.banalian.trackmaniabanalianstats.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import fr.banalian.trackmaniabanalianstats.Data.BestRank;
import fr.banalian.trackmaniabanalianstats.Data.COTDData;
import fr.banalian.trackmaniabanalianstats.Data.PlayerCOTDData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    private static final String COTD_URL = "https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Create a JSONObject from a url
     * @param url the url to parse from
     * @return the JSONObject created
     * @throws IOException if the url is not well-formed
     * @throws JSONException if the JSONObject is not well-formed
     */
    public static JSONObject parseJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }

    /**
     * Create a COTDData object from a JSONObject
     * @param json the JSONObject to parse from
     * @return the COTDData object
     * @throws JSONException if the JSONObject is not well-formed/is empty
     */
    public static COTDData createCOTDDataFromJSON(JSONObject json) throws JSONException {
        COTDData cotdData;
        int id;
        LocalDateTime date;
        String name;
        int div;
        int rank;
        int divRank;
        int score;
        int totalPlayers;

        if (json != null) {
            id = json.getInt("id");

            String temp = json.getString("timestamp");
            temp = temp.replace("+00:00", "");
            date = LocalDateTime.parse(temp);
            name = json.getString("name");
            div = json.getInt("div");
            rank = json.getInt("rank");
            divRank = json.getInt("divrank");
            score = json.getInt("score");
            totalPlayers = json.getInt("totalplayers");
            cotdData = new COTDData(id, name, rank, divRank, div, score, date, totalPlayers);
        }else{
            throw new JSONException("JSONObject is null");
        }

        return cotdData;
    }


    public static PlayerCOTDData createPlayerCOTDDataFromJSON (JSONObject json) throws JSONException {
        PlayerCOTDData playerCOTDData;

        String playerName = "nailanab";
        UUID playerId = UUID.fromString("8ff2fad2-059d-4a9a-99d3-93861e2e8f89");

        int totalParticipation = json.getInt("total");

        JSONObject stats = json.getJSONObject("stats");
        BestRank bestPrimary = createBestRankFromJSON(stats.getJSONObject("bestprimary"));
        BestRank bestOverall = createBestRankFromJSON(stats.getJSONObject("bestoverall"));

        int totalWins = stats.getInt("totalwins");
        int totalDivWins = stats.getInt("totaldivwins");
        double averageRank = stats.getDouble("avgrank");
        double averageDivRank = stats.getDouble("avgdivrank");
        double averageDiv = stats.getDouble("avgdiv");
        int winSteak = stats.getInt("winstreak");
        int divWinSteak = stats.getInt("divwinstreak");

        playerCOTDData = new PlayerCOTDData(bestPrimary,bestOverall,playerName,playerId,totalParticipation,totalWins,totalDivWins,averageRank,averageDivRank,averageDiv,winSteak,divWinSteak);

        try {
            playerCOTDData.setCOTDArrayListData(createCOTDDataList(10, null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return playerCOTDData;
    }

    /**
     * Create an array of COTDData from the class's trackmania.io API url
     * @param maxIteration the maximum number of iterations to perform before stopping
     * @return the array of COTDData
     * @throws JSONException if the JSONObject is not well-formed/is empty
     * @throws IOException if the url is not well-formed
     */
    public static ArrayList<COTDData> createCOTDDataList(int maxIteration, LocalDateTime dayToStop) throws JSONException, IOException {
        ArrayList<COTDData> cotdDataList = new ArrayList<>();

        int i = 0;
        boolean stop = false;
        JSONObject jsonObject = parseJsonFromUrl(COTD_URL+i);
        JSONArray jsonArray = jsonObject.getJSONArray("cotds");

        //while there is still cotds to parse or the maximum number of iterations has not been reached or while new data is available
        while(!jsonArray.isEmpty() && i < maxIteration && !stop) {
            for(int j = 0; j < jsonArray.length(); j++){
                JSONObject json = jsonArray.getJSONObject(j);
                COTDData cotdData = createCOTDDataFromJSON(json);
                if(dayToStop!=null){
                    if(cotdData.getDate().isBefore(dayToStop) || cotdData.getDate().isEqual(dayToStop)){
                        stop = true;
                    }else{
                        cotdDataList.add(cotdData);
                    }
                }else{
                    cotdDataList.add(cotdData);
                }

            }

            i++;

            jsonObject = parseJsonFromUrl(COTD_URL+i);
            jsonArray = jsonObject.getJSONArray("cotds");

        }

        return cotdDataList;
    }

    /**
     * Create a BestRank object from a JSONObject
     * @param json the JSONObject to parse from
     * @return the BestRank object
     * @throws JSONException if the JSONObject is not well-formed/is empty
     */
    public static BestRank createBestRankFromJSON (JSONObject json) throws JSONException {
        BestRank bestCategory;

        int bestRank = json.getInt("bestrank");
        LocalDateTime bestRankTime = LocalDateTime.parse(json.getString("bestranktime"));
        int bestRankDivRank = json.getInt("bestrankdivrank");
        int bestDiv = json.getInt("bestdiv");
        LocalDateTime bestDivTime = LocalDateTime.parse(json.getString("bestdivtime"));
        int bestRankInDiv = json.getInt("bestrankindiv");
        LocalDateTime bestRankInDivTime = LocalDateTime.parse(json.getString("bestrankindivtime"));
        int bestRankInDivDiv = json.getInt("bestrankindivdiv");

        bestCategory = new BestRank(bestRank, bestRankTime, bestRankDivRank, bestDiv, bestDivTime, bestRankInDiv, bestRankInDivTime, bestRankInDivDiv);

        return bestCategory;

    }


    public static void main(String[] args) throws IOException, JSONException {
        //JSONObject json = parseJsonFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
        //System.out.println(json.toString());
        //System.out.println("Total COTD played : "+json.get("total"));
        //JSONArray cotds = json.getJSONArray("cotds");
        //COTDData test = createCOTDDataFromJSON(cotds.getJSONObject(0));
        //System.out.println(test);

        JSONObject json = parseJsonFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
        PlayerCOTDData playerCOTDData = createPlayerCOTDDataFromJSON(json);
        System.out.println(playerCOTDData);
    }

}