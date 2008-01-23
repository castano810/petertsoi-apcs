public class TextNode {
    private String word;
    private int count;
    private TextNode parent;
    private TextNode left, right;
    
    public TextNode(String value)
    {
        word = value;
        count = 1;
    }
    
    public TextNode(String value, TextNode left, TextNode right)
    {
        word = value;
        this.left = left;
        this.right = right;
        count = 1;
    }
    
    public int compareX(TextNode node)
    {
        if (node != null)
        {
            return word.compareToIgnoreCase(node.getWord());
        }
        
        return 0;
    }
    
    public void insert(TextNode insertNode)
    {
        if (this.compareX(insertNode) > 0)
        {
            if (left == null)
            {
                left = insertNode;
            }
            else
            {
                left.insert(insertNode);
            }
        }
        else if (this.compareX(insertNode) < 0)
        {
            if (right == null)
            {
                right = insertNode;
            }
            else
            {
                right.insert(insertNode);
            }
        }
        else
        {
            this.addCount();
        }
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void addCount()
    {
        count++;
    }

    public TextNode getLeft() {
        return left;
    }

    public void setLeft(TextNode left) {
        this.left = left;
    }

    public TextNode getRight() {
        return right;
    }

    public void setRight(TextNode right) {
        this.right = right;
    }
}
