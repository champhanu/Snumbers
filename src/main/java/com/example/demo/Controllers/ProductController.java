package com.example.demo.Controllers;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @PostMapping("/setProducts")
    public ResponseEntity<?> setProducts(@RequestBody List<Product> product)
    {
        if(product.size()<=0 || product == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("size is NULL");
        }

        else
        {
            productService.setProducts(product);
            return ResponseEntity.ok(Map.of("message","list is saved"));
        }

    }

    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer sId)
    {
        if(sId==0 || sId == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");
        }

        else
        {
            productService.deleteProduct(sId);
            return ResponseEntity.ok(Map.of("message","entry is deleted"));
        }
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable(value = "id") Integer sId,@RequestBody Product product)
        {
            if(sId == 0 || sId ==null)
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect Id");
            }

            else
            {
                productService.updateProduct(sId,product);
                return ResponseEntity.ok(Map.of("message","The entry is updated"));
            }
        }

}
