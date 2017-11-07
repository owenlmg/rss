    <%@ page contentType="text/html; charset=GBK" %> 
    <%@ page import="java.util.*" %> 
    <%@ page import="java.net.InetAddress" %> 
    <html><head><title>Cluster App Test</title></head> 
    <body> 
    Server Info:  
    <%  
    out.println(request.getLocalAddr() + " : " + request.getLocalPort()+"<br>");%> 
    <%  
      out.println("<br> ID " + session.getId()+"<br>");   
      String dataName = request.getParameter("dataName");  
       
     if (dataName != null && dataName.length() > 0) {  
        String dataValue = request.getParameter("dataValue");  
        session.setAttribute(dataName, dataValue);  
     }    
       
     out.print("<b>Session 列表</b>");    
       
     Enumeration e = session.getAttributeNames();  
     
     InetAddress addr = InetAddress.getLocalHost();
     String ip=addr.getHostAddress().toString();//获得本机IP
       
     out.println("ip:" + ip);

    out.println("<br/>");
    out.println("<br/>");
    out.println("<br/>");
    
    out.println("Protocol: " + request.getProtocol()); 
    out.println("<br/>");
    out.println("Scheme: " + request.getScheme()); 
    out.println("<br/>");
    out.println("Server Name: " + request.getServerName() ); //获得服务器的名字 
    out.println("<br/>");
    out.println("Server Port: " + request.getServerPort()); //获得服务器的端口号 
    out.println("<br/>");
    out.println("rotocol: " + request.getProtocol()); 
    out.println("<br/>");
    out.println("Server Info: " + getServletConfig().getServletContext().getServerInfo()); 
    out.println("<br/>");
    out.println("Remote Addr: " + request.getRemoteAddr()); //获得客户端的ip地址 
    out.println("<br/>");
    out.println("Remote Host: " + request.getRemoteHost()); //获得客户端电脑的名字，若失败，则返回客户端电脑的ip地址 
    out.println("<br/>");
    out.println("Character Encoding: " + request.getCharacterEncoding()); 
    out.println("<br/>");
    out.println("Content Length: " + request.getContentLength()); 
    out.println("<br/>");
    out.println("Content Type: "+ request.getContentType()); 
    out.println("<br/>");
    out.println("Auth Type: " + request.getAuthType()); 
    out.println("<br/>");
    out.println("HTTP Method: " + request.getMethod()); //获得客户端向服务器端传送数据的方法有get、post、put等类型 
    out.println("<br/>");
    out.println("ath Info: " + request.getPathInfo()); 
    out.println("<br/>");
    out.println("ath Trans: " + request.getPathTranslated()); 
    out.println("<br/>");
    out.println("Query String: " + request.getQueryString()); 
    out.println("<br/>");
    out.println("Remote User: " + request.getRemoteUser()); 
    out.println("<br/>");
    out.println("Session Id: " + request.getRequestedSessionId()); 
    out.println("<br/>");
    out.println("Request URI: " + request.getRequestURI());//获得发出请求字符串的客户端地址  
    out.println("<br/>");

    out.println("Servlet Path: " + request.getServletPath()); //获得客户端所请求的脚本文件的文件路径 
    out.println("<br/>");
    out.println(request.getHeaderNames()); //返回所有request header的名字，结果集是一个enumeration（枚举）类的实例 
    out.println("<br/>");
    out.println("Accept: " + request.getHeader("Accept")); 
    out.println("<br/>");
    out.println("Host: " + request.getHeader("Host")); 
    out.println("<br/>");
    out.println("Referer : " + request.getHeader("Referer")); 
    out.println("<br/>");
    out.println("Accept-Language : " + request.getHeader("Accept-Language")); 
    out.println("<br/>");
    out.println("Accept-Encoding : " + request.getHeader("Accept-Encoding")); 
    out.println("<br/>");
    out.println("User-Agent : " + request.getHeader("User-Agent")); //返回客户端浏览器的版本号、类型 
    out.println("<br/>");
    out.println("Connection : " + request.getHeader("Connection")); 
    out.println("<br/>");
    out.println("Cookie : " + request.getHeader("Cookie")); 
    out.println("<br/>");
    out.println("Created : " + session.getCreationTime()); 
    out.println("<br/>");
    out.println("LastAccessed : " + session.getLastAccessedTime()); 
  %> 
  <script type="text/javascript">
    function GetAdapterInfo() {
     
        var locator = new ActiveXObject ("WbemScripting.SWbemLocator");
        var service = locator.ConnectServer("."); //连接本机服务器
        var properties = service.ExecQuery("SELECT * FROM Win32_NetworkAdapterConfiguration where IPEnabled=TRUE");
        //查询使用SQL标准
        var e = new Enumerator (properties);
               var msg="";
        for (;!e.atEnd();e.moveNext ())
        {
            var p = e.item ();
            msg+="Caption:" + p.Caption + " "; //网卡描述,也可以使用Description
            msg+="IP:" + p.IPAddress(0) + " ";//IP地址为数组类型,子网俺码及默认网关亦同
            msg+="MAC:" + p.MACAddress + " "; //网卡物理地址
        }
              return msg;
     
    }
    alert( GetAdapterInfo());
    </script>

    <form action="test.jsp" method="POST"> 
      名称:<input type=text size=20 name="dataName"> 
       <br> 
      值:<input type=text size=20 name="dataValue"> 
       <br> 
      <input type=submit> 
     </form> 
  </body> 
  </html> 