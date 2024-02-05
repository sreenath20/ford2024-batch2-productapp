package service;

import dto.Product;
import exception.ProductException;
import exception.UpdateProductException;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    //Create
    Product addProduct(Product newProduct)throws ProductException;
    //Read
    Product getProductById(Integer id)throws ProductException;
    //Update
    Product updateProduct(Product product)throws UpdateProductException;
    // Delete
    Boolean deleteProdctById(Integer id)throws ProductException;
    // get all products
    Collection<Product> getAllProducts();
}
