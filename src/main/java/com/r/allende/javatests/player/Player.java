package com.r.allende.javatests.player;

public class Player {
    private int minNumberToWin;
    private Dice dice;

    public Player(Dice dice, int minNumberToWin) {
        this.setMinNumberToWin(minNumberToWin);
        this.dice = dice;
    }

    public int getMinNumberToWin() {
        return minNumberToWin;
    }

    public void setMinNumberToWin(int minNumberToWin) {
        if (minNumberToWin < 1) {
            throw new IllegalArgumentException("minNumberToWin must be at least 1");
        }
        this.minNumberToWin = minNumberToWin;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public boolean play() {
        return this.dice.roll() >= this.getMinNumberToWin();
    }
}
