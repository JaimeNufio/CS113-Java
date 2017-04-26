import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Die die1 = new Die();
        Die die2 = new Die();

        die1.roll();
        die2.roll();

        int point = die1.getFace() + die2.getFace();

        System.out.println(die1 + " and " + die2 + " is " + point);

        if (point == 7 || point == 11) {
            System.out.println("You win!");
        }
        else if (point == 2 || point == 12) {
            System.out.println("You lose!");
        }
        else {
            int roll = 0;
            while (roll != point && roll != 7) {
                die1.roll();
                die2.roll();
                roll = die1.getFace() + die2.getFace();
                System.out.println(die1 + " and " + die2 + " is " + roll);
            }
            if (roll == point) {
                System.out.println("You win!");
            }
            else {
                System.out.println("You lose!");
            }
        }
    }
}

class Die {

    public Die() {

        roll();
    }

    public int getFace() {

        return face;
    }

    public void roll() {

        face = rand.nextInt(MAX_FACE) + 1;
    }

    public void setFace(int value) {

        if (1 <= value && value <= MAX_FACE) {
            face = value;
        }
    }

    public String toString() {

        return Integer.toString(face);
    }

    private Random rand = new Random();

    private static final int MAX_FACE = 6;
    private int face;
}
