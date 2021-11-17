package fr.banalian.trackmaniabanalianstats.Data;


import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Class to store the data of a player statistics for all the COTD (Cup of the Day)
 */
public class PlayerCOTDData {

    /**
     * The stats on the ranks of a COTD category
     */
    class bestRank {

        /**
         * The best rank of the player
         */
        private int bestRank;

        /**
         * The date of the best rank
         */
        private LocalDateTime bestRankDate;

        /**
         * The best rank of the player when they were in their best division
         */
        private int bestDivRank;

        /**
         * The best division of the player
         */
        private int bestDiv;

        /**
         * The date of the best division
         */
        private LocalDateTime bestDivDate;

        /**
         * The best rank of the player in any division
         */
        private int bestRankInDiv;

        /**
         * The date of the best rank in any division
         */
        private LocalDateTime bestRankInDivDate;

        /**
         * The division the player was in when they had the best rank
         */
        private int bestRankInDivDiv;

        public bestRank(int bestRank, LocalDateTime bestRankDate, int bestDivRank, int bestDiv, LocalDateTime bestDivDate, int bestRankInDiv, LocalDateTime bestRankInDivDate, int bestRankInDivDiv) {
            this.bestRank = bestRank;
            this.bestRankDate = bestRankDate;
            this.bestDivRank = bestDivRank;
            this.bestDiv = bestDiv;
            this.bestDivDate = bestDivDate;
            this.bestRankInDiv = bestRankInDiv;
            this.bestRankInDivDate = bestRankInDivDate;
            this.bestRankInDivDiv = bestRankInDivDiv;
        }

        /**
         * @return {@link #bestRank}
         */
        public int getBestRank() {
            return bestRank;
        }

        /**
         * @return {@link #bestRankDate}
         */
        public LocalDateTime getBestRankDate() {
            return bestRankDate;
        }

        /**
         * @return {@link #bestDivRank}
         */
        public int getBestDivRank() {
            return bestDivRank;
        }

        /**
         * @return {@link #bestDiv}
         */
        public int getBestDiv() {
            return bestDiv;
        }

        /**
         * @return {@link #bestDivDate}
         */
        public LocalDateTime getBestDivDate() {
            return bestDivDate;
        }

        /**
         * @return {@link #bestRankInDiv}
         */
        public int getBestRankInDiv() {
            return bestRankInDiv;
        }

        /**
         * @return {@link #bestRankInDivDate}
         */
        public LocalDateTime getBestRankInDivDate() {
            return bestRankInDivDate;
        }

        /**
         * @return {@link #bestRankInDivDiv}
         */
        public int getBestRankInDivDiv() {
            return bestRankInDivDiv;
        }
    }

    /**
     * The stats on the ranks of the primary COTD (each day at 19:00)
     */
    private bestRank bestPrimaryRank;

    /**
     * The stats on the ranks of all the COTD (3 per day)
     */
    private bestRank bestOverallRank;

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


    /**
     * @return {@link #bestPrimaryRank}
     */
    public bestRank getBestPrimaryRank() {
        return bestPrimaryRank;
    }

    /**
     * @return {@link #bestOverallRank}
     */
    public bestRank getBestOverallRank() {
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
