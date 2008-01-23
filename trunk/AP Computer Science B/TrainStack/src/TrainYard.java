//  File: TrainYard.java
//  Author: Peter Tsoi
//  Date Started: September 24, 2007
//  Date Completed: September 28, 2007
//  Revised: October 4, 2007
//  Notes: Testing Class

public class TrainYard
{
    public TrainYard()
    {
        
    }
    public static void main (String[] args)
    {
        TrainYard aBiggerYard = new TrainYard();
        aBiggerYard.receiveCars("HBJADICFKGE");
        aBiggerYard.oldTrain.dump();
        aBiggerYard.reorderCars ();
        aBiggerYard.newTrain.dump ();
    }
    
    void receiveCars(String input)
    {
        oldTrain = new stacker(input);
        newTrain = new stacker(input.length());
        shunter = new stacker(input.length());
    }
    
    void reorderCars()
    {
        TrainCar car1;
        TrainCar car2;
        TrainCar car3;
        shunter.push(oldTrain.pop ());
        shunter.push (oldTrain.pop ());
        newTrain.push (shunter.pop());
        while ((!oldTrain.isEmpty () || !shunter.isEmpty ()))
        {
            // Set to character larger than Z
            car1 = new TrainCar ((char)(((int)'z')+1));
            car2 = new TrainCar ((char)(((int)'z')+1));
            car3 = new TrainCar ((char)(((int)'z')+1));
            // Replace placeholder character with values from train
            if (!oldTrain.isEmpty()) 
            {
                car1 = oldTrain.pop ();
            }
            if (!shunter.isEmpty())
            {
                car2 = shunter.pop ();
            } 
            if (!newTrain.isEmpty())
            {
                car3 = newTrain.pop ();
            }
            // If oldTrain has lowest value (put in newTrain)
            if ((int)car1.getID() < (int)car2.getID() && (int)car1.getID() < (int)car3.getID())
            {
                shunter.push (car2);
                shunter.push (car3);
                shunter.push (car1);
                newTrain.push (shunter.pop ());
            } else
            {
                // If shunter has lowest Value 
                if ((int)car2.getID() < (int)car1.getID() && (int)car2.getID() < (int)car3.getID())
                {
                    oldTrain.push (car1);
                    shunter.push (car3);
                    oldTrain.push (shunter.pop ());
                    newTrain.push (car2);
                    shunter.push (oldTrain.pop ());
                } else
                {
                    // If lowest value is in newTrain Already
                    if ((int)car3.getID() < (int)car1.getID() && (int)car3.getID() < (int)car2.getID())
                    {
                        TrainCar car4 = newTrain.pop ();
                        TrainCar car5 = null;
                        int depth = 0;
                        while (car4 != null)
                        {
                            if ((int)car3.getID() < (int)car4.getID())
                            {
                            	shunter.push (car4);
	                            depth++;
	                            car4 = newTrain.pop();
                            }
                            else 
                            {
                            	newTrain.push(car4);
                            	car4 = null;
                            }
                        }
                        newTrain.push(car3);
                        for (int i = 0; i < depth; i++)
                        {
                        	newTrain.push(shunter.pop());
                        }
                        // Reposition shunter and oldTrain
                        if ((int)car2.getID () < (int)car1.getID ())
                        {
                            newTrain.push (car2);
                            oldTrain.push (car1);
                        } else 
                        {
                            newTrain.push (car1);
                            shunter.push (car2);
                        }
                    }
                }
            }
        }
    }
    
    private stacker oldTrain;
    private stacker shunter;
    private stacker newTrain;
}

/*  Exer A
 *      Valid opperations:
 *          movetoNew
 *          movetoShunter
 *          movetoOld
 *  Exer B
 *      See above
 *  Exer C
 *      My reorder method is flexible and does this
 *  Exer D
 *      Such a program would not be difficult but would require a little bit more 
 *      of “if” statements. My current implementation works by randomly comparing 
 *      and then placing the lowest value in the new, correct position. For the new 
 *      implementation, I would just add an “if” to see if the “original” operation 
 *      (the operation that the program would carry out as it is programmed now) 
 *      is valid and if not, the program would shuffle the cars to give it a new case 
 *      to test. My program loops until shunter and oldTrain are empty and this would 
 *      still be the ending result of the new program.
 *
 *      I because of the nature of my current program, I do not anticipate any problems 
 *      because this method will randomly execute and proceed towards the anticipated 
 *      result. The biggest problem will be efficiency because of the random nature 
 *      of the sorting algorithm. 
 *
 *      I would need to know what are the maximum size of the shunter or how many cars 
 *      and space I have to hold everything.
 */
