package cn.forest.system.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.system.service.SysLoginLogsService;
@RestController
@RequestMapping("sysLoginLogs")
public class SysLoginLogsController {

  @Autowired
  private SysLoginLogsService sysLoginLogsService;
  
  @RequestMapping("/list")
  public Map<String, Object> getSysLoginLogsList(Long page,Long pageSize) {
    return sysLoginLogsService.getList(page, pageSize);
  }
  
  
}
