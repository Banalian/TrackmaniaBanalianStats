package fr.banalian.trackmaniabanalianstats.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Class representing a player and its information and stats.
 */
public class PlayerData {

    /**
     * The player's UUID
     */
    private UUID accountId;

    /**
     * The player's name in-game
     */
    private String displayName;

    /**
     * The player's club tag
     */
    private String clubTag;

    /**
     * The player's club tag latest update
     */
    private LocalDateTime clubTagLastUpdate;

    /**
     * The player's first join date
     */
    private LocalDateTime startedPlaying;

    /**
     * The player's total amount of points/xp
     */
    private int totalPoints;

    /**
     * The player's trophies (xp by tiers)
     */
    private int[] trophiesArray;

    /**
     * The player's current echelon(from bronze to master)
     */
    private int echelon;

    /**
     * The player's current zone (from world to the specific region)
     */
    private ArrayList<String> zone;

    /**
     * The player's position in each zones
     */
    private ArrayList<Integer> zonePosition;

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getClubTag() {
        return clubTag;
    }

    public void setClubTag(String clubTag) {
        this.clubTag = clubTag;
    }

    public LocalDateTime getClubTagLastUpdate() {
        return clubTagLastUpdate;
    }

    public void setClubTagLastUpdate(LocalDateTime clubTagLastUpdate) {
        this.clubTagLastUpdate = clubTagLastUpdate;
    }

    public LocalDateTime getStartedPlaying() {
        return startedPlaying;
    }

    public void setStartedPlaying(LocalDateTime startedPlaying) {
        this.startedPlaying = startedPlaying;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    /**
     * Get the players trophies (all tiers)
     * @return the trophies array
     */
    public int[] getTrophiesTab() {
        return trophiesArray;
    }

    /**
     * Set the players trophies (all tiers)
     * @param trophies the new trophies array
     */
    public void setTrophiesTab(int[] trophies) {
        this.trophiesArray = trophies;
    }

    /**
     * Get the players trophies from a specific tier
     * @param trophiesTier the tier to get
     * @return the trophies from the specific tier
     */
    public int getTrophies(int trophiesTier) {
        if(trophiesTier <= 0 || trophiesTier > trophiesArray.length){
            throw new IllegalArgumentException("Trophie tier must be between 1 and " + trophiesArray.length);
        }
        return trophiesArray[trophiesTier];
    }

    /**
     * Set the players trophies from a specific tier
     * @param trophiesTier the tier to set
     * @param newTrophies the new trophies from the specific tier
     */
    public void setTrophies(int trophiesTier, int newTrophies) {
        if(trophiesTier <= 0 || trophiesTier > trophiesArray.length){
            throw new IllegalArgumentException("Trophie tier must be between 1 and " + trophiesArray.length);
        }
        this.trophiesArray[trophiesTier] = newTrophies;
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    public ArrayList<String> getZone() {
        return zone;
    }

    public void setZone(ArrayList<String> zone) {
        this.zone = zone;
    }

    public ArrayList<Integer> getZonePosition() {
        return zonePosition;
    }

    public void setZonePosition(ArrayList<Integer> zonePosition) {
        this.zonePosition = zonePosition;
    }


    @Override
    public String toString() {
        return "PlayerData :" +
                "accountId=" + accountId + "\n" +
                "displayName='" + displayName + "\n" +
                "clubTag='" + clubTag + "\n" +
                "clubTagLastUpdate=" + clubTagLastUpdate + "\n" +
                "startedPlaying=" + startedPlaying + "\n" +
                "totalPoints=" + totalPoints + "\n" +
                "trophiesArray=" + Arrays.toString(trophiesArray) + "\n" +
                "echelon=" + echelon + "\n" +
                "zone=" + zone + "\n" +
                "zonePosition=" + zonePosition +"\n";
    }
}
