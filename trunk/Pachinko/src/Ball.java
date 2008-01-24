// Authors: Justin Uang & Peter Tsoi
// Assignment: Pachinko
// Date Started: Dec 11, 2007

public class Ball {
    public Ball(){
	id = ballId;
	ballId++;
    }
    
    public int getID(){
	return id;
    }
    
    private int id;
    private static int ballId = 0;
    private String path;
}