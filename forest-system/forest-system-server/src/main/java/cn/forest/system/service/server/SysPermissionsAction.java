package cn.forest.system.service.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.forest.common.service.utils.ResultPage;
import cn.forest.system.entity.SysPermissions;
import cn.forest.system.mapper.SysPermissionsMapper;

@RestController
@RequestMapping("sys_permissions")
public class SysPermissionsAction {
  @Autowired
  private SysPermissionsMapper sysPermissionsMapper;

  @RequestMapping("/list")
  public Object getSysPermissions() {
    return sysPermissionsMapper.selectList(null);
  }

  @RequestMapping("/listfirstLevel")
  public Object listfirstLevel(Long page, Long pageSize) {
    Page<SysPermissions> pages = new Page<SysPermissions>(page, pageSize);
    QueryWrapper<SysPermissions> queryWrapper = new QueryWrapper<SysPermissions>();
    queryWrapper.eq("tree_depth", 1);
    IPage<SysPermissions> selectPage = sysPermissionsMapper.selectPage(pages, queryWrapper);
    selectPage.getRecords().forEach(e -> {
      if ("true".equals(e.getIsParent())) {
        e.setHasChildren(true);
      }
    });
    return new ResultPage<SysPermissions>(selectPage);
  }

  @RequestMapping("/listChildren")
  public Object listChildren(Long parentId) {
    QueryWrapper<SysPermissions> queryWrapper = new QueryWrapper<SysPermissions>();
    queryWrapper.eq("parent_id", parentId);
    List<SysPermissions> selectList = sysPermissionsMapper.selectList(queryWrapper);
    return selectList;
  }

}
