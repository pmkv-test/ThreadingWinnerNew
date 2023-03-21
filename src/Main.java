import multithreading.Player;
import multithreading.Winner;

public class Main {
    public static void main(String[] args) {
        Winner winner = new Winner();
        Player player = new Player(winner);
        Thread playerOne = new Thread(player);
        Thread playerTwo = new Thread(player);
        playerOne.setName("Player1");
        playerTwo.setName("Player2");
        playerOne.start();
        playerTwo.start();

        try {
            playerOne.join();
            playerTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("3. Score= "+ winner.countScore); //значение общего счетчика в главном потоке после того как отработали два дочерних

    }
}