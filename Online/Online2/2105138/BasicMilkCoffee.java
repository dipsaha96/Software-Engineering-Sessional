public class BasicMilkCoffee implements Coffee {
    @Override
    public String getIngredients() {
        return "Milk , grinned coffee bean";
    }

    @Override
    public int getCost() {
        return 180;
    }
    
}
