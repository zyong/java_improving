package com.mark2.service;

import com.mark2.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 */
public interface SysUserService extends IService<SysUser> {

    int InsertUser(SysUser user);

    SysUser findUser(long id);

    int deleteUser(String name);

}
