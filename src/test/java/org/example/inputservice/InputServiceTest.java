package org.example.inputservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    public void setUpOutput() {
        testIn = new ByteArrayInputStream("5\n10\n20\n".getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }
    @Test
    @DisplayName("test if the inputservice object is getting intialzied")
    void testIfInputServiceIsGettingInitialized() {
        assertDoesNotThrow(InputService::new);
    }

    @Test
    @DisplayName("test initial values with all the valid inputs")
    void testInitialValuesWithValidInput() {
        InputService inputService = new InputService();
        List<Integer> values = inputService.initialValues();

        assertEquals(3, values.size());
        assertEquals(5, values.get(0));
        assertEquals(10, values.get(1));
        assertEquals(20, values.get(2));
    }

    @Test
    @DisplayName("test initial values with negative values")
    void testInitialValuesWithInvalidInput() {
        testIn = new ByteArrayInputStream("-1\n-1\n-1\n".getBytes());
        System.setIn(testIn);

        InputService inputService = new InputService();

        assertThrows(IllegalArgumentException.class, inputService::initialValues);
    }
}