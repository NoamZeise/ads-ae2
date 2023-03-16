
public class ae2 {


    public static class Queue {
	class Cell {
	    int car;
	    Cell cdr;
	    Cell(int car, Cell cdr) {
		this.car = car;
		this.cdr = cdr;
	    }
	}
	Cell head;

	public Queue() {
	    head = null;
	}
	
	public void enqueue(int x) {
	    if(head == null)
		head = new Cell(x, null);
	    else{
		Cell n = new Cell(x, head.cdr);
		if(n.cdr == null)
		    n.cdr = head;
		head.cdr = n;
		head = n;
	    }
	}

	public int dequeue() {
	    if(head.cdr == null || head.cdr == head) {
		int v = head.car;
		head = null;
		return v;
	    }
	    int v = head.cdr.car;
	    head.cdr = head.cdr.cdr;
	    return v;
	}

	public void print() {
	    Cell c = head.cdr;
	    while(c != null) {
		System.out.println(c.car);
		c = c.cdr;
		if(c == head) {
		    System.out.println(c.car);
		    break;
		}
	    }
	}
    }


    public static void main(String[] args) {
	System.out.println("----- AE2 -----");
	Queue q = new Queue();
	q.enqueue(0);
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	q.print();
	System.out.println("----------");
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println("----------");
	q.enqueue(5);
	q.print();
	System.out.println("----------");
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



}
