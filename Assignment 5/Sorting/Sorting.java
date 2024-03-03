import java.util.Arrays;

/*
 * Quadratic Sorting: O(n^2)
 *      Takes more time to sort since it relies on nested loops to look through all the elements in the array
 *      to decide where to put each element.
 * Sublinear Sorting: O(nlogn)
 *      Takes less time to sort because the machine is not required to look at every element in the array.
 *      This is because recursion divides the array into smaller sections.
 */
public class Sorting {

    static boolean bubbleDone = false;
    static boolean mergeDone = false;
    static int n = 10;
    public static void main(String[] args) {

        double[] bubbleSort;
        double[] mergeSort;

        while (!bubbleDone && !mergeDone) {
            try {
                // creating arrays
                bubbleSort = new double[n];
                mergeSort = new double[n];
                for (int i = 0; i < bubbleSort.length; i++) {
                    bubbleSort[i] = Math.random();
                }
                mergeSort = Arrays.copyOf(bubbleSort, n);

                // bubble sort
                if (!bubbleDone) {
                    long start = System.currentTimeMillis();
                    bubbleSort(bubbleSort);
                    if (!bubbleDone) {
                        if (start + 20000 <= System.currentTimeMillis()) {
                            System.out.println("Bubble sort executed for more than 20 seconds.");
                            System.exit(0);
                        }
                        long end = System.currentTimeMillis();
                        long bubbleTime = end - start;
                        System.out.println("Bubble sort time: " + bubbleTime + " ms");
                    }
                }
                // merge sort
                if (!mergeDone) {
                    long start = System.currentTimeMillis();
                    mergeSort(mergeSort);
                    if (!mergeDone) {
                        if (start + 20000 <= System.currentTimeMillis()) {
                            System.out.println("Merge sort executed for more than 20 seconds.");
                            System.exit(0);
                        }
                        long end = System.currentTimeMillis();
                        long mergeTime = end = start;
                        System.out.println("Merge sort time: " + mergeTime + " ms");
                    }
                }
                // multiplying array length by ten
                n *= 10;
            } catch (OutOfMemoryError e) {
                System.out.println("Machine ran out of memory.");
            }
        }
    }
    
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        boolean swapped;
        double temp;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static double[] mergeSort(double[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        int m = n / 2;
        double[] b = Arrays.copyOfRange(arr, 0, m);
        double[] c = Arrays.copyOfRange(arr, m, n);
        b = mergeSort(b);
        c = mergeSort(c);
        int i = 1; int j = 1; int k = 1;
        while (i < b.length && j < c.length) {
            if (b[i] < c[j]) {
                arr[k] = b[i];
                k++; i++;
            } else {
                arr[k] = c[j];
                k++; j++;
            }
        }
        while (i < b.length) {
            arr[k] = b[i];
            i++; k++; 
        }
        while (j < c.length) {
            arr[k] = c[j];
            j++; k++;
        }
        return arr;
    }
}