public class BasicBlackCoffee implements Coffee {
    @Override
    public String getIngredients() {
        return "water , grinned coofee bean";
    }

    @Override
    public int getCost() {
        return 130;
    }
}
