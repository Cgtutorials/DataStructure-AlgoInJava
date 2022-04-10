package DivideAndConquer;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Arrays;

public class InversionCount {
    public InversionCount() {
    }

    private static Object countInversions(int[] arr) {
        int size = arr.length;
        int[] temp = new int[size];
        return countInversionsUtil(arr, temp, 0, size - 1);
    }

    private static int countInversionsUtil(int[] arr, int[] temp, int start, int end) {
        int inversionCount = 0;

        if (start < end) {
            int mid = (start + end) / 2;
            inversionCount = countInversionsUtil(arr, temp, start, mid);
            inversionCount += countInversionsUtil(arr, temp, mid + 1, end);
            inversionCount += merge(arr, temp, start, mid + 1, end);
        }

        return inversionCount;
    }

    private static int merge(int[] arr, int[] temp, int start, int mid, int end) {
        int invCount = 0;
        int i = start;
        int j = mid;
        int var8 = start;

        while(i <= mid - 1 && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[var8++] = arr[i++];
            } else {
                temp[var8++] = arr[j++];
                invCount += mid - i;
            }
        }

        return invCount;
    }

    public static void main(String[] args) {
        System.out.println("Given Array Inversion Count\n");
        int[] arr = new int[]{3, 2, 8, 4};
        System.out.println(Arrays.toString(arr) + " -> " + countInversions(arr));
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr1) + " -> " + countInversions(arr1));
        int[] arr2 = new int[]{10, 9, 8, 7, 6};
        System.out.println(Arrays.toString(arr2) + " -> " + countInversions(arr2));
    }
}

