package Arrays;

public class SplitArray2EqualSum {
    static int findSplitPoint(int arr[]){
        int leftSum=0;

        for(int i=0;i<arr.length;i++){
            leftSum+=arr[i];
        }

        int rightSum=0;

        for(int i=arr.length-1;i>=0;i--){
            rightSum+= arr[i];
            leftSum-=arr[i];

            if(rightSum==leftSum){
                return i;
            }
        }

        return -1;
    }

    static void printTwoParts(int arr[]){
        int splitPoint= findSplitPoint(arr);
        if(splitPoint==-1 || splitPoint== arr.length){
            System.out.println("Not Possible");
        }

        for(int i=0;i<arr.length;i++){
            if(splitPoint==i)
                System.out.println();
            System.out.println(arr[i] + "");
        }
    }
    public static void main (String[] args) {

        int arr[] = {1 , 2 , 3 , 4 , 5 , 5 };
        int n = arr.length;

        printTwoParts(arr);

    }
}
