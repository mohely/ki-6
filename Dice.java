import java.util.Random;

public class Dice {
    protected int value = 0;
    protected Random randome = new Random();

    public Dice(){
        value = randome.nextInt(6) + 1;
    }

    public int getValue(){
        return value;
    }

    //Overriding toString method.
    public String toString(){
        return this.value + "";
    }

    public static void main(String[] args) {
        Dice d1 = new Dice();
        System.out.println("d1 value: " + d1.getValue());
    }
}
