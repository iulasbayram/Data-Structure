public class List{
	private Node first;
	private Node last;
	private int size;

	private class Node{
		Item item;
		Node next;
	}

	public List(){
		first=null;
		last=null;
		size=0;
	}

	public void insertBack(Comparable elem){
		Node oldlast=last;
        last=new Node();
        last.item=elem;
        last.next=null;
        if(isEmpty())
            first=last;
        else
            oldlast.next=last;
        size+=1;


	}

	public Item removeBack(){
		Node temp = first;
		Item r=last.item;
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
			r=last.item;
		}

		size-=1;

		return r;
	}

	public int size(){
		return size;
	}

	public void sort(){
		
	}


}