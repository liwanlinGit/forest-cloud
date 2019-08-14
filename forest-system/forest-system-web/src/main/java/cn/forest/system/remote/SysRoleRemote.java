package cn.forest.system.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.forest.system.fallback.SysRoleBack;

@FeignClient(name = "forest-system-server", fallback = SysRoleBack.class)
public interface SysRoleRemote {
  @RequestMapping("/sys_role/list")
  public Object getSysRoleList(@RequestParam(value = "page")Long page,@RequestParam(value = "pageSize")Long pageSize);
}
