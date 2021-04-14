import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class bell {

    public static void main(String[] args) throws IOException {
        // get data and input in array
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String[] dataStr = sc.nextLine().split(" ");

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < dataStr.length; i++) arr.add(Integer.parseInt(dataStr[i]));

        arr.sort(Integer::compare);
        int arrSize = arr.size();
        ArrayList<Integer> arrRes = new ArrayList<Integer>();
        while(arrRes.size() < arrSize) arrRes = exchange_numbers(arr, arrRes);

//        for(int i=0; i < arrRes.size(); i++) System.out.println(arrRes.get(i));

        // output
        FileWriter out = new FileWriter("output.txt");
        for(int i = 0; i < arrRes.size(); i++) out.write(arrRes.get(i).toString() + ' ');
        out.close();
    }

    static ArrayList<Integer> exchange_numbers(ArrayList<Integer> arrSrc, ArrayList<Integer> arrDest){
        ArrayList<Integer> arrRes = new ArrayList<Integer>();
        Integer middle = arrDest.size()/2;
        // add the first part of previous array
        for(int i = 0; i < middle; i++) arrRes.add(arrDest.get(i));
        // add 1 or 2 elements - depends on parity
        for(int i = 0; i < 2; i++){
            if(arrSrc.isEmpty()) break;
            arrRes.add((middle + i), arrSrc.get(0));
            arrSrc.remove(0);
        }
        // add the second part of previous array
        for (int i = middle; i < arrDest.size(); i++) arrRes.add(arrDest.get(i));

        return arrRes;
    }
}
