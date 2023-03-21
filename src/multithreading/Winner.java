package multithreading;

public class Winner {
    private static final int SCORE_CONST = 100;
    public int scoreMax = SCORE_CONST;
    public volatile int countScore = 0;
    public volatile String playerWinner;
    public volatile String playerLatter;

    public synchronized int increment () {
        countScore++; // общий для двух потоков

        if (countScore == SCORE_CONST ) {
            playerWinner = Thread.currentThread().getName(); //когда поток в последний раз увеличивал счетчик и countScore равен SCORE_CONST, запоминаем его имя
        } else playerLatter = Thread.currentThread().getName(); // обращаемся к значению playerLatter когда закончился  while в классе Player, поэтому в Player будет последнее название потока счетчик у которого countScore <> SCORE_CONST

        return countScore;
    }


}
