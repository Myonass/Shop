package ru.tolmachev.buyandsell.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tolmachev.buyandsell.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        products.add(new Product(++ID,"Iphone 14 ", "Simple Description", 140000, "Simferopol", "Timur"));
        products.add(new Product(++ID,"Intel Core i10 ", "Simple Description", 14000, "Krasnodar", "Timur"));
    }
    public List<Product> listProducts(){return products;}

    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProducts(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if(product.getId().equals(id)) return product;
        }
        return null;
    }
}
