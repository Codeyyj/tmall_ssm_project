package zsx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zsx.dao.ProductCatogryDao;
import zsx.dao.PropertyDao;
import zsx.dao.PropertyValueDao;
import zsx.entity.ProdctCategory;
import zsx.entity.Property;
import zsx.entity.PropertyValue;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

@Autowired
ProductCatogryDao prodctCategoryDao;

@Autowired
PropertyDao propertyDao;

@Autowired
PropertyValueDao propertyValueDao;
    @Override
    public void add(ProdctCategory p) {
        prodctCategoryDao.add(p);

    }

    @Override
    public void delete(int id) {
        prodctCategoryDao.delete(id);
    }

    @Override
    public void dleteBycid(int cid) {
        prodctCategoryDao.deleteBycid(cid);
    }

    @Override
    public void update(ProdctCategory p) {
        prodctCategoryDao.update(p);
    }

    @Override
    public ProdctCategory get(int id) {
        return null;
    }


    public List<ProdctCategory> findAll(int cid) {
        return prodctCategoryDao.findAll(cid);
    }

    @Override
    public ProdctCategory findById(int id) {
        return prodctCategoryDao.findById(id);
    }

//    @Override
//    public List<PropertyValue> init(int ptid) {
//        return null;
//    }

@Override
    public List<PropertyValue> init(int ptid) {

        System.out.println(ptid);
        //  ptid产品id
        ProdctCategory p = prodctCategoryDao.findById(ptid);
        System.out.println(p);

        //获取属性id
        int cid = p.getCid();

        //到属性表中查询
        List<Property> list = propertyDao.findList(cid);

        int pid=cid;

      //  System.out.println(list);

        PropertyValue propertyValue = new PropertyValue();

        List<PropertyValue> plist= propertyValueDao.findAllByPtid(ptid);
        //查询出来的数据为空，才进行插入操作
        if(plist==null){
            //进行初始化操作,逐条添加数据
            for(int i=0;i<list.size();i++){
                String propertyName = list.get(i).getName();
                propertyValue.setPid(pid);
                propertyValue.setPtid(ptid);
                propertyValue.setValue(null);
                propertyValue.setPropertyName(propertyName);

               // System.out.println(propertyValue);

                propertyValueDao.insert(propertyValue);
            }

        }


         plist= propertyValueDao.findAllByPtid(ptid);
       // System.out.println(plist);
        //进程初始化成功
        return plist;
    }


}