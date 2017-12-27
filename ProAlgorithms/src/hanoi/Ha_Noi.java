package hanoi;

public class Ha_Noi {

    // initial - kernel where the discs lay initially
    // aux - auxiliary kernel
    // target - the kernel of final destination
    // 1, 2, 3 - numbers of kernel (initial, aux, target)
    public static void main(String[] args) {
        int numbOfDisks = 3;
        doHa_Noi(numbOfDisks, 1, 2, 3);
    }

    static void doHa_Noi(int num, int initial, int aux, int target) {
        if (num == 1) {
            System.out.println("Disk #1 from " + initial + " -> " + target);
        } else {
            doHa_Noi(num - 1, initial, target, aux);
            System.out.println("Disk #" + num + " from " + initial + " -> " + target);
            doHa_Noi(num - 1, aux, initial, target);
        }
    }
}
