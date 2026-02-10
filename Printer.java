/**
Printer class
@author Ryan Kim
@author Conner Wang
@version 2026.2.9
*/
public class Printer {

    private int inkLevel;      // percentage (0–100)
    private int paperCount;    // number of sheets
    private int stapleCount;   // number of staples

    public Printer() {
        inkLevel = 100;
        paperCount = 50;
        stapleCount = 20;
    }

    public void print() {
        if (inkLevel <= 0) {
            System.out.println("Cannot print: Ink is empty.");
        } else if (paperCount <= 0) {
            System.out.println("Cannot print: Out of paper.");
        } else if (stapleCount <= 0) {
            System.out.println("Cannot print: No staples left.");
        } else {
            inkLevel -= 5;
            paperCount--;
            stapleCount--;
            System.out.println("Printing... Done!");
        }
    }

    public void refillInk() {
        inkLevel = 100;
        System.out.println("Ink refilled.");
    }

    public void refillPaper() {
        paperCount = 50;
        System.out.println("Paper refilled.");
    }

    public void refillStaples() {
        stapleCount = 20;
        System.out.println("Staples refilled.");
    }
}
