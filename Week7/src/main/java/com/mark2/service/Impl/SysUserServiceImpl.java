package com.mark2.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mark2.datasource.CurDataSource;
import com.mark2.datasource.DataSourceNames;
import com.mark2.entity.SysUser;
import com.mark2.mapper.SysUserMapper;
import com.mark2.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public int InsertUser(SysUser user) {
        return this.baseMapper.insert(user);
    }

    @CurDataSource(name = DataSourceNames.SECOND)
    @Override
    public SysUser findUser(long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public int deleteUser(String name) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("username", name);

        return this.baseMapper.delete(queryWrapper);
    }

    public SysUser findUser(String name) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("name", name);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
