package zsx.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zsx.dao.ProductDao;
import zsx.entity.Product;

import java.util.List;
@Service  //该标签是标注清楚这个类是业务层代码，spring扫描到这里的时候会把当前代码当作项目业务层
public class ProductServiceImpl implements ProductService{

    @Autowired  //它代表在业务层中引入持久层接口，并实例化该接口
    private ProductDao pd;

    @Override
    public List<Product> findAll() {

        //业务层方法中一般封装对数据的算法操作，本案例不需要算法操作数据

        //第一步调用持久层（mapper映射器对应的接口），获取数据集合
        //PageHelper.offsetPage(0, 2);

        List<Product> list = pd.findAll();
        return list;
    }



    @Override
    public void deleteById(int id) {
        pd.deleteById(id);
    }

    @Override
    public void add(Product product) {
        pd.add(product);
    }

    @Override
    public Product findById(int id) {

        return pd.findByIdindById(id);
    }

    @Override
    public void update(Product product) {
        pd.update(product);
    }

    @Override
    public int total() {
        return pd.total();
    }

}
