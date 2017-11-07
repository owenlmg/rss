/**
 * @Title: VehicleService.java
 * @Package com.lmg.springboot.vehicle
 */
package com.lmg.springboot.vehicle.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lmg.springboot.vehicle.model.Vehicle;

/***********************************
 * @ClassName: VehicleService.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午4:21:45
 ***********************************/

public interface VehicleService {
    Page<Vehicle> findVehicles(Vehicle vehicle, Pageable pageable);
}
