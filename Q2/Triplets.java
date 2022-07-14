import java.util.*;
public class Triplets {
    public static int checkForTriplets(Integer arr[]) {
        int tripletsCount = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(Arrays.asList(arr).contains(arr[i]+arr[j])) {
                    tripletsCount++;
                }
            }
        }
        return tripletsCount;
    }
    public static void main(String args[]) {
        Integer arr[] = {11,10,1,2,12,13};
        System.out.println("Number of Triplets : "+checkForTriplets(arr));
    }
}
