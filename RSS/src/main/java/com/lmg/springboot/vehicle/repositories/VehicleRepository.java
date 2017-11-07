/**
 * @Title: VehicleRespository.java
 * @Package com.lmg.springboot.vehicle.service
 */
package com.lmg.springboot.vehicle.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.lmg.springboot.vehicle.model.Vehicle;

/***********************************
 * @ClassName: VehicleRespository.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午4:27:06
 ***********************************/

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    Page<Vehicle> findByLogisticIdAndLogisticName(Integer logisticId, String logisticName, Pageable pageable);
}
