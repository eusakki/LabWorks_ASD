public class Student {
    String surname;
    int totalClasses;
    int missedClasses;

    public Student(String surname, int totalClasses, int missedClasses) {
        this.surname = surname;
        this.totalClasses = totalClasses;
        this.missedClasses = missedClasses;
    }

    // ratio of missed to total
    public double ratio() {
        return (double) missedClasses / totalClasses;
    }

    @Override
    public String toString() {
        return String.format("ratio: %.2f | %-15s | total: %-3d | missed: %-3d",
                ratio(), surname, totalClasses, missedClasses);
    }
}
