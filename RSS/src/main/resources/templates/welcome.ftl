<!DOCTYPE html>

<html lang="en">

<body>
    <table style="text-align:left">
      <th>
        <td>车牌</td>
        <td>设备号</td>
        <td>卡号</td>
        <td>IP</td>
        <td>真实卡号</td>
        <td>公司名称</td>
      </th>
      <tr>
        <td>${vehicle.vehicleNo}</td>
        <td>${vehicle.gpsId}</td>
        <td>${vehicle.simNo}</td>
        <td>${vehicle.pretendIp}</td>
        <td>${vehicle.realSimNo}</td>
        <td>${vehicle.logisticName}</td>
      </tr>
    </table>
</body>

</html>