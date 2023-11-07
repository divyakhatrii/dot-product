/*this is the class where all the calculation occurs, separately from the gui
 */
package khatrigui;


public class DotCalculation
{
//declaring variables
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int dotProduct;
//constructor
    public DotCalculation(int xOne, int xTwo, int yOne, int yTwo)
    {
        this.x1 = xOne;
        this.x2 = xTwo;
        this.y1 = yOne;
        this.y2 = yTwo;
        setDotProduct(); //uses set method to calculate using above values
    }

    //set and get methods
    public void setX1(int xOne)
    {
        this.x1 = xOne;
    }

    public int getX1()
    {
        return this.x1;
    }

    public void setX2(int xTwo)
    {
        this.x2 = xTwo;
    }

    public int getX2()
    {
        return this.x2;
    }

    public void setY1(int yOne)
    {
        this.y1 = yOne;
    }

    public int getY1()
    {
        return this.y1;
    }

    public void setY2(int yTwo)
    {
        this.y2 = yTwo;
    }

    public int getY2()
    {
        return this.y2;
    }
    
    public void setDotProduct() //calculates the dot product
    {
       this.dotProduct = (x1 * x2) + (y1 * y2);
    }
    public int getDotProduct()
    {
        return this.dotProduct;
    }
    
    public String toString()
    {
        return "The dot product is " + dotProduct; 
    }
    
    //test calculations to make sure they are right
    public static void main(String [] args)
    {
        DotCalculation dotObj = new DotCalculation(3,4,5,6);
        System.out.println(dotObj);
    }

}
