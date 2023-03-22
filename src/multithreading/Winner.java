package multithreading;

import static java.lang.Thread.sleep;

public class Winner {
    private static final int SCORE_CONST = 100;
    public volatile int scoreMax = SCORE_CONST;
    public volatile int countScore = 0;
    public volatile boolean isMain = false;

    public synchronized void winnerWaiting(String playerName) {
         if (!isMain) {
                System.out.println("1. I`m latter! " + playerName );
                isMain = true;
                notify(); //запускаем
            } else System.out.println("2. I`m winner! " + playerName );

    }

    public synchronized int increment () {
        countScore++; // общий для двух потоков

        if (countScore == SCORE_CONST) {
            isMain = false;
            try {
                wait(); //остановили победителя
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        return countScore;
    }


}
