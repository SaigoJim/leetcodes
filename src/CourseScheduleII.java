import edu.princeton.cs.algs4.Stack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
public class CourseScheduleII {
    boolean isCyclic;
    int[] result;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < numCourses; i += 1) {
            List<Integer> list = new ArrayList<>();
            adjs.add(list);
        }
        for (int[] arr : prerequisites) {
            adjs.get(arr[1]).add(arr[0]);
        }
        index = numCourses - 1;
        result = new int[numCourses];
        reversePostOrder(adjs);
        return result;
    }

    private void reversePostOrder(List<List<Integer>> adjs) {
        int[] marked = new int[adjs.size()];
        for (int i = 0; i < adjs.size(); i += 1) {
            if (marked[i] == 0) {
                dfs(i, adjs, marked);
            }
            if (isCyclic) {
                result = new int[0];
                return;
            }
        }
    }

    private void dfs(int i, List<List<Integer>> adjs, int[] marked) {
        marked[i] = 1;
        for (int neighbor : adjs.get(i)) {
            if (marked[neighbor] == 0) {
                dfs(neighbor, adjs, marked);
            } else if (marked[neighbor] == -1) {
                continue;
            } else if (marked[neighbor] == 1) {
                isCyclic = true;
                return;
            }
        }
        if (isCyclic) {
            return;
        }
        result[index] = i;
        index -= 1;
        marked[i] = -1;
    }
    @Test
    public void testFindOredr() {
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{new int[]{1, 0}};
        int[] result1 = findOrder(numCourses1, prerequisites1);

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        int[] result2 = findOrder(numCourses2, prerequisites2);

        int numCourses3 = 4;
        int[][] prerequisites3 = new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}};
        int[] result3 = findOrder(numCourses3, prerequisites3);
    }
    @Test
    public void testFindOredrX() {
        int numCourses3 = 4;
        int[][] prerequisites3 = new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}};
        int[] result3 = findOrder(numCourses3, prerequisites3);
    }
}
