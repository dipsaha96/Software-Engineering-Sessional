abstract class MenuItem {
    protected String name;
    protected int price;
    protected boolean isFree = false;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract int getPrice();

    public abstract void display();

    public void setFree() {
        isFree = true;
    }
}