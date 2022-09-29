package rikkei.academy.productmanage.service;

import rikkei.academy.productmanage.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService{
    public static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Sữa", "ngon",16000));
        products.add(new Product(2,"Rau", "nhieu",8000));
        products.add(new Product(3,"Cá", "to",27000));
        products.add(new Product(4,"Thịt", "tuoi",30000));

    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id){
                products.remove(i);
            }
        }
    }
}
