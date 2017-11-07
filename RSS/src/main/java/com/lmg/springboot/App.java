/**
 * @Title: StartController.java
 * @Package com.lmg.springboot
 */
package com.lmg.springboot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lmg.springboot.listeners.MyApplicationListener;
import com.lmg.springboot.vehicle.repositories.VehicleRepository;

/***********************************
 * @ClassName: StartController.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午1:30:32
 ***********************************/

@SpringBootApplication
public class App implements CommandLineRunner {
    
    @Autowired
    DataSource        dataSource;
    
    @Autowired
    VehicleRepository vehicleRepository;
    
    
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.addListeners(new MyApplicationListener());
        springApplication.run(args);
    }
    
    
    /**
     * @Title: run
     * @Description: TODO
     * @param args
     * @throws Exception
     * @createdBy:Luomingguo
     * @createaAt:2017年11月7日上午10:50:35
     */
    public void run(String... args) throws Exception {
        // System.out.println(dataSource);
        // System.out.println(vehicleRepository.findOne(828));
    }
    
}
