import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;

public class Main {

    static ArrayList<lecture> list = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner user = new Scanner(System.in);
        String inputFileName;

        System.out.print("Input File Name: ");
        inputFileName = user.nextLine().trim();
        scan(inputFileName);// reading method
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int s = i + 1; s < list.size(); s++) {
                if (list.get(i).getDayOfWeek().equals(list.get(s).getDayOfWeek())) {
                    LocalTime starti = list.get(i).getTime();

                    LocalTime endi = list.get(i).getTime().plus(list.get(i).getDuration());

                    LocalTime starts = list.get(s).getTime();
                    int v = starti.compareTo(starts);
                    int f = endi.compareTo(starts);
                    if ((v < 0 || v == 0) && f > 0) {
                        System.out.println("yes there exists a conflict in :");
                        System.out.println(list.get(i).toString());
                        System.out.println(list.get(s).toString());
                        counter++;
                    }

                }

            }
        }
        if (counter == 0) {
            System.out.println("there is no conflict");
        }

    }

    public static void scan(String inputFileName) throws FileNotFoundException {

        File input = new File(inputFileName);
        Scanner scan = new Scanner(input);

        while (scan.hasNextLine()) {

            DayOfWeek dayOfWeek;
            LocalTime time;
            Duration duration;
            String day;

            String dayOfWeekArg = scan.next();
            switch (dayOfWeekArg) {
                case "Mon":
                    day = "MONDAY";
                    break;
                case "Tue":
                    day = "TUESDAY";
                    break;
                case "Wed":
                    day = "WEDNESDAY";
                    break;
                case "Thu":
                    day = "THURSDAY";
                    break;
                case "Fri":
                    day = "FRIDAY";
                    break;
                case "Sat":
                    day = "SATURDAY";
                    break;
                case "Sun":
                    day = "SUNDAY";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
            }
            dayOfWeek = DayOfWeek.valueOf(day);

            String str = scan.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            time = LocalTime.parse(str, formatter);

            int du = scan.nextInt();
            duration = Duration.ofMinutes(du);

            lecture l = new lecture(dayOfWeek, time, duration);
            list.add(l);

        }

    }
}