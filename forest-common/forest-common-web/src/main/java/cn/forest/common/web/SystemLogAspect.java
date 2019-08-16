package cn.forest.common.web;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.forest.common.util.AddressIpUtil;
import cn.forest.common.util.RequestMap;
import cn.forest.common.web.remote.SysLogsRemote;
import cn.forest.common.web.util.SysLogs;

@Aspect
@Component
public class SystemLogAspect {
  
  @Autowired
  private SysLogsRemote  sysLogsRemote;
  
  
  
  @Before("@annotation(cn.forest.common.web.util.SysLogs)")
  public void controllerAspect(JoinPoint joinPoint) throws Exception{
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    String method = joinPoint.getSignature().getName();
    String cla = joinPoint.getTarget().getClass().getName();
    String methodType = request.getMethod();
    Class<?> targetClass = Class.forName(cla);
   String classDesc=targetClass.getAnnotation(SysLogs.class).desc();
    Map<String, Object> map=new HashMap<String, Object>();
    map.put("roleName", "管理员");
    map.put("userId", 1);
    map.put("userName", "王二小");
    map.put("loginName", "admin");
    map.put("modelName", classDesc);
    map.put("ip", AddressIpUtil.getIpAddr(request));
    map.put("url", request.getRequestURI());
    map.put("method", method);
    map.put("methodType", methodType);
    String desc = getControllerMethodDescription(joinPoint,targetClass, method);
    map.put("description", desc);
    if("POST".equals(methodType)) {
      map.put("args",  RequestMap.requestToMap(request));
    }else {
      if(joinPoint.getArgs().length>0) {
        map.put("args", Arrays.toString(joinPoint.getArgs()));
      }
    }
    sysLogsRemote.add(map);
  }
  
  public static String getControllerMethodDescription(JoinPoint joinPoint,Class<?> targetClass,String methodName) throws Exception {
    Method[] methods = targetClass.getMethods();
    String description = "";
    for (Method method:methods) {
        if (method.getName().equals(methodName)){
            description = method.getAnnotation(SysLogs.class).desc();
            break;
        }
    }
    return description;
  }
  
}
