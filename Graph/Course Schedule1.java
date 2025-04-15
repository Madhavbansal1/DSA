import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // Build adjacency list and in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            map.get(prereq).add(course);
            inDegree[course]++;
        }

        // Add courses with no prerequisites (in-degree = 0) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        // Process courses using Kahn's Algorithm
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int nextCourse : map.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // Check if all courses can be completed
        return count == numCourses;
    }
}
