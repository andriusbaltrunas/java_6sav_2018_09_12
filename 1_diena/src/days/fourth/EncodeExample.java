package days.fourth;

import java.io.*;
import java.util.*;

public class EncodeExample {
    public static void main(String[] args) {
        Map<Integer, String> encodes = readEncodeFile();
        List<Integer> letters = readEncodedLetter();

        StringBuilder sb = new StringBuilder();

        letters.forEach(p -> sb.append(encodes.get(p)));

        writeToFile(sb);

        System.out.println(sb.toString());

    }

    private static void writeToFile(StringBuilder sb){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))){
            bw.write(sb.toString());
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private static List<Integer> readEncodedLetter(){
        List<Integer> letters = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader("uzkoduotasLaiskas.txt"))){
            String line;
            while ((line = bf.readLine()) != null){
                String[] items = line.split(" ");
                Arrays.asList(items).forEach(v -> letters.add(Integer.parseInt(v)));
            }
        }catch (IOException e){
            System.out.println(e);
        }

        return letters;
    }

    private static Map<Integer, String> readEncodeFile() {
        Map<Integer, String> encodes = new TreeMap<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("koduote.txt"))) {

            String line;
            while ((line = bf.readLine()) != null){
                String[] items = line.split(" ");

                Integer key = Integer.parseInt(items[0]);
                String val = items[1].equals("tarpas") ? " " : items[1];

                encodes.put(key, val);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return encodes;
    }
}