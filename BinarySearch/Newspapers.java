package BinarySearch;

/* This is a variation of Leetcode 410 - Split Array Largest Sum
You've begun your new job to organize newspapers. Each morning, you are to separate the newspapers into smaller piles and assign each pile to a co-worker. This way, your co-workers can read through the newspapers and examine their contents simultaneously.

Each newspaper is marked with a read time to finish all its contents. A worker can read one newspaper at a time, and, when they finish one, they can start reading the next. Your goal is to minimize the amount of time needed for your co-workers to finish all newspapers. Additionally, the newspapers came in a particular order, and you must not disarrange the original ordering when distributing the newspapers. In other words, you cannot pick and choose newspapers randomly from the whole pile to assign to a co-worker, but rather you must take a subsection of consecutive newspapers from the whole pile.

What is the minimum amount of time it would take to have your coworkers go through all the newspapers? That is, if you optimize the distribution of newspapers, what is the longest reading time among all piles?
Constraints

1 <= newspapers_read_times.length <= 10^5

1 <= newspapers_read_times[i] <= 10^5

1 <= num_coworkers <= 10^5
Examples
Example 1:
Input: newspapers_read_times = [7,2,5,10,8], num_coworkers = 2
Output: 18
Explanation:

Assign first 3 newspapers to one coworker then assign the rest to another. The time it takes for the first 3 newspapers is 7 + 2 + 5 = 14 and for the last 2 is 10 + 8 = 18.
Example 2:
Input: newspapers_read_times = [2,3,5,7], num_coworkers = 3
Output: 7
Explanation:

Assign [2, 3], [5], and [7] separately to workers. The minimum time is 7.
 */
public class Newspapers {
    private static boolean canFinish(int[] newspaperReadTimes, int coworkers, int limit) {
        int currentTime = 0; // time taken by current worker
        int requiredWorkers = 1; // worker pool

        for (int readTime : newspaperReadTimes) {
            if (currentTime + readTime > limit) {

                requiredWorkers++; // need one more worker
                currentTime = readTime; // assign current newspaper to new worker
                if (requiredWorkers > coworkers)
                    return false; // not feasible
            } else {
                currentTime += readTime; // assign newspaper to current worker
            }

        }
        return true; // feasible within the limit
    }

    public static int minTimeToRead(int[] times, int coworkers) {
        int left = 0;
        int right = 0;
        int result = -1;

        for (int time : times) {
            left = Math.max(left, time); // max single newspaper time
            right += time; // sum of all newspaper times
        }

        while (left <= right) {
            int mid = left + (right - left) / 2; // potential answer

            if (canFinish(times, coworkers, mid)) {
                result = mid; // update result
                right = mid - 1; // try for a smaller max time
            } else {
                left = mid + 1; // increase max time
            }
        }

        return result;
    }

}
