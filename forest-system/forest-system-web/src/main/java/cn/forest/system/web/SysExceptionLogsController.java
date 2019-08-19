package cn.forest.system.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.common.web.util.SysLogs;
import cn.forest.system.service.SysExceptionLogsVoService;

@RestController
@RequestMapping("sysExceptionLogs")
@SysLogs(desc  = "异常日志管理")
public class SysExceptionLogsController {

  @Autowired
  private SysExceptionLogsVoService sysExceptionLogsVoService;
  
  @RequestMapping("list")
  @SysLogs(desc  = "异常日志列表")
  public Map<String, Object> getList(Long page,Long pageSize){
    return sysExceptionLogsVoService.getList(page, pageSize);
  }
  
  
}
