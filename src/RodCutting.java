

public class RodCutting {
	
	public static void main(String[] args) {
		
		double startTime, endTime;
		int intResult;
		int[] arrayResult;

		int[] arr = {0,1,5,8,9,10,17,17,20,24,30,1,5,8,9,10,17,17,20,24,30,1,5,8,9,10,17,17,20,24,30,1,1};
		
		System.out.println("Naive solution:");
		startTime = System.currentTimeMillis();
		intResult = cut_rod_naive(arr, 32);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + ((endTime - startTime) / 1000));
		System.out.println("Result: " + intResult);
		
		System.out.println("\nBook DP solution:");
		startTime = System.currentTimeMillis();
		arrayResult = cut_rod_dp_bup_book(arr);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + ((endTime - startTime) / 1000));
		System.out.println("Result: " + arrayResult[32]);
		
		System.out.println("\nRevised DP solution:");
		startTime = System.currentTimeMillis();
		arrayResult = cut_rod_dp_bup(arr);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + ((endTime - startTime) / 1000));
		System.out.println("Result: " + arrayResult[31]);
	}
	
	public static int[] cut_rod_dp_bup(int[] p) {
		//dynamic programming, bottom up
		//does not include rod of length 0
		
		//print input
//		System.out.println("input:");
		int n = p.length;
//		System.out.println("len(p) = " + n);
//		for (int i=0; i<n; i++) {
//			System.out.println("p[" + i + "] = " + p[i]);
//		}

		// remove 0 from index 0
		int[] p2 = new int[n-1];
		for (int i=1; i<n; i++) {
			p2[i-1] = p[i];
		}
		n = n-1;
		
		//algorithm
		int[] r = new int[n];
		for (int j=1; j<=n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i=1; i<=j; i++) {
				if (i==j) {
					q = Math.max(q, p2[i-1]);
				} else {
					q = Math.max(q, p2[i-1] + r[j-i-1]);
				}
			}
			r[j-1] = q;
		}
		
		//print output
//		System.out.println("output:");
//		for (int i=0; i<n; i++) {
//			System.out.println("r[" + i + "] = " + r[i]);
//		}
		
		return r;
	}
	
	public static int[] cut_rod_dp_bup_book(int[] p) {
		//dynamic programming, bottom up
		//includes rod of length 0 (from CLRS)
		
		//print input
//		System.out.println("input:");
		int n = p.length-1;
//		System.out.println("len(p) = " + n);
//		for (int i=0; i<=n; i++) {
//			System.out.println("p[" + i + "] = " + p[i]);
//		}
		
		//algorithm
	    int[] r = new int[n+1];
		r[0] = 0;
		for (int j=1; j<=n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i=1; i<=j; i++) {
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		
		//print output
//		System.out.println("output:");
//		for (int i=0; i<=n; i++) {
//			System.out.println("r[" + i + "] = " + r[i]);
//		}
		
		return r;
	}
	
	public static int cut_rod_naive(int[] p, int n) {
		//naive solution, includes rod of length 0 (from CLRS)
		if (n==0) { return 0; }
		int q = Integer.MIN_VALUE;
		for (int i=1; i <=n; i++) {
			q = Math.max(q, p[i] + cut_rod_naive(p, n-i));
		}
		return q;
	}
}
