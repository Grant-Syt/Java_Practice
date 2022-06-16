

public class Palindrome {
	
	public static void main(String[] args) {
		System.out.println(isStringPalindrome("abcba"));
	}
	
	public static boolean isStringPalindrome(String str) {
        // If the length is < 1, return true
        if(str == null || str.length() < 1) return true;
        int l = str.length();
        // Run a for loop from 0 to length/2
        for (int i = 0; i <= l / 2; i++) {
        	int a = l-1-i;
        	System.out.println("Indices compared: " + i + " and " + a);
        	// Compare the first char with the last char (ith position with (l-1-i)th position)
            if (str.charAt(i) != str.charAt(l - 1 - i)) 
            {
                // Return false if in any iteration, these 2 chars are not the same
            	return false;
            }
        }
        // Otherwise return true
        return true;
    }
}
