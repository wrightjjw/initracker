/** InitBlock.java
 * Copyright (C) 2020 Josh Wright
 * licensed under GPLv3
 */
package inittracker;

/**
 * Container for tracking name, initiative, and AC.
 * @author Josh Wright
 */
public class InitBlock {

    protected String name;
    protected Integer init;
    protected Integer ac;

    /**
     * Default constructor
     */
    public InitBlock() {
        name = "";
        init = 0;
        ac = 0;
    }

    /**
     * Explicit constructor
     * @param myName Name to use
     * @param myInit Init to use
     * @param myAC AC to use
     */
    public InitBlock(String myName, Integer myInit, Integer myAC) {
        name = myName;
        init = myInit;
        ac = myAC;
    }

    /**
     * Greater than operator. Compares init values of two InitBlocks.
     * @param other InitBlock to compare to
     * @return true if this has a larger init value than other, false if not
     */
    // FIXME: This method may cause misbehavement when used with blocks of equal value
    public Boolean greaterThan(InitBlock other) {
        if (init > other.init) {
            return true;
        } else {
            return false;
        }
    }
}
