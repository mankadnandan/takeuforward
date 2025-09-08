public class FaultySensor {

    public static void main(String[] args) {
        System.out.println(badSensor(new int[] { 2, 3, 4, 5 }, new int[] { 2, 1, 3, 4 }));
        System.out.println(badSensor(new int[] { 2, 2, 2, 2, 2 }, new int[] { 2, 2, 2, 2, 5 }));
        System.out.println(badSensor(new int[] { 2, 3, 2, 2, 3, 2 }, new int[] { 2, 3, 2, 3, 2, 7 }));
    }

    private static int badSensor(int[] sensor1, int[] sensor2) {
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < sensor1.length && sensor1[ptr1] == sensor2[ptr2]) {
            ptr1++;
            ptr2++;
        }

        // Either no fault OR cant determine the faulty sensor
        if (ptr1 == sensor1.length || ptr1 == sensor1.length - 1) {
            return -1;
        }

        int faultyIdex = ptr1;

        // sensor2 is faulty
        ptr1++;
        while (ptr1 < sensor1.length && sensor1[ptr1] == sensor2[ptr2]) {
            ptr1++;
            ptr2++;
        }
        if (ptr1 == sensor1.length) {
            return 2;
        }

        // Reset faulty index
        ptr1 = faultyIdex;
        ptr2 = faultyIdex;

        // sensor1 is faulty
        ptr2++;
        while (ptr2 < sensor2.length && sensor1[ptr1] == sensor2[ptr2]) {
            ptr1++;
            ptr2++;
        }
        if (ptr2 == sensor2.length) {
            return 1;
        }

        return -1;
    }
}