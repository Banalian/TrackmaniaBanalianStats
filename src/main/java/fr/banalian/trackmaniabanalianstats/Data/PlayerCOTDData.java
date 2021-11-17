package fr.banalian.trackmaniabanalianstats.Data;


import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Class to store the data of a player statistics for all the COTD (Cup of the Day)
 */
public class PlayerCOTDData {

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
    private int total;

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

    public PlayerCOTDData(BestRank bestPrimaryRank, BestRank bestOverallRank, String playerName, UUID playerUUID, int total, int totalWins, int totalDivWins, double averageRank, double averageDivRank, double averageDiv, int winStreak, int divWinStreak) {
        this.bestPrimaryRank = bestPrimaryRank;
        this.bestOverallRank = bestOverallRank;
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.total = total;
        this.totalWins = totalWins;
        this.totalDivWins = totalDivWins;
        this.averageRank = averageRank;
        this.averageDivRank = averageDivRank;
        this.averageDiv = averageDiv;
        this.winStreak = winStreak;
        this.divWinStreak = divWinStreak;
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
     * @return {@link #total}
     */
    public int getTotal() {
        return total;
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
}
