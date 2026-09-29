package com.example.sqatesting.model;

public class QuadraticResult {

    private final String status;
    private final Double root1;
    private final Double root2;

    public QuadraticResult(String status, Double root1, Double root2) {
        this.status = status;
        this.root1 = root1;
        this.root2 = root2;
    }

    public String getStatus() {
        return status;
    }

    public Double getRoot1() {
        return root1;
    }

    public Double getRoot2() {
        return root2;
    }
}
