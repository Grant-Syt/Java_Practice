
// algorithm that reverses the order of words in a sentence
// and spaces them normally regardless of the input's spacing



public class ReverseWords {
	
	public static void main(String[] args) {
		System.out.println(reverseWords(" this is a super   long string of characters with  weird spacing  "));
	}
	
    public static String reverseWords(String s) {
        StringBuffer str = new StringBuffer(s);
        StringBuffer newStr = new StringBuffer();
        int currentChar = str.length() - 1;
        
        while (currentChar >= 0) {
            if (str.charAt(currentChar) == ' ') {
                currentChar--;
            } else {
                int wordEnd = currentChar;
                while (currentChar != 0 && str.charAt(currentChar) != ' ') {
                    currentChar--;
                }
                for (int i = 0; i <= wordEnd-currentChar; i++) {
                    if (str.charAt(currentChar + i) == ' ') {
                    	// ignore space
                    } else {
                    	newStr.append(str.charAt(currentChar + i));
                    }
                }
                if (currentChar == 0) {
                	currentChar--;
                	newStr.append(' ');
                } else {
                	newStr.append(' ');
                }
            }
        }
	    if (newStr.length() > 0) {
	    	newStr.deleteCharAt(newStr.length()-1);
	    }
	    return newStr.toString();
    }
}
