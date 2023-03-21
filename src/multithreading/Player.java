package multithreading;

public class Player implements Runnable {
    private Winner winner;

    public Player(Winner winner) {
        this.winner = winner;
    }

    @Override
    public void run() {
        int countScore = 0;

        while (countScore < winner.scoreMax-1) {
            countScore = winner.increment();
            System.out.println(Thread.currentThread().getName() + " " + countScore);
        }

        if (Thread.currentThread().getName() == winner.playerWinner) {
            System.out.println("1. I`m latter! " + winner.playerLatter);
            System.out.println("2. I`m winner! " + winner.playerWinner);
        }

    }
}
