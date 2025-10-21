public class BiasedDice extends Dice{
    
    public BiasedDice(){
        if(1 == randome.nextInt(2)){
            value = 6;
        }
        else{
            value = randome.nextInt(5) + 1;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new BiasedDice().getValue());
        }
    }
}
