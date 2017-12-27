package permutations.combinatoring.npermutation;
/*This program implements the mathematic formula that calculates the number of permutations with repetitions*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NPermutator {

    public static void main(String[] args) {
        // code just to receive values for permutation
        boolean notExit = true;
        Permutator permutator = new Permutator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(notExit) {
            String numberOfElems = "";
            int elemsNum = 0;
            System.out.println("Input the number of components, please (from 2 to 9): ");
            while(!permutator.inputInt(numberOfElems)) {
                try {
                    numberOfElems = reader.readLine();
                    if (permutator.inputExit(numberOfElems)) {
                        System.out.println("You input \"Exit\" the program!");
                        notExit = false;
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        System.exit(0);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!permutator.inputInt(numberOfElems)) {
                    System.out.println("You input not a number. Try again, please.");
                }
            }
            System.out.println();

            elemsNum = permutator.recieveNumber(numberOfElems);
            String[] strArr = new String[elemsNum];
            System.out.println("Please, input the elements for permutations: (+ Enter after every element) ");
            int counterIndex = 0;
            while(counterIndex < elemsNum) {
                try {
                    strArr[counterIndex] = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                counterIndex++;
            }

            // main code
            int[] array = permutator.formIntArray(strArr);
            Collection<ArrayList<String>> resultSet = null;
            if (permutator.haveRepetitions(strArr)) {
                resultSet = new HashSet<>();
            } else {
                resultSet = new ArrayList<>();
            }
            resultSet.add(new ArrayList<>(Arrays.asList(strArr)));
            while(permutator.nextSet(array)) {
                resultSet.add(permutator.formList(array, strArr));
            }
            permutator.displayTheResultOfPermutations(resultSet);
        }
    }

}
