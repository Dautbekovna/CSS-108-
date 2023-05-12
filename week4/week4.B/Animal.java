public abstract class Animal {
    protected int legs;
    protected Animal(int legs) {
        this.legs = legs;
    }
    public String walk() {
        return "Animal walks with " + this.legs + " legs";
    };
    public abstract void eat();
}
