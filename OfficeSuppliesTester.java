
public class OfficeSuppliesTester {
    public static void main (String[] args)
    {
        //Testing the Stapler
        
        // TESTING Stapler
        System.out.println("=== TESTING Stapler ===");
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
            System.out.println("Testing a small Stapler to run out of staples");
            Stapler smallStapler = new Stapler(5,1000);
            while(smallStapler.getStaples()>0)
            {
                smallStapler.staple();
            }
            System.out.println("Small stapler's staples remaining: "+smallStapler.getStaples());
            
        
        // TESTING Alarm Clock
        System.out.println("\n=== TESTING Alarm Clock ===");
        alarmClock myAlarm = new alarmClock();

            //testing the setTime()
            System.out.println("Setting the time to 3:32 pm...");
            myAlarm.setTime(15,32,0);
            if (myAlarm.getTime()==55920)
            {
                System.out.println("Passed.");
            }
            else{
                System.out.println("Setting time failed.");
            }

            myAlarm.setAlarm(6, 30);
            myAlarm.setTimer(120);
            myAlarm.setStopWatch();

            System.out.println("Alarm Clock Info:");
            System.out.println(myAlarm);

            // Battery test
            myAlarm.drainBattery();
            if (myAlarm.isBatteryDead()) {
                System.out.println("Battery drain PASSED");
            } else {
                System.out.println("Battery drain FAILED");
            }

            myAlarm.replaceBattery();
            if (!myAlarm.isBatteryDead()) {
                System.out.println("Battery replace PASSED");
            } else {
                System.out.println("Battery replace FAILED");
            }

        // TESTING PRINTER
        System.out.println("\n=== TESTING PRINTER ===");
        Printer printer = new Printer();

            System.out.println("Initial Ink: " + printer.getInk());
            System.out.println("Initial Paper: " + printer.getPaper());
            System.out.println("Initial Staples: " + printer.getStaples());

            // Test single-sided print
            printer.print(5, false);
            System.out.println("After printing 5 pages:");
            System.out.println("Ink: " + printer.getInk());
            System.out.println("Paper: " + printer.getPaper());
            System.out.println("Staples: " + printer.getStaples());

            // Test double-sided print
            printer.print(4, true);
            System.out.println("After printing 4 double-sided pages:");
            System.out.println("Ink: " + printer.getInk());
            System.out.println("Paper: " + printer.getPaper());
            System.out.println("Staples: " + printer.getStaples());

            // Drain supplies
            printer.print(50, false);

            // Refill tests
            printer.refillInk();
            printer.refillPaper();
            printer.refillStaples();

            System.out.println("After refilling:");
            System.out.println("Ink: " + printer.getInk());
            System.out.println("Paper: " + printer.getPaper());
            System.out.println("Staples: " + printer.getStaples());
    }

    }
