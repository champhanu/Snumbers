package com.example.demo.Service;


import com.example.demo.Entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

    public void setProducts(List<Product> product);

    public void deleteProduct(Integer sId);

    public void updateProduct(Integer sId,Product product);
}
