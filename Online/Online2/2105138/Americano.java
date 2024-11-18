public  class Americano extends CoffeeDecorator {
    private Coffee blackcoffee;

     Americano(Coffee blackcoffee) {
        this.blackcoffee = blackcoffee;
    }

    @Override
    public String getIngredients() {
        return blackcoffee.getIngredients() + ", extra grinned bean";
    }

    @Override
    public int getCost() {
        return blackcoffee.getCost() + 30;
    }
}
