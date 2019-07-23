/**
 * Container for InitBlocks. Automatically organizes them based on inits.
 * @author Josh Wright
 */

package inittracker;

import java.util.List;
import java.util.ArrayList;

public class InitList {

    private List<InitBlock> inits;
    private int size;
    public int getSize() { return size; }

    /**
     * Constructor. Instantiates blank list
     */
    public InitList() {
        inits = new ArrayList<>();
        size = 0;
    }

    /**
     * Get the InitBlock at a certain index
     * @param index The index of the InitBlock to get
     * @return The InitBlock at the given index
     */
    public InitBlock get(int index) {
        return inits.get(index);
    }

    /**
     * Add an InitBlock to the list.
     * @param ib InitBlock to add
     */
    public void add(InitBlock ib) {
        for (int i = 0; i < inits.size(); i++) {
            if (ib.greaterThan(inits.get(i))) {
                inits.add(i, ib);
                break;
            }
        }
        inits.add(ib);
        size++;
    }
}
