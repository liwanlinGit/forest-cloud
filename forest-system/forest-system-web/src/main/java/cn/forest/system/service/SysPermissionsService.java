package cn.forest.system.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.forest.common.util.ResultMessage;
import cn.forest.system.remote.SysPermissionsRemote;

@Service("sysPermissionsService")
public class SysPermissionsService {

	@Autowired
	private SysPermissionsRemote sysPermissionsRemote;
	
	
	public Map<String, Object> getSysPermissionsList(){
		Object sysPermissionsList = sysPermissionsRemote.getSysPermissionsList();
		if(sysPermissionsList != null) {
			return ResultMessage.success(sysPermissionsList);
		}
		return null;
	}
	
	public Map<String, Object> getlistfirstLevel(Long page,Long pageSize){
    Object sysPermissionsList = sysPermissionsRemote.getlistfirstLevel(page, pageSize);
    if(sysPermissionsList != null) {
      return ResultMessage.success(sysPermissionsList);
    }
    return null;
  }
	
	public Map<String, Object> getlistChildren(Long parentId){
    Object sysPermissionsList = sysPermissionsRemote.getlistChildren(parentId);
    if(sysPermissionsList != null) {
      return ResultMessage.success(sysPermissionsList);
    }
    return null;
  }
	
}
