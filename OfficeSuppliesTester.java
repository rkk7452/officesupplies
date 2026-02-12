
public class OfficeSuppliesTester {
    public static void main (String[] args)
    {
        
        // TESTING Stapler

        int maxStapler = 4;
        int staplerPts = 0;
        System.out.println("=== TESTING Stapler ===");
            //test the stapler class with a bad stapler
            System.out.println("Constructing a bad Stapler with a 1 in 2 chance of jamming.");
            Stapler badStapler = new Stapler(999999999, 2);
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
                staplerPts++;
            }
            else{
                System.out.println("It didn't jam...Fail?...or you should enter the lottery...rerun to check.It was able to staple "+numStapled+" time(s).");
                if (badStapler.getStaples()==0)
                {
                    System.out.println("0 staples left...");
                }
                else{
                    System.out.println("Unkown error. >0 staples and not jammed. Check tester code.");
                }
            }
            

            System.out.println("Attempting to staple with a jammed stapler...");
            int staplesRemaining = badStapler.getStaples();
            badStapler.jam();
            badStapler.staple();
            if (badStapler.getStaples()==staplesRemaining)
            {
                System.out.println("Passed. Didn't staple when jammed.");
                staplerPts++;
            }
            else
            {
                System.out.println("Failed. 'Stapled' with a jammed stapler");
            }
            
            System.out.println();

            //test the Stapler class with a good stapler!
            System.out.println("Constructing a good Stapler with a 1 in 1000 chance of jamming.");
            Stapler goodStapler = new Stapler(999999999, 1000);
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
                staplerPts++;
            }
            else{
                System.out.println("It didn't jam...Fail?...or you should enter the lottery...rerun to check.It was able to staple "+numStapled+" time(s).");
                if (badStapler.getStaples()==0)
                {
                    System.out.println("0 staples left...");
                }
                else{
                    System.out.println("Unkown error. >0 staples and not jammed. Check tester code.");
                }   
            }
            
            System.out.println();

            //test Stapler class refill method
            System.out.println("Testing a small Stapler (5 staples) to run out of staples");
            Stapler smallStapler = new Stapler(5,999999999);
            while(smallStapler.getStaples()>0)
            {
                smallStapler.staple();
            }
            if (smallStapler.getStaples()==0)
            {
                System.out.println("Passed.");
                staplerPts++;
            }
            else{
                if (smallStapler.getJammed())
                {
                    System.out.println("It jammed...Fail?...or you should enter the lottery...rerun to check.");
                }
                else{
                    System.out.println("Failed to use up all the staples.");
                }
            }

        System.out.println("Passed "+maxStapler+"/"+staplerPts+" tests.");
        
        // TESTING Alarm Clock
        System.out.println("\n=== TESTING Alarm Clock ===");
        int maxClock = 6;//number of tests
        int clockPts = 0;
        System.out.println("constructing new alarm clock...");
        alarmClock myAlarm = new alarmClock();
        clockPts++;

            //testing the setTime()
            System.out.println("Setting the time to 3:32 pm...");
            myAlarm.setTime(15,32,0);
            if (myAlarm.getTime()==55920)
            {
                System.out.println("Passed.");
                clockPts++;
            }
            else{
                System.out.println("Setting time failed.");
            }

            myAlarm.setAlarm(6, 30);
            myAlarm.setTimer(120);
            myAlarm.setStopWatch();

            System.out.println("Alarm Clock Info:");
            System.out.println(myAlarm);

            //stopwatch initialize
            System.out.println("Starting the stopwatch...will come back to it later...");
            myAlarm.startStopwatch();

            // Battery test
            System.out.println("Trying to drain battery...");
            myAlarm.drainBattery();
            if (myAlarm.isBatteryDead()) {
                System.out.println("Battery drain PASSED");
                clockPts++;
            } else {
                System.out.println("Battery drain FAILED");
            }


            System.out.println("Trying to replace the battery...");
            myAlarm.replaceBattery();
            if (!myAlarm.isBatteryDead()) {
                System.out.println("Battery replace PASSED");
                clockPts++;
            } else {
                System.out.println("Battery replace FAILED");
            }

            System.out.println("Testing 5 sec timer...");
            System.out.println(myAlarm.runTimer(5));

            myAlarm.stopStopwatch();
            if (myAlarm.getStopwatch()==5||myAlarm.getStopwatch()==6)
            {
                System.out.println("Passed. The stopwatch recorded "+myAlarm.getStopwatch()+" seconds.");
                clockPts+=2;
            }
            System.out.println("The alarm clock passed "+clockPts+"/"+maxClock+" tests.");

        // TESTING PRINTER
        System.out.println("\n=== TESTING PRINTER ===");
        int maxPrinter = 14;
        int printerPts = 0;
        System.out.println("Constructing new printer...");
        Printer printer = new Printer();

            System.out.println("Testing the initial setup levels...");
            System.out.println("Initial Ink: " + printer.getInk());
            System.out.println("Initial Paper: " + printer.getPaper());
            System.out.println("Initial Staples: " + printer.getStaples());

            if (printer.getInk()==100)
            {
                System.out.println("Passed Ink levels test");
                printerPts++;
            }
            if (printer.getPaper()==50)
            {
                System.out.println("Passed paper levels test");
                printerPts++;
            }
            if (printer.getStaples()==20)
            {
                System.out.println("Passed staple levels test");
                printerPts++;
            }

            // Test single-sided print
            System.out.println("\nTesting single-sided printing...");
            System.out.println(printer.print(5, false));
            System.out.println("After printing 5 pages:");
            if (printer.getInk()==90)
            {
                System.out.println("Passed Ink levels test");
                printerPts++;
            }
            else{
                System.out.println("Failed Ink Levels test. Expected 75, actual: "+printer.getInk());
            }
            if (printer.getPaper()==45)
            {
                System.out.println("Passed paper levels test");
                printerPts++;
            }
            else{
                System.out.println("Failed paper Levels test. Expected 45, actual: "+printer.getPaper());
            }
            if (printer.getStaples()==19)
            {
                System.out.println("Passed staple levels test");
                printerPts++;
            }
            else{
                System.out.println("Failed staple Levels test. Expected 19, actual: "+printer.getStaples());
            }
            
            //Test refill
            System.out.println("\nTesting refills");
            printer.refillInk();
            if (printer.getInk()==100){
                System.out.println("Ink...Passed");
                printerPts++;
            }
            else{
                System.out.println("Ink...failed");
            }
            printer.refillPaper();
            if (printer.getPaper()==50){
                System.out.println("Paper...Passed");
                printerPts++;
            }
            else{
                System.out.println("Paper...failed");
            }
            printer.refillStaples();
            if (printer.getStaples()==20){
                System.out.println("Staples...Passed");
                printerPts++;
            }
            else{
                System.out.println("Staples...failed");
            }

            // Test double-sided print
            System.out.println("\nTesting double-sided printing by attempting to print 5 pages...");
            printer.print(5, true);
            if (printer.getInk()==90){
                System.out.println("Ink level...Passed");
                printerPts++;
            }
            else{
                System.out.println("Ink level...failed");
            }

            if (printer.getPaper()==47){
                System.out.println("Paper level...Passed");
                printerPts++;
            }
            else{
                System.out.println("Paper level...failed");
            }

            if (printer.getStaples()==19){
                System.out.println("Staple level...Passed");
                printerPts++;
            }
            else{
                System.out.println("Staple level...failed");
            }

            // Drain paper
            System.out.println("\nDraining paper supplies...");
            System.out.println(printer.print(50, false));
            if (printer.getInk()==0&&printer.getPaper()>0)
            {
                System.out.println("Passed.");
                printerPts++;
            }
            else{
                System.out.println("Failed. Expected 0 ink, 4 paper. Actual: "+printer.getInk()+" ink, "+printer.getPaper()+" paper.");
            }
            printer.refillInk();
            System.out.println(printer.print(50, false));
            if (printer.getInk()>0&&printer.getPaper()==0)
            {
                System.out.println("Passed.");
                printerPts++;
            }
            else{
                System.out.println("Failed. Expected 84 ink, 0 paper. Actual: "+printer.getInk()+" ink, "+printer.getPaper()+" paper.");
            }
            printer.refillPaper();

            System.out.println("The printer passed "+printerPts+"/"+maxPrinter+" tests.");
    }

    }
