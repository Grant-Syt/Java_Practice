

import java.util.ArrayList;
import java.util.Stack;

public class CustomStackTest {
	public static void main(String[] args) {
		CustomStack cs = new CustomStack();
		
		cs.push(1);
		cs.push(2);
		cs.push(3);
		cs.push(4);
		cs.push(5);
		cs.push(6);
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop() + "\n");
		
		cs.push(1);
		cs.push(2);
		cs.push(3);
		cs.push(4);
		cs.push(5);
		cs.push(6);
		cs.increment(3, 2);
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.pop() + "\n");
	}
}

class CustomStack {
	private ArrayList<Integer> incArr;
    private Stack<Integer> st;

    CustomStack() {
    	incArr = new ArrayList<Integer>();
    	st = new Stack<Integer>();
    }

    public void push(int x) {
            st.push(x);
            incArr.add(0);
    }

    public int pop() {
        if(st.size() == 0) {
        	return -1;
        }
        int poppedInt = st.peek();
        st.pop();
        int incIndex = incArr.size()-1;
        // increment values as they are popped and move the increment info down
        if(incArr.get(incIndex) != 0){
        	poppedInt += incArr.get(incIndex);
        	if (incIndex != 0) {
        		incArr.set(incIndex-1, incArr.get(incIndex) 
                		+ incArr.get(incIndex-1));
        	}
        }
        incArr.remove(incIndex);
        return poppedInt;
    }

    // increment last k elements
    public void increment(int k, int val) {
    	int incIndex = incArr.size()-1;
        incArr.set(Math.min(k-1, incIndex), val
        		+ incArr.get(incIndex));
    }
    
}
