<h2><a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">17. Letter Combinations of a Phone Number</a></h2><h3>Medium</h3><hr><p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png" style="width: 300px; height: 243px;" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;23&quot;
<strong>Output:</strong> [&quot;ad&quot;,&quot;ae&quot;,&quot;af&quot;,&quot;bd&quot;,&quot;be&quot;,&quot;bf&quot;,&quot;cd&quot;,&quot;ce&quot;,&quot;cf&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;2&quot;
<strong>Output:</strong> [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 4</code></li>
	<li><code>digits[i]</code> is a digit in the range <code>[&#39;2&#39;, &#39;9&#39;]</code>.</li>
</ul>


# LeetCode 131: Palindrome Partitioning

You are stepping into a slightly higher weight class now. This problem combines the N-ary `for`-loop backtracking pattern you just mastered with dynamic string parsing.

Amateurs will try to generate *every single possible partition* first, and then run a loop at the very end to check if all the pieces are palindromes. Do not do this. It creates a catastrophic $O(2^N)$ explosion of garbage string arrays.

The strict invariant of this problem is **Aggressive Pruning via Lookahead**: You only ever slice a string and branch down the recursive tree if you can mathematically prove the current slice is already a palindrome.

Here are your definitive, production-grade notes.

---

## Pattern Trigger: Substring Partitioning

* **The explicit question:** Cut a string into pieces such that every single piece satisfies a specific condition (in this case, being a palindrome).
* **The Invariant:** You are not picking individual characters to form combinations. You are dropping "dividers" into the string. At the `start` index, you loop an `end` pointer forward. If the chunk between `start` and `end` is a palindrome, you slice it, add it to your path, and recursively ask the function to partition the remainder of the string starting at `end + 1`.
* **The Strategy:** Write a brutally efficient, two-pointer `isPalindrome(String s, int left, int right)` helper function. Never use `StringBuilder.reverse().equals()`—it wastes memory allocating new strings just to read them backward. Use the standard `for`-loop backtracking architecture. Base Case: If your `start` index reaches the end of the string, it means your dividers successfully chopped up the entire string into valid palindromes.

---

## The Blueprint (Optimal FAANG Code)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPath, List<List<String>> result) {
        // Base Case: Our slicing index has perfectly reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // Loop the 'end' pointer forward to try different sized chunks
        for (int end = start; end < s.length(); end++) {
            
            // PRUNING: Only branch if the current chunk is a valid palindrome
            if (isPalindrome(s, start, end)) {
                
                // 1. Mutate State: Extract the valid palindrome chunk
                // Note: substring in Java is (inclusive, exclusive), so we use end + 1
                currentPath.add(s.substring(start, end + 1));
                
                // 2. Recursive Dive: Ask the function to partition everything AFTER this chunk
                backtrack(s, end + 1, currentPath, result);
                
                // 3. Undo State: Remove the chunk so the loop can try a wider slice
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    // O(N) Two-Pointer Palindrome Check. Zero memory allocation.
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

```

---

## Complexity Analysis

* **Time Complexity:** $O(N \cdot 2^N)$. In the absolute worst-case scenario (a string of identical characters like "aaaaa"), every single prefix is a palindrome, meaning the tree splits into $2^{N-1}$ branches. For every valid partition, it takes $O(N)$ time to physically copy the substrings into the `currentPath` and run the palindrome checks.
* **Auxiliary Space Complexity:** strictly $O(N)$. The recursion call stack will go a maximum of $N$ frames deep.

---

## Core Failure Points to Avoid

* **Extracting strings too early:** A common amateur mistake is writing `String chunk = s.substring(start, end + 1);` before the `isPalindrome` check. That forces the JVM to allocate a new String object in memory for every single loop iteration, even the invalid ones. By passing `start` and `end` as raw integers into `isPalindrome`, we only execute `s.substring()` when we absolutely know we are keeping the data.

---

Stop trying to map the substring slices in your head. Step through this tool. Watch how the loop attempts to stretch the `end` pointer to create wider chunks, and watch how the `isPalindrome` check instantly ruthlessly murders any branch that attempts to form an invalid slice.
