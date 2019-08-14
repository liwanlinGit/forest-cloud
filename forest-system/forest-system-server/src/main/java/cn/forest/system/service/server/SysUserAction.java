package cn.forest.system.service.server;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.forest.common.service.utils.ResultPage;
import cn.forest.system.entity.SysUser;
import cn.forest.system.mapper.SysUserMapper;

@RestController
@RequestMapping("/sys_user")
public class SysUserAction {

  @Autowired
  private SysUserMapper sysUserMapper;

  @RequestMapping("/list")
  public Object getList(Long page, Long pageSize) {
    Page<SysUser> ipage = new Page<SysUser>(page, pageSize);
    IPage<SysUser> selectPage = sysUserMapper.selectPage(ipage, null);
    /*
     * PageHelper.startPage(Integer.parseInt(page+""),Integer.parseInt(pageSize+""))
     * ;
     */
    /* List<SysUser> selectList = sysUserMapper.selectList(null); */
    /* PageInfo<SysUser> selectPage=new PageInfo<SysUser>(selectList); */
    return new ResultPage<SysUser>(selectPage);
  }

  @RequestMapping("/delete")
  public int delete(Long id) {
    int deleteById = sysUserMapper.deleteById(id);
    return deleteById;
  }

  @RequestMapping("/add")
  public int save(@RequestBody SysUser user) {
    return sysUserMapper.insert(user);
  }

  @RequestMapping("/update")
  public int update(@RequestBody SysUser user) {
    System.out.println(user);
    return sysUserMapper.updateById(user);
  }

  @RequestMapping("/getById")
  public Object getById(Long id) {
    return sysUserMapper.selectById(id);
  }

}
