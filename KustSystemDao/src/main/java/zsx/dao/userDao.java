package zsx.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zsx.entity.User;

import java.util.List;

public interface userDao {
    @Select("select * from user ")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findById(int id);

    @Delete("delete from user where id=#{id}")
    public void DeleteById(int id);

    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    void update(User user);
}
