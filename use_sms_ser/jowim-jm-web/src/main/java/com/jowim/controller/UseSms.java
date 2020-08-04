package com.jowim.controller;

import cn.hutool.core.util.RuntimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

@RestController
public class UseSms {
    //获取所有启动的服务
    @GetMapping("get_all_start_server")
    public String getAllStartServer() {
        return RuntimeUtil.execForStr("tasklist");
    }


    //查询一个服务是否启动
    @GetMapping("check_one")
    public String checkOne(String server) {
        String tasklist = RuntimeUtil.execForStr("tasklist");
        boolean args = tasklist.contains(server);
        return args ? server + " 正在运行中。。" : server + " 未启动。。";
    }

    //获取所有服务包含未启动的服务
    @GetMapping("get_all_server")
    public String getAllServer() {
        return RuntimeUtil.execForStr("sc query state= all");
    }

    //根据pid结束某个服务
    @GetMapping("stop_server")
    public String stopServer(String pid) throws Exception {

        if (StringUtils.isEmpty(pid)) {
            return "请输入pid";
        }
        System.out.println("pid:" + pid);
        System.out.println(RuntimeUtil.execForStr("Tskill " + pid));
        Thread.sleep(5000);
        return "结束pid为：" + pid + " 的服务成功,请尽快根据原先查询到的对应的服务名去启动服务";
    }

    //根据服务名来启动某个服务 不填的话默认启动tomcat8081
    @GetMapping("start_server")
    public String startServer(String serverName) {

        if (StringUtils.isEmpty(serverName)) {
            return "请输入要启动的服务名";
        }
        System.out.println("serverName:" + serverName);
        String result = RuntimeUtil.execForStr("sc start " + serverName);
        return "启动服务名为：" + serverName + " 的服务成功，建议再执行一遍查询所有启动服务的接口查看启动状态\n" + result;
    }

    //重启指定的tomcat8081专用
    @GetMapping("restart_tomcat")
    public String restartTomcat(String pid) throws Exception {
        try {
            Integer.valueOf(pid);
        } catch (NumberFormatException e) {
            return "你别逗我";
        }
        System.out.println("pid:" + pid);
        System.out.println(RuntimeUtil.execForStr("Tskill " + pid));
        Thread.sleep(10000);
        String result = RuntimeUtil.execForStr("sc start tomcat8081");
        return "启动服务名为：tomcat8081 的服务成功，建议再执行一遍查询所有启动服务的接口查看启动状态\n" + result;
    }

    //执行cmd命令
    @GetMapping("use_cmd")
    public String useCmd(String cmdCode) {
        if (StringUtils.isEmpty(cmdCode)) {
            return "你要输入cmd命令";
        }
        System.out.println("cmd:" + cmdCode);
        return RuntimeUtil.execForStr(cmdCode);
    }


    //执行cmd命令
    @GetMapping("select_tomcat_servera")
    public String selectTomcatServera() {
        String result = RuntimeUtil.execForStr("tasklist /svc");
        boolean args = result.contains("tomcat8081");
        return args+"";
    }

}
