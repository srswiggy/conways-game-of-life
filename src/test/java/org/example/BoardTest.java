package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    @DisplayName("Test if the board is getting created successfully")
    void testIfBoardGetsCreatedWithMN() {
        assertDoesNotThrow(()-> new Board(2, 3, 20));
    }

    @Test
    @DisplayName("Test if the board creation throws error on negative values")
    void testIfBoardGetsThrowsExceptionWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, ()-> new Board(-2, -5, -20));
    }

    @Test
    @DisplayName("Test if the board creation throws error on 0")
    void testIfBoardGetsThrowsExceptionWith0() {
        assertThrows(IllegalArgumentException.class, ()-> new Board(0, 0, 0));
    }


}