# Interview Questions: Priority Queues

1. **Dynamic median.** Design a data type that supports _insert_ in logarithmic time, _find-the-median_ in constant time, and _remove-the-median_ in logarithmic time. If the number of keys in the data type is even,find/remove the _lower median_.

   **Hints:** maintain two binary heaps, one that is max-oriented and one that is min-oriented.

2. **Randomized priority queue.** Describe how to add the methods **sample()** and **delRandom()** to our binary heap implementation. The two methods return a key that is chosen uniformly at random among the remaining keys, with the latter method also removing that key. The **sample()** method should take constant time; the **delRandom()** method should take logarithmic time. Do not worry about resizing the underlying array.

   **Hints:** use **sink()** and **swim()**

3. **Taxicab numbers.** A _taxicab_ number is an integer that can be expressed as the sum of two cubes of positive integers in two different ways: _a<sup>3</sup> + b<sup>3</sup> = c<sup>3</sup> + d<sup>3</sup>_. For example, **1729** is the smallest taxicab number: 9<sup>3</sup> + 10<sup>3</sup> = 1<sup>3</sup> + 12<sup>3</sup>. Design an algorithm to find all taxicab number with _a_, _b_, _c_ and _d_ less than n.

   - Version 1: Use time proportional to n<sup>2</sup>log _n_ and space proportional to n<sup>2</sup>.

   - Version 2: Use time proportional to n<sup>2</sup>log _n_ and space proportional to n.

   **Hints:**

   - Version 1: Form the sums a<sup>3</sup> + b<sup>3</sup> and sort.

   - Version 2: Use a min-oriented priority queue with n items.
