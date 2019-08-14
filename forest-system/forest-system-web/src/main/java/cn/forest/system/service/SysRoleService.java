package cn.forest.system.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.forest.common.util.ResultMessage;
import cn.forest.system.remote.SysRoleRemote;

@Service("sysRoleService")
public class SysRoleService {
  @Autowired
  private SysRoleRemote sysRoleRemote;
  
  public Map<String, Object> getList(Long page,Long pageSize){
    Object sysRole = sysRoleRemote.getSysRoleList(page, pageSize);
    if(sysRole != null) {
      return ResultMessage.success(sysRole);
    }
    return null;
  } 
  
}
