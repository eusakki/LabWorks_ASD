public class Student {
    String surname;
    String name;
    int course;
    String gender;
    boolean isInDorm;

    public Student(String surname, String name, int course, String gender, boolean isInDorm) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.gender = gender;
        this.isInDorm = isInDorm;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s | course: %d | gender: %s | dorm: %s",
                surname, name, course, gender, isInDorm ? "yes" : " no");
    }
}
