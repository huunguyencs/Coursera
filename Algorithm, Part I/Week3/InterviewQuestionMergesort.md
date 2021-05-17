# Interview Questions: Mergesort

1. **Merging with smaller auxiliary array.** Suppose that the subarray a[0] to a[n-1] is sorted and the subarray a[n] to a[2n-1] is sorted. How can you merge the two subarrays so that a[0] to a[2n-1] is sorted using an auxiliary array of length n (instead of 2n)?

   **Hints:** Copy only the left half into the auxiliary array.

2. **Counting inversions.** An _invesion_ in an array a[] is a pair of entries a[i] and a[j] such that i < j but a[i] > a[j]. Given an array, design a linearithmic algorithm to count the number of inversions.

   **Hints:** count while mergesorting

3. **Shuffling a linked list.** Given a signly-linked list containing n items, rearrange the items uniformly at random. Your algorithm should consume a logarithm (or constant) amount of extra memory and run in time proportional to nlogn in the worst case.

   **Hint:** Design a linear-time subroutine that can take two uniformly shuffled linked lists of size n<sub>1</sub> and n<sub>2</sub> and combined them into a uniformly shuffled linked lists of size n<sub>1</sub> + n<sub>2</sub>
