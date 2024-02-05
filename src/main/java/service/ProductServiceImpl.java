package service;

import dto.Product;
import exception.ProductException;
import exception.UpdateProductException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    //Data member
    private Map<Integer,Product> productMap = new HashMap<>();

    public ProductServiceImpl() {

    }

    public ProductServiceImpl(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    // member function

    @Override
    public Product addProduct(Product newProduct)throws ProductException {
        if(newProduct == null)
            throw  new ProductException("New Product cant be null.");

        if(this.productMap.containsKey(newProduct.getId()))
            throw new ProductException("Product already exists!");

        this.productMap.put(newProduct.getId(),newProduct);
        return this.productMap.get(newProduct.getId());
        //return null;
    }
    @Override
    public Product getProductById(Integer id) throws ProductException{
        // handle exception if product id does not exists
        //if(!this.productMap.containsKey(id)) // throw productNotFound exception
            return this.productMap.get(id);
    }
    @Override
    public Product updateProduct(Product updateProduct) throws UpdateProductException {
     // check if updateProduct id is available in map else throw exception

     this.productMap.replace(updateProduct.getId(),updateProduct);
        return this.productMap.get(updateProduct.getId());
    }
       @Override
    public Collection<Product> getAllProducts() {
        return this.productMap.values();
    }
    @Override
    public Boolean deleteProdctById(Integer id)throws ProductException {
        // check if product id exists if not throw exception
        this.productMap.remove(id);
        return true;
    }
}
