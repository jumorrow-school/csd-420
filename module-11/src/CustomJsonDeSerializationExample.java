import com.google.gson.*;

public class CustomJsonDeSerializationExample {
    public static void main(String[] args) {

        String jsonString = "{\"fullName\":\"Ansh\", \"yearsOld\":23}";

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Person.class,
                (JsonDeserializer<Person>) (json, typeOfT, context) -> {

                    JsonObject obj = json.getAsJsonObject();

                    String name = obj.get("fullName").getAsString();
                    int age = obj.get("yearsOld").getAsInt();

                    return new Person(name, age);
                });

        Gson gson = gsonBuilder.create();

        Person person = gson.fromJson(jsonString, Person.class);
        System.out.println(person);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}