/**
 * @Title: VehicleController.java
 * @Package com.lmg.springboot.vehicle
 */
package com.lmg.springboot.vehicle.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmg.springboot.vehicle.model.Vehicle;
import com.lmg.springboot.vehicle.service.VehicleService;

/***********************************
 * @ClassName: VehicleController.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午4:18:10
 ***********************************/

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    
    @Autowired
    VehicleService VehicleService;
    
    
    @GetMapping("")
    String index(Map<String, Object> model) {
        Pageable pageable = new Pageable() {
            
            public Pageable previousOrFirst() {
                // TODO Auto-generated method stub
                return null;
            }
            
            
            public Pageable next() {
                // TODO Auto-generated method stub
                return null;
            }
            
            
            public boolean hasPrevious() {
                // TODO Auto-generated method stub
                return false;
            }
            
            
            public Sort getSort() {
                // TODO Auto-generated method stub
                return null;
            }
            
            
            public int getPageSize() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            
            public int getPageNumber() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            
            public int getOffset() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            
            public Pageable first() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        Vehicle vehicle = new Vehicle();
        vehicle.setLogisticId(771);
        vehicle.setLogisticName("上海海泰储运有限公司");
        Page<Vehicle> list = this.VehicleService.findVehicles(vehicle, pageable);
        model.put("vehicle", list.getContent().get(0));
        return "welcome";
    }
}
