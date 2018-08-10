package study;

public class StudyTests {

    public static void main(String[] args) {

        int arr[] = new int[]{3, 87, -4, 0, 67, 34, 2, 12, 3, 2, 6, -67, 4, 0, 24, 77, -5, -23};
        System.out.println(findTheBiggest(arr));
    }

    static int findTheBiggest(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
