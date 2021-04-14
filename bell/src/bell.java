import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class bell {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arr = new ArrayList<Integer>(){
            {
                add(2);
                add(5);
                add(3);
                add(6);
                add(9);
                add(1);
                add(8);
                add(11);
                add(12);
                add(13);
                add(14);
                add(15);
            }
        };

        arr.sort(new NumComparator());
        int arrSize = arr.size();
        ArrayList<Integer> arrRes = new ArrayList<Integer>();
        while(arrRes.size() < arrSize) arrRes = exchange_numbers(arr, arrRes);

        for(int i=0; i < arrRes.size(); i++) System.out.println(arrRes.get(i));
    }

    static class NumComparator implements Comparator<Integer>{
        public int compare(Integer first, Integer second){
            return first - second;
        }
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
