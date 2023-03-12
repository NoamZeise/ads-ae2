
public class ae2 {


    public class Queue {
	class Cell {
	    int car;
	    Cell cdr;
	    Cell(int car, Cell cdr) {
		
	    }
	}
	Cell head;

	public void push(int x) {
	    head = new Cell(x, head); 
	}

	public int pop() {
	    int v = head.car;
	    head = head.cdr;
	    return v;
	}
    }

    public class Stack {
	class Cell {
	    int count;
	    int car;
	    Cell cdr;
	    Cell(int car, Cell cdr) {
		this.car = car;
		this.cdr = cdr;
	    }
	}
	Cell head;

	public void push(int x) {
	    head = new Cell(x, head); 
	}

	public int pop() {
	    int v = head.car;
	    head = head.cdr;
	    return v;
	}
    }


    public int hashCode(String s) {
	int hash = 0;
	int skip = Math.max(1, s.length() / 3);
	for (int i = 0; i < s.length(); i += skip)
	    hash = (hash * 37) + s.charAt(i);
	return hash;
    }

    void genSameHashStrings(int n) {

    }



    public static void main(String[] args) {
	System.out.println("Hello ae2");
    }
}
