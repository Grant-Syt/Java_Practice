

public class ThreadClassDemo {
	
	/* This demo tests threads in Java. Two threads are made to work
	 * the whole time the program runs, while two other threads
	 * attempt to guess a number. The later two threads run one
	 * after the other. The program terminates after the second number
	 * is guessed.
	 * 
	 * Source: Tutorialspoint
	 */

	public static void main(String [] args) {
		// print hello loop thread
		Runnable hello = new DisplayMessage("Hello");
		Thread thread1 = new Thread(hello);
		thread1.setDaemon(true);
		thread1.setName("hello");
		System.out.println("Starting hello thread...******************************************");
		thread1.start();
		
		// print goodbye loop thread
		// tests min priority
		Runnable bye = new DisplayMessage("Goodbye");
		Thread thread2 = new Thread(bye);
		thread2.setPriority(Thread.MIN_PRIORITY);
		thread2.setDaemon(true);
		thread2.setName("goodbye");
		System.out.println("Starting goodbye thread...******************************************");
		thread2.start();
		
		// thread 3 guesses number
		// main stops until thread 3 dies
		System.out.println("Starting thread3...******************************************");
		Thread thread3 = new GuessANumber(1);
		thread3.setName("Thread3");
		thread3.start();
		try {
		   thread3.join();
		} catch (InterruptedException e) {
		   System.out.println("Thread interrupted.******************************************");
		}
		
		// thread 4 guesses number after thread 3 dies
		System.out.println("Starting thread4...******************************************");
		Thread thread4 = new GuessANumber(100);
		thread4.setName("Thread4");
		thread4.start();
		System.out.println("main() is ending...******************************************");
	}
}

// demonstrates extending "Thread" to make a new thread
class GuessANumber extends Thread {
	   private int number;
	   
	   // thread tries to guess "number"
	   // input can be 1-100
	   public GuessANumber(int number) {
	      this.number = number;
	   }
	   
	   public void run() {
	      int counter = 0;
	      int guess = 0;
	      do {
	         guess = (int) (Math.random() * 100 + 1);
	         System.out.println(this.getName() + " guesses " + guess);
	         counter++;
	      } while(guess != number);
	      System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.***************************");
	   }
}

// demonstrates implementing "Runnable" to make a new thread
class DisplayMessage implements Runnable {
	   private String message;
	   
	   public DisplayMessage(String message) {
	      this.message = message;
	   }
	   
	   // infinite loop prints message
	   public void run() {
	      while(true) {
	         System.out.println(message);
	      }
	   }
}
