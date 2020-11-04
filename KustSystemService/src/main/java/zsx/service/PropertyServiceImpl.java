package zsx.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zsx.dao.PropertyDao;
import zsx.entity.Product;
import zsx.entity.Property;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyDao pp;
    @Override
    public List<Property> findAll(int cid) {
        //注意：该行代码一定要在执行sql语句之前
        //PageHelper.startPage(1,2);
        return pp.findAll(cid);
    }

    @Override
    public void delete(int id) {
        pp.delete(id);
    }

    @Override
    public void deleteByCid(int cid) {
        pp.deleteByCid(cid);
    }

    @Override
    public Property findById(int id) {

        return pp.findById(id);
    }

    @Override
    public void add(Property property) {
        pp.add(property);
    }

    @Override
    public void update(Property property) {
        pp.update(property);
    }
}
