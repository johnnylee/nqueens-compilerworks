# nqueens-compilerworks

I haven't written much Java in the past five years with the exception of some
Android code, so I'm not confident that the code here is idiomatic. The code
takes the form it does for a few reasons. First it was translated from Go, then
refactored into the two classes in order to reproduce tests for the conflict
matrix class.

The tests are somewhat brittle at the moment. Ideally I'd prefer to have a
well-tested general purpose validator and use that to validate both the
intermediate and final results. It would also be useful for experimenting with
different algorithms.

The algorithm itself is pretty straight-forward, and could be stand to be
optimized both algorithmically and in terms of its mechanical sympathy. It
seems to work in a reasonable amount of time for N up to around 30. Beyond that
a different algorithm would be preferable.
