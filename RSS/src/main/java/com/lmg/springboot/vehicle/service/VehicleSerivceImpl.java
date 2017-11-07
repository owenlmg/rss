/**
 * @Title: VehicleSerivceImpl.java
 * @Package com.lmg.springboot.vehicle.service
 */
package com.lmg.springboot.vehicle.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.springboot.vehicle.model.Vehicle;
import com.lmg.springboot.vehicle.repositories.VehicleRepository;

/***********************************
 * @ClassName: VehicleSerivceImpl.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午4:33:47
 ***********************************/

@Component("vehicleService")
@Transactional
public class VehicleSerivceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public VehicleSerivceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    
    
    /**
     * @Title: findVehicles
     * @Description: TODO
     * @param vehicle
     * @param pageable
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月6日下午4:33:47
     */
    public Page<Vehicle> findVehicles(Vehicle vehicle, Pageable pageable) {
        return vehicleRepository.findByLogisticIdAndLogisticName(vehicle.getLogisticId(), vehicle.getLogisticName(), pageable);
    }
    
}
