//  File: stacker.java
//  Author: Peter Tsoi
//  Date Started: September 24, 2007
//  Date Completed: September 28, 2007
//  Notes: Stacker Class

public class stacker
{
    TrainCar[] cars;
    
    // Create blank stack
    public stacker (int size)
    {
        cars = new TrainCar[size];
    }
    
    // Create new Stack with input values
    public stacker (String input)
    {
        boolean unique = true;
        boolean invalid = false;
        cars = new TrainCar[input.length()];
        for (int i = 0; i < input.length(); i++)
        {
            for (int j = 0; j < i; j++) // Check for non-unique car
            {
                if (unique && input.charAt(i) == cars[((input.length () -1) - j)].getID())
                {
                    unique = false;
                    invalid = true;
                }
            }
            if (unique)
            {
                cars[((input.length () -1) - i)] = new TrainCar(input.charAt(i));
            } else
            {
                if (invalid)
                {
                    System.out.println ("Invalid Entry");
                    invalid = false;
                }
                cars = null;
            }
        }
    }
    
    void push(TrainCar newCar)
    {
        for (int arrPos = 0; arrPos < (cars.length)-1; arrPos++){
            cars[(cars.length)-(arrPos+1)] = cars[(cars.length)-(arrPos+2)];
        }
        cars[0] = newCar;
    }
    
    TrainCar pop(){
        TrainCar returnCar = cars[0];          // Car to Return
        for (int i = 0; i <= (cars.length-2); i++){
            cars[i] = cars[i + 1];
        }
        
        for (int i = 0; i <= (cars.length-2); i++)
        {
            if (cars[i] == cars[i+1]) {
                cars[i+1] = null;
            }
        }
        return returnCar;
    }
    
    public int size()
    {
        return cars.length;
    }
    
    public boolean isEmpty()
    {
        if (cars[0] == null || cars[0].getID () == (char)(((int)'z')+1))
            return true;
        return false;
    }
    
    public void dump()
    {
        if (cars != null)
        {
            for(TrainCar car: cars)
            {
                if (car != null)
                {
                    System.out.print(car.getID());
                }
            }
            System.out.println();
        }
    }
}
