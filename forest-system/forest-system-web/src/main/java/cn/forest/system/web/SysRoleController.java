package cn.forest.system.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.forest.system.service.SysRoleService;

@RestController
@RequestMapping("sysRole")
public class SysRoleController {

  @Autowired
  private SysRoleService sysRoleService;

  @RequestMapping("/list")
  public Map<String, Object> getList(Long page, Long pageSize) {
    return sysRoleService.getList(page, pageSize);
  }

}
