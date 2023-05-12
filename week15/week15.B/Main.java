public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Lion("Simba", 10, 150),
                new Tiger("Rajah", 8, 200),
                new Bear("Baloo", 5, 300),
                new Monkey("Abu", 2, 10)
        };
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].getName() + " the " + animals[i].getClass().getName() + " ate " +
                    animals[i].feedAnimal() + " grams of food.");
        }
    }
}
