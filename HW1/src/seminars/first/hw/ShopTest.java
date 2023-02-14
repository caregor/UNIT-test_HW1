package seminars.first.hw;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    public static void main(String[] args) {
        String[] vegetables = {"Cucumber", "Tomato", "Cabbage"};
        Integer[] prices = {100,50,89};

        List<Product> products = new ArrayList<>();
        Shop shop = new Shop();

        for (int i = 0; i < vegetables.length; i++) {
            Product item = new Product();
            item.setCost(prices[i]);
            item.setTitle(vegetables[i]);
            products.add(item);
        }
        shop.setProducts(products);

        // Testing functions
        testShopProducts(shop);
        testGetMostExpensiveProduct(shop);
        testShopSortFunction(shop);
    }

   //  1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
    public static void testShopProducts(Shop shop){
        List<Product> products = new ArrayList<>(shop.getProducts());
        assertThat(products)
                .isNotEmpty()
                .hasSize(3)
                .extracting(Product::getTitle).contains("Cucumber", "Tomato", "Cabbage");
    }

    // 2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
    public static void testGetMostExpensiveProduct(Shop shop){
        assertThat(shop.getMostExpensiveProduct())
                .extracting(Product::getCost)
                .isEqualTo(100);
    }

    // 3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    public static void testShopSortFunction(Shop shop){
        assertThat(shop.getSortedListProducts())
                .isNotEmpty()
                .extracting(Product::getCost)
                .containsSequence(50,89,100);
    }
}
