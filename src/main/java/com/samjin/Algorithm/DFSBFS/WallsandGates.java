/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) return;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                // 如果遇到一个门，从门开始广度优先搜索，标记连通的节点到自己的距离
                if(rooms[i][j] == 0) bfs(rooms, i, j);
            }
        }
    }
    
    public void bfs(int[][] rooms, int i, int j){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * rooms[0].length + j);
        int dist = 0;
        // 用一个集合记录已经访问过的点
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(i * rooms[0].length + j);
        while(!queue.isEmpty()){
            int size = queue.size();
            // 记录深度的搜索
            for(int k = 0; k < size; k++){
                Integer curr = queue.poll();
                int row = curr / rooms[0].length;
                int col = curr % rooms[0].length;
                // 选取之前标记的值和当前的距离的较小值
                rooms[row][col] = Math.min(rooms[row][col], dist);
                int up = (row - 1) * rooms[0].length + col;
                int down = (row + 1) * rooms[0].length + col;
                int left = row * rooms[0].length + col - 1;
                int right = row * rooms[0].length + col + 1;
                if(row > 0 && rooms[row - 1][col] > 0 && !visited.contains(up)){
                    queue.offer(up);
                    visited.add(up);
                }
                if(col > 0 && rooms[row][col - 1] > 0 && !visited.contains(left)){
                    queue.offer(left);
                    visited.add(left);
                }
                if(row < rooms.length - 1 && rooms[row + 1][col] > 0 && !visited.contains(down)){
                    queue.offer(down);
                    visited.add(down);
                }
                if(col < rooms[0].length - 1 && rooms[row][col + 1] > 0 && !visited.contains(right)){
                    queue.offer(right);
                    visited.add(right);
                }
            }
            dist++;
        }
    }
}
