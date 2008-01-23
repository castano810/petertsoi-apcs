
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordCountTree {
    private TextNode root;
    
    public WordCountTree(WordSource source)
    {
        String nextWord = source.nextWord();
        while(nextWord != null)
        {
            insert(new TextNode(nextWord));
            nextWord = source.nextWord();
        }
    }
    
    public WordCountTree()
    {
        
    }
    
    public void insert(TextNode insertNode)
    {
        if (root == null)
        {
            root = insertNode;
        }
        else
        {
            root.insert(insertNode);
        }
    }
    
    public String remove(String value)
    {
        TextNode[] returnedNodes = getNodeWithParent(value);
        TextNode removedNode = returnedNodes[0];
        TextNode parentNode = returnedNodes[1];
        
        if (parentNode != null)
        {
            //get relationship between nodes
            String linkDirectionToParent = null;
            if (parentNode.getLeft() == removedNode)
            {
                linkDirectionToParent = "upRight";
            }
            if (parentNode.getRight() == removedNode)
            {
                linkDirectionToParent = "upLeft";
            }

            //Remove the node
            if (numChildren(removedNode) == 0)
            {
                if (linkDirectionToParent.equals("upLeft"))
                {
                    parentNode.setRight(null);
                }
                if (linkDirectionToParent.equals("upRight"))
                {
                    parentNode.setLeft(null);
                }
            }
            if (numChildren(removedNode) == 1)
            {
                System.out.println("TEst");
                TextNode child = null;
                if (removedNode.getLeft() != null)
                {
                    child = removedNode.getLeft();
                }
                if (removedNode.getRight() != null)
                {
                    child = removedNode.getRight();
                }

                if (linkDirectionToParent.equals("upLeft"))
                {
                    parentNode.setRight(child);
                }
                else if (linkDirectionToParent.equals("upRight"))
                {
                    parentNode.setLeft(child);
                }
            }
            if (numChildren(removedNode) == 2)
            {
                TextNode currentNode = removedNode.getRight();
                TextNode farthestChild = null;
                TextNode farthestChildParent = removedNode;
                while (currentNode != null)
                {
                    if (farthestChild != null)
                    {
                        farthestChildParent = farthestChild;
                    }
                    farthestChild = currentNode;
                    currentNode = currentNode.getLeft();
                }
                
                removedNode.setWord(farthestChild.getWord());

                if (farthestChildParent.getLeft() == farthestChild)
                {
                    farthestChildParent.setLeft(null);
                }
                if (farthestChildParent.getRight() == farthestChild)
                {
                    farthestChildParent.setRight(null);
                }
            }
        }
        else
        {
            TextNode currentNode = removedNode.getRight();
            TextNode farthestChild = null;
            TextNode farthestChildParent = removedNode;
            while (currentNode != null)
            {
                if (farthestChild != null)
                {
                    farthestChildParent = farthestChild;
                }
                farthestChild = currentNode;
                currentNode = currentNode.getLeft();
            }

            removedNode.setWord(farthestChild.getWord());

            if (farthestChildParent.getLeft() == farthestChild)
            {
                farthestChildParent.setLeft(null);
            }
            if (farthestChildParent.getRight() == farthestChild)
            {
                farthestChildParent.setRight(null);
            }
        }
        
        
        return value;
    }
    
    
    public int numChildren(TextNode node)
    {
        int childCount = 0;
        if (node.getLeft() != null)
        {
            childCount++;
        }
        if (node.getRight() != null)
        {
            childCount++;
        }
        
        return childCount;
    }
    
    public TextNode getNode(String value)
    {
        return getNodeWithParent(value)[0];
    }
    
    public TextNode[] getNodeWithParent(String value)
    {
        if(value == null)
        {
            return null;
        }
        
        TextNode[] start = new TextNode[2];
        start[0] = root;
        start[1] = null;
        return getNodeWithParentHelper(start, value);
    }
    
    public TextNode[] getNodeWithParentHelper(TextNode[] currentNode, String value)
    {
        TextNode[] returned = null;
        
        if (currentNode[0] != null)
        {
            if (currentNode[0].getWord().equalsIgnoreCase(value) )
            {
                returned = currentNode;
            }
            else
            {
                if (currentNode[0].getWord().compareToIgnoreCase(value) > 0)
                {
                    TextNode[] returnArray = new TextNode[2];
                    returnArray[0] = currentNode[0].getLeft();
                    returnArray[1] = currentNode[0];
                    
                    returned = getNodeWithParentHelper(returnArray, value);
                }
                else
                {
                    TextNode[] returnArray = new TextNode[2];
                    returnArray[0] = currentNode[0].getRight();
                    returnArray[1] = currentNode[0];
                    
                    returned = getNodeWithParentHelper(returnArray, value);
                }
            }
        }
        return returned;
    }
    
    public void dumpToOrder()
    {
        dumpToOrderHelper(root);
    }
    
    public void dumpToOrderHelper(TextNode currentNode)
    {
        if (currentNode != null)
        {
            dumpToOrderHelper(currentNode.getLeft());
            System.out.println(currentNode.getWord());
            dumpToOrderHelper(currentNode.getRight());
        }
    }
    
    public int size()
    {
        return sizeHelper(root);
    }
    
    public int sizeHelper(TextNode currentNode)
    {
        if (currentNode != null)
        {
            int currentSize = 0;
            currentSize += sizeHelper(currentNode.getLeft());
            currentSize += sizeHelper(currentNode.getRight());
            currentSize += currentNode.getCount();
            return currentSize;
        }
        else
        {
            return 0;
        }
    }
    
    public TextNode getRoot()
    {
        return root;
    }
    
    public TextNode[] getLowest ()
    {
        TextNode[] array = new TextNode[2];
        
        return getLowestHelper(array, root);
    }
    
    public TextNode[] getLowestHelper(TextNode[] array, TextNode currentNode)
    {
        TextNode[] returnArray = array;
        if (array[0] == null || array[1] == null)
        {
            if (currentNode.getLeft() == null && currentNode.getWord().length() >= 3)
            {
                //Add to Array
                if (array[0] == null)
                {
                    array[0] = currentNode;
                }
                else if (array[1] == null)
                {
                    array[1] = currentNode;
                }
            }
            else
            {
                TextNode[] copy = returnArray.clone();
                if (currentNode.getLeft() != null)
                {
                    returnArray = getLowestHelper(array, currentNode.getLeft());
                }
                if (returnArray != copy)
                {
                    //Add to Array
                    if (array[0] == null)
                    {
                        array[0] = currentNode;
                    }
                    else if (array[1] == null)
                    {
                        array[1] = currentNode;
                    }
                }
                if (currentNode.getRight() != null)
                {
                    returnArray = getLowestHelper(array, currentNode.getRight());
                }
                
            }
        }
        return returnArray;
    }
    
    public TextNode[] getHighest ()
    {
        TextNode[] array = new TextNode[2];
        
        return getHighestHelper(array, root);
    }
    
    public TextNode[] getHighestHelper(TextNode[] array, TextNode currentNode)
    {
        TextNode[] returnArray = array;
        if (array[0] == null || array[1] == null)
        {
            if (currentNode.getRight() == null && currentNode.getWord().length() >= 3)
            {
                //Add to Array
                if (array[0] == null)
                {
                    array[0] = currentNode;
                }
                else if (array[1] == null)
                {
                    array[1] = currentNode;
                }
            }
            else
            {
                TextNode[] copy = returnArray.clone();
                if (currentNode.getRight() != null)
                {
                    returnArray = getHighestHelper(array, currentNode.getRight());
                }
                if (returnArray != copy)
                {
                    //Add to Array
                    if (array[0] == null)
                    {
                        array[0] = currentNode;
                    }
                    else if (array[1] == null)
                    {
                        array[1] = currentNode;
                    }
                }
                if (currentNode.getLeft() != null)
                {
                    returnArray = getHighestHelper(array, currentNode.getLeft());
                }
                
            }
        }
        return returnArray;
    }
    
    public void getNumLeafNodes()
    {
        System.out.println("Number of Leaf Nodes: " + getNumLeafNodesHelper(root, 0));
    }
    
    public int getNumLeafNodesHelper(TextNode currentNode, int currentNum)
    {
        int returnNum = currentNum;
        
        if (numChildren(currentNode) != 0)
        {
            if (currentNode.getLeft() != null)
            {
                returnNum += getNumLeafNodesHelper(currentNode.getLeft(), currentNum);
            }
            if (currentNode.getRight() != null)
            {
                returnNum += getNumLeafNodesHelper(currentNode.getRight(), currentNum);
            }
        }
        else
        {
            System.out.println("Leaf Node: " + currentNode.getWord());
            returnNum = currentNum + 1;
        }
        
        return returnNum;
    }
    
    public void findCommonWords()
    {
        TextNode[] array = new TextNode[10];
        TextNode[] returnedArray = findCommonWordsHelper(array, root);
        for (TextNode word : returnedArray)
        {
            if (word != null)
                System.out.println(word.getWord());
        }
    }
    
    public TextNode[] findCommonWordsHelper(TextNode[] array, TextNode currentNode)
    {
        boolean addToEmpty = false;
        //If the 10 words hasn't been filled up
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
            {
                addToEmpty = true;
                array[i] = currentNode;
                
                //exit
                i = array.length;
            }
        }
        //Otherwise... add if 
        if (!addToEmpty)
        {
            int smallestIndex = 0;
            for (int i = 0; i < array.length; i++)
            {
                if (array[i].getCount() < array[smallestIndex].getCount())
                {
                    smallestIndex = i;
                }
            }

            if (array[smallestIndex].getCount() < currentNode.getCount())
            {
                array[smallestIndex] = currentNode;
            }

        }

        if (currentNode.getLeft() != null)
        {
            findCommonWordsHelper(array, currentNode.getLeft());
        }
        if (currentNode.getRight() != null)
        {
            findCommonWordsHelper(array, currentNode.getRight());
        }
        
        return array;
    }
    
    public int getDepth()
    {
        return getDepthHelper(root);
    }
    
    public int getDepthHelper(TextNode currentNode)
    {
        int returnValue = 0;
        
        if (currentNode != null)
        {
            if (numChildren(currentNode) != 0)
            {
                int leftSubTree = getDepthHelper(currentNode.getLeft());
                int rightSubTree = getDepthHelper(currentNode.getRight());

                if (leftSubTree > rightSubTree)
                {
                    returnValue = ++leftSubTree;
                }
                else
                {
                    returnValue = ++rightSubTree;
                }
            }
            else
            {
                returnValue = 1;
            }
        }
        
        return returnValue;
    }
    
    public int getShortestPathToLeaf()
    {
        return getShortestPathToLeafHelper(root);
    }
    
    public int getShortestPathToLeafHelper(TextNode currentNode)
    {
        int returnValue = 0;
        if (numChildren(currentNode) != 0)
        {
            int leftSubTree = 0, rightSubTree = 0;
            if (currentNode.getLeft() != null)
            {
                leftSubTree = getShortestPathToLeafHelper(currentNode.getLeft());
            }
            if (currentNode.getRight() != null)
            {
                rightSubTree = getShortestPathToLeafHelper(currentNode.getRight());
            }

            if (leftSubTree == 0)
            {
                returnValue = ++rightSubTree;
            }
            else if (rightSubTree == 0)
            {
                returnValue = ++leftSubTree;
            }
            else
            {
                if (leftSubTree < rightSubTree)
                {
                    returnValue = ++leftSubTree;
                }
                else
                {
                    returnValue = ++rightSubTree;
                }
            }
        }
        else
        {
            returnValue = 1;
        }
        
        return returnValue;
    }
    
    public WordCountTree transferSWords()
    {
        
        return transferSWordsHelper(new WordCountTree(), root);
    }
    
    public WordCountTree transferSWordsHelper(WordCountTree newTree, TextNode currentNode)
    {
        if (currentNode.getWord().substring(0, 1).equalsIgnoreCase("s"))
        {
            newTree.insert(new TextNode(currentNode.getWord()));
        }

        if (currentNode.getLeft() != null)
        {
            transferSWordsHelper(newTree, currentNode.getLeft());
        }
        if (currentNode.getRight() != null)
        {
            transferSWordsHelper(newTree, currentNode.getRight());
        }
        
        return newTree;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        WordSource theOneSource = new WordSource("Agnew.txt");
        WordCountTree theOneTree = new WordCountTree(theOneSource);
        WordCountTree newTree = theOneTree.transferSWords();
        newTree.dumpToOrder();
    }

}
