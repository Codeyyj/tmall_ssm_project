package zsx.dao;

import org.apache.ibatis.annotations.*;
import zsx.entity.Product;
import zsx.entity.Property;

import java.util.List;

public interface PropertyDao {
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "cid", column = "cid"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "propertyValue", column = "propertyValue")
//    })

    @Select("select * from property where cid=#{cid}")

    public List<Property> findAll(int cid);

    @Delete("delete from property where id = #{id}")
    public void delete(int id);

    @Delete("delete from property where cid = #{cid}")
    public void deleteByCid(int cid);

    @Select("select * from property where id=#{id}")
    public Property findById(int id);


    @Insert("insert into property (cid,name) values (#{cid},#{name})")
    public void add(Property property);
    @Update("update  property set name= #{name},cid=#{cid} where id=#{id}")
    public void update(Property property);

    @Select("select * from property where cid=#{cid}")
    public List<Property> findList(int cid);

}
