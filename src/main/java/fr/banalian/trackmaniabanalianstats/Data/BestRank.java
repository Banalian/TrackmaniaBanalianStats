package fr.banalian.trackmaniabanalianstats.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The stats on the ranks of a COTD category
 */
public class BestRank implements Serializable {

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

    public BestRank(int bestRank, LocalDateTime bestRankDate, int bestDivRank, int bestDiv, LocalDateTime bestDivDate, int bestRankInDiv, LocalDateTime bestRankInDivDate, int bestRankInDivDiv) {
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