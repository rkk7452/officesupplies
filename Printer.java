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

    /**
     * The print() method uses up paper, staples, and ink to 'print'
     * @param pages the number of pages being printed
     * @param doubleSided whether or not the print job should be double sided
     */
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

    /**
     * The refillInk() method resets the inkLevel to max capacity
     */
    public void refillInk() {
        inkLevel = 100;
        System.out.println("Ink refilled.");
    }

    /**
     * The refillPaper() method resets the papercount to max capacity
     */
    public void refillPaper() {
        paperCount = 50;
        System.out.println("Paper refilled.");
    }

    /**
     * The refillStaples() method resets the stapleCount to max capacity
     */
    public void refillStaples() {
        stapleCount = 20;
        System.out.println("Staples refilled.");
    }

    /**
     * The getInk() method returns the current ink level
     * @return the current ink level
     */
    public int getInk()
    {
        return inkLevel;
    }

    /**
     * The getStaples() method returns the current ink level
     * @return the current staple count
     */
    public int getStaples()
    {
        return stapleCount;
    }

    /**
     * The getPaper() method returns the current ink level
     * @return the current paper count
     */
    public int getPaper()
    {
        return paperCount;
    }
}
