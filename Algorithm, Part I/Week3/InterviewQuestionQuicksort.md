# Interview Questions: Quicksort (ungraded)

1. **Nuts and bolts.** A disorganized carpenter has a mixed pile if b nuts and n bolts. The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolt directly). Design an algorithm for the problem that uses at most proportional to `nlogn` compares (probabilistically).

   **Hints:** modify the quicksort partitioning part of quicksort.

   Remark: This [research paper](http://web.cs.ucla.edu/~rafail/PUBLIC/17.pdf) gives an algorithm that runs in nlog<sup>4</sup>n time in the worst case.

2. **Selection in two sorted arrays.** Given two sorted arrays a[] and b[], of lengths n<sub>1</sub> and n<sub>2</sub> and an integer 0 <= k < n<sub>1</sub> + n<sub>2</sub>, design an algorithm to find a key of rank k. The order of growth of the worst case running time of your algorithm should be logn, where n = n<sub>1</sub> + n<sub>2</sub>.

   - Version 1: n<sub>1</sub> = n<sub>2</sub> (equal length arrays) and k = n/2 (median).
   - Version 2: k = n/2 (median).
   - Version 3: no restrictions.

   **Hints:** there are two basic approaches.

   - Approach A: Compute the median in a[] and the median in b[]. Recur in a subproblem of roughly half the size.
   - Approach B: Design a constant-time algorithm to determine whether a[i] is a key of rank k. Use this subroutine and binary search.

3. **Decimal dominants.** Given an array with n keys, design an algorithm to find all values that occur more than n/10 times. The expected running time of your algorithm should be linear.

   **Hints:** determine the (n/10)<sup>th</sup> largest key using quickselect and check if it occurs more than n/10 times.

   _Alternate solution hint_: use 9 counters.
