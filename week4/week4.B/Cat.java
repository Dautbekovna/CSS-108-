public class Cat extends Animal implements Pet {
    private String name;
    public Cat() {
        this("");
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }
    @Override
    public void eat() {}

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {}
}
