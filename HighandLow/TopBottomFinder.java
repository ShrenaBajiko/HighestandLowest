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
    public void showHighestFive(List<Student> students) {}
    @Override
    public void showLowestFive(List<Student> students) {}
}