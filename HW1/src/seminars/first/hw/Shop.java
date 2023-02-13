package seminars.first.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts(List<Product> products) {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, (product1, product2) -> Integer.compare(product1.getCost(), product2.getCost()));
        return sortedProducts;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct(List<Product> products) {
        Product lastItem = null;
        List<Product> sortedProducts = getSortedListProducts(products);
        for (Product item:sortedProducts) {
            lastItem = item;
        }
        return lastItem;
    }
}