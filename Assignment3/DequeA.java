public class DequeA<Item> {
	private Node first;
	private Node last;
	private int size;

	private class Node {
		Item data;
		Node next;
	}

	public DequeA() {
		first=null;
		last=null;
		size=0;
	}

	public void enqueueBack(Item elem) {
		Node oldlast=last;
        last=new Node();
        last.data=elem;
        last.next=null;
        if(isEmpty())
            first=last;
        else
            oldlast.next=last;
        size+=1;
	}

	public Item dequeueFront() {
		Item r=first.data;
		first=first.next;
		size -=1;
		if(isEmpty())
			last=null;
		return r;
	}

	public void enqueueFront(Item elem){
		Node oldfirst=first;
		first=new Node();
		first.data=elem;
		first.next=null;
		if(isEmpty())
			last=first;
		else
			first.next=oldfirst;
		size+=1;
	}

	public Item dequeueBack(){
		
		Node temp = first;
		Item r=last.data;
		Node oldequeulast=last;
		oldequeulast=null;
		if(isEmpty())
			last=null;
		for(int i=0;i<size-2;i++){
			temp=temp.next;
			last=temp;
		}
		if(size==1){
			last=first;
			r=last.data;
		}

		size-=1;

		return r;
	}
	
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public static void main(String[] args) {
        DequeA<Integer> q = new DequeA<Integer>();

        for (int i = 0; i < 5; i += 1)
            q.enqueueFront(i);

        q.enqueueFront(42);
        StdOut.println();
        StdOut.println("We have enqueued " + q.size() + " items to the queue (FRONT).");

        for (int i = 0; i < 5; i += 1)
            q.enqueueBack(i);

        q.enqueueBack(42);
        StdOut.println();
        StdOut.println("We have enqueued " + q.size() + " items to the queue (BACK).");

        while (!q.isEmpty())
            StdOut.println(q.dequeueBack());

        StdOut.println();
        StdOut.println("There are " + q.size() + " items remaining in the queue (BACK).");

        while (!q.isEmpty())
            StdOut.println(q.dequeueFront());

        StdOut.println();
        StdOut.println("There are " + q.size() + " items remaining in the queue (FRONT).");
        StdOut.println();
    }
}