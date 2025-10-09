package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/* 
Leetcode 2055 - Plates Between Candles
We’ll use:

```
s = "**|**|***|"
index = 0 1 2 3 4 5 6 7 8 9
candles = [2, 5, 9]
```

---

## 🧭 Query 1: [2, 5]

```
Index:  0 1 2 3 4 5 6 7 8 9
String: * * | * * | * * * |
              ^     ^
              |     |
            left   right
```

### Step-by-step:

| Step                 | Meaning          | Value                          |
| -------------------- | ---------------- | ------------------------------ |
| `leftPos`            | first candle ≥ 2 | candle index 0 (at position 2) |
| `rightPos`           | last candle ≤ 5  | candle index 1 (at position 5) |
| `leftCandle`         | candles.get(0)   | 2                              |
| `rightCandle`        | candles.get(1)   | 5                              |
| `totalDistance`      | 5 - 2            | 3                              |
| `candleCountBetween` | 1 - 0 = 1        | 1                              |
| `plates`             | 3 - 1            | ✅ 2                            |

### Visual breakdown:

```
| → candle at index 2
* → plate at 3
* → plate at 4
| → candle at index 5
```

Between these two candles, we have **2 plates (3, 4)** ✅

---

## 🧭 Query 2: [5, 9]

```
Index:  0 1 2 3 4 5 6 7 8 9
String: * * | * * | * * * |
                    ^     ^
                    |     |
                 left   right
```

### Step-by-step:

| Step                 | Meaning          | Value                          |
| -------------------- | ---------------- | ------------------------------ |
| `leftPos`            | first candle ≥ 5 | candle index 1 (at position 5) |
| `rightPos`           | last candle ≤ 9  | candle index 2 (at position 9) |
| `leftCandle`         | candles.get(1)   | 5                              |
| `rightCandle`        | candles.get(2)   | 9                              |
| `totalDistance`      | 9 - 5            | 4                              |
| `candleCountBetween` | 2 - 1 = 1        | 1                              |
| `plates`             | 4 - 1            | ✅ 3                            |

### Visual breakdown:

```
| → candle at index 5
* → plate at 6
* → plate at 7
* → plate at 8
| → candle at index 9
```

Between these candles, we have **3 plates (6, 7, 8)** ✅

---

## 🎯 Summary Table

| Query | leftCandle | rightCandle | totalDistance | candleCountBetween | Plates |
| ----- | ---------- | ----------- | ------------- | ------------------ | ------ |
| [2,5] | 2          | 5           | 3             | 1                  | 2      |
| [5,9] | 5          | 9           | 4             | 1                  | 3      |

✅ **Final Answer: `[2, 3]`**

---

/* 
 */
public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candles = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|'){
                candles.add(i);
            }
        }

        int[] result = new int[queries.length]; // to store results of each query
        // process each query

        for(int q=0; q < queries.length; q++){
            int qLeft = queries[q][0];
            int qRight = queries[q][1];
            int leftPos = -1;
            int rightPos = -1;

            int left = 0; 
            int right = candles.size() - 1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(candles.get(mid) >= qLeft){
                    leftPos = mid;
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }


            }

            left = 0;
            right = candles.size() - 1;
            while(left <= right){
                int mid = (left + right)/2;
                if(candles.get(mid) <= qRight){
                    rightPos = mid;
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }


            }

            if(leftPos != -1 && rightPos != -1 && rightPos > leftPos){
                int leftCandle = candles.get(leftPos);
                int rightCandle = candles.get(rightPos);
                int totalDistance = rightCandle - leftCandle;
                int candleCountBetween = rightPos - leftPos;
                result[q] = totalDistance - candleCountBetween;
            } else {
                result[q] = 0;
            }
        }

        return result;
    }
}
