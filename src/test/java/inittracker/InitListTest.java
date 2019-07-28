/**
 * JUnit tests for InitList
 * @author Josh Wright
 */

package inittracker;

import org.junit.Test;
import static org.junit.Assert.*;

public class InitListTest {

    @Test
    public void testGet() {
        InitList il = new InitList();
        InitBlock ib = new InitBlock("Oswalt", 16, 15);
        il.add(ib);
        assertEquals("get returns Oswalt", "Oswalt", il.get(0).name);
    }

    @Test
    public void testAdd() {
        InitList il = new InitList();
        InitBlock ib1 = new InitBlock("Klaus", 16, 18);
        InitBlock ib2 = new InitBlock("Oswalt", 15, 15);
        InitBlock ib3 = new InitBlock("Remus", 20, 13);
        il.add(ib1);
        il.add(ib2);
        il.add(ib3);
        assertEquals("Remus is 1st", "Remus", il.get(0).name);
        assertEquals("Klaus is 2nd", "Klaus", il.get(1).name);
        assertEquals("Oswalt is 3rd", "Oswalt", il.get(2).name);
    }

    @Test
    public void testRemoveIndex() {
        InitList il = new InitList();
        InitBlock ib1 = new InitBlock("Klaus", 16, 18);
        InitBlock ib2 = new InitBlock("Oswalt", 15, 15);
        InitBlock ib3 = new InitBlock("Remus", 20, 13);
        il.add(ib1);
        il.add(ib2);
        il.add(ib3);
        assertEquals("remove 1 is ib1", ib1, il.remove(1));
        assertEquals("Remus is 1st", "Remus", il.get(0).name);
        assertEquals("Oswalt is 2nd", "Oswalt", il.get(1).name);
    }

    @Test
    public void testRemoveBlock() {
        InitList il = new InitList();
        InitBlock ib1 = new InitBlock("Klaus", 16, 18);
        InitBlock ib2 = new InitBlock("Oswalt", 15, 15);
        InitBlock ib3 = new InitBlock("Remus", 20, 13);
        il.add(ib1);
        il.add(ib2);
        il.add(ib3);
        assertTrue("remove ib2 is true", il.remove(ib1));
        assertEquals("Remus is 1st", "Remus", il.get(0).name);
        assertEquals("Oswalt is 2nd", "Oswalt", il.get(1).name);
        assertEquals("Remus is 1st", "Remus", il.get(0).name);
        assertEquals("Oswalt is 2nd", "Oswalt", il.get(1).name);
    }
}
