package cn.forest.system.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.system.service.SysPermissionsService;

@RestController
@RequestMapping("sysPermissions")
public class SysPermissionsController {
  @Autowired
  private SysPermissionsService sysPermissionsService;

  @RequestMapping("/list")
  private Map<String, Object> getSyspermissionsList() {
    return sysPermissionsService.getSysPermissionsList();
  }

  @RequestMapping("/getlistfirstLevel")
  private Map<String, Object> getlistfirstLevel(Long page, Long pageSize) {
    return sysPermissionsService.getlistfirstLevel(page, pageSize);
  }

  @RequestMapping("/getlistChildren")
  private Map<String, Object> getlistChildren(Long parentId) {
    return sysPermissionsService.getlistChildren(parentId);
  }

}
