import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class GsonListExample {
    public static void main(String[] args) {

        Gson gson = new Gson();

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1));
        students.add(new Student("Bob", 2));

        // Convert List to JSON
        String json = gson.toJson(students);
        System.out.println("JSON Output: " + json);

        // Convert JSON back to List (using array conversion approach)
        Student[] studentArray = gson.fromJson(json, Student[].class);

        for (Student s : studentArray) {
            System.out.println(s.name + " - " + s.id);
        }
    }
}
