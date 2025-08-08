public class Student {
    private String fullName;
    private double totalMarks;

    public Student(String fullName, double totalMarks) {
        this.fullName = fullName;
        this.totalMarks = totalMarks;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }
}
