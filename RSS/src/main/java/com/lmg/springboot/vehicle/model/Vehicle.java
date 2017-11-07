/**
 * @Title: Snippet.java
 * @Package com.lmg.springboot.vehicle.model
 */
package com.lmg.springboot.vehicle.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/***********************************
 * @ClassName: Vehicle.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午4:23:57
 ***********************************/

@Entity
@Table(name = "BS_VEHICLE_CONFIG_INFO")
public class Vehicle implements Serializable {
    
    /**
     * @Fields serialVersionUID:序列
     */
    private static final long  serialVersionUID = 1L;
    
    /**
     * 表名
     */
    public final static String TABLE_NAME       = "BS_VEHICLE_CONFIG_INFO";
    
    @Id
    private java.lang.Integer  vehicleId;
    /**
     * 车牌号
     */
    private java.lang.String   vehicleNo;
    /**
     * 司机ID
     */
    private java.lang.Integer  driverId;
    /**
     * 司机名称
     */
    private java.lang.String   driverName;
    /**
     * 司机电话
     */
    private java.lang.String   driverCell;
    /**
     * 设备号
     */
    private java.lang.String   gpsId;
    private java.lang.String   gpsType;
    /**
     * sim卡号
     */
    private java.lang.String   simNo;
    /**
     * 伪ip
     */
    private java.lang.String   pretendIp;
    private java.lang.String   oilId;
    private java.lang.String   temperatureId;
    private java.lang.String   lcdId;
    private java.lang.String   udpIp;
    private java.lang.Integer  udpPort;
    private java.lang.String   tcpIp;
    private java.lang.Integer  tcpPort;
    private java.lang.String   smsNo;
    private java.lang.String   version;
    private java.lang.Double   unit;
    private java.lang.String   reporterId;
    private java.util.Date     addDate;
    private java.util.Date     lastModifyDate;
    /**
     * 门磁1
     */
    private java.lang.String   magnetic1;
    /**
     * 门磁2
     */
    private java.lang.String   magnetic2;
    /**
     * 门磁3
     */
    private java.lang.String   magnetic3;
    
    /**
     * 油杆型号
     */
    private java.lang.String   cypoleType;
    /**
     * 油杆数量
     */
    private java.lang.Integer  cypoleNum;
    /**
     * 油杆高度
     */
    private java.lang.Integer  cypoleHeight;
    /**
     * 油箱长度
     */
    private java.lang.Integer  oilboxLength;
    /**
     * 油箱宽度
     */
    private java.lang.Integer  oilboxWidth;
    /**
     * 油箱高度
     */
    private java.lang.Integer  oilboxHeight;
    /**
     * 温度型号
     */
    private java.lang.String   tempType;
    /**
     * 温度个数
     */
    private java.lang.Integer  tempNum;
    /**
     * 冷机型号
     */
    private java.lang.String   refrigeratorType;
    /**
     * 冷机个数
     */
    private java.lang.Integer  refrigeratorNum;
    /**
     * 冷机1
     */
    private java.lang.String   refrigerator1;
    /**
     * 冷机2
     */
    private java.lang.String   refrigerator2;
    /**
     * 门磁型号
     */
    private java.lang.String   doorcontactType;
    /**
     * 门磁个数
     */
    private java.lang.Integer  doorcontactNum;
    /**
     * 摄像头型号
     */
    private java.lang.String   cameraType;
    /**
     * 摄像头个数
     */
    private java.lang.Integer  cameraNum;
    /**
     * 公司编号
     */
    private java.lang.Integer  logisticId;
    /**
     * 公司名称
     */
    private java.lang.String   logisticName;
    /**
     * 车辆类型
     */
    private java.lang.String   vehicleType;
    /**
     * 车辆离线时间间隔
     */
    private java.lang.Integer  offlineTimes;
    /**
     * 电量报警值
     */
    private java.lang.Integer  powerWarning;
    private java.lang.String   vehicleStyle;
    /**
     * SIM 真实卡号
     */
    private java.lang.String   realSimNo;
    /**
     * 通道上限（T1）
     */
    private java.lang.String   passwayup;
    /**
     * 通道下限（T1）
     */
    private java.lang.String   passwaydown;
    /**
     * 采集间隔（T1）
     */
    private java.lang.String   sampleinterval;
    /**
     * 通讯间隔（T1）
     */
    private java.lang.String   talkinterval;
    /**
     * 采集开关（T1）
     */
    private java.lang.String   samplekey;
    /**
     * 按键开关（T1）
     */
    private java.lang.String   onkey;
    /**
     * 清除数据开关（T1）
     */
    private java.lang.String   cleardata;
    private java.lang.String   humUp;
    private java.lang.String   humDown;
    private java.lang.String   humFlag;
    
    private java.lang.Integer  heartInterval;
    private java.lang.Integer  positionStrategy;
    private java.lang.Integer  dormancyInterval;
    /**
     * 回传时间间隔
     */
    private java.lang.Integer  defaultInterval;
    private java.lang.Integer  defaultDistance;
    private java.lang.Integer  dormancyDistance;
    private java.lang.Integer  maxSpeed;
    private java.lang.Integer  speedDuration;
    private java.lang.Integer  continuousDriver;
    private java.lang.Integer  dayContinuoustime;
    private java.lang.Integer  minRest;
    private java.lang.Integer  maxStop;
    private java.lang.Integer  mileAge;
    private java.lang.Integer  provinceId;
    private java.lang.Integer  cityId;
    private java.lang.String   plateColor;
    private java.lang.String   positionMode;
    /**
     * 软件版本
     */
    // @NotBlank(message = "bsVehicleConfigInfo.softVersion.NotBlank")
    private java.lang.String   softVersion;
    /**
     * 硬件版本
     */
    // @NotBlank(message = "bsVehicleConfigInfo.hardwareVersion.NotBlank")
    private java.lang.String   hardwareVersion;
    /**
     * 车辆类型（11：12吨以下货车，12：12吨及以上货车，2：客车，3：轿车）
     */
    private java.lang.String   carType;
    /**
     * 油杆2高度
     */
    private java.lang.Integer  cypoleHeight2;
    /**
     * 油箱2长度
     */
    private java.lang.Integer  oilboxLength2;
    /**
     * 油箱2宽度
     */
    private java.lang.Integer  oilboxWidth2;
    /**
     * 油箱2高度
     */
    private java.lang.Integer  oilboxHeight2;
    /**
     * 油杆2型号
     */
    private java.lang.String   cypoleType2;
    /**
     * 邮箱一体积
     */
    private java.lang.Integer  oilboxVolume;
    /**
     * 油箱二体积
     */
    private java.lang.Integer  oilboxVolume2;
    /**
     * 理论油耗
     */
    private java.lang.Double   oilConsumption;
    /**
     * 车辆外设
     */
    private java.lang.String   vehicleModel;
    /**
     * 车辆品牌
     */
    private java.lang.String   vehicleBrand;
    /**
     * 购车时间
     */
    private java.lang.String   buyDate;
    /**
     * 发动机号
     */
    private java.lang.String   engineNum;
    /**
     * 车辆产权
     */
    private java.lang.String   propertyRight;
    /**
     * 拖架编号
     */
    private java.lang.String   trailerNum;
    /**
     * 载重
     */
    private java.lang.Double   loadWeight;
    /**
     * gps设备温度数据保存间隔，单位秒
     */
    private java.lang.Integer  tempInterval;
    /**
     * 转入公司
     */
    private java.lang.String   transferredCompany;
    /**
     * T1T2行程操作标志,1开0关
     */
    private java.lang.Integer  tTravelFlag;
    /**
     * T1T2精度开关,1开0关
     */
    private java.lang.Integer  tAccuracyFlag;
    /**
     * ERP安装单号
     */
    private java.lang.String   mountNumber;
    /*
     * ERP报价单号
     */
    private java.lang.String   erpPriceNo;
    
    private java.util.Date     serviceEndTime;
    
    
    /**
     * @return the erpPriceNo
     */
    public java.lang.String getErpPriceNo() {
        return erpPriceNo;
    }
    
    
    /**
     * @param erpPriceNo
     *            the erpPriceNo to set
     */
    public void setErpPriceNo(java.lang.String erpPriceNo) {
        this.erpPriceNo = erpPriceNo;
    }
    
    
    public java.util.Date getLastModifyDate() {
        return lastModifyDate;
    }
    
    
    public void setLastModifyDate(java.util.Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
    
    
    /**
     * @return the mountNumber
     */
    public java.lang.String getMountNumber() {
        return mountNumber;
    }
    
    
    /**
     * @param mountNumber
     *            the mountNumber to set
     */
    public void setMountNumber(java.lang.String mountNumber) {
        this.mountNumber = mountNumber;
    }
    
    
    /**
     * @return the addDate
     */
    public java.util.Date getAddDate() {
        return addDate;
    }
    
    
    public java.lang.Integer gettTravelFlag() {
        return tTravelFlag;
    }
    
    
    public void settTravelFlag(java.lang.Integer tTravelFlag) {
        this.tTravelFlag = tTravelFlag;
    }
    
    
    public java.lang.Integer gettAccuracyFlag() {
        return tAccuracyFlag;
    }
    
    
    public void settAccuracyFlag(java.lang.Integer tAccuracyFlag) {
        this.tAccuracyFlag = tAccuracyFlag;
    }
    
    
    /**
     * @param addDate
     *            the addDate to set
     */
    public void setAddDate(java.util.Date addDate) {
        this.addDate = addDate;
    }
    
    
    public java.lang.Integer getMileAge() {
        return mileAge;
    }
    
    
    public void setMileAge(java.lang.Integer mileAge) {
        this.mileAge = mileAge;
    }
    
    
    public java.lang.Integer getVehicleId() {
        return vehicleId;
    }
    
    
    public java.lang.Integer getTempInterval() {
        return tempInterval;
    }
    
    
    public java.lang.String getRefrigerator1() {
        return refrigerator1;
    }
    
    
    public void setRefrigerator1(java.lang.String refrigerator1) {
        this.refrigerator1 = refrigerator1;
    }
    
    
    public java.lang.String getRefrigerator2() {
        return refrigerator2;
    }
    
    
    public void setRefrigerator2(java.lang.String refrigerator2) {
        this.refrigerator2 = refrigerator2;
    }
    
    
    public void setTempInterval(java.lang.Integer tempInterval) {
        this.tempInterval = tempInterval;
    }
    
    
    public java.lang.String getTransferredCompany() {
        return transferredCompany;
    }
    
    
    public void setTransferredCompany(java.lang.String transferredCompany) {
        this.transferredCompany = transferredCompany;
    }
    
    
    public void setVehicleId(java.lang.Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    
    /**
     * set vehicleNo:车牌号
     */
    
    public java.lang.String getVehicleNo() {
        return vehicleNo;
    }
    
    
    public void setVehicleNo(java.lang.String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    
    
    /**
     * set driverId:司机ID
     */
    
    public java.lang.Integer getDriverId() {
        return driverId;
    }
    
    
    public void setDriverId(java.lang.Integer driverId) {
        this.driverId = driverId;
    }
    
    
    /**
     * set driverName:司机名称
     */
    
    public java.lang.String getDriverName() {
        return driverName;
    }
    
    
    public void setDriverName(java.lang.String driverName) {
        this.driverName = driverName;
    }
    
    
    /**
     * set driverCell:司机电话
     */
    
    public java.lang.String getDriverCell() {
        return driverCell;
    }
    
    
    public void setDriverCell(java.lang.String driverCell) {
        this.driverCell = driverCell;
    }
    
    
    /**
     * set gpsId:设备号
     */
    
    public java.lang.String getGpsId() {
        return gpsId;
    }
    
    
    public void setGpsId(java.lang.String gpsId) {
        this.gpsId = gpsId;
    }
    
    
    public java.lang.String getGpsType() {
        return gpsType;
    }
    
    
    public void setGpsType(java.lang.String gpsType) {
        this.gpsType = gpsType;
    }
    
    
    /**
     * set simNo:sim卡号
     */
    
    public java.lang.String getSimNo() {
        return simNo;
    }
    
    
    public void setSimNo(java.lang.String simNo) {
        this.simNo = simNo;
    }
    
    
    /**
     * set pretendIp:伪ip
     */
    
    public java.lang.String getPretendIp() {
        return pretendIp;
    }
    
    
    public void setPretendIp(java.lang.String pretendIp) {
        this.pretendIp = pretendIp;
    }
    
    
    public java.lang.String getOilId() {
        return oilId;
    }
    
    
    public void setOilId(java.lang.String oilId) {
        this.oilId = oilId;
    }
    
    
    public java.lang.String getTemperatureId() {
        return temperatureId;
    }
    
    
    public void setTemperatureId(java.lang.String temperatureId) {
        this.temperatureId = temperatureId;
    }
    
    
    public java.lang.String getLcdId() {
        return lcdId;
    }
    
    
    public void setLcdId(java.lang.String lcdId) {
        this.lcdId = lcdId;
    }
    
    
    public java.lang.String getUdpIp() {
        return udpIp;
    }
    
    
    public void setUdpIp(java.lang.String udpIp) {
        this.udpIp = udpIp;
    }
    
    
    public java.lang.Integer getUdpPort() {
        return udpPort;
    }
    
    
    public void setUdpPort(java.lang.Integer udpPort) {
        this.udpPort = udpPort;
    }
    
    
    public java.lang.String getTcpIp() {
        return tcpIp;
    }
    
    
    public void setTcpIp(java.lang.String tcpIp) {
        this.tcpIp = tcpIp;
    }
    
    
    public java.lang.Integer getTcpPort() {
        return tcpPort;
    }
    
    
    public void setTcpPort(java.lang.Integer tcpPort) {
        this.tcpPort = tcpPort;
    }
    
    
    public java.lang.String getSmsNo() {
        return smsNo;
    }
    
    
    public void setSmsNo(java.lang.String smsNo) {
        this.smsNo = smsNo;
    }
    
    
    public java.lang.String getVersion() {
        return version;
    }
    
    
    public void setVersion(java.lang.String version) {
        this.version = version;
    }
    
    
    public Double getUnit() {
        return unit;
    }
    
    
    public void setUnit(Double unit) {
        this.unit = unit;
    }
    
    
    public java.lang.String getReporterId() {
        return reporterId;
    }
    
    
    public void setReporterId(java.lang.String reporterId) {
        this.reporterId = reporterId;
    }
    
    
    public java.lang.String getMagnetic2() {
        return magnetic2;
    }
    
    
    public void setMagnetic2(java.lang.String magnetic2) {
        this.magnetic2 = magnetic2;
    }
    
    
    public java.lang.String getMagnetic1() {
        return magnetic1;
    }
    
    
    public void setMagnetic1(java.lang.String magnetic1) {
        this.magnetic1 = magnetic1;
    }
    
    
    public java.lang.String getMagnetic3() {
        return magnetic3;
    }
    
    
    public void setMagnetic3(java.lang.String magnetic3) {
        this.magnetic3 = magnetic3;
    }
    
    
    /**
     * set cypoleType:油杆型号
     */
    
    public java.lang.String getCypoleType() {
        return cypoleType;
    }
    
    
    public void setCypoleType(java.lang.String cypoleType) {
        this.cypoleType = cypoleType;
    }
    
    
    /**
     * set cypoleNum:油杆数量
     */
    
    public java.lang.Integer getCypoleNum() {
        return cypoleNum;
    }
    
    
    public void setCypoleNum(java.lang.Integer cypoleNum) {
        this.cypoleNum = cypoleNum;
    }
    
    
    /**
     * set cypoleHeight:油杆高度
     */
    
    public java.lang.Integer getCypoleHeight() {
        return cypoleHeight;
    }
    
    
    public void setCypoleHeight(java.lang.Integer cypoleHeight) {
        this.cypoleHeight = cypoleHeight;
    }
    
    
    /**
     * set oilboxLength:油箱长度
     */
    
    public java.lang.Integer getOilboxLength() {
        return oilboxLength;
    }
    
    
    public void setOilboxLength(java.lang.Integer oilboxLength) {
        this.oilboxLength = oilboxLength;
    }
    
    
    /**
     * set oilboxWidth:油箱宽度
     */
    
    public java.lang.Integer getOilboxWidth() {
        return oilboxWidth;
    }
    
    
    public void setOilboxWidth(java.lang.Integer oilboxWidth) {
        this.oilboxWidth = oilboxWidth;
    }
    
    
    /**
     * set oilboxHeight:油箱高度
     */
    
    public java.lang.Integer getOilboxHeight() {
        return oilboxHeight;
    }
    
    
    public void setOilboxHeight(java.lang.Integer oilboxHeight) {
        this.oilboxHeight = oilboxHeight;
    }
    
    
    /**
     * set tempType:温度型号
     */
    
    public java.lang.String getTempType() {
        return tempType;
    }
    
    
    public void setTempType(java.lang.String tempType) {
        this.tempType = tempType;
    }
    
    
    /**
     * set tempNum:温度个数
     */
    
    public java.lang.Integer getTempNum() {
        return tempNum;
    }
    
    
    public void setTempNum(java.lang.Integer tempNum) {
        this.tempNum = tempNum;
    }
    
    
    /**
     * set refrigeratorType:冷机型号
     */
    
    public java.lang.String getRefrigeratorType() {
        return refrigeratorType;
    }
    
    
    public void setRefrigeratorType(java.lang.String refrigeratorType) {
        this.refrigeratorType = refrigeratorType;
    }
    
    
    /**
     * set refrigeratorNum:冷机个数
     */
    
    public java.lang.Integer getRefrigeratorNum() {
        return refrigeratorNum;
    }
    
    
    public void setRefrigeratorNum(java.lang.Integer refrigeratorNum) {
        this.refrigeratorNum = refrigeratorNum;
    }
    
    
    /**
     * set doorcontactType:门磁型号
     */
    
    public java.lang.String getDoorcontactType() {
        return doorcontactType;
    }
    
    
    public void setDoorcontactType(java.lang.String doorcontactType) {
        this.doorcontactType = doorcontactType;
    }
    
    
    /**
     * set doorcontactNum:门磁个数
     */
    
    public java.lang.Integer getDoorcontactNum() {
        return doorcontactNum;
    }
    
    
    public void setDoorcontactNum(java.lang.Integer doorcontactNum) {
        this.doorcontactNum = doorcontactNum;
    }
    
    
    /**
     * set cameraType:摄像头型号
     */
    
    public java.lang.String getCameraType() {
        return cameraType;
    }
    
    
    public void setCameraType(java.lang.String cameraType) {
        this.cameraType = cameraType;
    }
    
    
    /**
     * set cameraNum:摄像头个数
     */
    
    public java.lang.Integer getCameraNum() {
        return cameraNum;
    }
    
    
    public void setCameraNum(java.lang.Integer cameraNum) {
        this.cameraNum = cameraNum;
    }
    
    
    /**
     * set logisticId:公司编号
     */
    
    public java.lang.Integer getLogisticId() {
        return logisticId;
    }
    
    
    public void setLogisticId(java.lang.Integer logisticId) {
        this.logisticId = logisticId;
    }
    
    
    /**
     * set logisticName:公司名称
     */
    
    public java.lang.String getLogisticName() {
        return logisticName;
    }
    
    
    public void setLogisticName(java.lang.String logisticName) {
        this.logisticName = logisticName;
    }
    
    
    /**
     * set vehicleType:车辆类型
     */
    
    public java.lang.String getVehicleType() {
        return vehicleType;
    }
    
    
    public void setVehicleType(java.lang.String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
    /**
     * set offlineTimes:车辆离线时间间隔
     */
    
    public java.lang.Integer getOfflineTimes() {
        return offlineTimes;
    }
    
    
    public void setOfflineTimes(java.lang.Integer offlineTimes) {
        this.offlineTimes = offlineTimes;
    }
    
    
    /**
     * set powerWarning:电量报警值
     */
    
    public java.lang.Integer getPowerWarning() {
        return powerWarning;
    }
    
    
    public void setPowerWarning(java.lang.Integer powerWarning) {
        this.powerWarning = powerWarning;
    }
    
    
    public java.lang.String getVehicleStyle() {
        return vehicleStyle;
    }
    
    
    public void setVehicleStyle(java.lang.String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }
    
    
    /**
     * set realSimNo:SIM 真实卡号
     */
    
    public java.lang.String getRealSimNo() {
        return realSimNo;
    }
    
    
    public void setRealSimNo(java.lang.String realSimNo) {
        this.realSimNo = realSimNo;
    }
    
    
    /**
     * set passwayup:通道上限（T1）
     */
    
    public java.lang.String getPasswayup() {
        return passwayup;
    }
    
    
    public void setPasswayup(java.lang.String passwayup) {
        this.passwayup = passwayup;
    }
    
    
    /**
     * set passwaydown:通道下限（T1）
     */
    
    public java.lang.String getPasswaydown() {
        return passwaydown;
    }
    
    
    public void setPasswaydown(java.lang.String passwaydown) {
        this.passwaydown = passwaydown;
    }
    
    
    /**
     * set sampleinterval:采集间隔（T1）
     */
    
    public java.lang.String getSampleinterval() {
        return sampleinterval;
    }
    
    
    public void setSampleinterval(java.lang.String sampleinterval) {
        this.sampleinterval = sampleinterval;
    }
    
    
    /**
     * set talkinterval:通讯间隔（T1）
     */
    
    public java.lang.String getTalkinterval() {
        return talkinterval;
    }
    
    
    public void setTalkinterval(java.lang.String talkinterval) {
        this.talkinterval = talkinterval;
    }
    
    
    /**
     * set samplekey:采集开关（T1）
     */
    
    public java.lang.String getSamplekey() {
        return samplekey;
    }
    
    
    public void setSamplekey(java.lang.String samplekey) {
        this.samplekey = samplekey;
    }
    
    
    /**
     * set onkey:按键开关（T1）
     */
    
    public java.lang.String getOnkey() {
        return onkey;
    }
    
    
    public void setOnkey(java.lang.String onkey) {
        this.onkey = onkey;
    }
    
    
    /**
     * set cleardata:清除数据开关（T1）
     */
    
    public java.lang.String getCleardata() {
        return cleardata;
    }
    
    
    public void setCleardata(java.lang.String cleardata) {
        this.cleardata = cleardata;
    }
    
    
    public java.lang.Integer getHeartInterval() {
        return heartInterval;
    }
    
    
    public void setHeartInterval(java.lang.Integer heartInterval) {
        this.heartInterval = heartInterval;
    }
    
    
    public java.lang.Integer getPositionStrategy() {
        return positionStrategy;
    }
    
    
    public void setPositionStrategy(java.lang.Integer positionStrategy) {
        this.positionStrategy = positionStrategy;
    }
    
    
    public java.lang.Integer getDormancyInterval() {
        return dormancyInterval;
    }
    
    
    public void setDormancyInterval(java.lang.Integer dormancyInterval) {
        this.dormancyInterval = dormancyInterval;
    }
    
    
    public java.lang.Integer getDefaultInterval() {
        return defaultInterval;
    }
    
    
    public void setDefaultInterval(java.lang.Integer defaultInterval) {
        this.defaultInterval = defaultInterval;
    }
    
    
    public java.lang.Integer getDefaultDistance() {
        return defaultDistance;
    }
    
    
    public void setDefaultDistance(java.lang.Integer defaultDistance) {
        this.defaultDistance = defaultDistance;
    }
    
    
    public java.lang.Integer getDormancyDistance() {
        return dormancyDistance;
    }
    
    
    public void setDormancyDistance(java.lang.Integer dormancyDistance) {
        this.dormancyDistance = dormancyDistance;
    }
    
    
    public java.lang.Integer getMaxSpeed() {
        return maxSpeed;
    }
    
    
    public void setMaxSpeed(java.lang.Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    
    public java.lang.Integer getSpeedDuration() {
        return speedDuration;
    }
    
    
    public void setSpeedDuration(java.lang.Integer speedDuration) {
        this.speedDuration = speedDuration;
    }
    
    
    public java.lang.Integer getContinuousDriver() {
        return continuousDriver;
    }
    
    
    public void setContinuousDriver(java.lang.Integer continuousDriver) {
        this.continuousDriver = continuousDriver;
    }
    
    
    public java.lang.Integer getDayContinuoustime() {
        return dayContinuoustime;
    }
    
    
    public void setDayContinuoustime(java.lang.Integer dayContinuoustime) {
        this.dayContinuoustime = dayContinuoustime;
    }
    
    
    public java.lang.Integer getMinRest() {
        return minRest;
    }
    
    
    public void setMinRest(java.lang.Integer minRest) {
        this.minRest = minRest;
    }
    
    
    public java.lang.Integer getMaxStop() {
        return maxStop;
    }
    
    
    public void setMaxStop(java.lang.Integer maxStop) {
        this.maxStop = maxStop;
    }
    
    
    public java.lang.Integer getProvinceId() {
        return provinceId;
    }
    
    
    public void setProvinceId(java.lang.Integer provinceId) {
        this.provinceId = provinceId;
    }
    
    
    public java.lang.Integer getCityId() {
        return cityId;
    }
    
    
    public void setCityId(java.lang.Integer cityId) {
        this.cityId = cityId;
    }
    
    
    public java.lang.String getPlateColor() {
        return plateColor;
    }
    
    
    public void setPlateColor(java.lang.String plateColor) {
        this.plateColor = plateColor;
    }
    
    
    public java.lang.String getPositionMode() {
        return positionMode;
    }
    
    
    public void setPositionMode(java.lang.String positionMode) {
        this.positionMode = positionMode;
    }
    
    
    /**
     * set softVersion:软件版本
     */
    
    public java.lang.String getSoftVersion() {
        return softVersion;
    }
    
    
    public void setSoftVersion(java.lang.String softVersion) {
        this.softVersion = softVersion;
    }
    
    
    /**
     * set hardwareVersion:硬件版本
     */
    
    public java.lang.String getHardwareVersion() {
        return hardwareVersion;
    }
    
    
    public void setHardwareVersion(java.lang.String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }
    
    
    /**
     * set carType:车辆类型（11：12吨以下货车，12：12吨及以上货车，2：客车，3：轿车）
     */
    
    public java.lang.String getCarType() {
        return carType;
    }
    
    
    public void setCarType(java.lang.String carType) {
        this.carType = carType;
    }
    
    
    /**
     * set cypoleHeight2:油杆2高度
     */
    
    public java.lang.Integer getCypoleHeight2() {
        return cypoleHeight2;
    }
    
    
    public void setCypoleHeight2(java.lang.Integer cypoleHeight2) {
        this.cypoleHeight2 = cypoleHeight2;
    }
    
    
    /**
     * set oilboxLength2:油箱2长度
     */
    
    public java.lang.Integer getOilboxLength2() {
        return oilboxLength2;
    }
    
    
    public void setOilboxLength2(java.lang.Integer oilboxLength2) {
        this.oilboxLength2 = oilboxLength2;
    }
    
    
    /**
     * set oilboxWidth2:油箱2宽度
     */
    
    public java.lang.Integer getOilboxWidth2() {
        return oilboxWidth2;
    }
    
    
    public void setOilboxWidth2(java.lang.Integer oilboxWidth2) {
        this.oilboxWidth2 = oilboxWidth2;
    }
    
    
    /**
     * set oilboxHeight2:油箱2高度
     */
    
    public java.lang.Integer getOilboxHeight2() {
        return oilboxHeight2;
    }
    
    
    public void setOilboxHeight2(java.lang.Integer oilboxHeight2) {
        this.oilboxHeight2 = oilboxHeight2;
    }
    
    
    /**
     * set cypoleType2:油杆2型号
     */
    
    public java.lang.String getCypoleType2() {
        return cypoleType2;
    }
    
    
    public void setCypoleType2(java.lang.String cypoleType2) {
        this.cypoleType2 = cypoleType2;
    }
    
    
    public java.lang.Integer getOilboxVolume() {
        return oilboxVolume;
    }
    
    
    public void setOilboxVolume(java.lang.Integer oilboxVolume) {
        this.oilboxVolume = oilboxVolume;
    }
    
    
    public java.lang.Integer getOilboxVolume2() {
        return oilboxVolume2;
    }
    
    
    public void setOilboxVolume2(java.lang.Integer oilboxVolume2) {
        this.oilboxVolume2 = oilboxVolume2;
    }
    
    
    public java.lang.Double getOilConsumption() {
        return oilConsumption;
    }
    
    
    public void setOilConsumption(java.lang.Double oilConsumption) {
        this.oilConsumption = oilConsumption;
    }
    
    
    public java.lang.String getVehicleModel() {
        return vehicleModel;
    }
    
    
    public void setVehicleModel(java.lang.String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    
    public java.lang.String getBuyDate() {
        return buyDate;
    }
    
    
    public void setBuyDate(java.lang.String buyDate) {
        this.buyDate = buyDate;
    }
    
    
    public java.lang.String getEngineNum() {
        return engineNum;
    }
    
    
    public void setEngineNum(java.lang.String engineNum) {
        this.engineNum = engineNum;
    }
    
    
    public java.lang.String getPropertyRight() {
        return propertyRight;
    }
    
    
    public void setPropertyRight(java.lang.String propertyRight) {
        this.propertyRight = propertyRight;
    }
    
    
    public java.lang.String getTrailerNum() {
        return trailerNum;
    }
    
    
    public void setTrailerNum(java.lang.String trailerNum) {
        this.trailerNum = trailerNum;
    }
    
    
    public java.lang.String getVehicleBrand() {
        return vehicleBrand;
    }
    
    
    public void setVehicleBrand(java.lang.String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
    
    
    public java.lang.Double getLoadWeight() {
        return loadWeight;
    }
    
    
    public void setLoadWeight(java.lang.Double loadWeight) {
        this.loadWeight = loadWeight;
    }
    
    
    /**
     * @return the humUp
     */
    public java.lang.String getHumUp() {
        return humUp;
    }
    
    
    /**
     * @param humUp
     *            the humUp to set
     */
    public void setHumUp(java.lang.String humUp) {
        this.humUp = humUp;
    }
    
    
    /**
     * @return the humDown
     */
    public java.lang.String getHumDown() {
        return humDown;
    }
    
    
    /**
     * @param humDown
     *            the humDown to set
     */
    public void setHumDown(java.lang.String humDown) {
        this.humDown = humDown;
    }
    
    
    /**
     * @return the humFlag
     */
    public java.lang.String getHumFlag() {
        return humFlag;
    }
    
    
    /**
     * @param humFlag
     *            the humFlag to set
     */
    public void setHumFlag(java.lang.String humFlag) {
        this.humFlag = humFlag;
    }
    
    
    public java.util.Date getServiceEndTime() {
        return serviceEndTime;
    }
    
    
    public void setServiceEndTime(java.util.Date serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }
    
    
    @Override
    public String toString() {
        return "BsVehicleConfigInfo [vehicleId=" + vehicleId + ", vehicleNo=" + vehicleNo + ", driverId=" + driverId
                + ", driverName=" + driverName + ", driverCell=" + driverCell + ", gpsId=" + gpsId + ", gpsType="
                + gpsType + ", simNo=" + simNo + ", pretendIp=" + pretendIp + ", oilId=" + oilId + ", temperatureId="
                + temperatureId + ", lcdId=" + lcdId + ", udpIp=" + udpIp + ", udpPort=" + udpPort + ", tcpIp=" + tcpIp
                + ", tcpPort=" + tcpPort + ", smsNo=" + smsNo + ", version=" + version + ", unit=" + unit
                + ", reporterId=" + reporterId + ", addDate=" + addDate + ", lastModifyDate=" + lastModifyDate
                + ", magnetic1=" + magnetic1 + ", magnetic2=" + magnetic2 + ", magnetic3=" + magnetic3
                + ", cypoleType=" + cypoleType + ", cypoleNum=" + cypoleNum + ", cypoleHeight=" + cypoleHeight
                + ", oilboxLength=" + oilboxLength + ", oilboxWidth=" + oilboxWidth + ", oilboxHeight=" + oilboxHeight
                + ", tempType=" + tempType + ", tempNum=" + tempNum + ", refrigeratorType=" + refrigeratorType
                + ", refrigeratorNum=" + refrigeratorNum + ", refrigerator1=" + refrigerator1 + ", refrigerator2="
                + refrigerator2 + ", doorcontactType=" + doorcontactType + ", doorcontactNum=" + doorcontactNum
                + ", cameraType=" + cameraType + ", cameraNum=" + cameraNum + ", logisticId=" + logisticId
                + ", logisticName=" + logisticName + ", vehicleType=" + vehicleType + ", offlineTimes=" + offlineTimes
                + ", powerWarning=" + powerWarning + ", vehicleStyle=" + vehicleStyle + ", realSimNo=" + realSimNo
                + ", passwayup=" + passwayup + ", passwaydown=" + passwaydown + ", sampleinterval=" + sampleinterval
                + ", talkinterval=" + talkinterval + ", samplekey=" + samplekey + ", onkey=" + onkey + ", cleardata="
                + cleardata + ", humUp=" + humUp + ", humDown=" + humDown + ", humFlag=" + humFlag + ", heartInterval="
                + heartInterval + ", positionStrategy=" + positionStrategy + ", dormancyInterval=" + dormancyInterval
                + ", defaultInterval=" + defaultInterval + ", defaultDistance=" + defaultDistance
                + ", dormancyDistance=" + dormancyDistance + ", maxSpeed=" + maxSpeed + ", speedDuration="
                + speedDuration + ", continuousDriver=" + continuousDriver + ", dayContinuoustime=" + dayContinuoustime
                + ", minRest=" + minRest + ", maxStop=" + maxStop + ", mileAge=" + mileAge + ", provinceId="
                + provinceId + ", cityId=" + cityId + ", plateColor=" + plateColor + ", positionMode=" + positionMode
                + ", softVersion=" + softVersion + ", hardwareVersion=" + hardwareVersion + ", carType=" + carType
                + ", cypoleHeight2=" + cypoleHeight2 + ", oilboxLength2=" + oilboxLength2 + ", oilboxWidth2="
                + oilboxWidth2 + ", oilboxHeight2=" + oilboxHeight2 + ", cypoleType2=" + cypoleType2
                + ", oilboxVolume=" + oilboxVolume + ", oilboxVolume2=" + oilboxVolume2 + ", oilConsumption="
                + oilConsumption + ", vehicleModel=" + vehicleModel + ", vehicleBrand=" + vehicleBrand + ", buyDate="
                + buyDate + ", engineNum=" + engineNum + ", propertyRight=" + propertyRight + ", trailerNum="
                + trailerNum + ", loadWeight=" + loadWeight + ", tempInterval=" + tempInterval
                + ", transferredCompany=" + transferredCompany + ", tTravelFlag=" + tTravelFlag + ", tAccuracyFlag="
                + tAccuracyFlag + ", mountNumber=" + mountNumber + ", erpPriceNo=" + erpPriceNo + ", serviceEndTime="
                + serviceEndTime + "]";
    }
    
}
