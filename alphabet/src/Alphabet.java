import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Comparator;

public class Alphabet {

    public static void main(String[] args) throws IOException {
        Boolean bResult = false;
        Map<Integer, Character> mapSymbols = new HashMap<Integer, Character>();

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String data = sc.nextLine();
        char[] charSymbolsArr = data.toCharArray();
        for(int i = 1; i < charSymbolsArr.length; i++){
            mapSymbols.put(i, charSymbolsArr[i]);
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
//        String symbols = "AAZZZZZZZZZZZZZZZZZZZZZZZZ".toUpperCase();
//        String symbols = "BCARTYXYZZYZZYXYXYZZYZZYXV".toUpperCase();
//        String symbols = "ABCDZZZZZZZZZZZZZZZZZZZZZZ".toUpperCase();
        char[] charAlphaArr = alphabet.toCharArray();
        for(int i = 0; i < charSymbolsArr.length; i++) mapSymbols.put(i+1, charSymbolsArr[i]); // заполняем мапу
        List<Map.Entry<Integer, Character>> list = new LinkedList<Map.Entry<Integer, Character>>(mapSymbols.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> o1, Map.Entry<Integer, Character> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        StringBuilder numbers = new StringBuilder();
        for(int i = 0; i < charAlphaArr.length; i++) {
            bResult = list.get(i).getValue() >= charAlphaArr[i];
            if (bResult) {
                numbers.append(list.get(i).getKey());
                numbers.append(" ");
                continue;
            } else {
                break;
            }
        }

        String result = !bResult ? "NO" : "YES" + "\n" + numbers.toString().trim();

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
