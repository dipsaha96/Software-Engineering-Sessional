import java.util.ArrayList;
import java.util.List;

// class Combo extends MenuItem {
//     private List<MenuItem> items = new ArrayList<>();
//     private int discount = 0;

//     public Combo(String name) {
//         super(name, 0);
//     }

//     public void addItem(MenuItem item) {
//         items.add(item);
//     }

//     public void removeItem(MenuItem item) {
//         items.remove(item);
//     }

//     public void applyDiscount(int discount) {
//         this.discount = discount;
//     }

//     @Override
//     public int getPrice() {
//         int total = 0;
//         for (MenuItem item : items) {
//             total += item.getPrice();
//         }
//         return total - (total * discount / 100);
//     }

//     @Override
//     public void display() {
//         System.out.println(name + " Combo:");
//         for (MenuItem item : items) {
//             System.out.print("  - ");
//             item.display();
//         }
//         int total = getPrice();
//         if (discount > 0) {
//             System.out.println("Discount - " + discount + "%");
//             System.out.println("Discounted Total - " + total + "tk");
//         } else {
//             System.out.println("Total - " + total + "tk");
//         }
//     }
// }

class Combo extends MenuItem {
    private List<MenuItem> items = new ArrayList<>();
    private int discount = 0;
    private boolean hasFixedPrice = false; // To check if the combo has a fixed price

    public Combo(String name, int price, boolean hasFixedPrice) {
        super(name, price);
        this.hasFixedPrice = hasFixedPrice;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public void applyDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        if (hasFixedPrice) {
            return price - (price * discount / 100); // Use fixed price with discount if applicable
        } else {
            int total = 0;
            for (MenuItem item : items) {
                total += item.getPrice();
            }
            return total - (total * discount / 100); // Calculate based on item prices with discount
        }
    }

    @Override
    public void display() {
        System.out.println(name + " Combo:");
        for (MenuItem item : items) {
            System.out.print("  - ");
            item.display();
        }
        if (hasFixedPrice) {
            System.out.println("Original Price - " + price + "tk");
        }
        int total = getPrice();
        if (discount > 0) {
            System.out.println("Discount - " + discount + "%");
            System.out.println("Discounted Total - " + total + "tk");
        } else {
            System.out.println("Total - " + total + "tk");
        }
    }
}
