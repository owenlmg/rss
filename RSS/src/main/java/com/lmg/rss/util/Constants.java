package com.lmg.rss.util;

import java.io.File;

public class Constants extends BaseConstants {
    
    private static final long   serialVersionUID                = 1234135065937991641L;
    
    /****************** 业务相关常量 开始 **************************/
    
    /**
     * IC卡读卡成功
     */
    public static final String  IC_STATUS_SUCCESS               = "0";
    /**
     * IC卡插卡
     */
    public static final String  IC_CARD_IN                      = "1";
    /**
     * IC卡拔卡
     */
    public static final String  IC_CARD_OUT                     = "2";
    /**
     * page参数默认 1
     */
    public static final String  PAGE_VALUE                      = "1";
    /**
     * size参数默认 20
     */
    public static final String  PAGE_SIZE                       = "20";
    
    /**
     * session：ip
     */
    public static final String  SESSION_KEY_IP                  = "SESSION_IP";
    /**
     * session：mac
     */
    public static final String  SESSION_KEY_MAC                 = "SESSION_MAC";
    
    /**
     * 当前登录用户的自定义点
     */
    public static final String  SESSION_KEY_SELF_DEFINE_POINTS  = "SelfDefinePoints";
    /**
     * 当前登录用户
     */
    public static final String  SESSION_KEY_USER                = "SESSION_USER";
    /**
     * 用户登录类型
     */
    public static final String  SESSION_KEY_LOGINTYPE           = "SESSION_KEY_LOGINTYPE";
    /**
     * 当前登录用户 菜单
     */
    public static final String  SESSION_USER_MENU               = "SESSION_USER_MENU";
    /**
     * 当前登录用户 车辆
     */
    public static final String  SESSION_USER_VEHICLEMAP         = "SESSION_USER_VEHICLEMAP";
    /**
     * 当前登录用户 车辆
     */
    public static final String  SESSION_USER_VEHICLETREE        = "SESSION_USER_VEHICLETREE";
    /**
     * 当前登录用户公司信息
     */
    public static final String  SESSION_VEHICLE_TREE            = "SESSION_VEHICLE_TREE";
    /**
     * 当前登录用户的自定义区域
     */
    public static final String  SESSION_KEY_SELF_DEFINE_AREAS   = "SelfDefineAreas";
    
    /**
     * 当前登录的车辆
     */
    public static final String  SESSION_KEY_USER_ALL_VEHICLES   = "UserAllVehicles";
    
    /**
     * 当前登录用户的线路
     */
    public static final String  SESSION_KEY_USER_LINES          = "userLines";
    
    /**
     * 当前登录用户的温度报警
     */
    public static final String  SESSION_KEY_LIST_OF_TMPWARNING  = "listOfTmpwarning";
    
    /**
     * 当前登录用户的警告信息
     */
    public static final String  SESSION_KEY_LIST_OF_WARNINGINFO = "listOfWarningInfo";
    
    /**
     * 当前登录用户菜单
     */
    public static final String  SESSION_KEY_USER_MENUS_JSON     = "userMenusJson";
    
    /**
     * 登录验证码
     */
    public static final String  SESSION_KEY_RAND                = "rand";
    /**
     * 菜单
     */
    public static final String  SESSION_KEY_MENU                = "SESSION_KEY_MENU";
    
    /**
     * 是否默认显示温度报警
     */
    public static final String  IS_DEFAULT_VIEW_TMP_WARNING     = "isDefaultViewTmpWarning";
    
    /**
     * 127.0.0.1
     */
    public static final String  LOCALHOST_V4                    = "127.0.0.1";
    
    /**
     * 0:0:0:0:0:0:0:1
     */
    public static final String  LOCALHOST_V6                    = "0:0:0:0:0:0:0:1";
    
    /****************** 业务相关常量 结束 **************************/
    
    /****************** 通用常量 开始 **************************/
    /**
     * DIC_TYPE:CODE 用户参数
     */
    public static final String  USER_PARAMETERTYPE              = "USER_PARAMETERTYPE";
    
    /**
     * user-agent
     */
    public static final String  USER_AGENT                      = "user-agent";
    /**
     * 微信访问标识
     */
    public static final String  WX_FLAG                         = "MicroMessenger";
    /**
     * ios访问标识
     */
    public static final String  IOS_FLAG                        = "JieYi";
    /**
     * 微信小程序访问标识
     */
    public static final String  WXAPP_FLAG                      = "servicewechat.com";
    /**
     * 安卓订单访问标识
     */
    public static final String  ANDROID_ORDER                   = "jy;order;";
    /**
     * iPhone
     */
    public static final String  IPHONE                          = "iPhone";
    /**
     * Android
     */
    public static final String  ANDROID                         = "Android";
    /**
     * Android客户端
     */
    public static final String  ANDROID_APP                     = "okhttp";
    /**
     * DIC_TYPE:CODE 设备类型
     */
    public static final String  DEVICE_TYPE                     = "DEVICE";
    /**
     * DIC_TYPE:CODE 油杆类型
     */
    public static final String  CYPOLETYPE                      = "CYPOLETYPE";
    /**
     * DIC_TYPE:CODE 温度传感器类型
     */
    public static final String  TEMPTYPE                        = "TEMPTYPE";
    /**
     * DIC_TYPE:CODE 冷机型号
     */
    public static final String  REFRIGERATORTYPE                = "REFRIGERATORTYPE";
    /**
     * DIC_TYPE:CODE 门磁型号
     */
    public static final String  DOORCONTACTTYPE                 = "DOORCONTACTTYPE";
    /**
     * DIC_TYPE:CODE 摄像头型号
     */
    public static final String  CAMERATYPE                      = "CAMERATYPE";
    /**
     * DIC_TYPE:CODE 报警方式
     */
    public static final String  WARNING_MODE                    = "WARNING_MODE";
    /**
     * 参数格式错误
     */
    public static final String  PARAMETERS_FORMATTING_ERROR     = "参数格式错误";
    /**
     * 缺少参数
     */
    public static final String  MISSING_PARAMETERS              = "缺少参数";
    /**
     * 查询失败
     */
    public static final String  QUERY_FAIL                      = "查询失败";
    /**
     * 无数据
     */
    public static final String  NO_DATAS                        = "数据不存在";
    /**
     * 删除失败 , 请先删除该公司下所有的车辆
     */
    public static final String  HAVE_CHILD_DATE                 = "删除失败 , 请先删除该公司下所有的车辆";
    /**
     * 添加失败
     */
    public static final String  ADD_FAIL                        = "添加失败";
    /**
     * 记录已存在
     */
    public static final String  EXISTING_RECORD                 = "记录已存在";
    /**
     * 没有车辆
     */
    public static final String  NO_VEHICLES                     = "无车辆";
    /**
     * Session失效
     */
    public static final String  SESSION_INVALID                 = "当前登录用户身份验证过期";
    /**
     * 没有权限
     */
    public static final String  NO_POWER                        = "没有权限 ";
    /**
     * 远程调用失败
     */
    public static final String  RMI_FAILED                      = "远程调用失败";
    /**
     * 开
     */
    public static final String  OPEN                            = "开";
    /**
     * 关
     */
    public static final String  CLOSE                           = "关";
    /**
     * on
     */
    public static final String  ON                              = "on";
    /**
     * ELSE
     */
    public static final String  ELSE                            = "ELSE ";
    /**
     * grid传递分页页码page参数名
     */
    public static final String  PAGE                            = "page";
    /**
     * grid传递分页页数rows参数名
     */
    public static final String  ROW                             = "rows";
    /**
     * SQL倒序
     */
    public static final String  SORT_DESC                       = "desc";
    /**
     * SQL正序
     */
    public static final String  SORT_ASC                        = "asc";
    
    /**
     * 查询字段
     */
    public static final String  SEARCH_KEY_Q                    = "q";
    /**
     * 返回页面key值：id
     */
    public static final String  ID                              = "id";
    /**
     * 返回页面key值：success
     */
    public static final String  SUCCESS                         = "success";
    /**
     * 返回页面key值：message
     */
    public static final String  MESSAGE                         = "message";
    
    /**
     * 编码格式UTF-8
     */
    public static final String  UTF8                            = "UTF-8";
    
    /**
     * 编码格式GBK
     */
    public static final String  GBK                             = "GBK";
    
    /**
     * 编码格式GB2312
     */
    public static final String  GB2312                          = "GB2312";
    
    /**
     * Space
     */
    public static final String  HALF_SIZE_SPACE                 = " ";
    
    /**
     * 空字符串
     */
    public static final String  NULLSTRING                      = "";
    
    /**
     * 斜杠
     */
    public static final String  SLASH                           = "/";
    
    /**
     * 中划线
     */
    public static final String  HALF_SIZE_HYPHEN                = "-";
    
    /**
     * 下划线
     */
    public static final String  UNDERLINE                       = "_";
    /**
     * 波浪号
     */
    public static final String  TILDE                           = "~";
    
    /**
     * 反斜杠
     */
    public static final String  WQ                              = "\"";
    
    /**
     * 点
     */
    public static final String  DOT                             = ".";
    /**
     * 空格
     */
    public static final char    CHAR_BLANK                      = ' ';
    /**
     * 冒号
     */
    public final static String  COLON                           = ":";
    /**
     * 分号
     */
    public final static String  SEMICOLON                       = ";";
    /**
     * 逗号
     */
    public final static String  COMMA                           = ",";
    /**
     * 文件分隔符
     */
    public final static String  FILE_SEPARATOR                  = File.separator;
    
    /**
     * 换行（CRLF）
     */
    public static final String  CRLF                            = "\r\n";
    
    /**
     * 换行（CR）0x0d
     */
    public static final String  CR                              = "\r";
    
    /**
     * 换行（LF）0x0a
     */
    public static final String  LF                              = "\n";
    
    /**
     * tab
     */
    public static final String  TAB                             = "\t";
    /**
     * br
     */
    public static final String  BR                              = "<br>";
    
    /**
     * HTTP
     */
    public static final String  HTTP                            = "http";
    
    /**
     * HTTPS
     */
    public static final String  HTTPS                           = "https";
    
    /**
     * 后缀PDF
     */
    public static final String  EXTENSION_PDF                   = ".pdf";
    
    /**
     * 后缀HTML
     */
    public static final String  EXTENSION_HTML                  = ".html";
    
    /**
     * 后缀PNG
     */
    public static final String  EXTENSION_PNG                   = ".png";
    
    /**
     * 后缀TXT
     */
    public static final String  EXTENSION_TXT                   = ".txt";
    
    /**
     * 后缀XML
     */
    public static final String  EXTENSION_XML                   = ".xml";
    
    /**
     * 后缀XLS
     */
    public static final String  EXTENSION_XLS                   = ".xls";
    
    /**
     * 后缀XLSX
     */
    public static final String  EXTENSION_XLSX                  = ".xlsx";
    
    /**
     * 美国语言
     */
    public static final String  LANGUAGE_USE                    = "use";
    /**
     * 中国语言
     */
    public static final String  LANGUAGE_CN                     = "cn";
    
    /**
     * 公用消息文件
     */
    public static final String  MESSAGE_COMMON                  = "/message_common.xml";
    
    /**
     * 业务
     */
    public static final String  MESSAGE_BUSINESS                = "/message_business.xml";
    
    /**
     * 共通配置文件
     */
    public static final String  CONFIG_COMMON                   = "/config_common.xml";
    
    /**
     * ?
     */
    public static final String  REQ_OPR                         = "?";
    
    /**
     * 地址
     */
    public static final String  MAIL_PARA_TO_ADDRESS            = "toAddress";
    
    /**
     * title
     */
    public static final String  MAIL_PARA_TITLE                 = "title";
    
    /**
     * mail内容
     */
    public static final String  MAIL_PARA_BODY                  = "body";
    
    /**
     * 
     */
    public static final String  MAIL_PARA_REQUIREMENT           = "requirement";
    
    /**
     * result
     */
    public static final String  NODE_RESULT                     = "result";
    /**
     * 车辆温度查询历史
     */
    public static final String  QUERY_VEHICLE_TEMP_HIS          = "queryvehicletemphis";
    /**
     * cd
     */
    public static final String  NODE_ATTRIBUTE_CD               = "cd";
    
    /**
     * =
     */
    public static final String  EQUAL_OPR                       = "=";
    
    /**
     * &
     */
    public static final String  AND_OPR                         = "&";
    
    /**
     * CONTENT TYPE
     */
    public static final String  CONTENT_TYPE_XML                = "text/xml;charset=UTF-8";
    
    /**
     * CONTENT TYPE
     */
    public static final String  CONTENT_TYPE_DOWNLOAD           = "application/x-download";
    
    /**
     * HTTP 200
     */
    public static final int     HTTP_STATUS_NORMAL              = 200;
    
    /**
     * HTTP 400
     */
    public static final int     HTTP_STATUS_ERROR               = 400;
    
    /**
     * String 0
     */
    public static final String  STRING_ZERO                     = "0";
    
    /**
     * String 1
     */
    public static final String  STRING_ONE                      = "1";
    
    /**
     * String 2
     */
    public static final String  STRING_TWO                      = "2";
    
    /**
     * String 3
     */
    public static final String  STRING_THREE                    = "3";
    
    /**
     * String 4
     */
    public static final String  STRING_FOUR                     = "4";
    
    /**
     * String 5
     */
    public static final String  STRING_FIVE                     = "5";
    
    /**
     * String 6
     */
    public static final String  STRING_SIX                      = "6";
    
    /**
     * String 7
     */
    public static final String  STRING_SEVEN                    = "7";
    
    /**
     * String 8
     */
    public static final String  STRING_EIGHT                    = "8";
    
    /**
     * String 9
     */
    public static final String  STRING_NINE                     = "9";
    
    /**
     * String 10
     */
    public static final String  STRING_TEN                      = "10";
    
    /**
     * String -1
     */
    public static final String  STRING_MINUS_ONE                = "-1";
    
    /**
     * INT -1
     */
    public static final Integer INT_MINUS_ONE                   = -1;
    
    /**
     * INT 0
     */
    public static final int     INT_ZERO                        = 0;
    
    /**
     * INT 1
     */
    public static final int     INT_ONE                         = 1;
    
    /**
     * INT 2
     */
    public static final int     INT_TWO                         = 2;
    
    /**
     * INT 3
     */
    public static final int     INT_THREE                       = 3;
    
    /**
     * INT 4
     */
    public static final int     INT_FOUR                        = 4;
    
    /**
     * INT 5
     */
    public static final int     INT_FIVE                        = 5;
    
    /**
     * INT 6
     */
    public static final int     INT_SIX                         = 6;
    
    /**
     * INT 7
     */
    public static final int     INT_SEVEN                       = 7;
    
    /**
     * INT 8
     */
    public static final int     INT_EIGHT                       = 8;
    
    /**
     * INT 9
     */
    public static final int     INT_NINE                        = 9;
    
    /**
     * INT 10
     */
    public static final int     INT_TEN                         = 10;
    
    /**
     * DOUBLE 0
     */
    public static final Double  DOUBLE_ZERO                     = 0.0;
    
    /**
     * 登录错误次数
     */
    public static final String  SESSION_KEY_ERRORTIMES          = "errortimes";
    
    /**
     * 车辆离线时间
     */
    // public static final long OFFLINE_TIME = 1440;
    public static final long    OFFLINE_TIME                    = 1 * 60;
    
    /**
     * 默认点计算距离
     */
    public static final Integer DEFAULT_POINT_DISTANCE          = 500;
    
    /**
     * 默认区域计算距离
     */
    public static final Integer DEFAULT_AREA_DISTANCE           = 500;
    
    /**
     * 上海中心点坐标
     */
    public static final String  MAP_CENTER_SHANGHAI             = "121.4726440000,31.231706000";
    
    /**
     * 上海中心点坐标 经度
     */
    public static final String  MAP_CENTER_LON                  = "121.472644";
    
    /**
     * 上海中心点坐标 纬度
     */
    public static final String  MAP_CENTER_LAT                  = "31.231706";
    
    /**
     * 默认地图缩放层级
     */
    public static final Integer MAP_ZOOM_DEFAULT                = 10;
    /**
     * 地图缩放层级 14
     */
    public static final Integer MAP_ZOOM_MAX                    = 14;
    /**
     * gps一圈最大里程
     */
    public static double        MONTIOR_GPSMILE_MAX             = 16777.215;
    
    /**
     * vehicle
     */
    public static final String  CONTEXT_VEHICLE                 = "CONTEXT_VEHICLE";
    /**
     * company
     */
    public static final String  CONTEXT_COMPANY                 = "CONTEXT_COMPANY";
    
    public static final String  CONTEXT_DIC_TYPE                = "CONTEXT_DIC_TYPE";
    
    public static final String  CONTEXT_DIC_DATA                = "CONTEXT_DIC_DATA";
    
    public static final String  CONTEXT_GLOBAL_PARAMS           = "CONTEXT_GLOBAL_PARAMS";
    
    public static final String  CITY_FILE_PATH                  = "/city.json";
    
    public static final String  CONTEXT_DIC_CITY                = "CONTEXT_DIC_CITY";
    
    public static final String  CONTEXT_VEHICLE_MENU            = "CONTEXT_VEHICLE_MENU";
    
    public static final String  SIM_IOC_1064                    = "1064";
    
    /**
     * 清除T1数据
     */
    public static final String  CLEAR_T1_DATA                   = "1";
    
    /**
     * acc off
     */
    public static String        MONITOR_WARNING_ACCOFF          = "1";
    /**
     * acc on
     */
    public static String        MONITOR_WARNING_ACCON           = "0";
    
    public static String        REDIS_PREFIX_VEHICLE            = "vehicle-";
    
    /****************** 通用常量 结束 **************************/
    /**
     * NULL
     */
    public static String        NORMAL_NULL                     = null;
    
    /****************** 可变常量 开始 **************************/
    
    public static String        TEST_PROP                       = "TEST";
    
    /****************** 可变常量 结束 **************************/
    
    /****************** 微信常量 开始 **************************/
    public static final Integer USERID                          = 2321;
    public static String        URL                             = get("weixin.url");
    /** 关注 */
    public static final String  SUBSCRIBE                       = "1";
    /** 取消关注 */
    public static final String  UNSUBSCRIBE                     = "0";
    /****************** 微信常量 结束 **************************/
    
    /****************** 极光短信模板 开始 ***********************/
    /** 车辆{{a}}平均温度{{b}}最高温度{{c}}最低温度{{d}} */
    public static final String  SMS_TEMPAVG                     = "144818";
    /** 车辆{{a}}位置{{b}} */
    public static final String  SMS_VEHICLELOCATION             = "144817";
    /** System Warning{{a}} */
    public static final String  SMS_SYSWARNING1                 = "144816";
    /** 系统数据从{{a}}开始报警{{b}}请检查系统{{c}} */
    public static final String  SMS_SYSWARNING2                 = "144815";
    /** 车辆{{a}}从{{b}}开始{{c}}，{{d}}，项目：{{e}} */
    public static final String  SMS_WARNSEND                    = "144814";
    /** 车辆{{a}}，订单{{b}}，{{c}}到{{d}}平均温度{{e}}，最高温度{{f}},最低温度{{g}} */
    public static final String  SMS_ORDER_TEMPAVG               = "144813";
    /** 车辆{{a}}到{{b}}平均温度{{c}}最高温度{{d}}最低温度{{e}} */
    public static final String  SMS_TIME_TEMPAVG                = "144812";
    /** 第{{a}}级报警,{{b}}采集点当前值{{c}}℃超过下限{{d}}℃警告 */
    public static final String  SMS_LK_TEMPWARN_MIN             = "144811";
    /** 第{{a}}级报警,{{b}}采集点当前值{{c}}℃超过上限{{d}}℃警告 */
    public static final String  SMS_LK_TEMPWARN_MAX             = "144810";
    /** {{a}}向{{b}}推送了安装单，编号为：{{c}}，安装公司：{{d}}，联系名称：{{e}}，联系号码：{{f}} */
    public static final String  SMS_ERP_AZORDER                 = "144809";
    /**
     * 尊敬的客户{{a}}您好!您的订单号:{{b}}的{{c}}设备{{d}}共{{e}}个),将由我司安装工程师{{f}}负责,联系电话{{g}},
     * 感谢您的支持!
     */
    public static final String  SMS_ERP_AZORDERTOCUS            = "144808";
    /** {{a}}接收程序接收报警队列错误并恢复失败,请查看! */
    public static final String  SMS_WARNLIST1                   = "144806";
    /** {{a}}接收程序接收报警队列恢复成功! */
    public static final String  SMS_WARNLIST2                   = "144805";
    /** 您的手机验证码：{{code}}，60s后过期，请勿泄露。如非本人操作，请忽略此短信。谢谢！ */
    public static final String  SMS_CODE                        = "1";
    
    
    /****************** 极光短信模板 结束 ***********************/
    
    /**
     * 
     * @Title: parseConfigProperties
     * @Description: 解析配置文件
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午10:04:59
     */
    public void parseConfigProperties() {
        // 文件配置覆盖默认的值
        TEST_PROP = get("TEST_PROP", TEST_PROP);
    }
    
}
