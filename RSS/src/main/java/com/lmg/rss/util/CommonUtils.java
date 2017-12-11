package com.lmg.rss.util;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * *********************************
 * 
 * @ClassName: CommonUtils.java
 * @Description: 通用类
 * @author: luomingguo
 * @createdAt: 2014年9月30日上午10:37:09
 ********************************** 
 */
public class CommonUtils {
    
    public final static String            COMMON_DATE_PATTERN = "yyyy-MM-dd";
    public static final SimpleDateFormat  dateFormat          = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat  dateFormat1         = new SimpleDateFormat(COMMON_DATE_PATTERN);
    public static final SimpleDateFormat  timeFormat          = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static final SimpleDateFormat sdf                 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DecimalFormat    df                  = new DecimalFormat("0.0");
    private static final DecimalFormat    df2                 = new DecimalFormat("0.00");
    private static Logger                 logger              = LoggerFactory.getLogger(CommonUtils.class);
    
    
    /**
     * 
     * @Title: pagingParam
     * @Description: 生成分页的map
     * @param param
     *            接收分页的Map
     * @param page
     *            页码
     * @param row
     *            页数
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static void pagingParam(Map<String, Object> param, Integer page, Integer row) {
        pagingParam(param, page, row, "id", Constants.SORT_DESC);
    }
    
    
    /**
     * 
     * @Title: pagingParam
     * @Description: 生成分页的map
     * @param param
     *            接收分页的Map
     * @param page
     *            页码
     * @param row
     *            页数
     * @param col
     *            排序字段
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static void pagingParam(Map<String, Object> param, Integer page, Integer row, String col) {
        /**
         * 不传参数 默认 根据ID倒序
         */
        pagingParam(param, page, row, col, Constants.SORT_DESC);
        
    }
    
    
    /**
     * 
     * @Title: pagingParam
     * @Description: 生成分页的map
     * @param param
     *            接收分页的Map
     * @param page
     *            页码
     * @param row
     *            页数
     * @param col
     *            排序字段
     * @param sort
     *            排序方式
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static void pagingParam(Map<String, Object> param, Integer page, Integer row, String col, String sort) {
        /**
         * 增加排序参数
         */
        param.put("orderby", "orderby");
        param.put("col", col);
        param.put("sort", sort);
        /**
         * 增加分页参数
         */
        param.put("inPage", "inPage");
        param.put("start", (page - 1) * row);// 从0开始
        param.put("size", row);
        
    }
    
    
    /**
     * 
     * @Title: pagingParam
     * @Description: 生成分页的map
     * @param page
     *            页码
     * @param row
     *            页数
     * @param col
     *            排序字段
     * @param sort
     *            排序方式
     * @return 参数MAP
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static Map<String, Object> pagingParam(Integer page, Integer row, String col, String sort) {
        Map<String, Object> param = new HashMap<String, Object>();
        pagingParam(param, page, row, col, sort);
        return param;
    }
    
    
    /**
     * 
     * @Title: pagingParam
     * @Description: 生成分页的map
     * @param page
     *            页码
     * @param row
     *            页数
     * @param col
     *            排序字段
     * @param sort
     *            排序方式
     * @return 参数MAP
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static Map<String, Object> pagingParam(Integer page, Integer row, String col) {
        Map<String, Object> param = new HashMap<String, Object>();
        pagingParam(param, page, row, col);
        return param;
    }
    
    
    /**
     * 
     * @Title: pagingParam
     * @Description: 生成分页的map
     * @param page
     *            页码
     * @param row
     *            页数
     * @return 参数MAP
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static Map<String, Object> pagingParam(Integer page, Integer row) {
        Map<String, Object> param = new HashMap<String, Object>();
        pagingParam(param, page, row);
        return param;
    }
    
    
    /**
     * 
     * @Title: requestToQueryMap
     * @Description: 参数自动组装MAP 默认ID 倒序
     * @param request
     *            request请求对象
     * @return 参数MAP
     * @Author: luomingguo
     * @Date: 2014年9月30日
     */
    public static Map<String, Object> requestToQueryMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        @SuppressWarnings("rawtypes")
        Enumeration e = request.getParameterNames();
        String page = request.getParameter(Constants.PAGE);
        String row = request.getParameter(Constants.ROW);
        if (StringUtil.isNotBlank(page) && StringUtil.isNotBlank(row)){// /如果获取到
                                                                       // 分页参数
                                                                       // 自动组装
            CommonUtils.pagingParam(map, Integer.parseInt(page), Integer.parseInt(row));
        } else{
            // 默认第一页 显示20条
            if (request.getRequestURI().indexOf("Excel") >= 0 && request.getRequestURI().indexOf("Pdf") >= 0){
                
            } else if (request.getRequestURI().indexOf("/app/") == -1){
                
            } else{
                CommonUtils.pagingParam(map, Integer.parseInt(Constants.PAGE_VALUE), Integer.parseInt(Constants.PAGE_SIZE));
            }
        }
        
        String value;
        while (e.hasMoreElements()){
            Object obj = e.nextElement();
            value = request.getParameter(String.valueOf(obj));
            if (StringUtil.isNotBlank(value) && !"undefined".equals(value)){
                map.put(String.valueOf(obj), value);
            }
        }
        // 排序
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        if (StringUtil.isNotBlank(sort) && StringUtil.isNotBlank(order)){
            String[] sorts = StringUtil.splitIntoArr(sort);
            String[] orders = StringUtil.splitIntoArr(order);
            if (sorts.length == orders.length){
                String orderBy = "";
                for (int i = 0; i < sorts.length; i++){
                    if (!"".equals(orderBy)){
                        orderBy += ",";
                    }
                    orderBy += sorts[i] + " " + orders[i];
                }
                if (!"".equals(orderBy)){
                    map.put("orderBy", orderBy);
                }
            }
        }
        return map;
    }
    
    
    /**
     * 
     * @Title: getRemoteAddress
     * @Description: 根据request得到客户端ip地址
     * @param request
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年9月30日下午1:21:57
     */
    public static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")){
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    
    /**
     * 把Object类型转换成String类型
     * 
     * @param o
     * @return
     */
    public static String obj2Str(Object o) {
        if (o == null){
            return null;
        }
        return o.toString();
    }
    
    
    /**
     * 把Object类型转换成Long类型
     * 
     * @param o
     * @return
     */
    public static Long obj2Long(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        try{
            return Long.valueOf(str);
        } catch (Exception e){
            return null;
        }
    }
    
    
    /**
     * 把Object类型转换成Integer类型
     * 
     * @param o
     * @return
     */
    public static Integer obj2Int(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        try{
            return Integer.valueOf(str);
        } catch (Exception e){
            return null;
        }
    }
    
    
    /**
     * 把Object类型转换成Boolean类型
     * 
     * @param o
     * @return
     */
    public static boolean obj2Bool(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return false;
        }
        return Boolean.parseBoolean(str);
    }
    
    
    /**
     * 把Object类型转换成Double类型
     * 
     * @param o
     * @return
     */
    public static Double obj2Double(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        try{
            return Double.valueOf(str);
        } catch (Exception e){
            return null;
        }
    }
    
    
    /**
     * 把Object类型转换成Float类型
     * 
     * @param o
     * @return
     */
    public static Float obj2Float(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        try{
            return Float.valueOf(str);
        } catch (Exception e){
            return null;
        }
    }
    
    
    /**
     * 把Object类型转换成Date类型
     * 
     * @param o
     * @return
     */
    public static Date obj2Date(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        try{
            return sdf.parse(str);
        } catch (Exception e){
            return null;
        }
    }
    
    
    /**
     * 把Object类型转换成Date类型
     * 
     * @param o
     * @return
     */
    public static Date obj2Date(Object o, String formatter) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        try{
            DateFormat sdf = new SimpleDateFormat(formatter);
            return sdf.parse(str);
        } catch (Exception e){
            return null;
        }
    }
    
    
    public static Timestamp toTimestamp(Object o) {
        String str = obj2Str(o);
        if (str == null){
            return null;
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try{
            ts = Timestamp.valueOf(str);
            return ts;
        } catch (Exception e){
            return null;
        }
    }
    
    
    public static String dataFormat(Date date, String formatter) {
        if (date == null){
            return null;
        }
        try{
            DateFormat sdf = new SimpleDateFormat(formatter);
            return sdf.format(date);
        } catch (Exception e){
            return null;
        }
    }
    
    
    public static String dataFormat(Date date) {
        return dataFormat(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    
    public static Map<String, Object> updateMap(Map<String, Object> map, String removeKey, String putValue) {
        return updateMap(map, removeKey, removeKey, putValue);
    }
    
    
    public static Map<String, Object> updateMap(Map<String, Object> map, String removeKey, String putKey,
            String putValue) {
        if (map.containsKey(removeKey)){
            map.remove(removeKey);
        }
        map.put(putKey, putValue);
        return map;
    }
    
    
    public static RowBounds getRowBounds(Map<String, Object> param) {
        int start = 0;
        int size = 15;
        if (!param.containsKey("start")){
            param.put("start", start);
        }
        if (!param.containsKey("size")){
            param.put("size", size);
        }
        return new RowBounds(Integer.valueOf(param.get("start").toString()),
                Integer.valueOf(param.get("size").toString()));
    }
    
    
    /**
     * 
     * @Title: getRandColor
     * @Description: 给定范围获得随机颜色
     * @param fc
     * @param bc
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年11月13日下午1:54:31
     */
    public static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    
    
    public static Map<String, Object> updateMap(Map<String, Object> map, String removeKey, Object t) {
        return updateMap(map, removeKey, removeKey, t);
    }
    
    
    public static Map<String, Object> updateMap(Map<String, Object> map, String removeKey, String putKey, Object t) {
        if (map.containsKey(removeKey)){
            map.remove(removeKey);
        }
        map.put(putKey, t);
        return map;
    }
    
    
    /**
     * 给定一组字符串，替换其中的字符
     * 
     * @param sourceString
     * @param oldChar
     * @param newChar
     * @return
     */
    public static String replaceString(String sourceString, String oldChar, String newChar) {
        if (StringUtil.isNotBlank(sourceString)){
            try{
                if (sourceString.contains(oldChar)){
                    sourceString = sourceString.replace(oldChar, newChar);
                }
                return sourceString;
            } catch (Exception e){
                return "";
            }
        }
        return "";
    }
    
    
    public static String replaceString(String sourceString, String[] oldChar, String newChar) {
        if (StringUtil.isNotBlank(sourceString)){
            for (String string : oldChar){
                try{
                    if (sourceString.contains(string)){
                        sourceString = sourceString.replace(string, newChar);
                    }
                } catch (Exception e){
                    return "";
                }
            }
            return sourceString;
        }
        return "";
    }
    
    
    /**
     * 
     * @Title: getScale
     * @Description: 保留小数位
     * @param d
     * @param scale
     *            小数位数
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年11月30日下午4:39:34
     */
    public static double getScale(Double d, int scale) {
        if (d == null){
            return 0;
        }
        return new BigDecimal(d).setScale(scale, RoundingMode.UP).doubleValue();
    }
    
    
    /**
     * 
     * @Title: getStackTrace
     * @Description: 返回异常信息
     * @param e
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年12月3日下午4:33:23
     */
    public static String getStackTrace(Exception e) {
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer, true));
        
        return writer.toString();
    }
    
    
    /**
     * 
     * @Title: inRect
     * @Description: 判断点是否在矩形内
     * @param leftTop
     *            矩形左上角点（x,y)
     * @param rightBot
     *            矩形右下角点（x,y)
     * @param x
     *            点x
     * @param y
     *            点y
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年12月16日下午1:17:25
     */
    public static boolean inRect(String leftTop, String rightBot, String x, String y) {
        if (StringUtil.isBlank(leftTop) || StringUtil.isBlank(rightBot) || StringUtil.isBlank(x)
                || StringUtil.isBlank(y)){
            return false;
        }
        String[] lts = leftTop.split(Constants.COMMA);
        String[] rbs = rightBot.split(Constants.COMMA);
        if (lts.length != 2 || rbs.length != 2){
            return false;
        }
        double ltxd = Double.parseDouble(lts[0]);
        double ltyd = Double.parseDouble(lts[1]);
        double rbxd = Double.parseDouble(rbs[0]);
        double rbyd = Double.parseDouble(rbs[1]);
        double xd = Double.parseDouble(x);
        double yd = Double.parseDouble(y);
        if (xd >= ltxd && xd <= rbxd && yd >= rbyd && yd <= ltyd){
            return true;
        }
        return false;
    }
    
    
    /**
     * 
     * @Title: readFile
     * @Description: 读取文件内容
     * @param path
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年12月21日下午2:05:13
     */
    public static String readFile(String path) {
        InputStream in = CommonUtils.class.getResourceAsStream(path);
        BufferedReader reader = null;
        String laststr = "";
        try{
            reader = new BufferedReader(new InputStreamReader(in, Constants.UTF8));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null){
                // 显示行号
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            if (reader != null){
                try{
                    reader.close();
                } catch (IOException e1){
                }
            }
            if (in != null){
                try{
                    in.close();
                } catch (IOException e1){
                }
            }
        }
        return laststr;
    }
    
    
    /**
     * 保留小数
     * 
     * @param d
     *            : 值
     * @param postion
     *            : 保留位数
     * @return
     */
    public static Double keepDecimal(Double d, int position) {
        if (d != null){
            if (position == 1){
                String value = df.format(d);
                return Double.valueOf(value);
            } else if (position == 2){
                String value = df2.format(d);
                return Double.valueOf(value);
            } else{
                String value = df2.format(d);
                return Double.valueOf(value);
            }
        } else{
            return null;
        }
    }
    
    
    /**
     * @Title: strArrToInt
     * @Description: 字符数组转整形数组
     * @param strArr
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2016年1月6日下午1:27:14
     */
    public static int[] strArrToInt(String[] strArr) {
        if (strArr == null){
            return null;
        }
        int[] intArr = new int[strArr.length];
        try{
            for (int i = 0; i < strArr.length; i++){
                intArr[i] = Integer.parseInt(strArr[i]);
            }
        } catch (Exception e){
            logger.error("strArrToInt failed", e);
            return null;
        }
        return intArr;
    }
    
    
    /**
     * 
     * @Title: getDicNameByDicId
     * @Description: 通过dicId获取dicName
     * @param code
     * @param dicId
     * @param dicMap
     * @return
     * @createdBy:zenghang
     * @createaAt:2016年1月9日上午10:14:46
     */
    public static String getDicNameByDicId(String code, String dicId, Map<String, Map<String, String>> dicMap) {
        if (dicMap != null && dicMap.containsKey(code) && dicId != null){
            Map<String, String> value = dicMap.get(code);
            if (value.containsKey(dicId.toString())){
                for (Iterator<Entry<String, String>> it = value.entrySet().iterator(); it.hasNext();){
                    Entry<String, String> e = it.next();
                    if (e.getKey().equals(dicId.toString())){
                        return e.getValue();
                    }
                }
            }
        }
        return Constants.NULLSTRING;
    }
    
    
    /**
     * 
     * @Title: getDicNamesByCode
     * @Description: 通过code获取dicNames
     * @param code
     * @param dicMap
     * @return
     * @createdBy:zenghang
     * @createaAt:2016年1月14日下午4:43:36
     */
    public static String[] getDicNamesByCode(String code, Map<String, Map<String, String>> dicMap) {
        String[] dicName = null;
        if (dicMap != null && dicMap.containsKey(code)){
            Map<String, String> value = dicMap.get(code);
            dicName = new String[value.size()];
            int i = 0;
            for (Iterator<Entry<String, String>> it = value.entrySet().iterator(); it.hasNext();){
                Entry<String, String> e = it.next();
                dicName[i] = e.getKey();
                i++;
            }
        }
        return dicName;
    }
}
