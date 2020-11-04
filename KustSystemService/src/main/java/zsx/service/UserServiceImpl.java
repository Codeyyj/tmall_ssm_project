package zsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zsx.dao.userDao;
import zsx.entity.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserServie{
    @Autowired
    userDao u;
    @Override
    public List<User> findAll() {

        return u.findAll();
    }

    @Override
    public User findById(int id) {
        return u.findById(id);
    }

    @Override
    public void update(User user) {
      u.update(user);
    }

    @Override
    public void DeleteById(int id){
        u.DeleteById(id);
    }


}
