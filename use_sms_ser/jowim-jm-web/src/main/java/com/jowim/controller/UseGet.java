//package com.jowim.controller;
//
//import cn.hutool.core.util.RuntimeUtil;
//import cn.hutool.http.HttpUtil;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.thymeleaf.util.StringUtils;
//
//@RestController
//@RequestMapping("tomcat")
//public class UseGet {
//
//    private final String URL = "http://localhost:7992/";
//
//    //获取所有启动的服务
//    @GetMapping("get_all_start_server")
//    public String getAllStartServer() {
//        return HttpUtil.get(URL + "get_all_start_server");
//    }
//
//    //获取所有服务包含未启动的服务
//    @GetMapping("get_all_server")
//    public String getAllServer() {
//        return HttpUtil.get(URL + "get_all_server");
//    }
//
//    //根据pid结束某个服务
//    @GetMapping("stop_server")
//    public String stopServer(String pid) {
//        return HttpUtil.get(URL + "stop_server?pid="+pid);
//    }
//
//    //根据服务名来启动某个服务 不填的话默认启动tomcat8081
//    @GetMapping("start_server")
//    public String startServer(String serverName) {
//        return HttpUtil.get(URL + "start_server?serverName="+serverName);
//    }
//
//    //重启指定的tomcat8081专用
//    @GetMapping("restart_tomcat")
//    public String restartTomcat(String pid)  {
//        return HttpUtil.get(URL + "restart_tomcat?pid="+pid);
//    }
//
//    //执行cmd命令
//    @GetMapping("use_cmd")
//    public String useCmd(String cmdCode) {
//        return HttpUtil.get(URL + "use_cmd?cmdCode="+cmdCode);
//    }
//
//}
