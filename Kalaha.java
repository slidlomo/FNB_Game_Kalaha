import java.util.Scanner;

public class Kalaha {
    private int[] pits;
    private int[] kalaha;
    private int player1Kalaha;
    private int player2Kalaha;
    private int currentPlayer;

    public Kalaha() {
        pits = new int[12];
        for (int i = 0; i < 12; i++) {
            pits[i] = 4;
        }
        kalaha = new int[2];
        currentPlayer = 0;
    }

    public boolean makeMove(int pitIndex) {
        if (pitIndex < 0 || pitIndex > 11 || pits[pitIndex] == 0 || pitIndex / 6 != currentPlayer) {
            return false;
        }

        int stones = pits[pitIndex];
        pits[pitIndex] = 0;
        int currentPitIndex = pitIndex;
        while (stones > 0) {
            currentPitIndex = (currentPitIndex + 1) % 12;
            if (currentPitIndex / 6 != currentPlayer) {
                continue;
            }
            pits[currentPitIndex]++;
            stones--;
        }

        if (currentPitIndex / 6 == currentPlayer && pits[currentPitIndex] == 1) {
            int oppositePitIndex = 11 - currentPitIndex;
            kalaha[currentPlayer] += pits[oppositePitIndex] + 1;
            pits[currentPitIndex] = 0;
            pits[oppositePitIndex] = 0;
        }

        if (currentPitIndex / 6 == currentPlayer && currentPitIndex % 6 == 6) {
            return true;
        }

        currentPlayer = 1 - currentPlayer;
        return false;
    }

    public void play(int pit) {
        if (currentPlayer == 1) {
            if (pit < 0 || pit > 5 || kalaha[pit] == 0) {
                System.out.println("Invalid move. Please try again.");
                return;
            }
            int stones = kalaha[pit];
            kalaha[pit] = 0;
            int i = pit;
            while (stones > 0) {
                i++;
                if (i == 13) {
                    i = 0;
                }
                if (i == 6) {
                    continue;
                }
                kalaha[i]++;
                stones--;
            }
            if (i == 6) {
                player1Kalaha++;
            }
            if (kalaha[i] == 1 && i >= 0 && i <= 5) {
                player1Kalaha += kalaha[12 - i] + 1;
                kalaha[12 - i] = 0;
                kalaha[i] = 0;
            }
            if (i != 6) {
                currentPlayer = 2;
            }
        } else {
            if (pit < 7 || pit > 12 || kalaha[pit] == 0) {
                System.out.println("Invalid move. Please try again.");
                return;
            }
            int stones = kalaha[pit];
            kalaha[pit] = 0;
            int i = pit;
            while (stones > 0) {
                i++;
                if (i == 14) {
                    i = 0;
                }
                if (i == 13) {
                    continue;
                }
                if (i == 6) {
                    i++;
                }
                kalaha[i]++;
                stones--;
            }
            if (i == 13) {
                player2Kalaha++;
            }
            if (kalaha[i] == 1 && i >= 7 && i <= 12) {
                player2Kalaha += kalaha[12 - i] + 1;
                kalaha[12 - i] = 0;
                kalaha[i] = 0;
            }
            if (i != 13) {
                currentPlayer = 1;
            }
        }
    }


    public int[] getPits() {
        return pits;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int[] getKalaha() {
        return kalaha;
    }


}

