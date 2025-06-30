import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
// If you don’t want packages, delete this line in BOTH files.
   //import java.util.ArrayList;
//import java.util.Scanner;

   // public class StudentGradeTracker {

        private static final Scanner SC = new Scanner(System.in);

        public static void main(String[] args) {
            ArrayList<Student> students = new ArrayList<>();

            System.out.println("=========== Student Grade Tracker ===========");
            int studentCount = promptPositiveInt("Enter number of students: ");

            for (int i = 0; i < studentCount; i++) {
                System.out.printf("%n--- Student %d ---%n", i + 1);
                System.out.print("Name: ");
                String name = SC.nextLine().trim();

                int subjectCount = promptPositiveInt("Number of subjects: ");
                int[] marks = new int[subjectCount];

                for (int s = 0; s < subjectCount; s++)
                    marks[s] = promptMark("  Marks for subject " + (s + 1) + ": ");

                students.add(new Student(name, marks));
            }

            // ----------- Report -----------
            System.out.println("\n=========== Summary Report ===========");
            for (Student st : students) {
                System.out.printf("Student : %s%n", st.getName());
                System.out.printf("Total   : %d%n", st.getTotalMarks());
                System.out.printf("Average : %.2f%n", st.getAverage());
                System.out.printf("Highest : %d%n", st.getHighestMark());
                System.out.printf("Lowest  : %d%n", st.getLowestMark());
                System.out.println("--------------------------------------");
            }
            SC.close();   // eliminate resource‑leak warning
        }

        /* ---------- Helpers ---------- */

        private static int promptPositiveInt(String msg) {
            while (true) {
                System.out.print(msg);
                try {
                    int v = Integer.parseInt(SC.nextLine().trim());
                    if (v > 0) return v;
                } catch (NumberFormatException ignored) { }
                System.out.println("  ❌ Please enter a whole number > 0.");
            }
        }

        private static int promptMark(String msg) {
            while (true) {
                System.out.print(msg);
                try {
                    int m = Integer.parseInt(SC.nextLine().trim());
                    if (m >= 0 && m <= 100) return m;
                } catch (NumberFormatException ignored) { }
                System.out.println("  ❌ Enter a mark between 0–100.");
            }
        }
    }
