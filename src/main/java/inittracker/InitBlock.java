/**
 * Container for tracking name, initiative, and AC.
 * @author Josh Wright
 */

package inittracker;

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
     * @return 1 if this > other, -1 if this < other, 0 if this = other
     */
    // FIXME: This method may cause misbehavement when used with blocks of equal value
    public int greaterThan(InitBlock other) {
        if (init > other.init) {
            return 1;
        } else if (init < other.init) {
            return -1;
        } else {
            return 0;
        }
    }
}
