package com.example.sqatesting.service;

import com.example.sqatesting.model.QuadraticResult;
import org.springframework.stereotype.Service;

@Service
public class QuadraticService {

    public QuadraticResult solve(double a, double b, double c) {
        if (a == 0) {
            return new QuadraticResult("Not Quadratic Equation", null, null);
        }

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double root1 = (-b + sqrtDiscriminant) / (2 * a);
            double root2 = (-b - sqrtDiscriminant) / (2 * a);
            return new QuadraticResult("Two Real Roots", root1, root2);
        }

        if (discriminant == 0) {
            double root = -b / (2 * a);
            return new QuadraticResult("One Real Root", root, null);
        }

        return new QuadraticResult("No Real Root", null, null);
    }
}
