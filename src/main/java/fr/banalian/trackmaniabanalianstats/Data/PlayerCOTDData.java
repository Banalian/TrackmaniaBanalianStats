package fr.banalian.trackmaniabanalianstats.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Class to store the data of a player statistics for all the COTD (Cup of the Day)
 */
public class PlayerCOTDData implements Serializable {

    /**
     * The stats on the ranks of the primary COTD (each day at 19:00)
     */
    private BestRank bestPrimaryRank;

    /**
     * The stats on the ranks of all the COTD (3 per day)
     */
    private BestRank bestOverallRank;

    /**
     * The player's name
     */
    private String playerName;

    /**
     * The player's UUID
     */
    private UUID playerUUID;

    /**
     * The total number of participation
     */
    private int totalParticipation;

    /**
     * The total number of wins (first place in the world)
     */
    private int totalWins;

    /**
     * The total number of wins in a division
     */
    private int totalDivWins;

    /**
     * The average rank of the player (qualification ranks)
     */
    private double averageRank;

    /**
     * The average rank of the player in a division
     */
    private double averageDivRank;

    /**
     * The average division of the player
     */
    private double averageDiv;

    /**
     * The best consecutive number of wins (first place in the world)
     */
    private int winStreak;

    /**
     * The best consecutive number of wins in a division
     */
    private int divWinStreak;

    /**
     * An array of all the COTD (Cup of the Day) the player has participated in
     */
    private ArrayList<COTDData> COTDArrayListData;

    public PlayerCOTDData(BestRank bestPrimaryRank,
                          BestRank bestOverallRank,
                          String playerName,
                          UUID playerUUID,
                          int total,
                          int totalWins,
                          int totalDivWins,
                          double averageRank,
                          double averageDivRank,
                          double averageDiv,
                          int winStreak,
                          int divWinStreak) {
        this.bestPrimaryRank = bestPrimaryRank;
        this.bestOverallRank = bestOverallRank;
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.totalParticipation = total;
        this.totalWins = totalWins;
        this.totalDivWins = totalDivWins;
        this.averageRank = averageRank;
        this.averageDivRank = averageDivRank;
        this.averageDiv = averageDiv;
        this.winStreak = winStreak;
        this.divWinStreak = divWinStreak;
        this.COTDArrayListData = null;
    }

    /**
     * @return {@link #bestPrimaryRank}
     */
    public BestRank getBestPrimaryRank() {
        return bestPrimaryRank;
    }

    /**
     * @return {@link #bestOverallRank}
     */
    public BestRank getBestOverallRank() {
        return bestOverallRank;
    }

    /**
     * @return {@link #playerName}
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return {@link #playerUUID}
     */
    public UUID getPlayerUUID() {
        return playerUUID;
    }

    /**
     * @return {@link #totalParticipation}
     */
    public int getTotalParticipation() {
        return totalParticipation;
    }

    /**
     * @return {@link #totalWins}
     */
    public int getTotalWins() {
        return totalWins;
    }

    /**
     * @return {@link #totalDivWins}
     */
    public int getTotalDivWins() {
        return totalDivWins;
    }

    /**
     * @return {@link #averageRank}
     */
    public double getAverageRank() {
        return averageRank;
    }

    /**
     * @return {@link #averageDivRank}
     */
    public double getAverageDivRank() {
        return averageDivRank;
    }

    /**
     * @return {@link #averageDiv}
     */
    public double getAverageDiv() {
        return averageDiv;
    }

    /**
     * @return {@link #winStreak}
     */
    public int getWinStreak() {
        return winStreak;
    }

    /**
     * @return {@link #divWinStreak}
     */
    public int getDivWinStreak() {
        return divWinStreak;
    }

    /**
     * @return {@link #COTDArrayListData}
     */
    public ArrayList<COTDData> getCOTDArrayListData() {
        return COTDArrayListData;
    }


    /**
     * sets {@link #bestPrimaryRank}
     * @param bestPrimaryRank the new value
     */
    public void setBestPrimaryRank(BestRank bestPrimaryRank) {
        this.bestPrimaryRank = bestPrimaryRank;
    }

    /**
     * sets {@link #bestOverallRank}
     * @param bestOverallRank the new value
     */
    public void setBestOverallRank(BestRank bestOverallRank) {
        this.bestOverallRank = bestOverallRank;
    }

    /**
     * sets {@link #totalParticipation}
     * @param totalParticipation the new value
     */
    public void setTotalParticipation(int totalParticipation) {
        this.totalParticipation = totalParticipation;
    }

    /**
     * sets {@link #totalWins}
     * @param totalWins the new value
     */
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    /**
     * sets {@link #totalDivWins}
     * @param totalDivWins the new value
     */
    public void setTotalDivWins(int totalDivWins) {
        this.totalDivWins = totalDivWins;
    }

    /**
     * sets {@link #averageRank}
     * @param averageRank the new value
     */
    public void setAverageRank(double averageRank) {
        this.averageRank = averageRank;
    }

    /**
     * sets {@link #averageDivRank}
     * @param averageDivRank the new value
     */
    public void setAverageDivRank(double averageDivRank) {
        this.averageDivRank = averageDivRank;
    }

    /**
     * sets {@link #averageDiv}
     * @param averageDiv the new value
     */
    public void setAverageDiv(double averageDiv) {
        this.averageDiv = averageDiv;
    }

    /**
     * sets {@link #winStreak}
     * @param winStreak the new value
     */
    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    /**
     * sets {@link #divWinStreak}
     * @param divWinStreak the new value
     */
    public void setDivWinStreak(int divWinStreak) {
        this.divWinStreak = divWinStreak;
    }

    /**
     * sets {@link #COTDArrayListData}
     * @param COTDArrayListData the new arrayList data to be added
     */
    public void setCOTDArrayListData(ArrayList<COTDData> COTDArrayListData) {
        this.COTDArrayListData = COTDArrayListData;
    }

    @Override
    public String toString() {
        return "PlayerCOTDData : " + playerName + "\n" +
                "bestPrimaryRank=" + bestPrimaryRank + "\n" +
                "- bestOverallRank=" + bestOverallRank + "\n" +
                "- playerUUID=" + playerUUID + "\n" +
                "- totalParticipation=" + totalParticipation + "\n" +
                "- totalWins=" + totalWins + "\n" +
                "- totalDivWins=" + totalDivWins + "\n" +
                "- averageRank=" + averageRank + "\n" +
                "- averageDivRank=" + averageDivRank + "\n" +
                "- averageDiv=" + averageDiv + "\n" +
                "- winStreak=" + winStreak + "\n" +
                "- divWinStreak=" + divWinStreak + "\n" +
                "- COTDArrayListData=\n" + COTDArrayListData;
    }
}
