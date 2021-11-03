package com.r.allende.javatests.player;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void playerLoosesWhenDiceNumberIsGreaterThanMin() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);
        Player player = new Player(dice, 3);
        assertEquals(false, player.play());
    }

    @Test
    public void playerWinsWhenDiceNumberIsGreaterThanMIn() {

    }
}