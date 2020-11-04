package zsx.service;

import zsx.entity.adminUser;

public interface AddUserService {

    public adminUser findByUserName(String name);

    public adminUser login(String username);

    public void register(adminUser user);

    public void SaveUser(adminUser pr);
    /**
     * 登录账号
     */


}
