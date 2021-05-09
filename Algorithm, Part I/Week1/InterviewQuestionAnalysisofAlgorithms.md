# Interview Questions: Analysis of Algorithms

1. **3-SUM in quadratic time.** Design an algorithm for the 3-SUM problem that takes time proportional to n<sup>2</sup> in the worst case. You may assume that you can sort the nn integers in time proportional to n<sup>2</sup>or better.

   **Hints**: given an integer **x** and a sorted array **a**[] of n distinct integers, design a linear-time algorithm to determine if there exists two distinct indices **i** and **j** such that **a[i]** + **a[j]** == **x**

2. **Search in a bitonic array.** An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of nn distinct integer values, determines whether a given integer is in the array.

   - Standard version: Use ~ 3lg(n) compares in the worst case.
   - Signing bonus: Use ~ 2lg(n) compares in the worst case (and prove that no algorithm can guarantee to perform fewer than ~ 2lg(n) compares in the worst case).

   **Hints**: Standard version. First, find the maximum integer using ~1lgn compares - this divides the array into the increasing and decreasing pieces.

   Signing bonus. Do it without finding the maximum integer.

3. **Egg drop.** Suppose that you have an n-story building (with floors 1 through nn) and plenty of eggs. An egg breaks if it is dropped from floor T or higher and does not break otherwise. Your goal is to devise a strategy to determine the value of T given the following limitations on the number of eggs and tosses:

   - Version 0: 1 egg, <= T tosses.
   - Version 1: ~ 1lg(n) eggs and ~ 1lg(n) tosses.
   - Version 2: ~ lg(T) eggs and ~ 2lg(T) tosses.
   - Version 3: 2 eggs and ~ 2sqrt(n) tosses.
   - Version 4: 2 eggs and <= c.sqrt(T) tosses for some fixed constant c.

   **Hints**:

   - Version 0: sequential search.
   - Version 1: binary search.
   - Version 2: find an interval containing T of size <= 2T, the do binary search.
   - Version 3: find an interval of size sqrt(n), then do sequential search. Note: can be improved to ~sqrt(2n) tosses.
   - Version 4: 1 + 2 + 3 + ... + t ~ (1/2)\*t<sup>2</sup>. Aim for c = 2sqrt(2)
