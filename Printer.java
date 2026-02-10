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

    public void print(int pages, boolean doubleSided) {
        if (inkLevel <= 0) {
            System.out.println("Cannot print: Ink is empty.");
        } else if (paperCount <= 0) {
            System.out.println("Cannot print: Out of paper.");
        } else if ((stapleCount <= 0&&pages>1&&!doubleSided)||(stapleCount <= 0&&pages>2&&doubleSided)) {
            System.out.println("Cannot print: No staples left.");
        } else {
            inkLevel -= pages*5;
            if (doubleSided)
            {
                paperCount-=(int) pages/2 + pages%2;
            }
            else
            {
                paperCount -= pages;
            }
            if ((pages>1&&!doubleSided)||(pages>2&&doubleSided))
            {
                stapleCount--;
            }
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
    public int getInk()
    {
        return inkLevel;
    }

    public int getStaples()
    {
        return stapleCount;
    }

    public int getPaper()
    {
        return paperCount;
    }
}
