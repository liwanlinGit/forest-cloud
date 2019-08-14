package cn.forest.system.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.forest.system.fallback.SysPermissionsBack;

@FeignClient(name = "forest-system-server", fallback = SysPermissionsBack.class)
public interface SysPermissionsRemote {

  @RequestMapping("/sys_permissions/list")
  public Object getSysPermissionsList();

  @RequestMapping("/sys_permissions/listfirstLevel")
  public Object getlistfirstLevel(@RequestParam(value = "page") Long page,@RequestParam(value = "pageSize") Long pageSize);

  @RequestMapping("/sys_permissions/listChildren")
  public Object getlistChildren(@RequestParam(value = "parentId") Long parentId);

}
