package com.r.allende.javatests.util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void cantRepeatNegativeItems() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("fd", -1);
        });
    }

    @Test
    public void stringIsEmpty() {
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(""));
        assertTrue(StringUtil.isEmpty("   "));
        assertTrue(StringUtil.isEmpty(" "));
        assertFalse(StringUtil.isEmpty(" s "));
        assertFalse(StringUtil.isEmpty("12"));
        assertFalse(StringUtil.isEmpty("as"));
        //CoreMatchers.is(false);
        //assertThat(false, );
    }
}