import java.util.List;

public class TopBottomFinder implements RankingDisplay {

    private void bubbleSortDescending(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (students.get(j).getTotalMarks() < students.get(j + 1).getTotalMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    private void bubbleSortAscending(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (students.get(j).getTotalMarks() > students.get(j + 1).getTotalMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
    @Override
    public void showHighestFive(List<Student> students) {
        bubbleSortDescending(students);
        System.out.println("\nTop 5 Students:");
        int limit = students.size() < 5 ? students.size() : 5;
        for (int i = 0; i < limit; i++) {
            Student s = students.get(i);
            System.out.printf("%d. %s - %.2f%n", i + 1, s.getFullName(), s.getTotalMarks());
        }
    }

    @Override
    public void showLowestFive(List<Student> students) {
        bubbleSortAscending(students);
        System.out.println("\nBottom 5 Students:");
        int limit = students.size() < 5 ? students.size() : 5;
        for (int i = 0; i < limit; i++) {
            Student s = students.get(i);
            System.out.printf("%d. %s - %.2f%n", i + 1, s.getFullName(), s.getTotalMarks());
        }
    }
}