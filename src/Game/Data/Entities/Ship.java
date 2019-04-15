package Game.Data.Entities;

public class Ship {
    private String name;
    private boolean sunk;
    private Coordinate startPoint;
    private Coordinate endPoint;
    private Integer size;

    /**
     * Constructor for Ship class
     * @param name Ship's name/class
     * @param size Size of ship
     */
    Ship(String name, Integer size) {
        this.name = name;
        this.size = size;
        this.sunk = false;
        this.startPoint = null;
        this.endPoint = null;
    }

    /**
     * Is this ship sunk or not?
     * @return True if sunk, false otherwise
     */
    public boolean isSunk() {
        return this.sunk;
    }

    /**
     * Determines if this ship is placed on a field or not
     * @return True if placed (coordinates specified), false otherwise
     */
    public boolean isPlaced() {
        return this.startPoint != null && this.endPoint != null;
    }

    /**
     * Places a ship using a start coordinate as a pivot, and 4 directions to specify for end point
     * @param startX starting X coordinate for pivot
     * @param startY starting Y coordinate for pivot
     * @param direction which way to place endpoint relative to pivot coordinate
     */
    public void placeShip(int startX, int startY, Direction direction) {
        this.startPoint = new Coordinate(startX, startY);
        this.endPoint = this.startPoint.clone();

        switch(direction) {
            case UP:
                this.endPoint.setY(this.endPoint.getY() + this.size);
                break;
            case DOWN:
                this.endPoint.setY(this.endPoint.getY() - this.size);
                break;
            case LEFT:
                this.endPoint.setX(this.endPoint.getX() - this.size);
                break;
            case RIGHT:
                this.endPoint.setX(this.endPoint.getX() + this.size);
                break;
        }
    }

    /**
     * "Unplaces" a ship by unassigning any coordinates set to it
     */
    public void unplaceShip() {
        this.startPoint = null;
        this.endPoint = null;
    }

    /**
     * Setter for this.sunk member
     * @param sink Set ship sunk status
     */
    public void setSunk(boolean sink) {
        this.sunk = sink;
    }

    /**
     * Returns a string representation of this class
     * @return String representation of this class
     */
    @Override
    public String toString() {
        String locationString;
        if (isPlaced()) {
            locationString = String.format("%s, %s", this.startPoint.toString(), this.endPoint.toString());
        }
        else {
            locationString = "unplaced";
        }
        return String.format("Ship class: %s, size: %d, location: %s, sunk: %s",
                this.name, this.size, locationString, this.sunk);
    }

    /**
     * Main method for unit testing
     * @param args unused
     */
    public static void main(String[] args) {
        Ship testShip1 = new Ship("Carrier", 5);
        System.out.println(testShip1.toString());
        System.out.printf("testShip1 placed: %s\n", testShip1.isPlaced());
        System.out.printf("testShip1 sunk: %s\n", testShip1.isSunk());

        System.out.println("Placing testShip1, direction UP");
        testShip1.placeShip(0,0, Direction.UP);

        System.out.println(testShip1.toString());

        System.out.println("Sinking testShip1");
        testShip1.setSunk(true);

        System.out.println(testShip1.toString());

        System.out.println("Placing testShip1, direction DOWN");
        testShip1.placeShip(0,0, Direction.DOWN);
        System.out.println("Unsinking testShip1");
        testShip1.setSunk(false);

        System.out.println(testShip1.toString());

        System.out.println("Unplacing testShip1");
        testShip1.unplaceShip();
        System.out.println(testShip1.toString());
    }
}
