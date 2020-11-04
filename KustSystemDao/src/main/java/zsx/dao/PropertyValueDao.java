package zsx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import zsx.entity.PropertyValue;

import java.util.List;

public interface PropertyValueDao {
    @Insert("insert into propertyvalue (pid,ptid,value,propertyName) values (#{pid},#{ptid},#{value},#{propertyName})")
    public void insert(PropertyValue propertyValue);

    @Select("select * from propertyvalue where ptid = #{ptid}")
    public List<PropertyValue> findAllByPtid(int ptid);
}
