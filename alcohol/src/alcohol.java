import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class alcohol {

    public static void main(String[] args) throws IOException {
        // get data and input in array
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String[] dataStr = sc.nextLine().split(" ");
        ArrayList<Integer> dataNum = new ArrayList<>();
        for(int i = 0; i < dataStr.length; i++) dataNum.add(Integer.parseInt(dataStr[i]));

        // count
        ArrayList<Integer> resInt = new ArrayList();
        resInt.add((Integer) dataNum.get(0)/ 2);
        resInt.add((Integer) dataNum.get(1)/ 5);
        resInt.add((Integer) dataNum.get(2));

        Optional<Integer> min =
                resInt.stream().min(Comparator.comparing(Integer::intValue, Integer::compare));

        // output
        FileWriter out = new FileWriter("output.txt");
        out.write(min.get().toString());
        out.close();
    }
}
