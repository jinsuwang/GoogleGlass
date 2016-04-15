/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class GetStepsToDestination {
    
    /*
    一个 2 ＊4 的数组不重复包含1-8这些整数，有3种操作：
    a) 上下两个row交换
    b) 所有元素向右shift一个位置
    c) 中间4个元素，顺时针旋转90度
    现在随便给一个这样的数组，最小恢复到 [[1234], [5678]] 要几步  
    */
    
    public static int getStep( int[][] arr ){
        if(isValid(arr)) return 0;
        Queue<int[][]> queue = new LinkedList<>(); 
        int level = 0;
        queue.offer(arr);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add( encode(arr) );
        
        while( !queue.isEmpty() ){   
            int size = queue.size();
            level++;
            for( int k = 0; k < size; k++ ){
                int[][] curr = queue.poll();
                List<int[][]> nexts = getNext( curr, visited );
                for( int[][] next : nexts ){
                    if( isValid(next) ){
                        return level;
                    }else{
                    queue.offer(next);
                    visited.add(encode(next));
                    }
                }
            }
        }
        return -1;
    }

    private static Integer encode(int[][] arr) {
        int ret = 0;
        for( int i = 0; i < arr.length; i++ ){
            for( int j = 0; j < arr[0].length; j++ ){
                ret = ret * 10 + arr[i][j];
            }
        }
        return ret;
    }

    private static List<int[][]> getNext(int[][] curr, Set<Integer> visited ) {
       List<int[][]> ret = new ArrayList<>();
       // swap row.
       for( int j = 0; j < curr[0].length; j++ ){
           int[][] tmp = deepcopy( curr );
           // swap
           int v = tmp[0][j]; tmp[0][j] = tmp[1][j]; tmp[1][j] = v; 
           if( !visited.contains(encode(tmp ))){
               ret.add(tmp);
               visited.add(encode(tmp ));
           }
       }
//       
        // shift right
        int[][] tmp = deepcopy( curr );
        for( int i = 0; i < curr.length * curr[0].length -1; i++ ){
           int oldRow = i / curr[0].length;
           int oldCol = i % curr[0].length;
           int newRow = (i+1) / curr[0].length;
           int newCol = (i+1) % curr[0].length; 
           tmp[newRow][newCol] = curr[oldRow][oldCol];
        } 
        tmp[0][0] = curr[curr.length-1][curr[0].length-1];
        
        if( !visited.contains( encode( tmp ))){
            visited.add( encode( tmp) );
            ret.add(tmp);
        }
        return ret;
    }
    
    private static int[][] deepcopy( int[][] curr ){
        int[][] ret = new int [curr.length][curr[0].length];
         for( int i = 0; i < curr.length; i++ ){
            for( int j = 0; j < curr[0].length; j++ ){
                ret[i][j] = curr[i][j];
            }
        }
        return ret;
    }
    
    private static boolean isValid( int[][] arr ){
        int[] validation = {1,2,3,4,5,6,7,8};
        for( int i = 0; i < arr.length; i++ ){
            for( int j = 0; j < arr[0].length; j++ ){
                if( arr[i][j] !=  validation[ arr[0].length * i + j ]) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] test = new int[][]{ {1,6,7,4},{5,2,3,8} };
        
        System.out.println(getStep(test));
        //System.out.println( isValid(test) );
        
//        List<int[][]> nexts = getNext( test, new HashSet<Integer>() );
//        for( int[][] e : nexts ){
//            for( int i = 0 ; i < e.length; i++ ){
//                System.out.println(Arrays.toString(e[i]));
//            }
//            System.out.println("----------------");
//        }
    }
}
