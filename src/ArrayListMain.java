import java.util.Random;
import java.util.Scanner;

public class ArrayListMain {
    public static void main(String[] args) {

        Random rnd = new Random();
        OwnArrayList<String> names = new OwnArrayList<>(new String[]{"smthng","Uraaa","Mickey"});
        System.out.println(names);

        names.add("SpongeBob");
        names.add("Lukas");
        names.add("patrick");
        System.out.println(names);

        System.out.println("\nNumbers : ");

        int numberToAdd;
        OwnArrayList<Integer>numbers=new OwnArrayList<>(Integer.class,5);
        addNumbers(5, numbers);
        System.out.println(numbers);

        System.out.println("\nIntegers : ");
        OwnArrayList<Integer>integers= new OwnArrayList<>(Integer.class);
//        for (int i = 0; i < 8; i++) {
//            numberToAdd = rnd.nextInt(0,100);
//            integers.add(numberToAdd);
//        }
        addNumbers(8,integers);
        System.out.println(integers);

    }

    public static void addNumbers(int numbersCount, OwnArrayList<Integer> array) {
        while (numbersCount > 0) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the number to add :");
            int numberToAdd = scan.nextInt();
            array.add(numberToAdd);
            numbersCount--;
        }
    }
}