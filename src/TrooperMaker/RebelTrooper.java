package TrooperMaker;

/**
 * Title: RebelTrooper.java
 * Abstract: Derived/child class of Trooper, extends Trooper, creates a RebelTrooper object
 * Author: Stacy Kirchner
 * Date: 14 November 2022
 */

public class RebelTrooper extends Trooper {
    private String name = "Rebel";
    private static int soliderCount = 0;


    /**
     * sets trooperKind to Pilot
     * sets marchModifier to 0.75
     * increments soliderCount
     * @param unit =  sets using super/parent class
     * @param number = sets using super/parent class
     */
    public RebelTrooper(String unit, int number, String trooperKind) {

        super(unit, number);
        soliderCount++;
        this.trooperKind = "Pilot";
        this.marchModifier = 0.75;
        this.name = trooperKind;
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
