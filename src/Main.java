import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DynamicArray<Integer> lengths = new DynamicArray<>();

        getLongest_SecondLongest("D:\\Java Projects\\DynamicArrays\\src\\numbers.txt",lengths);

        //Without my class
        System.out.println("\nList : ");
        List<Integer> lineLengths = new ArrayList<>();
        try {
            File file = new File("D:\\Java Projects\\DynamicArrays\\src\\numbers.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                lineLengths.add(line.length());
            }
        } catch (IOException e) {
            System.out.println("An error occurred reading the file: " + e.getMessage());
        }

        int lineSize = lineLengths.size();
        if (lineSize >= 2) {
            Collections.sort(lineLengths);
            Integer max = lineLengths.get(lineSize - 1);
            Integer secondMax = lineLengths.get(lineSize - 2);
            System.out.println("longest number : " + max + "\nSecond longest number : " + secondMax);
        }

    }

    public static void getLongest_SecondLongest(String filePath, DynamicArray<Integer> arrayList) {

        try  {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line.length());
            }
        } catch (IOException e) {
            System.out.println("An error occurred reading the file => " + e.getMessage());
        }

        int size = arrayList.getSize();

        if (size >= 2) {
            Integer max = arrayList.getMax();
            Integer secondMax = arrayList.getSecondMax();
            if (max != null && secondMax != null) {
                System.out.println("longest number : " + max + "\nSecond longest number : " + secondMax);
            }
        }
    }
}
