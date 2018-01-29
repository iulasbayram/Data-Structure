public class DequeB<Item> {
	private Node first;
	private Node last;
	private int size;
	
	private class Node{
		Item data;
		Node next;
		Node prev;
	}

	public DequeB(){
		first=null;
		last=null;
		size=0;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public void enqueueB(Item item){
		Node n= new Node();
		n.data=item;
		if(size==0){
			n.prev=n;
			n.next=n;
			first=n;
			last=n;
		}else{
			
			n.next=first;
			n.prev=last;
			last.next=n;
			last=n;
			first=n.next;
		}
		size+=1;
		StdOut.println();
		StdOut.println("Last data-----> " + last.data);
	}

	public void enqueueF(Item item){
		Node n=new Node();
		n.data=item;
		if(size==0){
			n.prev=n;
			n.next=n;
			first=n;
		}else{
			n.next=first;
			n.prev=last;
			last.next=n;
			first=n.next;
			first=n;
		}
		size+=1;
		StdOut.println();
		StdOut.println("First data-----> " + first.data);
	}

	public Item dequeueF() {
		Item r=first.data;
		size-=1;
		if(size==0){
			first=null;
		}else{
			last.next=first.next;
			first.next.prev=last;
			first=first.next;
		}
		return r;
	}

		public Item dequeueB() {
		Item r= last.data;
		Node temp= first;
		Node oldequeueLast=last;
		oldequeueLast=null;
		int counter=size;
		if(size==0)
			last=null;
		
		for(int i=1; i<counter-1; i++){
			temp=temp.next;
			last=temp;

		}
		if(size==1){
			last=first;
			r=last.data;
		}
		first.prev=last;
		last.next=first;

		size-=1;

		return r;

	}

	public static void main(String[] args) {
        DequeB<Integer> q = new DequeB<Integer>();

        for (int i = 0; i < 2; i += 1)
            q.enqueueB(i);

        q.enqueueB(42);
        StdOut.println();
        StdOut.println("We have back-enqueued " + q.size() + " items to the queue.");

        for (int i = 0; i < 2; i += 1)
            q.enqueueF(i);

        q.enqueueF(42);
        StdOut.println();
        StdOut.println("We have front-enqueued " + q.size() + " items to the queue.");

        while (!q.isEmpty())
            StdOut.println(q.dequeueB());
        StdOut.println();
        StdOut.println("There are " + q.size() + " items remaining in the queue.");
    	StdOut.println();
    }

}