import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        // Creating an ArrayList of String
        List<String> animals = new ArrayList<>();

        // Adding new elements to the ArrayList
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Cat");
        animals.add("Dog");

        System.out.println(animals);

        // Adding an element at a particular index
        animals.add(2, "Elephant");

        System.out.println(animals);
        
        String firstAnimal = animals.get(0);
        System.out.println("The first animal: " + firstAnimal);	

    }
}