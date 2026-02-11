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
    public void setTime(int h, int m, int s) {
        if (!batteryDead) {
            hours = h;
            minutes = m;
            seconds = s;
        }
    }

    private long getMillisPassed() {
        return System.currentTimeMillis() - startTime;
    }

    public void setTimer(int seconds) {
        if (!batteryDead) {
            timerSeconds = seconds;
        }
    }

    public void setAlarm(int h, int m) {
        if (!batteryDead) {
            alarmHours = h;
            alarmMinutes = m;
        }
    }

    public void setStopWatch() {
        if (!batteryDead) {
            stopwatchSeconds = 0;
        }
    }

    public boolean isBatteryDead() {
        return batteryDead;
    }

    public void replaceBattery() {
        batteryDead = false;
        startTime = System.currentTimeMillis();
    }

    public void drainBattery() {
        batteryDead = true;
    }

    public int getTime() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds
                + " | Battery Dead: " + batteryDead
                + " | Timer Seconds: " + timerSeconds
                + " | Stopwatch Seconds: " + stopwatchSeconds;
    }
}
