package zsx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import zsx.entity.adminUser;


public interface AddUserDao {
//    @Select(value = "select * from adminUser")
//    public List<adminUser> findAll();

    @Select("select * from adminUser where username=#{name}")
    public adminUser findByUserName(String name);

    @Insert("insert into adminUser(username,password) values (#{username},#{password})")
    public void SaveUser(adminUser pr);


}
