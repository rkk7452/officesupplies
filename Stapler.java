/**
Stapler class
@author Ryan Kim
@author Conner Wang
@version 2026.2.4


*/

public class Stapler
{
    //initialize variables
    private int staples;
    private boolean jammed;
    final int CHANCEOFJAM;
    
    /**
     * Overloaded Constructor for an empty stapler
     */
    public Stapler()
    {
        staples = 0;
        jammed = false;
        CHANCEOFJAM = 5;
    }

    /**
     * Overloaded Constructor for an empty stapler
     * @param initStaples the amount of staples initially loaded into the stapler
     */
    public Stapler(int initStaples)
    {
        staples = initStaples;
        jammed = false;
        CHANCEOFJAM = 5;
    }

    /**
     * The getStaples() method returns the current number of staples
     * @return the amount of staples remaining in the stapler
     */
    public int getStaples()
    {
        return staples;
    }

    /**
     * The getJammed() method whether the stapler is jammed
     * @return whether the stapler is jammed
     */
    public boolean getJammed()
    {
        return jammed;
    }

    /**
     * The staple() method uses up one of the staples if there is at least one staple available
     */
    public void staple()
    {
        if (staples>0)
        {
            if (!jammed)
            {
                int randJam = (int) (Math.random()*CHANCEOFJAM);//1 in CHANCEOFJAM chance of getting jammed
                if (randJam==0)
                {
                    jammed = true;
                }
                else{
                    staples--;
                }
            }
            else{
                System.out.println("Jammed...could not staple");
            }
        }
        else
        {
            System.out.println("Out of staples! Time to refill!");
        }
        
    }
}