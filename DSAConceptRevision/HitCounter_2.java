import java.util.LinkedList;
import java.util.Queue;

public class HitCounter_2 {

    Queue<Integer> queue;
    public static void main(String[] args) {
        HitCounter_2 hitCounter = new HitCounter_2();
        
        hitCounter.hit(1);    // hit at timestamp 1.
        hitCounter.hit(2);    // hit at timestamp 2.
        hitCounter.hit(3);    // hit at timestamp 3.
        System.out.println(hitCounter.getHits(4));  // get hits at timestamp 4, return 3.
        hitCounter.hit(300);   // hit at timestamp 300.
        System.out.println(hitCounter.getHits(300)); // get hits at timestamp 300, return 4.
        System.out.println(hitCounter.getHits(301)); // get hits at timestamp 301, return 3.

        /*System.out.println(hitCounter.getHits(8));  // get hits at timestamp 8, return 0.
        System.out.println(hitCounter.getHits(20));  // get hits at timestamp 8, return 0.
        System.out.println(hitCounter.getHits(42)); // get hits at timestamp 42, return 0.
        hitCounter.hit(62); // hit at timestamp 62.
        hitCounter.hit(73); // hit at timestamp 73.
        hitCounter.hit(91); // hit at timestamp 91.
        System.out.println(hitCounter.getHits(100));  // get hits at timestamp 100, return 3.
        System.out.println(hitCounter.getHits(100));  // get hits at timestamp 100, return 3.
        System.out.println(hitCounter.getHits(101)); // get hits at timestamp 101, return 3.*/

        /*hitCounter.hit(41);
        hitCounter.hit(70);
        System.out.println(hitCounter.getHits(77));
        hitCounter.hit(111);
        System.out.println(hitCounter.getHits(121));
        hitCounter.hit(145);
        hitCounter.hit(151);
        System.out.println(hitCounter.getHits(196));
        System.out.println(hitCounter.getHits(224));
        System.out.println(hitCounter.getHits(229));
        System.out.println(hitCounter.getHits(249));
        hitCounter.hit(251);
        System.out.println(hitCounter.getHits(267));
        System.out.println(hitCounter.getHits(273));
        System.out.println(hitCounter.getHits(275));
        hitCounter.hit(324);
        hitCounter.hit(362);
        System.out.println(hitCounter.getHits(373));*/
    }

    public HitCounter_2() {
        queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        if (queue.isEmpty()) {
            return 0;
        }
        int diff = timestamp - queue.peek();
        while (diff >= 300) {
            queue.poll();
            diff = timestamp - queue.peek();
        }
        return queue.size();
    }
}