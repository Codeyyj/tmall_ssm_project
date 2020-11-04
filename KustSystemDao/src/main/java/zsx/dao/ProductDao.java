package zsx.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zsx.entity.Product;

import java.util.List;

public interface ProductDao {


    @Select("select * from category")
    public List<Product> findAll();

    @Delete("delete from category where id=#{id}")
    public void deleteById(int id);

    @Insert("insert into category (name) values (#{name})")
    public void add(Product product);

    @Select("select * from category where id=#{id}")
    public Product findById(int id);

    @Update("update  category set name= #{name} where id=#{id}")
    public void update(Product product);
    @Select("select count(*) from category")
    public int total();
    @Select("select * from category where id=#{id}")
    public Product findByIdindById(int id);

}

