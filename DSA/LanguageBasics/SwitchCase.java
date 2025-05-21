public class SwitchCase {
    public static void main(String[] args) {
        whichWeekDay(1);
        whichWeekDay(8);
        whichWeekDay(5);
        whichWeekDay(3);
    }

    public static void whichWeekDay(int day) {
        switch(day) {
                case 1:
                    System.out.print("Monday");
                    break;
                case 2:
                    System.out.print("Tuesday");
                    break;
                case 3:
                    System.out.print("Wednesday");
                    break;
                case 4:
                    System.out.print("Thursday");
                    break;
                case 5:
                    System.out.print("Friday");
                    break;
                case 6:
                    System.out.print("Saturday");
                    break;
                case 7:
                    System.out.print("Sunday");
                    break;
                default:
                    System.out.print("Invalid");
                    break;
        }
    }
}