package com.jowim.task;

import cn.hutool.core.util.RuntimeUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@RunWith(SpringRunner.class) //非mvc模式下使用autowired注入不报空的注解 2个
@SpringBootTest
public class ChekTask {


    @Scheduled(fixedRate = 5000)
    public void sd(){
//        String tasklist = RuntimeUtil.execForStr("tasklist");
//        boolean args = tasklist.contains("tomcat8081");
//        System.out.println(args);
//        if(!args){
//            //TODO 发短信
//            System.out.println("发短信");
//        }
    }

}
