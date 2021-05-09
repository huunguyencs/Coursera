# Interview Questions: Elementary Sorts

1. **Intersection of two sets.** Given two arrays _a[]_ and _b[]_, each containing _n_ distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array _a[]_ and array _b[]_.

   **Hint:** shellsort (or any other subquadratic sort).

2. **Permutation.** Given two integer arrays of size _n_, design a subquadratic algorithm to determine whether one is a permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.

   **Hint:** sort both arrays.

3. **Dutch national flag.** Given an array of _n_ buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:

   - _swap(i, j)_: swap the pebble in bucket _i_ with the pebble in bucket _j_.
   - _color(i)_: determine the color of the pebble in bucket _i_.

   The performance requirements are as follows:

   - At most _n_ calls to _color()_.
   - At most _n_ calls to _swap()_.
   - Constant extra space.

   **Hint:** 3-way partitioning.
