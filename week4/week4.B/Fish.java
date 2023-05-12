public class Fish extends Animal implements Pet {
    private String name;
    public Fish() {
        super(0);
    }
    @Override
    public String walk() {
        return "Fish can't walk";
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
