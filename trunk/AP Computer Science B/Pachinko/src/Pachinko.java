// Authors: Justin Uang & Peter Tsoi
// Assignment: Pachinko
// Date Started: Dec 11, 2007

import java.util.Random;

public class Pachinko {
    public Pachinko (int sizeBoard, int numOfBalls){
	toy = new TreeList(sizeBoard); 
	rows = sizeBoard;
	ballArray = new Ball[numOfBalls];
	ballBin = new int[sizeBoard+1];
	for (int i = 0; i<numOfBalls;i++){
	    ballArray[i] = new Ball();
	    dropBall(ballArray[i],toy.getFirst(),null);
	}
        reportAllBins();
        System.out.print("Most Likely Path: \t");
        String[] mlp = mostLikelyPaths();
        
        for (int i = 0; i<mlp.length;i++){
	    if (mlp[i] != null)
		System.out.println(mlp[i]);
	}
        System.out.println();
        drawPath(mlp);
    }
    
    public int[] countAllBins(){
	return ballBin;
    }
    
    public void reportAllBins(){
	System.out.print("Ball Bin: \t");
        for (int i = 0; i<ballBin.length;i++){
	    System.out.print(ballBin[i] + ", ");
	}
        System.out.println();
    }
    
    public String[] mostLikelyPaths(){
        String[] returnValue = new String[rows];
	mostLikely = new int[rows];
        returnValue[0] = toy.getFirst().getID() + "";
	mostLikely[0] = toy.getFirst().getID();
        mostLikelyPaths(returnValue, toy.getFirst(), 0);
	return returnValue;
    }
    
    public String[] mostLikelyPaths(String[] curValue, TreeNode curNode, int i){
        if (curNode.getNext() == null){
            
        }
        else{
            if(curNode.getLeft().getValue() > curNode.getRight().getValue()){
                curValue[i] = curValue[i] + ", " + curNode.getLeft().getID();
		//mostLikely[i] = curNode.getLeft().getID();
                mostLikelyPaths(curValue, curNode.getLeft(),i);
            } 
            if(curNode.getLeft().getValue() < curNode.getRight().getValue()){
                curValue[i] = curValue[i] + ", " + curNode.getRight().getID();
		//mostLikely[i] = curNode.getRight().getID();
                mostLikelyPaths(curValue, curNode.getRight(),i);
            }
            if(curNode.getLeft().getValue() == curNode.getRight().getValue()){
                //System.out.println("hi");
		String tempPath = curValue[i];
                curValue[i] = curValue[i] + ", " + curNode.getRight().getID();
		//mostLikely[i] = curNode.getRight().getID();
                mostLikelyPaths(curValue, curNode.getRight(),i);
                //mostLikely[i] = curNode.getLeft().getID();
		curValue[++i] = tempPath + ", " + curNode.getLeft().getID();
                mostLikelyPaths(curValue, curNode.getLeft(),i);
                
            }
            
        }
        return curValue;
    }
    
    public void dropBall(Ball theBall, TreeNode curNode, TreeNode prevNode){
	if (curNode == null){
            Random newRandom = new Random();
            ballBin[(prevNode.getID()-1)+newRandom.nextInt (2)]++;
	}
        else {
            curNode.incrementCounter();
	    dropBall(theBall, curNode.getNext(), curNode);
	}
    }
    
    public void drawPath(String[] path){
	int nodes = (int)((.5*Math.pow(path.length, 2))+(path.length * 0.5));
        int curNode = nodes;
        for (int i = 0; i<mostLikely.length;i++){
	    if (i > 0){
		System.out.println();
	    }
            for (int j = 0; j<2*(path.length-(i));j++){
                System.out.print(" ");
            }
            for (int k=0; k<i; k++){
                System.out.print(curNode + "   ");
                if (curNode < 10)
                    System.out.print(" ");
                curNode--;
            }    
        }
	System.out.println();
	for (int i = 0; i<path.length;i++){
	    System.out.print(curNode + "   ");
            if (curNode < 10)
                    System.out.print(" ");
            curNode--;
	}
    }
    
    private TreeList toy;
    private int rows;
    private Ball[] ballArray;
    private int[] ballBin;
    private int[] mostLikely;
}
