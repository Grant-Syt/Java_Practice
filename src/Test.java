

public class Test {

	public static void main(String[] args) {
		System.out.println(testEquation(1));
		System.out.println(testEquation(2));
		System.out.println(testEquation(3));
		System.out.println(testEquation(4));
		System.out.println(testEquation(5));
		System.out.println(testEquation(10));
		System.out.println(testEquation(100));
	}
	
	public static int testEquation(int n) {
		return (int) Math.floor((Math.pow(n, 2)*(n-1))/2);
	}
}
