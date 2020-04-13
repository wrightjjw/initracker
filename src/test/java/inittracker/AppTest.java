/** AppTest.java
 * Copyright (C) 2020 Josh Wright
 * licensed under GPLv3
 */
package inittracker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test
    public void testInitListToObjectArray() {
        InitList il = new InitList();
        InitBlock ib1 = new InitBlock("Klaus", 15, 17);
        InitBlock ib2 = new InitBlock("Remus", 18, 13);
        il.add(ib1); il.add(ib2);

        Object[][] data = App.initListToObjectArray(il);

        assertEquals("[1,0] is 18", 18, data[0][0]);
        assertEquals("[1,1] is Remus", "Remus", data[0][1]);
        assertEquals("[1,2] is 13", 13, data[0][2]);

        assertEquals("[0,0] is 15", 15, data[1][0]);
        assertEquals("[0,1] is Klaus", "Klaus", data[1][1]);
        assertEquals("[0,2] is 17", 17, data[1][2]);
    }
}
