package cn.forest.system.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.common.Constant;
import cn.forest.common.util.RequestMap;
import cn.forest.system.service.SysUserService;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
  @Autowired
  private SysUserService sysUserService;

  @RequestMapping("/list")
  public Map<String, Object> getList(Long page, Long pageSize) {
    return sysUserService.getList(page, pageSize);
  }

  @RequestMapping("/delete")
  public Map<String, Object> delete(Long id) {
    return sysUserService.delete(id);
  }

  @RequestMapping("/add")
  public Map<String, Object> add(HttpServletRequest request) {
    return sysUserService.add(RequestMap.requestToMap(request));
  }

  @RequestMapping("/update")
  public Map<String, Object> update(HttpServletRequest request) {
    return sysUserService.update(RequestMap.requestToMap(request));
  }

  @RequestMapping("/getById")
  public Map<String, Object> getById(Long id) {
    return sysUserService.getById(id);
  }
}
