public class Cappuccino extends CoffeeDecorator {
    private Coffee coffee;

    public Cappuccino(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + ", Cinamon Powder";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 50;
    }
}
