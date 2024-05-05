package TrooperMaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Title: Trooper.java
 * Abstract: Parent/Super class of RebelTrooper and StormTrooper;
 * Author: Stacy Kirchner
 * Date: 14 November 2022
 */

public abstract class Trooper{
    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier;

    public Trooper() {
        this.unit = "AA";
        this.number = 0;
    }

    /**
     * @param unit = "AA"
     * @param number = 0
     */
    Trooper(String unit, int number) {
        this.unit = unit;
        unit = "AA";
        this.number = number;
        number = 0;
        this.marchSpeed = 5;
    }

    /**
     * if HashMap already has a key that has the value T.unit,
     * adds Trooper object to the List in the HashMap as the value;
     * if key is not already there adds key with a List of Troopers for the value
     * @param units: HashMap with the key as the value for unit of the Trooper object t,
     *             the value is a List of Troopers that contains all the Trooper objects that have the same value for unit
     * @param T: Trooper object that is added to the List in the HashMap
     */
    static void addToUnit(HashMap<String, List<Trooper>> units, Trooper T){

        if (T == null){
            return;
        }
        else {
            if(units.containsKey(T.unit)){
                units.get(T.unit).add(T);
            }
            else{
                units.put(T.unit, new ArrayList<Trooper>());
                units.get(T.unit).add(T);
            }
        }

    }

    public abstract double march(double march);

    /**
     * Determines based on the roll what object is attacking what target
     * prints what number the object rolled
     */
    public boolean attack(Trooper target, int roll) {
        boolean check = true;
        Trooper StormTrooper;
        if((this.equals(target)) || roll == 1){
            System.out.println(this.toString() + " is targeting itself.");
            System.out.println(this.toString() + " rolled a " + roll + " and hurt itself in the confusion");
            check = true;
        }
        else if(this instanceof StormTrooper){
            if(target instanceof RebelTrooper){
                System.out.println("rolled a " + roll + " against the rebel scum.");
                if(roll > 10 && (roll%2 == 0)){
                    check = true;
                }
                else {
                    check = false;
                }
            }
            else if (target instanceof StormTrooper){
                System.out.println("No treason in the ranks!");
                check = false;
            }
            else {
                System.out.println("Acceptable Collateral Damage");
                if (roll > 10 || (roll % 2 == 0)) {
                    check = true;
                }
                else {
                    check = false;
                }
            }
        }
        else if(this instanceof RebelTrooper){
            if(target instanceof RebelTrooper){
                System.out.println("Imperial Spy!");
                check = false;
            }
            else if(target instanceof StormTrooper){
                System.out.println("rolled a " + roll + " against the imperial scum.");
                if(roll > 5 || (roll%2 == 1)){
                    check = true;
                }
                else {
                    check = false;
                }
            }
            else {
                System.out.println("Rebel target an innocent bystander");
                if(roll >= 18 && (roll%2 == 0)){
                    check = true;
                }
                else {
                    check = false;
                }
            }
        }
        return check;
    }

    /**
     * @return unit as a String
     */
    public String getUnit() {
        return unit;
    }

    /**
     * sets unit as a String
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return number as a int
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets number as an int
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return trooperKind as a String
     */
    public String getTrooperKind() {
        return trooperKind;
    }

    /**
     * sets trooperKind as a String
     */
    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    /**
     * @return marchSpeed as a double
     */
    public double getMarchSpeed() {
        return marchSpeed;
    }

    /**
     * sets marchSpeed as a double;
     */
    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    /**
     * @return [unit][number]:
     */
    @Override
    public String toString() {

        return this.unit + this.number + ":";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trooper trooper = (Trooper) o;

        if (getNumber() != trooper.getNumber()) return false;
        if (Double.compare(trooper.getMarchSpeed(), getMarchSpeed()) != 0) return false;
        if (Double.compare(trooper.marchModifier, marchModifier) != 0) return false;
        if (getUnit() != null ? !getUnit().equals(trooper.getUnit()) : trooper.getUnit() != null) return false;
        return getTrooperKind() != null ? getTrooperKind().equals(trooper.getTrooperKind()) : trooper.getTrooperKind() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getUnit() != null ? getUnit().hashCode() : 0;
        result = 31 * result + getNumber();
        result = 31 * result + (getTrooperKind() != null ? getTrooperKind().hashCode() : 0);
        temp = Double.doubleToLongBits(getMarchSpeed());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(marchModifier);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

