package Game.Data.Entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Ship {
    private String name;
    private Coordinate startPoint;
    private Coordinate endPoint;
    private Integer size;
    private ArrayList<Coordinate> cellCoords;
    private Hashtable<Coordinate, Boolean> cellStatuses;

    /**
     * Constructor for Ship class
     * @param name Ship's name/class
     * @param size Size of ship
     */
    Ship(String name, Integer size) {
        this.name = name;
        this.size = size;
        this.startPoint = null;
        this.endPoint = null;
        this.cellCoords = new ArrayList<>();
        this.cellStatuses = new Hashtable<>();
    }

    /**
     * Getter for this ship's size
     * @return The ship's segment size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Is this ship sunk or not?
     * @return True if sunk, false otherwise
     */
    public boolean isSunk() {
        if (!isPlaced()) throw new RuntimeException("Unplaced ships are not sunk");
        for (Boolean isHit: this.cellStatuses.values()) {
            if (!isHit) return false;
        }
        return true;
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
        if (this.isPlaced()) throw new RuntimeException("Unplace ship first before calling placeShip() on it again");

        this.startPoint = new Coordinate(startX, startY);
        Coordinate newCoord;
        for (int i = 0; i < this.size; ++i) {
            newCoord = this.startPoint.clone();
            switch(direction) {
                case UP:
                    newCoord.setY(newCoord.getY() + i);
                    this.cellCoords.add(newCoord);
                    break;
                case DOWN:
                    newCoord.setY(newCoord.getY() - i);
                    this.cellCoords.add(newCoord);
                    break;
                case LEFT:
                    newCoord.setX(newCoord.getX() - i);
                    this.cellCoords.add(newCoord);
                    break;
                case RIGHT:
                    newCoord.setX(newCoord.getX() + i);
                    this.cellCoords.add(newCoord);
                    break;
            }
            if (i == this.size - 1) this.endPoint = newCoord;
        }
        for (Coordinate cell: this.cellCoords) {
            this.cellStatuses.put(cell, false);
        }
    }

    /**
     * "Unplaces" a ship by unassigning any coordinates set to it
     * As well as clearing out coordinate lists
     */
    public void unplaceShip() {
        this.startPoint = null;
        this.endPoint = null;
        this.cellStatuses.clear();
        this.cellCoords.clear();
    }

    /**
     * Damages the ship at the specified segment
     * @param segment The segment part to damage the ship in
     */
    public void damageShipAtSegment(int segment) {
        if (segment < 0 || segment >= this.size)
            throw new RuntimeException("Cannot damage ship at invalid segment index");
        Coordinate segCoord = this.cellCoords.get(segment);
        if (this.cellStatuses.get(segCoord)) {
            String eMsg = String.format("Ship already damaged at segment %d (coordinate %s)", segment, segCoord.toString());
            throw new RuntimeException(eMsg);
        }
        this.cellStatuses.replace(segCoord, true);
    }

    /**
     * Returns a string representation of this class
     * @return String representation of this class
     */
    @Override
    public String toString() {
        String locationString;
        if (isPlaced()) {
            locationString = String.format("%s,%s", this.startPoint.toString(), this.endPoint.toString());
        }
        else locationString = "unplaced";

        int currentHP = this.size;
        for (boolean isHit: this.cellStatuses.values()) {
            if (isHit) --currentHP;
        }

        return String.format("Ship class: %s, size: %d, location: %s, HP: %d/%d",
                this.name, this.size, locationString, currentHP, this.size);
    }

    /**
     * Main method for unit testing
     * @param args unused
     */
    public static void main(String[] args) {
        Ship testShip1 = new Ship("Carrier", 5);
        System.out.println(testShip1.toString());
        try {
            System.out.printf("testShip1 sunk: %s\n", testShip1.isSunk());
        }
        catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("testShip1 placed: %s\n", testShip1.isPlaced());

        System.out.println("Placing testShip1, direction UP");
        testShip1.placeShip(0,0, Direction.UP);
        System.out.println(testShip1.toString());

        System.out.println("Damaging testShip1 at segment 0");
        testShip1.damageShipAtSegment(0);
        System.out.println(testShip1.toString());

        try {
            System.out.println("Damaging testShip1 at segment 0 again");
            testShip1.damageShipAtSegment(0);
            System.out.println(testShip1.toString());
        }
        catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Damaging testShip1 at segment 1");
        testShip1.damageShipAtSegment(1);
        System.out.println(testShip1.toString());
        System.out.printf("Sunk?: %s\n", testShip1.isSunk());

        System.out.println("Damaging testShip1 at completely");
        testShip1.damageShipAtSegment(2);
        testShip1.damageShipAtSegment(3);
        testShip1.damageShipAtSegment(4);
        System.out.println(testShip1.toString());
        System.out.printf("Sunk?: %s\n", testShip1.isSunk());

        try {
            System.out.println("Placing testShip1, direction DOWN");
            testShip1.placeShip(0,0, Direction.DOWN);
        }
        catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Unplacing testShip1");
        testShip1.unplaceShip();
        System.out.println(testShip1.toString());
    }
}
