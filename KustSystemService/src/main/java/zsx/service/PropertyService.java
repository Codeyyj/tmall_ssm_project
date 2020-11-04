package zsx.service;



import org.springframework.stereotype.Service;
import zsx.entity.Product;
import zsx.entity.Property;

import java.util.List;

public interface PropertyService {

    public List<Property> findAll(int id);
    public void delete(int id);
    public void deleteByCid(int cid);

    public Property findById(int id);
    public void add(Property property);
    public void update(Property property);

}
