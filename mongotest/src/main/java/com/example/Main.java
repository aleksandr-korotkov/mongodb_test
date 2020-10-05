package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class);

        WorkspacesService bean = run.getBean(WorkspacesService.class);
        bean.save(new Workspace("es",2,33,"dagdfj", OSFamily.WINDOWS));
        bean.save(new Workspace("ed",4,5,"ytktnd", OSFamily.OSX));
        bean.save(new Workspace("et",5,2,"sadfawe", OSFamily.LINUX));
        bean.save(new Workspace("ef",61,66,"rethtdn", OSFamily.WINDOWS));

        List<Workspace> all = bean.findAll();
//
//        for(Workspace workspace : all){
//            System.out.println(workspace.toString());
//        }

        //List<Workspace> workspaces = bean.findByUnitAndSeat(5, 2);
        for(Workspace workspace : all){
            System.out.println(workspace.toString());
        }
    }
}
