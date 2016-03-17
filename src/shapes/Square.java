package shapes;

/*
Job of shapes.Square is to calculate any quantity of shapes.Square using length and breadth
    or length or breadth.
 */
public class Square extends Rectangle {
    private double side;

    private Square(double side) {
        super(side,side);
    }

    public static Square createSquare(double side) {
        if(side <= 0)
            throw new IllegalArgumentException("Non positive input is provided side: "+side+" while creating square");
        return new Square(side);
    }
}
