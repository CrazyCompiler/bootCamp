package shapes;/*
Job of shapes.Rectangle is to calculate any quantity of shapes.Rectangle using length and breadth
    or length or breadth.
 */

public class Rectangle {

    private double length;
    private double breadth;

    protected Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    static public Rectangle createRectangle(double length, double breadth) {
        if (length <= 0 || breadth <= 0)
            throw new IllegalArgumentException("Non positive input is provided length :" + length +" breadth :"+ breadth + " while creating rectangle");
        return new Rectangle(length, breadth);
    }

    public double calculateArea() {
        return length * breadth;
    }

    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}
    