/**
 * Container for InitBlocks. Automatically organizes them based on inits.
 * @author Josh Wright
 */

package inittracker;

import java.util.List;
import java.util.ArrayList;

public class InitList {

    private List<InitBlock> inits;

    public InitList() {
        inits = new ArrayList<>();
    }

    public InitBlock get(int index) {
        return inits.get(index);
    }

    public void add(InitBlock ib) {
        for (int i = 0; i < inits.size(); i++) {
            if (ib.greaterThan(inits.get(i))) {
                inits.add(i, ib);
                break;
            }
        }
        inits.add(ib);
    }
}
