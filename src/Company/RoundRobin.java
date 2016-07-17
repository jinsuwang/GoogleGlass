package Company;

//public static float waitingTimeRobin(int[] arrival,int[] run, int q) 
import java.util.Queue;
import java.util.LinkedList;
// e.g.
// arrival_time = [0, 1, 4], execution_time = [5, 2, 3], q = 3
// average wait time = (7 - 5) + (5 - 3) + (10 - 7) / 3 = 2.3333333 // q is quantum

public class RoundRobin {
       
    
    public static float waitingTimeRobin(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length)	return 0;
        int length = Atime.length;
        // process q 
        Queue<Process> queue = new LinkedList<Process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                // fetch current queue
                Process cur = queue.poll();
                waitTime += curTime - cur.arriveTime;
                curTime += Math.min(cur.excuteTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new Process(Atime[index], Etime[index]));
                if (cur.excuteTime > q)
                    queue.offer(new Process(curTime, cur.excuteTime - q));
            }else{
                queue.offer(new Process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }
    
    public static void main(String[] args) {
           int[] arrival1 = {0, 1, 4};
           int[] run1 = {5, 2, 3};
           int q1 = 3;
           int[] arrival2 = {0, 1, 3, 9};
           int[] run2 = {2, 1, 7, 5};
           int q2 = 2;
           System.out.print(waitingTimeRobin(arrival2, run2, q2));
     }
}