package cn.forest.system.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.common.web.util.SysLogs;
import cn.forest.system.service.SysPermissionsService;

@RestController
@RequestMapping("sysPermissions")
@SysLogs(desc  = "菜单管理")
public class SysPermissionsController {
  
  @Autowired
  private SysPermissionsService sysPermissionsService;

  
  
  @RequestMapping("/list")
  @SysLogs(desc  = "菜单列表")
  public Map<String, Object> getList() {
    return sysPermissionsService.getSysPermissionsList();
  }
  
  @RequestMapping("/getlistfirstLevel")
  @SysLogs(desc  = "菜单一级列表")
  public Map<String, Object> getlistfirstLevel(Long page, Long pageSize) {
    return sysPermissionsService.getlistfirstLevel(page, pageSize);
  }

  @RequestMapping("/getlistChildren")
  @SysLogs(desc  = "菜单子集列表")
  public Map<String, Object> getlistChildren(Long parentId) {
    return sysPermissionsService.getlistChildren(parentId);
  }

}
