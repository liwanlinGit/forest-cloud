package cn.forest.system.fallback;

import org.springframework.stereotype.Component;

import cn.forest.system.remote.SysPermissionsRemote;

@Component
public class SysPermissionsBack implements SysPermissionsRemote {

  @Override
  public Object getSysPermissionsList() {
    return null;
  }

  @Override
  public Object getlistfirstLevel(Long page, Long pageSize) {
    return null;
  }

  @Override
  public Object getlistChildren(Long parentId) {
    return null;
  }

}
