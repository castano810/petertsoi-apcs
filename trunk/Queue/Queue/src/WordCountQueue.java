//
//  WordCountQueue.java
//  Queue
//
//  Created by Justin Uang on 2/4/08.
//  Copyright 2008 __MyCompanyName__. All rights reserved.
//

public class WordCountQueue {
	private class Node
	{
		private String value;
		private Node next;
		
		public Node()
		{
			value = "";
			next = null;
		}
		
		public Node(String value, Node next)
		{
			this.value = value;
			this.next = next;
		}
		
		public String toString()
		{
			return value;
		}
	}
	
	private Node first, last;
	
	public WordCountQueue()
	{
		first = null;
		last = null;
	}
	
	public boolean enque(String value)
	{
		Node oldLast = last;
		last = new Node(value, null);
		if (first == null)
		{
			first = last;
		}
		else
		{
			oldLast.next = last;
		}
		
		return true;
	}
	
	public String deque()
	{
		Node returnNode = null;
		if (first != null)
		{
			returnNode = first;
			first = first.next;
		}
		
		return returnNode.value;
	}
	
	public String peek()
	{
		String returnString = null;
		if (first != null)
		{
			returnString = first.value;
		}
		
		return returnString;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int size()
	{
		int returnSize = 0;
		Node currentNode = first;
		while (currentNode != null)
		{
			returnSize++;
			currentNode = currentNode.next;
		}
		
		return returnSize;
	}
	
	public String toString()
	{
		String returnString = "";
		Node currentNode = first;
		while (currentNode != null)
		{
			returnString += currentNode.toString() + "\n";
			currentNode = currentNode.next;
		}
		return returnString;
	}
}
