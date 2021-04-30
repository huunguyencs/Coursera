## Explain the code:

- Percolation.java

  - We will use 2 more elements of UF, one is virtual top, one for virtual. Virtual top will connect to all elements at top row and virtual bottom will connect to all elements at bottom row. If it percolate, virtual top will connect to virtual bottom.

  - Because virtual bottom connect to all elements at bottom row, when it percolate, all sites at bottom row will connect to top row (connect to virtual top). Actually, it isn't sure that, and to removed this problem, we will use more UF array without virtual bottom to determined isFull of each site.
