/**
AlarmClock class
@author Ryan Kim
@author Conner Wang
@version 2026.2.4

*/



public class alarmClock {
    private int hours;
    private int minutes;
    private int seconds;
    private int alarmHours;
    private int alarmMinutes;
    private int timerSeconds;
    private int stopwatchSeconds;
    private boolean batteryDead;

    private long startTime;

    public alarmClock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        alarmHours = 0;
        alarmMinutes = 0;
        timerSeconds = 0;
        stopwatchSeconds = 0;
        batteryDead = false;

        startTime = System.currentTimeMillis();
    }

    /**
     * Sets the clock's time to the parameters
     * @param h hours
     * @param m minutes
     * @param s seconds
     */
    public void setTime(int h, int m, int s) {
        if (!batteryDead) {
            hours = h;
            minutes = m;
            seconds = s;
        }
    }

    /**
     * Returns the number of milliseconds passed since the beginning of the program
     * @return the number of milliseconds passed
     */
    private long getMillisPassed() {
        return (System.currentTimeMillis() - startTime);
    }

    /**
     * setTimer() Sets the timer to the number of seconds given
     * @param seconds the number of seconds to time
     */
    public void setTimer(int seconds) {
        if (!batteryDead) {
            timerSeconds = seconds;
        }
    }

    /**
     * The runTimer() method runs a timer of a given duration
     * @param seconds the number of seconds to time
     * @return print out when the timer finishes
     */
    public String runTimer(int seconds)
    {
        Threat.sleep(seconds*1000);
        return ("Timer is over");
    }
    
    /**
     * setAlarm() sets the time for the alarm to go off
     * @param h hours in 24 hour time
     * @param m minutes
     */
    public void setAlarm(int h, int m) {
        if (!batteryDead) {
            alarmHours = h;
            alarmMinutes = m;
        }
    }

    /**
     * setStopWatch() resets the stopwatch to 0
     */
    public void setStopWatch() {
        if (!batteryDead) {
            stopwatchSeconds = 0;
        }
    }

    /**
     * isBatteryDead returns if the battery is dead
     * @return batteryDead; true if it is dead
     */
    public boolean isBatteryDead() {
        return batteryDead;
    }

    /**
     * replaceBattery() resets the battery and resets the startTime
     */
    public void replaceBattery() {
        batteryDead = false;
        startTime = System.currentTimeMillis();
    }

    /**
     * draimBattery() kills the battery
     */
    public void drainBattery() {
        batteryDead = true;
    }

    /**
     * getTime() returns the clock's time in seconds
     * @return time in seconds since midnight
     */
    public int getTime() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    /**
     * toString returns key info: time, whether battery is dead, timer, and stopwatch
     */
    public String toString() {
        return hours + ":" + minutes + ":" + seconds
                + " | Battery Dead: " + batteryDead
                + " | Timer Seconds: " + timerSeconds
                + " | Stopwatch Seconds: " + stopwatchSeconds;
    }
}
