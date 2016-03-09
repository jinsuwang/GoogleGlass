/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.*

/**
 *
 * @author Sam
 */


public class RoomSchedual {
    
    public static ArrayList<ArrayList<Interval>> findAllMinIntervalPath(ArrayList<Interval> intervals, Interval range) {
                ArrayList<ArrayList<Interval>> res = new ArrayList<ArrayList<Interval>>();
                if(intervals.size() == 0) return res;
                HashMap<Interval, ArrayList<Interval>> map = new HashMap<Interval, ArrayList<Interval>>();
                Queue<Interval> queue = new LinkedList<Interval>();
                ArrayList<Interval> heads = new ArrayList<Interval>();
                Collections.sort(intervals, new Comparator<Interval>(){
                    public int compare(Interval a, Interval b){
                            return a.start - b.start;
                    }
                });
                
                for(Interval i : intervals) {
                    if(i.start <= range.start){
                        if(i.end >= range.end){
                                ArrayList<Interval> list = new ArrayList<Interval>();
                                list.add(i);
                                res.add(list);
                            }
                            queue.add(i);
                            heads.add(i);
                        }
                }
                if(queue.isEmpty()) return res;
                if(res.size() != 0) return res;
                

                Iterator<Interval> iter = queue.iterator();
                while(iter.hasNext()){
                        intervals.remove(iter.next());
                }
                
                int min = 1;
                boolean findPath = false;
                while(!queue.isEmpty()){
                        Queue<Interval> tmp = new LinkedList<Interval>();
                        HashSet<Interval> set = new HashSet<Interval>();
                        
                        findPath = false;
                        while(!queue.isEmpty()){
                                Interval prev = queue.poll();
                                for(Interval i : intervals) {
                                        if(i.start > prev.start && i.start <= prev.end + 1){
                                                if(!map.containsKey(prev)){
                                                        ArrayList<Interval> inter = new ArrayList<Interval>();
                                                        inter.add(i);
                                                        map.put(prev, inter);
                                                }else {
                                                        map.get(prev).add(i);
                                                }
                                                if(!set.contains(i)){
                                                        set.add(i);
                                                        tmp.add(i);
                                                }
                                                if(i.end >= range.end) {
                                                        findPath = true;
                                                }
                                        }
                                }
                        }.
                        min++;
                        if(findPath) break;
                        Iterator<Interval> ite = tmp.iterator();
                        while(ite.hasNext()){
                                intervals.remove(ite.next());
                        }
                        queue = tmp;
                }
                if(!findPath) return res;
                ArrayList<Interval> list = new ArrayList<Interval>();
                for(Interval i : heads) {
                        list.add(i);
                        dfs(min, map, range, list, res);. from: 1point3acres.com/bbs 
                        list.remove(i);
                }
                
                return res;
        }
        
        public static void dfs(int min, HashMap<Interval, ArrayList<Interval>> map, Interval range, ArrayList<Interval> list, ArrayList<ArrayList<Interval>> res) {. 1point3acres.com/bbs
                Interval prev = list.get(list.size() - 1);
                if(prev.end >= range.end && min == 1){
                        res.add(new ArrayList<Interval>(list));
                        return;
                }
                
                if(!map.containsKey(prev)) return;
                
                ArrayList<Interval> neighbors = map.get(prev);
                
                for(Interval i : neighbors){
                        list.add(i);. visit 1point3acres.com for more.
                        dfs(min - 1, map, range, list, res);-google 1point3acres
                        list.remove(i);
                }
        }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
