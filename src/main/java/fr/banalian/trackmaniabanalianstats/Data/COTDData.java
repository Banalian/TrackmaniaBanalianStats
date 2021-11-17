package fr.banalian.trackmaniabanalianstats.Data;

import java.time.LocalDateTime;

/**
 * Class to store the data of a singe COTD (Cup of the Day)
 */
public class COTDData {

    /**
     * the division the player ended in
     */
    private int division;

    /**
     * the player's rank in the division
     */
    private int divRank;

    /**
     * the id of the COTD
     */
    private int id;

    /**
     * the player's overall rank (qualification rank)
     */
    private int rank;

    /**
     * the name of the COTD
     */
    private String name;

    /**
     * score of the player in the COTD
     */
    private int score;

    /**
     * the date and time of the COTD
     */
    private LocalDateTime date;

    /**
     * total number of players in the COTD
     */
    private int totalPlayers;

    /**
     * @return {@link #division}
     */
    public int getDivision() {
        return division;
    }

    /**
     * @return {@link #divRank}
     */
    public int getDivRank() {
        return divRank;
    }

    /**
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * @return {@link #rank}
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * @return {@link #score}
     */
    public int getScore() {
        return score;
    }

    /**
     * @return {@link #date}
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @return {@link #totalPlayers}
     */
    public int getTotalPlayers() {
        return totalPlayers;
    }

    public COTDData(int id, String name, int rank, int divRank, int division, int score, LocalDateTime date, int totalPlayers) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.divRank = divRank;
        this.division = division;
        this.score = score;
        this.date = date;
        this.totalPlayers = totalPlayers;
    }

    /**
     * get a string representation of the COTD
     * @return a string representation of the COTD
     */
    @Override
    public String toString() {
        return "COTDData : " + name + "\n" +
                "division=" + division + "\n" +
                ", divRank=" + divRank + "\n" +
                ", id=" + id + "\n" +
                ", rank=" + rank + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", score=" + score + "\n" +
                ", date=" + date + "\n" +
                ", totalPlayers=" + totalPlayers;
    }
}
