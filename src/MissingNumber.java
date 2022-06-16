

public class MissingNumber {
	
	public static void main(String[] args) {
		System.out.println("Solution: " + findMissingNumber(new int[] {1,2,4,5,6,7,8,9,10}));
	}
	
	public static int findMissingNumber(int[] arr) {
	    
	    boolean[] hasValues = new boolean[10];
	    
	    for (int i = 0; i < 9; i++){
	        hasValues[arr[i]-1] = true;
	    }
	    for (int i = 0; i < 10; i++){
	        if (hasValues[i] == false){
	            return i+1;
	        }
	    }
	    return -1;
	}
}
