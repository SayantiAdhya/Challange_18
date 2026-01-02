import java.util.*;

class Line {

    // Reverse array
    static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    // Move all zeros to the end
    static void zero(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }
        while (count < arr.length) {
            arr[count++] = 0;
        }
    }

    // Remove duplicates (array must be sorted)
    static int duplicates(int[] arr) {
        if (arr.length <= 1)
            return arr.length;

        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }
        return index;
    }

    // Median of array
    static double medianArr(int[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }

    // Ascending / Descending / Unsorted
    static boolean statusofArr(int[] arr) {
        boolean isAscending = true;
        boolean isDescending = true;

        if (arr.length <= 1)
            return true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isDescending = false;
            }
            if (arr[i] > arr[i + 1]) {
                isAscending = false;
            }
            if (!isAscending && !isDescending) {
                return false;
            }
        }
        return true;
    }

    // Print array helper
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Timeline {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your timeline size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.print("Enter your timeline elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    
   while(true){
        System.out.println("\n1. Travel to the past (Reverse)");
        System.out.println("2. Clean the Timeline (Move zeros)");
        System.out.println("3. Compress History (Remove duplicates)");
        System.out.println("4. Find the Present Moment (Median)");
        System.out.println("5. Timeline Stability (Sorted check)");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                Line.reverseArray(arr);
                System.out.print("Reversed array: ");
                Line.printArray(arr, arr.length);
                break;

            case 2:
                Line.zero(arr);
                System.out.print("After moving zeros: ");
                Line.printArray(arr, arr.length);
                break;

            case 3:
                Arrays.sort(arr);
                int newSize = Line.duplicates(arr);
                System.out.print("After removing duplicates: ");
                Line.printArray(arr, newSize);
                break;

            case 4:
                double median = Line.medianArr(arr);
                System.out.println("Median is: " + median);
                break;

            case 5:
                boolean sorted = Line.statusofArr(arr);
                if (sorted) {
                    System.out.println("Array is sorted (Ascending or Descending)");
                } else {
                    System.out.println("Array is NOT sorted");
                }
                break;

            case 6:
                System.out.println("Thank you for using Timeline.");
                sc.close();
                return;

            default:
                System.out.println("Invalid option! Try again.");
        }

    }
}
}
