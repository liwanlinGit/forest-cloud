package cn.forest.system.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.forest.common.web.fallback.SysLogsBack;

@FeignClient(name = "forest-system-server", fallback = SysLogsBack.class)
public interface SysExceptionLogsVoRemote {
  
  @RequestMapping("/sys_exception_logs/list")
  public Object getList(@RequestParam(value = "page") Long page,@RequestParam(value = "pageSize") Long pageSize);
  
}
