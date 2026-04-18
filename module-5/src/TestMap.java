import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Perez", "555-1234");
        hashMap.put("Washington", "555-5678");
        hashMap.put("Lewis", "555-9012");
        hashMap.put("Cook", "555-3456");

        System.out.println("\nHashMap (unordered, no guaranteed order):");
        System.out.println(hashMap + "\n");

        // Create a TreeMap from the preceding HashMap
        Map<String, String> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeMap (sorted in ascending order by key [name]):");
        System.out.println(treeMap + "\n");

        // Create a LinkedHashMap
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Perez", "555-1234");
        linkedHashMap.put("Washington", "555-5678");
        linkedHashMap.put("Lewis", "555-9012");
        linkedHashMap.put("Cook", "555-3456");

        // Access LinkedHashMap to demonstrate access-order
        System.out.println("Accessing the key 'Lewis' to demonstrate access-order behavior:");
        System.out.println("The phone number for Lewis is " + linkedHashMap.get("Lewis"));

        System.out.println("\nLinkedHashMap (ordered by most recent access):");
        System.out.println(linkedHashMap + "\n");

        // Display each entry with name and phone number
        System.out.println("Displaying entries using forEach (key: value):");
        treeMap.forEach((name, phone) -> System.out.print(name + ": " + phone + " \n"));
    }
}