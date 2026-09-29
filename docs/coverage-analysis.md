# Quadratic Solver Coverage Analysis

## Scope and counting rules

Coverage is analyzed for the body of `QuadraticService.solve(double a, double b, double c)` only, not the controller, model, framework code, or test code. The method has three decision statements: `a == 0`, `discriminant > 0`, and `discriminant == 0`.

For statement coverage, count each source-level executable statement in the method body, including each `if` control statement and each return, declaration, and assignment. Do not count the signature, braces, comments, or blank lines. With that convention the denominator is 12:

1. `if (a == 0)`
2. The non-quadratic return
3. Discriminant declaration and calculation
4. `if (discriminant > 0)`
5. Square-root declaration and calculation
6. First-root declaration and calculation
7. Second-root declaration and calculation
8. The two-real-roots return
9. `if (discriminant == 0)`
10. Repeated-root declaration and calculation
11. The one-real-root return
12. The no-real-root return

For branch coverage, count the two outcomes (true and false) of each binary decision. The denominator is therefore `3 decisions × 2 outcomes = 6 branches`.

## Statement coverage

| Test | Statements exercised |
|---|---|
| TC1 (`a == 0`) | 1, 2 |
| TC2 (`D > 0`) | 1, 3, 4, 5, 6, 7, 8 |
| TC3 (`D == 0`) | 1, 3, 4, 9, 10, 11 |
| TC4 (`D < 0`) | 1, 3, 4, 9, 12 |

Together TC1–TC4 execute all 12 of the 12 counted statements: **statement coverage = 12/12 = 100%**.

## Branch coverage

| Decision | True outcome covered by | False outcome covered by |
|---|---|---|
| `a == 0` | TC1 | TC2, TC3, TC4 |
| `D > 0` | TC2 | TC3, TC4 |
| `D == 0` | TC3 | TC4 |

All six outcomes are exercised: **branch coverage = 6/6 = 100%**.

## Conclusion

The four test cases correspond to the method's four independent paths (`V(G) = 4`) and provide complete statement and branch coverage under the counting conventions stated above. Numerical roots are asserted with a tolerance rather than exact floating-point equality.
