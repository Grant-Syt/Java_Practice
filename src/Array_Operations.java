import java.util.ArrayList;
import java.util.List;

public class Array_Operations {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 1, 5, 4 };
        List<int[]> res = allSubarray(arr);
        printListOfArrays(res);
        System.out.println("");
        allSubsequence(arr);
    }

    protected static List<int[]> allSubarray(int[] arr) {
        int n = arr.length;
        List<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int range = j - i + 1;
                int[] subarr = new int[range];
                // System.out.print("[");
                for (int k = 0; k < range; k++) {
                    // System.out.print(arr[i + k] + ",");
                    subarr[k] = arr[i + k];
                }
                // System.out.println("]");
                res.add(subarr);
            }
        }
        return res;
    }

    protected static void allSubsequence(int[] arr) {
        subseqHelper(arr, 0, new ArrayList<Integer>());
    }

    private static void subseqHelper(int[] arr, int i, List<Integer> subarr) {
        // base case, past last element
        if (i == arr.length) {
            System.out.println(subarr);
        } else {
            // ignore ith
            subseqHelper(arr, i + 1, subarr);
            // add ith
            subarr.add(arr[i]);
            subseqHelper(arr, i + 1, subarr);
            // remove addition for next call tree
            subarr.remove(subarr.size() - 1);
        }
        return;
    }

    private static void printListOfArrays(List<int[]> ListOfArrays) {
        for (int[] anIntArray : ListOfArrays) {
            List<String> slist = new ArrayList<String>();
            // iterate the retrieved array an print the individual elements
            for (int aNumber : anIntArray) {
                slist.add(Integer.toString(aNumber));
            }
            // slist.remove(slist.size() - 1);
            System.out.println(slist.toString());
        }
    }

}
