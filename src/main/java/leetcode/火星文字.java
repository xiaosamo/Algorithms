package leetcode;

import 基础练习.Stack;

import java.util.*;

/**
 * @author yuan
 * @date 2019/12/14
 * @description
 */
public class 火星文字 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        if (words.length == 1) {
            return words[0];
        }

        // 构建有向图，使用邻接链表
        Map<Character, List<Character>> adjList = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            // 两两比较字符串
            String w1 = words[i], w2 = words[i + 1];
            int n1 = w1.length(), n2 = w2.length();

            boolean found = false; // 是否找到两个不同的字符
            for (int j = 0; j < Math.max(n1, n2); j++) {

                Character c1 = j < n1 ? w1.charAt(j) : null;
                Character c2 = j < n2 ? w2.charAt(j) : null;
                // 对每个出现的字母都创建一个顶点
                if (c1 != null && !adjList.containsKey(c1)) {
                    adjList.put(c1, new ArrayList<>());
                }

                if (c2 != null && !adjList.containsKey(c2)) {
                    adjList.put(c2, new ArrayList<>());
                }

                // 如果发现两个字母不同，就链接两个顶点
                if (c1 != null && c2 != null && !c1.equals(c2) && !found) {
                    adjList.get(c1).add(c2);
                    found = true;
                }
            }
        }

        // 接着进行拓扑排序
        Set<Character> visited = new HashSet<>();
        Set<Character> loop = new HashSet<>(); // 记录是否有环
        Stack<Character> stack = new Stack<>(); // 记录顶点访问的顺序
        for (Character key : adjList.keySet()) {
            if (!visited.contains(key)) {
                if (!topologicalSort(adjList, key, visited, loop, stack)) {
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 这里使用DFS进行拓扑排序
     * @param adjList
     * @param u
     * @param visited
     * @param loop
     * @param stack
     * @return
     */
    private boolean topologicalSort(Map<Character, List<Character>> adjList, char u, Set<Character> visited, Set<Character> loop, Stack<Character> stack) {
        visited.add(u);
        loop.add(u);

        if (adjList.containsKey(u)) {
            for (int i = 0; i < adjList.get(u).size(); i++) {
                char v = adjList.get(u).get(i);

                // 如果loop包含v，说明v被访问过，有环
                if (loop.contains(v)) {
                    return false;
                }

                if (!visited.contains(v)) {
                    // 如果v还没访问过，继续访问v
                    if (!topologicalSort(adjList, v, visited, loop, stack)) {
                        return false;
                    }
                }
            }
        }

        loop.remove(u);
        stack.push(u);
        return true;
    }

    public static void main(String[] args) {
        火星文字 obj = new 火星文字();
        System.out.println(obj.alienOrder(new String[]{"wrt", "wft", "er", "ett", "rftt"}));
        System.out.println(obj.alienOrder(new String[]{"z", "x", "z"}));
        System.out.println(obj.alienOrder(new String[]{"z", "x"}));
    }

}
