

import java.util.Arrays;
import java.util.HashSet;

// Source: GeeksforGeeks
public class Triplets {
	
	// Driver code 
    public static void main(String[] args) {
    	// Each method prints all triplets in 
        // arr[] with given sum
    	
        /* test brute force method
         * should print:
         * 0 -3 1
         * -1 2 -3
         */
    	int arr[] = { 0, -1, 2, -3, 1 }; 
        int sum = -2;
    	int n = arr.length; 
        findTripletsBF(arr, n, sum);
        System.out.println();
        
        /* test HashSet method
         * should print:
         * -3 0 1
         * 2 -1 -3
         */
        arr = new int[]{ 0, -1, 2, -3, 1 }; 
        sum = -2; 
        n = arr.length; 
        findTripletsHS(arr, n, sum);
        System.out.println();
        
        /* test two pointer method
         * should print:
         * -3 -1 2
         * -3 0 1
         */
         arr = new int[] { 0, -1, 2, -3, 1 }; 
         sum = -2;
         n = arr.length;
         findTripletsTP(arr, n, sum);
    }
	
    // Brute force method
    static void findTripletsBF(int arr[], int n, int sum) { 
        for (int i = 0; i < n - 2; i++) { 
            for (int j = i + 1; j < n - 1; j++) { 
                for (int k = j + 1; k < n; k++) { 
                    if (arr[i] + arr[j] + arr[k] == sum) { 
                        System.out.println(arr[i] + " " 
                        		+ arr[j] + " " + arr[k]);
                    } 
                }
            }
        }
    }
    
    // HashSet method
    static void findTripletsHS(int arr[], int n, int sum) { 
        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to 
            // "sum-arr[i]" 
            HashSet<Integer> s = new HashSet<>(); 
            for (int j = i + 1; j < n; j++) { 
                int x = sum - (arr[i] + arr[j]); 
                if (s.contains(x)) 
                    System.out.printf( 
                        "%d %d %d\n", x, arr[i], arr[j]); 
                else
                    s.add(arr[j]);
            } 
        } 
    }
    
    // Sort and two pointer method
    static void findTripletsTP(int[] arr, int n, int sum) {
		// sort array elements 
		Arrays.sort(arr);

		for (int i = 0; i < n - 1; i++) {
			// initialize left and right
			int l = i + 1;
			int r = n - 1;
			int x = arr[i];
			while (l < r) {
				if (x + arr[l] + arr[r] == sum) {
				   // print elements if it's
				   // sum is target sum.
				   System.out.println(x + " " + arr[l] + " " + arr[r]);
				   l++;
				   r--;
				}
				// if sum of three elements 
				// is less than target sum, 
				// then increment left
				else if (x + arr[l] + arr[r] < sum)
				   l++;
				// if sum is greater than
				// target sum, then decrement
				// right side
				else
				   r--;
			}
		}
    }
    
}
