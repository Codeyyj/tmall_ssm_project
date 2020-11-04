package zsx.service;


import zsx.entity.ProdctCategory;
import zsx.entity.Property;
import zsx.entity.PropertyValue;

import java.util.List;


public interface ProductCategoryService {
    void add(ProdctCategory p);
    void delete(int id);
    void dleteBycid(int cid);
    void update(ProdctCategory p);

    ProdctCategory get(int id);

    public List<ProdctCategory> findAll(int cid);

    public ProdctCategory findById(int id);
    public List<PropertyValue> init(int ptid);
}