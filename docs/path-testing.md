# Quadratic Solver Path Testing

## Method under test and control flow

The test scope is only `QuadraticService.solve(double a, double b, double c)`. The method checks `a == 0` first and returns immediately if the equation is not quadratic. Otherwise it calculates `D = b*b - 4*a*c`, then selects the positive-discriminant, zero-discriminant, or negative-discriminant result. The order matters: the discriminant is not calculated for `a == 0`.

The control-flow graph is in [`CFG.png`](CFG.png). Its decision nodes are:

| Node | Decision | True edge | False edge |
|---|---|---|---|
| N2 | `a == 0` | N3: return Not Quadratic Equation | N4: calculate D |
| N5 | `D > 0` | N6: calculate two roots and return Two Real Roots | N7: check D == 0 |
| N7 | `D == 0` | N8: calculate one root and return One Real Root | N9: return No Real Root |

Every return node exits the method.

## Cyclomatic complexity

Cyclomatic complexity for this single-entry, single-exit method is calculated using `V(G) = Decision + 1`. There are three binary decisions (`a == 0`, `D > 0`, and `D == 0`), so `V(G) = 3 + 1 = 4`. The four basis paths below correspond to these four independent routes through the method.

## Independent paths

| Path | Node Traversal | Condition | Expected Output |
|---|---|---|---|
| P1 | Start → N2(T) → N3 → Exit | `a == 0` | Not Quadratic Equation; roots null |
| P2 | Start → N2(F) → N4 → N5(T) → N6 → Exit | `a != 0` and `D > 0` | Two Real Roots with both roots calculated |
| P3 | Start → N2(F) → N4 → N5(F) → N7(T) → N8 → Exit | `a != 0` and `D == 0` | One Real Root; second root null |
| P4 | Start → N2(F) → N4 → N5(F) → N7(F) → N9 → Exit | `a != 0` and `D < 0` | No Real Root; roots null |

## Test cases

| TC | Input `(a, b, c)` | Expected Result |
|---|---|---|
| TC1 / P1 | `(0, 2, 1)` | `Not Quadratic Equation`; `root1=null`, `root2=null` |
| TC2 / P2 | `(1, -3, 2)` | `Two Real Roots`; `root1=2`, `root2=1` |
| TC3 / P3 | `(1, 2, 1)` | `One Real Root`; `root1=-1`, `root2=null` |
| TC4 / P4 | `(1, 0, 1)` | `No Real Root`; `root1=null`, `root2=null` |

`QuadraticServiceTest` exercises the service directly. It checks each status, checks numerical roots with an absolute tolerance of `1.0e-9`, and checks null roots explicitly. These four cases traverse all four independent paths.
