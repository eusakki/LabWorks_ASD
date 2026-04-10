import java.time.LocalDate;

public class Student {
    String lastName;
    String firstName;
    int course;
    String studentId;
    LocalDate birthDate;

    public Student(String lastName, String firstName, int course,
                   String studentId, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.studentId = studentId;
        this.birthDate = birthDate;
    }

    // Checking if student was born in the winter(for lvl 2 and lvl 3)
    public boolean bornInWinter() {
        int month = birthDate.getMonthValue();
        return month == 12 || month == 1 || month == 2;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10s %-5d %-10s %-12s",
                lastName, firstName, course, studentId, birthDate);
    }
}
