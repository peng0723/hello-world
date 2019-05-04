package com.daydayup;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Graph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        //adj[t].add(s);    //注释掉此行，变有向图
    }

    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
        System.out.println();
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    public void dfsAll(int s, int t) {  //改造深度搜索算法，列出所有路径
        //found = false;
        //boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfsAll(s,s, t,prev);
        //print(prev, s, t);
        System.out.println();
    }

    private void recurDfsAll(int s, int w, int t, int[] prev) {//改造深度搜索算法，列出所有路径
        //if (found) return;
        //visited[w] = true;
        if (w == t) {
            //found = true;
            //return;
            print(prev, s, t);
            System.out.println();
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            //if (!visited[q]) {
                prev[q] = w;
                recurDfsAll(s, q, t, prev);
            //}
        }
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public void bfsAll(int s, int t) {//改造广度搜索算法
        if (s == t) return;
        //boolean[] visited = new boolean[v];
        //visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        LinkedList<Integer>[] prev = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = new LinkedList<>();
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                //if (!visited[q]) {

                    prev[q].add(w);
                    if (q == t) {
                        printAll(prev, s, t,list);
                        System.out.println();
                        //return;
                    }
                    //visited[q] = true;
                    queue.add(q);
                //}
            }
        }
    }

    //参考二叉树所有路径遍历算法，https://blog.csdn.net/dongqifan/article/details/35666035
    private void printAll(LinkedList<Integer>[] prev, int s, int t, LinkedList<Integer> list) {
        list.add(t);
        if(t==s){
            printList(list);
            list.removeLast();
            return;
        }
        for(int i=0; i<prev[t].size(); ++i){
            printAll(prev, s, prev[t].get(i), list);
        }
        list.removeLast();
    }

    private void printList(LinkedList<Integer> list) {
        //LinkedList<Interger> dest = list.clone();
        //Collections.reverse(dest);
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,3);

        g.addEdge(1,2);
        g.addEdge(1,4);

        g.addEdge(3,4);

        g.addEdge(2,5);

        g.addEdge(4,5);
        g.addEdge(4,6);

        g.addEdge(5,7);
        g.addEdge(6,7);

        //g.dfs(0,6);
        //g.bfs(0,6);
        g.bfsAll(0,6);
        //g.dfsAll(0,6);

    }

}
