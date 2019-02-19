package miscellaneous;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindLongestSignChain {
    public static void main(String[] args) {
        //                                                                                            ||||||||||||||||||
        //String line = "1000100101010111100001101101001011101111111111111100010101010010011001111110011011111111111111111011"; // answer - 17
        //System.out.println("The longest 1-chain has " + findLongestChainOfOnes(line) + " 1-links");
        writeResultInFile(findLongestChainOfOnes(readStrFromFile()));
    }



    static int findLongestChainOfOnes(String line) {
        int result = 1, counter = 0;
        char arr[] = line.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                counter++;
            } else {
                if(counter > result) {
                    result = counter;
                }
                counter = 0;
            }
        }
        return result;
    }

    // read/write from/in INPUT.txt/OUTPUT.txt files
    static String readStrFromFile() {
        String result = null;
        try (FileReader reader = new FileReader("D:\\INPUT.txt");
             Scanner scanner = new Scanner(reader);) {
            result = scanner.nextLine();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    static void writeResultInFile(int result) {
        try(FileWriter writer = new FileWriter("D:\\OUTPUT.txt", false))
        {
            writer.write(String.valueOf(result));
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
