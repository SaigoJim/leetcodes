import edu.princeton.cs.algs4.Stack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < numCourses; i += 1) {
            List<Integer> list = new ArrayList<>();
            adjs.add(list);
        }
        for (int[] arr : prerequisites) {
            adjs.get(arr[1]).add(arr[0]);
        }
        boolean returnVal = isAcyclic(adjs);
        return returnVal;
    }

    private boolean isAcyclic(List<List<Integer>> adjs) {
        int[] marked = new int[adjs.size()];
        for (int i = 0; i < adjs.size(); i += 1) {
            if (marked[i] == 0) {
                if (dfsWithoutRecursion(i, adjs, marked) == false) {
                    return false;
                }
//                if (dfs(i, adjs, marked) == false) {
//                    return false;
//                }
            }
        }
        return true;
    }

    private boolean dfs(int i, List<List<Integer>> adjs, int[] marked) {
        marked[i] = 1;
        for (int neighbor : adjs.get(i)) {
            if (marked[neighbor] == 0) {
                if (dfs(neighbor, adjs, marked) == false) {
                    return false;
                }
            } else if (marked[neighbor] == -1) {
                continue;
            } else if (marked[neighbor] == 1) {
                return false;
            }
        }
        marked[i] = -1;
        return true;
    }
    private boolean dfsWithoutRecursion(int i, List<List<Integer>> adjs, int[] marked) {
        Stack<Integer> fringe = new Stack<>();
        fringe.push(i);
        while (!fringe.isEmpty()) {
            int top = fringe.peek();
            marked[top] = 1;
            boolean isEnd = true;
            for (int neighbor : adjs.get(top)) {
                if (marked[neighbor] == 0) {
                    fringe.push(neighbor);
                    isEnd = false;
                    break;
                } else if (marked[neighbor] == -1) {
                    continue;
                } else if (marked[neighbor] == 1) {
                    // Cyclic, not Acyclic
                    return false;
                }
            }
            if (isEnd) {
                fringe.pop();
                marked[top] = -1;
            }
        }
        return true;
    }

    @Test
    public void testCanFinish() {
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{new int[]{1, 0}};
        assertTrue(canFinish(numCourses1, prerequisites1));

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        assertFalse(canFinish(numCourses2, prerequisites2));
    }
    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int i = stack.pop();
    }
}
