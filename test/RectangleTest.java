import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shapes.Rectangle;

import static org.junit.Assert.assertEquals;
/*
job of the RectangleTest is to test all the behaviour of shapes.Rectangle.
 */
public class RectangleTest {
    Rectangle rectangle;

    @Before
    public void setUp() throws Exception {
        double length = 3.4d;
        double breadth = 4.5d;
        rectangle= Rectangle.createRectangle(length, breadth);

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void calculateArea_should_calculate_area_of_rectangle() throws Exception {
        double expectedArea = 15.3d;
        assertEquals(expectedArea,rectangle.calculateArea(), 0.0001);
    }

    @Test
    public void calculatePerimeter_should_calculate_perimeter_of_the_rectangle() throws Exception {
        double expectedPerimeter = 15.8d;
        assertEquals(expectedPerimeter, rectangle.calculatePerimeter(), 0.000);
    }

    @Test
    public void rectangle_throws_exception_for_non_positive_length() throws Exception {
        double length = -2;
        double breadth = 20;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Non positive input is provided length :-2.0 breadth :20.0 while creating rectangle");
        Rectangle rectangle = Rectangle.createRectangle(length,breadth);
    }

    @Test
    public void rectangle_throws_exception_for_non_positive_breadth() throws Exception {
        double length = 20;
        double breadth = -2;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Non positive input is provided length :20.0 breadth :-2.0 while creating rectangle");
        Rectangle rectangle = Rectangle.createRectangle(length,breadth);
    }

    @Test
    public void rectangle_throws_exception_if_any_of_given_length_or_breadth_is_zero() throws Exception {
        double length = 0;
        double breadth = -2;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Non positive input is provided length :0.0 breadth :-2.0 while creating rectangle");
        Rectangle rectangle = Rectangle.createRectangle(length,breadth);
    }
}