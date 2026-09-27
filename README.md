# DSA Solutions
# 🚀 DSA Solutions (Java)

This repository contains my solutions to Data Structures and Algorithms problems from [LeetCode](https://leetcode.com/) and [GeeksforGeeks](https://www.geeksforgeeks.org/).

## 📂 Repository Structure
The project is structured by platform and topic to keep things organized:

* `src/main/java/leetcode/` - Solutions to LeetCode problems (e.g., arrays, trees, dp).
* `src/main/java/gfg/` - Solutions to GeeksforGeeks problems.

## 💡 Design Pattern
To prevent class name clashes (like multiple `TreeNode` or `Trie` classes) and to ensure local code can be copy-pasted directly into the browser editor, all helper classes are implemented as **static nested classes** inside the main problem class.

Example: java
```
public class LC0208_ImplementTrie {
    static class TrieNode {
        // ...
    }
}
```
## 🛠️ Tech Stack
* **Language:** Java
* **IDE:** IntelliJ IDEA