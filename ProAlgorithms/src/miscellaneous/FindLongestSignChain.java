package miscellaneous;

public class FindLongestSignChain {
    public static void main(String[] args) {
        //                                                                                            ||||||||||||||||||
        String line = "1000100101010111100001101101001011101111111111111100010101010010011001111110011011111111111111111011"; // answer - 17
        System.out.println("Longest chain has " + findLongestChainOfOnes(line) + " 1-links");
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
}
