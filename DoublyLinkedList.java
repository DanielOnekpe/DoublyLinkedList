package Examsn;

class DoublyLinkedList {
    Node head;
	public DoublyLinkedList()
	{
		head = null;
	}
	
	public void push(int data)
	{
		//puts a node at the head of the linked list
		Node newnode = new Node(data);
		
		newnode.next = head;
		newnode.previous = null;
		
		if(head != null) //puts the previous of the head to be the newnode if it isnt null
		{
			head.previous = newnode; 
		}
		
		//then it makes the newnode the head
		newnode = head;
	}
	
	public void insertAfter (Node n, int data)
	{
		if(n == null) return ; // if the node is null we cannot insert after that so we end the method
		
		Node newnode = new Node (data); //creates node to be inserted
		
		newnode.next = n.next; 
		n.next = newnode;
		newnode.previous = n;
		
		if(newnode.next != null) //if the next for the node isnt null then the previous points at the newnode
		{
		newnode.next.previous = newnode;
		}
	}
	
	public void insertEnd (int data)
	{
		Node endnode = new Node (data);
		if(head == null) //if there are no nodes in the linked list the last node is the head
		{
			endnode.previous =null;
			endnode = head ;
		}
		
		Node temp = head; //we create this node to find the last element
		while(temp.next != null) //to get the last we move till we reach were next 
		{
			temp = temp.next;
		}
		
		temp.next = endnode;//change the next of the last node
		endnode.previous = temp; //change the previous of the new last node to the old last node	
	}
	
	public void deleteNode (Node del)
	{
	     if(head == null || del == null) //if the node is null or link is empty
	     {
	    	 return ;
	     }
	     
	     if(head == del) //if the node to be deleted is the head 
	     {
	    	 head = del.next;
	     }
	     
	     if(del.next != null) //if its not the last node change the next
	     {
	    	 del.next.previous = del.previous;
	     }
	     
	     if(del.previous != null) //if its not the first link change the previous
	     {
	    	 del.previous.next = del.next;
	     }
	     
	     return ; //clears the memory
	}
}
