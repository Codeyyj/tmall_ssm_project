package zsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zsx.dao.AddUserDao;
import zsx.entity.adminUser;

import javax.annotation.Resource;


    @Service   //该标签是标注清楚这个代码是业务层，Spring扫描到这里的时候会把当前代码当做一个项目的业务层
    public class AddUserServicelmpl implements AddUserService {

        @Autowired   //它代表在业务层中引入持久层接口，并实例化该接口
        private AddUserDao dao;

        @Override
        public adminUser findByUserName(String name) {
            return dao.findByUserName(name);
        }

        @Override
        public adminUser login(String username) {
            adminUser user = dao.findByUserName(username);
            return user;
        }

        @Override
        public void register(adminUser user) {
             dao.SaveUser(user);
        }

        @Override
        public void SaveUser(adminUser pr) {
            dao.SaveUser(pr);
        }


//        @Override
//        public adminUser findById(int id) {
//            return dao.findById(id);
//        }

    }
