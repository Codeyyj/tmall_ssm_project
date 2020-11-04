package zsx.service;

import com.github.pagehelper.Page;
import zsx.entity.Product;

import java.util.List;

public interface ProductService {

    //这是业务层的接口，因为需要按照面向接口编程的方式
    public List<Product> findAll();
    public void deleteById(int id);
    public void add(Product product);
    public Product findById(int id);
    public void update(Product product);
    public int total();

}
