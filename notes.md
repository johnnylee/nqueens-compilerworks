# Notes

## Naive

The most naive method would involve itterating over each possible configuration
and testing it for validity. There may be some benefit to this approach in that
it's probably easy to partition the search space and distribute the work over
multiple processors. The total number of configurations would be N^2 choose N,
I think. I didn't explore this approach further.

## One column per row

The first simplification that came to mind was to store a candidate solution as
a 1D array of column positions, one for each row of the board. The simplest
form of an algorithm would iterate over the solution space, checking each for
candidate solution for validity.

### Pruning

To speed up processing, we can prune incomplete solutions to avoid a large
number of candidates. For example no solution can have queens in the same
column.

In order to be able to prune solutions, we can construct solutions by starting
in the first row, then placing a queen in a valid column in the second row and
so on. In that case we only need to ensure that the column placement is
consistent given the previous rows.

### Validity Matrix

In order to avoid having to find all the diagonals defined by queen placements
in the previous rows, I decided to construct a validitiy matrix in parallel
with the candidate solution. The validity matrix can be updated whenever a
queen is added or removed without much difficulty. When placing queens on
subsequent rows, we consult the validity matrix to find possible legal columns.

An additional benefit of this approach is that it's easy to write tests for
incomplete candidate solutions and see where the algorithm is going wrong.

Down-sides include additional memory usage if the problem size is large, as
well as un-necessary computation if back-tracking occurs before much of the
validity matrix is utilized.

### References to valid diagonals

Another option I considered but didn't explore was constructing all valid
diagonals up front. The idea is to construct the board as an integer matrix
with 1s where queens have been placed, and then construct a 1D array for every
valid diagonal of pointers to the integers in the board matrix.

For each (row, column) combination we could store a list of diagonals that
include the space and easily check for a conflict.

It could be interesting to look into the space and performance characteristics
of this type of solution.

## Evolutionary

There are ways to solve the problem using evolutionary models, though I didn't
explore this avenue. For large N, this seems like an interesting approach
because it can be easily scaled to multiple processors / machines.

## 1D array

It seems possible to use a 1D array and represent diangonals in terms of valid
step sizes. For example for a 16x16 board, a step size of 16 corresponds to a
column, a step size of 15 or 17 to the two diagonals. For step sizes of 14 or
18 we get the slope 1/2 diagonals and so on.

I only explored this on paper, but it seems like a promising approach.
