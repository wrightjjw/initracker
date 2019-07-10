/**
 * Container for tracking name, initiative, and AC.
 * @author Josh Wright
 */

package inittracker;

public class InitBlock {

    protected String name;
    protected Integer init;
    protected Integer ac;

    public InitBlock() {
        name = "";
        init = 0;
        ac = 0;
    }

    public InitBlock(String myName, Integer myInit, Integer myAC) {
        name = myName;
        init = myInit;
        ac = myAC;
    }

    public Boolean greaterThan(InitBlock other) {
        if (init > other.init) {
            return true;
        } else {
            return false;
        }
    }
}
