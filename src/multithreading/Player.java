package multithreading;

public class Player implements Runnable {
    private Winner winner;

    public Player(Winner winner) {
        this.winner = winner;
    }

    @Override
    public void run() {
        int count = 0;

        while (count < winner.scoreMax-1) {
            count = winner.increment();
            //System.out.println(Thread.currentThread().getName() + " " + count);
        }

        winner.winnerWaiting(Thread.currentThread().getName()+" "+count);
    }
}
