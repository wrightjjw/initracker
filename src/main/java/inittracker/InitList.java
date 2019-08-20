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
     * If it is equivalent to an init already in the list, it will throw an exception.
     * Behavior when an init is equal should be determined by the application.
     * @param ib InitBlock to add
     * @throws EqualInitsException
     */
    public void add(InitBlock ib) {
        for (int i = 0; i < inits.size(); i++) {
            if (ib.greaterThan(inits.get(i)) == 0) throw new EqualInitsException();
            if (ib.greaterThan(inits.get(i)) == 1) {
                inits.add(i, ib);
                size++;
                return;
            }
        }
        inits.add(ib);
        size++;
    }

    /**
     * Remove an InitBlock at a specified index.
     * @param index The index of the item to remove
     * @return The InitBlock that was removed
     */
    public InitBlock remove(int index) {
        size--;
        return inits.remove(index);
    }

    /**
     * Remove an InitBlock from the list.
     * @param ib The InitBlock to remove.
     * @return True if the InitBlock was in the list, false if not.
     */
    public boolean remove(InitBlock ib) {
        size--;
        boolean result = inits.remove(ib);
        return result;
    }
}
