package com.r.allende.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void testsWhen() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("José Tomás"));
        assertEquals("fda", "fda");
    }
}