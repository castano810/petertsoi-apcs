// Authors: Justin Uang & Peter Tsoi
// Assignment: Pachinko
// Date Started: Dec 11, 2007

public class TreeList  /*Obviously*/
{
    private int numRows;
    
    //Default Constructor
    //Creates an empty Linked List
    public TreeList (int rows)
    {
        first = null;
        numRows = rows;
        generateEmptyTree();
    }
    
    public void generateEmptyTree()
    {
        first = generateEmptyTreeHelper(1)[0];
    }
    
    public TreeNode[] generateEmptyTreeHelper(int currentRow)
    {
        TreeNode[] returnArray = null;
        if (currentRow <= numRows){
            TreeNode[] returnedNodes = generateEmptyTreeHelper(currentRow + 1);
            
            returnArray = new TreeNode[currentRow];
            for(int i = 0; i < currentRow; i++)
            {
                returnArray[i] = new TreeNode();
            }
            
            if (returnedNodes != null)
            {
                
                for (int i = 0; i < returnedNodes.length - 1; i++)
                {
                    returnArray[i].setLeft(returnedNodes[i]);
                    returnArray[i].setRight(returnedNodes[i + 1]);
                }
            }
        }
        
        return returnArray;
    }
    
    public TreeNode getFirst ()
    {
        return first;
    }
    
    public void setFirst (TreeNode first)
    {
        this.first = first;
    }
    
    public static void main(String[] args) {
        TreeList list = new TreeList(11);
        System.out.println(list.getFirst().getID());
        
    }

    
    private TreeNode first;
}