package cn.forest.system.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.common.util.RequestMap;
import cn.forest.common.web.util.SysLogs;
import cn.forest.system.service.SysPermissionsService;
import cn.forest.system.service.SysUserService;

@RestController
@RequestMapping("/sysUser")
@SysLogs(desc  = "用户管理")
public class SysUserController {
  @Autowired
  private SysUserService sysUserService;

  @SysLogs(desc = "用户列表")
  @RequestMapping("/list")
  public Map<String, Object> getList(Long page, Long pageSize) {
    return sysUserService.getList(page, pageSize);
  }

  @SysLogs(desc = "删除用户")
  @RequestMapping("/delete")
  public Map<String, Object> delete(Long id) {
    return sysUserService.delete(id);
  }

  @SysLogs(desc = "添加用户")
  @RequestMapping("/add")
  public Map<String, Object> add(HttpServletRequest request) {
    return sysUserService.add(RequestMap.requestToMap(request));
  }
  
  @SysLogs(desc = "修改用户")
  @RequestMapping("/update")
  public Map<String, Object> update(HttpServletRequest request) {
    return sysUserService.update(RequestMap.requestToMap(request));
  }
  
  @SysLogs(desc = "查询用户")
  @RequestMapping("/getById")
  public Map<String, Object> getById(Long id) {
    return sysUserService.getById(id);
  }
}
