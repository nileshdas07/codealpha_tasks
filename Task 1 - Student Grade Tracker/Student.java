
    public class Student {
        private String name;
        private int[] marks;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int[] getMarks() {
            return marks;
        }

        public int getTotalMarks() {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total;
        }

        public double getAverage() {
            return (double) getTotalMarks() / marks.length;
        }

        public int getHighestMark() {
            int high = marks[0];
            for (int mark : marks) {
                if (mark > high) high = mark;
            }
            return high;
        }

        public int getLowestMark() {
            int low = marks[0];
            for (int mark : marks) {
                if (mark < low) low = mark;
            }
            return low;
        }
    }


