# Interview Questions: Elementary Symbol Tables

1. **Java autoboxing and equals().** Consider two **double** values **a** and **b** and their corresponding **Double** values **x** and **y**.

   - Find values such that (a == b) is **true** but x.equals(y) is false.

   - Find values such that (a == b) is **false** but x.equals(y) is true.

   **Hints:** IEEE floating point arithmetic has some peculiar for 0.0, -0.0, and NaN. Java requires that equals() implements an equivalence relation.

2. **Check if a binary tree is a BST.** Given a binary tree where each Node contains a key, determine whether it is a binary search tree. Use extra space proportional to the height of the tree.

   **Hints:** design a recursive isBST(Node x, Key min, Key max) that determines whether x is the root of a binary search tree with all keys between min and max.

3. **Inorder traversal with constant extra space.** Design an algorithm to perform an inorder traversal of a binary search tree using only a constant amount of extra space.

   **Hints:** you may modify the BST during the traversal provided you restore it upon completion

4. **Web tracking.** Suppose that you are tracking _n_ web sites and _m_ users and you want to support the following API:

   - User visits a website.

   - How many times has a given user visited a given site?

   What data structure or data structures would you use?

   **Hints:** maintain a symbol table of symbol tables.
