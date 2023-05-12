public class TestAnimal {
    public static void main(String[] args) {
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();

        System.out.println(d.walk());
        System.out.println(c.walk());
        System.out.println(a.walk());
        System.out.println(e.walk());
        p.setName("cc");
        System.out.println(p.getName());
        System.out.println(c.getName());
    }
}
