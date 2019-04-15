package Game.Data.Entities;

public class Coordinate implements Cloneable {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        }
        catch (CloneNotSupportedException e) {
            System.err.println("Error cloning Coordinate");
            return null;
        }
    }

    public static void main(String[] args) {
        Coordinate testCoord = new Coordinate(2, 2);
        System.out.printf("testCoord = %s\n", testCoord.toString());
        Coordinate testCoordCopy = testCoord.clone();
        System.out.printf("testCoordCopy = %s\n", testCoordCopy.toString());
        testCoordCopy.setX(-2);
        testCoordCopy.setY(-2);
        System.out.println("testCoordCopy coordinates changed");
        System.out.printf("testCoord = %s\n", testCoord.toString());
        System.out.printf("testCoordCopy = %s\n", testCoordCopy.toString());
    }

}
