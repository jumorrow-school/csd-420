import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.util.ArrayList;

public class GsonJsonArrayExample {

    public static void main(String[] args) {

        // Create ArrayList
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("Database Systems");
        courses.add("Networking");

        // Create Gson object
        Gson gson = new Gson();

        // Convert ArrayList into JsonArray
        JsonArray jsonArray =
                gson.toJsonTree(courses).getAsJsonArray();

        // Display JSON array
        System.out.println(jsonArray);
    }
}