package com.bsu.by;

import java.util.Arrays;
import java.util.List;

public class Books {
    private String name;
    private int amountOfPages;
    private String[] recommendation;

    public String getName() {
        return name;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOfPages(String amountOfPages) {
        this.amountOfPages = Integer.parseInt(amountOfPages);
    }

    public boolean hasOverHundredPages() {
        return this.amountOfPages > 100;
    }

    public List<String> getRecommendation() {
        return Arrays.asList(recommendation);
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation.split(" ");
    }

    public  boolean hasRecommBoring() {
        for (int i = 0; i < this.recommendation.length; i++) {
            return (this.recommendation[i].equalsIgnoreCase("boring"));

        }
        return false;
    }
}
