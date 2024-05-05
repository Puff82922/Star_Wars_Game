package TrooperMaker;

/**
 * Title: StormTrooper.java
 * Abstract: Derived/child class of Trooper, extends Trooper, creates a Storm Trooper object
 * Author: Stacy Kirchner
 * Date: 14 November 2022
 */

public class StormTrooper extends Trooper {
    private String name = "";
    private static int soliderCount = 0;


    /**
     * sets trooperKind to StormTrooper
     * sets marchModifier to 1.10
     * increments soliderCount
     * @param unit =  sets using super/parent class
     * @param number = sets using super/parent class
     */
    public StormTrooper(String unit, int number) {

        super(unit, number);
        soliderCount++;
        this.trooperKind = "StormTrooper";
        this.marchModifier = 1.10;
    }

    /**
     * @return marchSpeed multiplied by duration multiplied by marchModifer,
     */
    @Override
    public double march(double duration) {
        return marchSpeed * duration * marchModifier;
    }

    /**
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * sets name as a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return soliderCount as an int
     */
    public static int getSoldierCount() {
        return soliderCount;
    }

    /**
     * @return [name]([unit][number]:)[trooperKind]
     */
    @Override
    public String toString() {

        return this.name + "(" + super.toString() + ")" + trooperKind;
    }
}
