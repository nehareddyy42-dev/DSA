import java.util.*;

class Product {

    int productId;
    int price;

    Product(int productId, int price) {
        this.productId = productId;
        this.price = price;
    }
}

public class FlipkartBPlusTree {

    public static void main(String[] args) {

        List<Product> products =
                new ArrayList<>();

        products.add(new Product(101,11800));
        products.add(new Product(102,12300));
        products.add(new Product(103,12900));
        products.add(new Product(104,13500));
        products.add(new Product(105,14100));
        products.add(new Product(106,14700));
        products.add(new Product(107,15400));
        products.add(new Product(108,16200));

        int low = 12000;
        int high = 14800;

        System.out.println(
                "Products in Range [" +
                        low + "," + high + "]");

        int count = 0;

        for(Product p : products) {

            if(p.price >= low &&
                    p.price <= high) {

                System.out.println(
                        "Product ID : "
                                + p.productId +
                                " Price : ₹"
                                + p.price);

                count++;
            }
        }

        System.out.println(
                "\nTotal Products Found = "
                        + count);
    }
}