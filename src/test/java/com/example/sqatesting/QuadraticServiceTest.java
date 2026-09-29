package com.example.sqatesting;

import com.example.sqatesting.model.QuadraticResult;
import com.example.sqatesting.service.QuadraticService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class QuadraticServiceTest {

    private static final double TOLERANCE = 1.0e-9;

    private final QuadraticService quadraticService = new QuadraticService();

    @Test
    void returnsNotQuadraticWhenLeadingCoefficientIsZero() {
        QuadraticResult result = quadraticService.solve(0, 2, 1);

        assertEquals("Not Quadratic Equation", result.getStatus());
        assertNull(result.getRoot1());
        assertNull(result.getRoot2());
    }

    @Test
    void returnsBothRootsWhenDiscriminantIsPositive() {
        QuadraticResult result = quadraticService.solve(1, -3, 2);

        assertEquals("Two Real Roots", result.getStatus());
        assertEquals(2.0, result.getRoot1(), TOLERANCE);
        assertEquals(1.0, result.getRoot2(), TOLERANCE);
    }

    @Test
    void returnsOneRootWhenDiscriminantIsZero() {
        QuadraticResult result = quadraticService.solve(1, 2, 1);

        assertEquals("One Real Root", result.getStatus());
        assertEquals(-1.0, result.getRoot1(), TOLERANCE);
        assertNull(result.getRoot2());
    }

    @Test
    void returnsNoRealRootsWhenDiscriminantIsNegative() {
        QuadraticResult result = quadraticService.solve(1, 0, 1);

        assertEquals("No Real Root", result.getStatus());
        assertNull(result.getRoot1());
        assertNull(result.getRoot2());
    }
}
