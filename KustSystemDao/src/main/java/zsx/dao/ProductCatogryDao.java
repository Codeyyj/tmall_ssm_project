package zsx.dao;

import org.apache.ibatis.annotations.*;
import zsx.entity.ProdctCategory;
import zsx.entity.Product;
import zsx.entity.Property;

import java.util.List;

public interface ProductCatogryDao {

    @Select("select * from product where cid=#{cid}")
    public List<ProdctCategory> findAll(int cid);

    @Insert("insert into product (name,subTitle,originalPrice,promotePrice,stock,cid,createDate) values (#{name},#{subTitle},#{originalPrice},#{promotePrice},#{stock},#{cid},#{createDate})")
    public void add(ProdctCategory prodctCategory);

    @Delete("delete from product where id=#{id}")
    public void delete(int id);

    @Delete("delete from product where cid=#{did}")
    public void deleteBycid(int cid);

    @Select("select * from product where id=#{id}")
    public ProdctCategory findById(int id);

    @Update("update  product set id= #{id},name= #{name} ,subTitle=#{subTitle},originalPrice=#{originalPrice},promotePrice=#{promotePrice},stock=#{stock},cid=#{cid},createDate=#{createDate} where id=#{id}")
    public void update(ProdctCategory prodctCategory);
}
