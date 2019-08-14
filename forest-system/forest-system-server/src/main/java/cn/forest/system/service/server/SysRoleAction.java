package cn.forest.system.service.server;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.forest.common.service.utils.ResultPage;
import cn.forest.system.entity.SysRole;
import cn.forest.system.mapper.SysRoleMapper;

@RestController
@RequestMapping("sys_role")
public class SysRoleAction {

  @Autowired
  private SysRoleMapper sysRoleMapper;

  @RequestMapping(value = "/list")
  public Object getList(Long page, Long pageSize) {
    Page<SysRole> pages = new Page<SysRole>(page, pageSize);
    IPage<SysRole> selectPage = sysRoleMapper.selectPage(pages, null);
    return new ResultPage<SysRole>(selectPage);
  }

}
