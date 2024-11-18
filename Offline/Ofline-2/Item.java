class Item extends MenuItem {
    public Item(String name, int price) {
        super(name, price);
    }

    @Override
    public int getPrice() {
        return isFree ? 0 : price;
    }

    @Override
    public void display() {
        System.out.println(name + (isFree ? " (Free!!!)" : "") + " - " + getPrice() + "tk");
    }
}