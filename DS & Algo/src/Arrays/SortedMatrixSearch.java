package Arrays;

public class SortedMatrixSearch {
    /*time complexity o(n+m)*/
    public static Object findKeyUsingMovingDirections(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        //i is the last row
        int i=numberOfRows-1;
        //j is the first column
        int j=0;

        while(i>=0 && j<numberOfColumns){
            if(matrix[i][j]==target){
                return true;
            }

            if(target>matrix[i][j]){
                j++;
            }
            else {
                i--;
            }
            }

        return false;
    }
    /*time complexity o(logn+logm)*/
    public static Object findKeyUsingBinarySearch(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
       int min=0;
       int max= numberOfColumns*numberOfRows-1;

       while (min<=max){
           /*
           for example min=0,max=3*3-1=8
           middle= 0+8/2=4
           row=4/3=1
           col=4%3=1
            */
           int middle= (min+max)/2;
           int row= middle/numberOfColumns;
           int col= middle%numberOfColumns;
           if(target==matrix[row][col]){
               return true;
           }
           else if(target<matrix[row][col]){
               max=middle-1;
           }
           else {
               min=middle+1;
           }
       }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 50}
        };

        // Example 1
        Object x = findKeyUsingMovingDirections(matrix, 4, 4, 80);
        System.out.println("Search for 80 returned findKeyUsingMovingDirections: " + x);

        // Example 2
        x = findKeyUsingMovingDirections(matrix, 4, 4, 15);
        System.out.println("Search for 15 returned findKeyUsingMovingDirections:  " + x);

        Object y = findKeyUsingBinarySearch(matrix, 4, 4, 80);
        System.out.println("Search for 80 returned findKeyUsingBinarySearch:  " + y);

        // Example 2
        y = findKeyUsingBinarySearch(matrix, 4, 4, 15);
        System.out.println("Search for 15 returned findKeyUsingBinarySearch: " + y);
    }

}
