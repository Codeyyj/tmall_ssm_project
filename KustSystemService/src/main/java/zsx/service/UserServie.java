package zsx.service;

import zsx.entity.Product;
import zsx.entity.User;

import java.util.List;

public interface UserServie {

    public List<User> findAll();

    public User findById(int id);

    public void update(User product);

    public void DeleteById(int id);

}
