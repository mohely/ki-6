import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class RandomTester{

    public static ArrayList<Integer> generateNumbers(int n){
        ArrayList<Integer> temp = new ArrayList<>();
        Random rnd = new Random();

        for(int i = 0; i < n ; i++){
            temp.add(rnd.nextInt());
        }

        return temp;
    }

    public static ArrayList<Integer> shuffle(ArrayList<Integer> list){
        ArrayList<Integer> copy = new ArrayList<>();
        Random rnd = new Random();
        int SIZE = list.size();
        copy.addAll(list);


        for(int i = 0; i < SIZE; i++){
            
            int j = rnd.nextInt(SIZE - 1);
            Integer temp = copy.get(i);

            copy.set(i, copy.get(j));
            copy.set(j, temp);
        }

        return copy;
    }

    public static ArrayList<Dice> sequenceOfDice(int n){
        ArrayList<Dice> diceList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diceList.add(new Dice());
        }
        return diceList;
    }
    
    public static int highestAdjacentRolls(ArrayList<Dice> sequence){
        int maxValue = 0;

        for (int i = 0; i < sequence.size() - 1; i++) {
            int temp = sequence.get(i).getValue() + sequence.get(i+1).getValue();
            if(maxValue < temp){
                maxValue = temp;
            }
        }

        return maxValue;
    }

    public static int smallestAdjacentRolls(ArrayList<Dice> sequence){
        int minValue = 12;

        for (int i = 0; i < sequence.size() - 1; i++) {
            int temp = sequence.get(i).getValue() + sequence.get(i+1).getValue();
            if(minValue > temp){
                minValue = temp;
            }
        }

        return minValue;
    }

    public static ArrayList<Dice> remove(ArrayList<Dice> sequence, int n){
        ArrayList<Dice> copy = new ArrayList<>(sequence);
        Iterator<Dice> iterator = copy.iterator();
       
        while (iterator.hasNext()) {
            Dice temp = iterator.next();
            if(temp.value == n){
                iterator.remove();
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        // When declaring a constant, it is a convention to put the name in capital letters
        final int AMOUNT_OF_NUMBERS = 5;

        // Generate a lists
        ArrayList<Integer> randomNumbers = generateNumbers(AMOUNT_OF_NUMBERS); 
        ArrayList<Dice> diceList = sequenceOfDice(5);

        // Print the numbers
        // Every time you run this example, it should produce new numbers
	    System.out.println("The following " + AMOUNT_OF_NUMBERS + " numbers were generated:");
        for (Integer number : randomNumbers) {
            System.out.println(number);
        }

        System.out.println("______________Shuffled Copy_______________");

        for (Integer number : shuffle(randomNumbers)){
            System.out.println(number);
        }

        System.out.println("_________________Original_________________");

        for (Integer number : randomNumbers) {
            System.out.println(number);
        }

        System.out.println("_________Highest adjacent rolls__________");

        for (Dice val : diceList) {
            System.out.println(val);
        }
        System.out.println("Highest Adjacent Roll: " + highestAdjacentRolls(diceList));

        System.out.println("______Remove dices with specific value_______");
        System.out.println("All Dice Values:");
        for (Dice val : diceList) {
            System.out.println(val);
        }
        
        System.out.println("Removing all Dice with value: " + diceList.get(2));
        for (Dice val : remove(diceList, diceList.get(2).value)) {
            System.out.println(val);
        }
    }
}
