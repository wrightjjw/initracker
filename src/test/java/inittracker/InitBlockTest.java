/** InitBlockTest.java
 * Copyright (C) 2020 Josh Wright
 * licensed under GPLv3
 */

package inittracker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for InitBlock
 * @author Josh Wright
 */
public class InitBlockTest {

    @Test
    public void testDefaultConstructor() {
        InitBlock ib = new InitBlock();
        assertEquals("Name is blank", "", ib.name);
        assertEquals("Init is 0", Integer.valueOf(0), ib.init);
        assertEquals("AC is 0", Integer.valueOf(0), ib.ac);
    }

    @Test
    public void testExplicitConstructor() {
        InitBlock ib = new InitBlock("Klaus", 16, 15);
        assertEquals("Name is Klaus", "Klaus", ib.name);
        assertEquals("Init is 16", Integer.valueOf(16), ib.init);
        assertEquals("AC is 15", Integer.valueOf(15), ib.ac);
    }

    @Test
    public void testGreaterThan() {
        InitBlock ib1 = new InitBlock("Klaus", 16, 15);
        InitBlock ib2 = new InitBlock("Oswalt", 15, 15);
        assertTrue("Klaus > Oswalt", ib1.greaterThan(ib2));
    }
}
