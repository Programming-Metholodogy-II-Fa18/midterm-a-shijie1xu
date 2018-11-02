import java.util.NoSuchElementException;

import Queue.Node;

public class Queue {
	public class Node {
			int key;
			Node next;
			Node prev;
		public Node(int key, Node next, Node prev){
			this.key = key;
			this.next = next;
			this.prev = prev;
		}
	}
	public static int size;
	static Node head;
	public Queue(){ // constructor
		size = 0;
		head = null;
	}

	public void add(int a){
		if(size == 0){
			Node temp = new Node(a,null, null);
			head = temp;
			size++;
		}
		else{
			Node ptr = head;
			while(ptr.next!=null){
				ptr = ptr.next;
			}
			Node temp = new Node(a,null,ptr);
			ptr.next = temp;
			size++;
		}
	}
	
	public int remove()
	throws NoSuchElementException{
		if(size == 0){
			throw new NoSuchElementException("The Data Structure is Empty!");
		}
		else if(size == 1){
			int r = head.key;
			head = null;
			size--;
			return r;
		}
		else{
			int temp = head.key;
			head = head.next;
			head.prev = null;
			size--;
			return temp;
		}
		
	}
	
	public static int getValue(int i){
		int value = -1;
		if (i > size){
			return value;
		}
		
		Node ptr =head;
		int count = 0;

		while(ptr !=null){
			if(count == i){
				break;
			}
			count++;
			ptr = ptr.next;
		}
		value = ptr.key;
		return value;
	}
	
	private static void traverse(){
		Node ptr = head;
		System.out.println("The data structure is: ");
		while(ptr != null){
			System.out.print(ptr.key + " ");
			ptr = ptr.next;
		}
		System.out.println();
		System.out.println();
	}
	
	public static int search(int data){
		int count=0;
		Node mid = getMid(head);
		if(data < mid.key){
			count++;
			while(mid.key != data && mid != null){
				mid = mid.prev;
				count ++;
			}
		}
		else if(data > mid.key){
			count++;
			while(mid.key != data && mid != null){
				mid = mid.next;
				count ++;
			}
		}
	
		
		
		
		return count;
	}
	
	private static Node getMid(Node head){
		Node tail = head;
		while(tail.next !=null){
			tail = tail.next;
		}
		Node temp_tail = tail;
		Node mid =head;
		while(temp_tail.prev != null&& mid.next !=null){
				if(mid.key == temp_tail.key){
					break;
				}
				temp_tail = temp_tail.prev;
				mid = mid.next;
		}
		return mid;
	}
	public static void main(String[] args){
		Queue data = new Queue();
		data.add(1);
		data.add(5);
		data.add(8);
		data.add(10);
		data.add(12);
		data.add(14);
		data.add(18);
		data.add(20);
		data.add(33);
		data.add(41);
		
		traverse();
		
	}
	
}
