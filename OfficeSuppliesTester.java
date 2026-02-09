
public class OfficeSuppliesTester {
    public static void main (String[] args)
    {
        //Testing the Stapler
        
            //test the stapler class with a bad stapler
            System.out.println("Constructing a bad Stapler with a 1 in 2 chance of jamming.");
            Stapler badStapler = new Stapler(50, 2);
            System.out.println("Stapling until it jams...");
            int numStapled = 0;
            while(!badStapler.getJammed())
            {
                badStapler.staple();
                numStapled++;
            }
            if (badStapler.getJammed())
            {
                System.out.println("It was able to staple "+numStapled+" time(s) before jamming.");
            }
            else{
                System.out.println("It was able to staple "+numStapled+" time(s) before running out of staples.");
            }
            
            System.out.println("Attempting to staple with a jammed stapler...");
            int staplesRemaining = badStapler.getStaples();
            badStapler.staple();
            if (badStapler.getStaples()==staplesRemaining)
            {
                System.out.println("Passed. Didn't staple when jammed.");
            }
            else
            {
                System.out.println("Failed. 'Stapled' with a jammed stapler");
            }
            
            System.out.println();

            //test the Stapler class with a good stapler!
            System.out.println("Constructing a good Stapler with a 1 in 100 chance of jamming.");
            Stapler goodStapler = new Stapler(150, 100);
            System.out.println("Stapling until it jams...");
            numStapled = 0;
            while(!goodStapler.getJammed()&&goodStapler.getStaples()>0)
            {
                goodStapler.staple();
                numStapled++;
            }
            if (goodStapler.getJammed())
            {
                System.out.println("It was able to staple "+numStapled+" time(s) before jamming.");
            }
            else{
                System.out.println("It was able to staple "+numStapled+" time(s) before running out of staples.");
            }
            
            System.out.println();

            //test Stapler class refill method
            Stapler smallStapler = new Stapler(5,1000);
            while(smallStapler.getStaples()>0)
            {
                smallStapler.staple();
            }
            System.out.println("staples remaining: "+smallStapler.getStaples());
            
        //test the alarmClock
        System.out.println();
        System.out.println("Testing Alarm Clock...\nCreating new alarm clock...")
        alarmClock myAlarm = new alarmClock();
        myAlarm.setAlarm(15,32);
        
        
    }
}
