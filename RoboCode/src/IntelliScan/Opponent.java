package IntelliScan;

import robocode.*;
import java.util.Stack;

public class Opponent implements Comparable {
    private String name;
    private Stack<Double> bearing;
    private Stack<Double> heading;
    private Stack<Double> velocity;
    private Stack<Double> energy;
    
    
    public Opponent(String n, double b, double h, double v, double e){
	name = n;
	bearing = new Stack<Double>();
	heading = new Stack<Double>();
	velocity = new Stack<Double>();
	energy = new Stack<Double>();
	bearing.push(b);
	heading.push(h);
	velocity.push(v);
	energy.push(e);
    }

    public String getName() {
	return name;
    }

    public double getBearing() {
	return bearing.peek();
    }
    
    public double getBearing(int index){
	Stack<Double> temp = new Stack();
	double toReturn;
	if (index >= bearing.size()){
	    return getBearing();
	}else{
	    for (int i = 0; i < index; i++){
		temp.push(bearing.pop());
	    }
	    toReturn = bearing.peek();
	    for (int i = 0; i < index; i++){
		bearing.push(temp.pop());
	    }
	}
	return toReturn;
    }

    public void setBearing(double bearing) {
	this.bearing.push(bearing);
    }

    public double getHeading() {
	return heading.peek();
    }
    
    public double getHeading(int index){
	Stack<Double> temp = new Stack();
	double toReturn;
	if (index >= heading.size()){
	    return getHeading();
	}else{
	    for (int i = 0; i < index; i++){
		temp.push(heading.pop());
	    }
	    toReturn = heading.peek();
	    for (int i = 0; i < index; i++){
		heading.push(temp.pop());
	    }
	}
	return toReturn;
    }

    public void setHeading(double heading) {
	this.heading.push(heading);
    }

    public double getVelocity() {
	return velocity.peek();
    }
    
    public double getVelocity(int index){
	Stack<Double> temp = new Stack();
	double toReturn;
	if (index >= velocity.size()){
	    return getVelocity();
	}else{
	    for (int i = 0; i < index; i++){
		temp.push(velocity.pop());
	    }
	    toReturn = velocity.peek();
	    for (int i = 0; i < index; i++){
		velocity.push(temp.pop());
	    }
	}
	return toReturn;
    }

    public void setVelocity(double velocity) {
	this.velocity.push(velocity);
    }

    public double getEnergy() {
	return energy.peek();
    }
    
    public double getEnergy(int index){
	Stack<Double> temp = new Stack();
	double toReturn;
	if (index >= energy.size()){
	    return getEnergy();
	}else{
	    for (int i = 0; i < index; i++){
		temp.push(energy.pop());
	    }
	    toReturn = energy.peek();
	    for (int i = 0; i < index; i++){
		energy.push(temp.pop());
	    }
	}
	return toReturn;
    }

    public void setEnergy(double energy) {
	this.energy.push(energy);
    }
    
    public boolean stationary(){
	System.out.println("Stationary Check for " + getName());
	System.out.println("\tVelocity: " + getVelocity());
	System.out.println("\tHeading(1): " + getHeading(1));
	System.out.println("\tHeading: " + getHeading());
	System.out.println("\tBearing: " + getBearing());
	
	if (getVelocity() == 0){
	    if (getBearing() == getBearing(1)){
		System.out.println("\tStationary");
		return true;
	    }
	}
	System.out.println("\tMoving");
	return false;
    }
    
    public int compareTo (Object other){
	return (int)(getEnergy() - ((Opponent)other).getEnergy());
    }
}
