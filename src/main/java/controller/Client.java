package controller;

import dto.Product;
import exception.ProductException;
import exception.UpdateProductException;
import service.ProductService;
import service.ProductServiceImpl;

public class Client {
    public static void main(String[] args){

        ProductService productService = new ProductServiceImpl();
        try {
            productService.addProduct(new
                    Product(5,"Rice",57.0));
            productService.addProduct(null);
            productService.addProduct(new
                    Product(15,"Dhal",160.0));

            System.out.println("All products:"+
                    productService.getAllProducts());
            System.out.println("id 5:"+
                    productService.getProductById(5));
            productService.
                    updateProduct(new
                            Product(15,"Dhaal",180.0));
            System.out.println("All products:"+
                    productService.getAllProducts());
            productService.deleteProdctById(5);
            System.out.println("All products:"+
                    productService.getAllProducts());
        } catch (ProductException e) {
            e.printStackTrace();
        }
        catch (UpdateProductException e) {
            e.printStackTrace();
        }

    }
}
