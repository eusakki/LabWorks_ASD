public class SearchUtils {
    public static Student linearSearch(Student[] arr, String key) {
        for (Student s : arr) {
            if (s.name.equals(key))
                return s;
        }
        return null;
    }

    public static Student[] removeStudents(Student[] arr) {
        int count = 0;

        for (Student s : arr) {
            if (!(s.gender.equals("M") && s.course == 6 && s.isInDorm))
                count++;
        }

        Student[] result = new Student[count];
        int j = 0;

        for (Student s : arr) {
            if (!(s.gender.equals("M") && s.course == 6 && s.isInDorm))
                result[j++] = s;
        }

        return result;
    }
}
