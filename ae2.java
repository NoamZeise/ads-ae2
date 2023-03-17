// for returning a list of string from part 3
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ae2 {

    /// -------------- PART 2 -----------------

    public static class Queue {
	public static class Cell {
	    int car;
	    Cell cdr;
	}
	public static Cell cons(int car, Cell cdr) {
	    Cell n = new Cell();
	    n.car = car;
	    n.cdr = cdr;
	    return n;
	}	
	Cell head;
	public Queue() {
	    head = null;
	}
	
	public void enqueue(int x) {
	    if(head == null)
		head = cons(x, null);
	    else{
		Cell n = cons(x, head.cdr);
		if(n.cdr == null)
		    n.cdr = head;
		head.cdr = n;
		head = n;
	    }
	}

	public int dequeue() {
	    if(head == null)
		throw new EmptyStackException();
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

    public static void queue_demo() {
	Queue q = new Queue();
	q.enqueue(0);
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	q.print();
	System.out.println("----------");
	System.out.println(q.dequeue() == 0); 
	System.out.println(q.dequeue() == 1); 
	System.out.println(q.dequeue() == 2); 
	System.out.println("----------");
	q.enqueue(5);
	q.print(); // 3 4 5
	System.out.println(q.dequeue() == 3); 
	System.out.println(q.dequeue() == 4);
	q.enqueue(6);
	System.out.println(q.dequeue() == 5);
	System.out.println(q.dequeue() == 6);
	try {
	    q.dequeue();
	} catch(EmptyStackException e) {
	    System.out.println("expected exception occured");
	}
    }

    /// -------------- PART 2 -----------------
    
    
    public static class Stack {
	static class Elem {
	    int v;
	    int count;
	    Elem prev;
	    Elem next;
	    Elem(int v, Elem next, Elem prev) {
		this.v = v;
		this.next = next;
		this.count = 1;
	    }
	}
	public Stack() {
	    head = null;
	}
	
	Elem head;

	public void push(int x) {
	    Elem e = head;
	    while(e != null) {
		if(e.v == x) {
		    e.count += 1;
		    return;
		}
		e = e.next;
	    }
	    head = new Elem(x, head, null);
	    if(head.next != null)
		head.next.prev = head;
	}
    
	public int pop() {
	    if(head == null)
		throw new EmptyStackException();
	    Elem e = head;
	    Elem max = head;
	    while(e != null) {
		if(e.count > max.count)
		    max = e;
		e = e.next;
	    }
	    int v = max.v;
	    max.count--;
	    if(max.count <= 0) {
		if(max.prev != null)
		    max.prev.next = max.next;
		if(max.next != null)
		    max.next.prev = max.prev;
		if(max == head)
		    head = head.next;
	    }
	    return v;
	}

	public void print() {
	    System.out.println("---");
	    Elem e = head;
	    while(e != null) {
		System.out.println("val: " + e.v + "  count: " + e.count);
		e = e.next;
	    }
	}
    }

    public static void stack_demo() {
	Stack s = new Stack(); //( elem1 - count1) (elem2, count2) 
	s.push(1);// (1 - 1)
	s.push(1);
	s.push(1);
	s.print();// (1 - 3)
	s.push(2);// (2 - 1) (1 - 3)
	s.push(2);
	s.push(2);
	s.print();// (2 - 3) (1 - 3)
	System.out.println(s.pop() == 2);
	System.out.println(s.pop() == 1);
	System.out.println(s.pop() == 2);
	s.print(); // (2 - 1) (1 - 2)
	s.push(3);
	s.push(4);
	s.print(); // (4 - 1) (3 - 1) ( 2 - 1) (1 - 2)
	System.out.println(s.pop() == 1);
	System.out.println(s.pop() == 4);
	s.print(); // (3 - 1) ( 2 - 1) (1 - 1)
	s.push(2);
	System.out.println(s.pop() == 2);
	System.out.println(s.pop() == 3);
	System.out.println(s.pop() == 2);
	System.out.println(s.pop() == 1);
	s.print(); // empty
	try {
	    s.pop();
	} catch (EmptyStackException e) {
	    System.out.println("proper exception thrown");
	}
    }

    /// -------------- PART 3 -----------------

    public static int hashCode(String s) {
	int hash = 0;
	int skip = Math.max(1, s.length() / 3);
	for (int i = 0; i < s.length(); i += skip)
	    hash = (hash * 37) + s.charAt(i);
	return hash;
    }

    static ArrayList<String> genSameHashStrings(int n) {
	ArrayList<String> strings = new ArrayList<String>();
	for(int i = 1; i <= n && strings.add("---".repeat(i)); i++);
	return strings;
    }

    static void hash_demo() {
	for(String s: genSameHashStrings(13)) {
	    System.out.println(s);
	    System.out.println(hashCode(s));
	}
    }

    
    public static void main(String[] args) {
	System.out.println("----- AE2 -----");
	System.out.println("----PART1-----");
	queue_demo();
	System.out.println("----PART2-----");
	stack_demo();
	System.out.println("----PART3-----");
	hash_demo();
    }
    
}
