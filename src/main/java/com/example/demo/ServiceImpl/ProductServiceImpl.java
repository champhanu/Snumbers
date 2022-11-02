package com.example.demo.ServiceImpl;


import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        try
        {
            return productRepo.findAll();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void setProducts(List<Product> product)
    {
       try
       {
           productRepo.saveAll(product);
       }

       catch(Exception e)
       {
           e.printStackTrace();
       }
    }

    @Override
    public void deleteProduct(Integer sId) {
       List<Integer> Ids = new ArrayList<>();
       Ids.add(sId);

       try
       {
           productRepo.deleteAllByIdInBatch(Ids);
       }

       catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Integer sId, Product product) {

        try
        {
            productRepo.save(product);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
