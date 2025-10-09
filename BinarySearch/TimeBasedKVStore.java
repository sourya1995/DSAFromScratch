package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Leetcode 981 - Time based K-V store
 * 
 * Ah! Now we’re getting into the **“why binary search”** part, and it’s actually super neat once you see it visually. Let’s break it down **like you’re new to this**.

---

## 1️⃣ What problem are we solving?

We have a **list of timestamp-value pairs** for a key:

```
histories[key] = [[10,"high"], [20,"low"], [30,"medium"], ...]
```

We want, given some `targetTimestamp`, the **largest timestamp ≤ targetTimestamp**.

Naive way:

* Loop from start to end, check each timestamp → O(n)

Better way:

* Use **binary search** → O(log n)

---

## 2️⃣ Why binary search works: **the monotonic function**

Think about this function:

```
f(i) = histories[key][i].timestamp <= targetTimestamp
```

* `i` = index in the list
* `f(i)` = true if the timestamp at index i is ≤ target
* `f(i)` = false if timestamp > target

---

### Monotonic property:

* Once `f(i)` becomes **false**, it **stays false for all later indices** because timestamps are sorted in ascending order.
* Once `f(i)` is **true**, it might still be true for some larger indices until it eventually becomes false.

✅ This is exactly a **monotonic (non-decreasing) function in boolean sense**:

```
true, true, true, ..., true, false, false, false
```

---

### 3️⃣ Why binary search is perfect

Binary search works when we have a **monotonic property** — something that is:

```
all true → then all false
```

or

```
all false → then all true
```

Here:

```
f(i) = histories[key][i].timestamp <= target
```

* left side → true (timestamps ≤ target)
* right side → false (timestamps > target)

We want the **last true** (rightmost timestamp ≤ target).
Binary search can **zoom in fast** instead of checking every element.

---

### 4️⃣ Visual timeline analogy

```
timestamps: 10  20  30  40  50
target = 35

f(i) = timestamp <= 35 ?

i=0 → 10 <= 35 ✅
i=1 → 20 <= 35 ✅
i=2 → 30 <= 35 ✅
i=3 → 40 <= 35 ❌
i=4 → 50 <= 35 ❌

Rightmost true = i=2 → timestamp 30
```

* True/False sequence is **monotonic**: `true, true, true, false, false`
* Binary search finds **the transition point** from true → false efficiently → gives the **rightmost true** → exactly the value we want.

---

### 5️⃣ Recap

* **Binary search is used** because the timestamps are sorted.
* **Monotonic function**: `f(i) = timestamp at i ≤ target`.
* **Goal**: find **rightmost index i where f(i) is true**.
* This lets us **get the largest timestamp ≤ target in O(log n)** instead of O(n).

---


 */
public class TimeBasedKVStore {
      private static class Pair{
        int timestamp;
        String value;
        Pair(int t, String v){
            this.timestamp = t;
            this.value = v;
        }
    }

    private Map<String, List<Pair>> histories;

    public TimeBasedKVStore() {
        histories = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        histories.putIfAbsent(key, new ArrayList<>());
        histories.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!histories.containsKey(key)) return "";

        List<Pair> list = histories.get(key);
        int left = 0; int right = list.size() - 1;
        int pos = -1;

        while(left <= right){
            int mid = (left + right)/2;
            if(list.get(mid).timestamp <= timestamp){
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (pos == -1 ) ? "" : list.get(pos).value;
    }
}
