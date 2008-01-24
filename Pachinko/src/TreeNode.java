// Authors: Justin Uang & Peter Tsoi
// Assignment: Pachinko
// Date Started: Dec 11, 2007

import java.util.Random;

public class TreeNode  /*Obviously*/
{
    public TreeNode()
    {
        this.value = 0;
        this.left = null;
        this.right = null;
        ID = nextID;
        nextID++;
    }
    
    public TreeNode (int value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode (int value, TreeNode left, TreeNode right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public void incrementCounter()
    {
        value++;
    }
    
    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
    
    public TreeNode getNext(){
	Random newRandom = new Random();
        int randomInt = newRandom.nextInt (2);
	if (randomInt == 0)
	    return right;
	else
	    return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    public int getValue(){
        return value;
    }
    
    public String toString()
    {
        return "ID:" + ID;
    }
    
    private int value;
    public static int nextID = 1;
    private int ID;
    private TreeNode left;
    private TreeNode right;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
