import java.util.TreeMap;

public class HitCounter {  
    
    TreeMap<Integer, Integer> timeStampToHitCountMap;
    int currCount;

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        
        /*hitCounter.hit(1);    // hit at timestamp 1.
        hitCounter.hit(2);    // hit at timestamp 2.
        hitCounter.hit(3);    // hit at timestamp 3.
        System.out.println(hitCounter.getHits(4));  // get hits at timestamp 4, return 3.
        hitCounter.hit(300);   // hit at timestamp 300.
        System.out.println(hitCounter.getHits(300)); // get hits at timestamp 300, return 4.
        System.out.println(hitCounter.getHits(301)); // get hits at timestamp 301, return 3.*/

        /*System.out.println(hitCounter.getHits(8));  // get hits at timestamp 8, return 0.
        System.out.println(hitCounter.getHits(20));  // get hits at timestamp 8, return 0.
        System.out.println(hitCounter.getHits(42)); // get hits at timestamp 42, return 0.
        hitCounter.hit(62); // hit at timestamp 62.
        hitCounter.hit(73); // hit at timestamp 73.
        hitCounter.hit(91); // hit at timestamp 91.
        System.out.println(hitCounter.getHits(100));  // get hits at timestamp 100, return 3.
        System.out.println(hitCounter.getHits(100));  // get hits at timestamp 100, return 3.
        System.out.println(hitCounter.getHits(101)); // get hits at timestamp 101, return 3.*/

        hitCounter.hit(41);
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
        System.out.println(hitCounter.getHits(373));
        
    }

    public HitCounter() {
        timeStampToHitCountMap = new TreeMap<>();
        currCount = 0;        
    }
    
    public void hit(int timestamp) {
        currCount++;
        timeStampToHitCountMap.put(timestamp, currCount);
    }
    
    public int getHits(int timestamp) {
        if (timeStampToHitCountMap.containsKey(timestamp)) {
            return timeStampToHitCountMap.get(timestamp);
        } else {
            Integer endKey = timeStampToHitCountMap.lowerKey(timestamp);
            Integer startKey = timeStampToHitCountMap.lowerKey(timestamp - 300 + 1);

            int endValue = endKey == null ? 0 : timeStampToHitCountMap.get(endKey);
            int startValue = startKey == null ? 0 : timeStampToHitCountMap.get(startKey);
            
            return endValue - startValue;
        }
    }
}