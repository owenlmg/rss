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
       
     out.print("<b>Session �б�</b>");    
       
     Enumeration e = session.getAttributeNames();  
     
     InetAddress addr = InetAddress.getLocalHost();
     String ip=addr.getHostAddress().toString();//��ñ���IP
       
     out.println("ip:" + ip);

    out.println("<br/>");
    out.println("<br/>");
    out.println("<br/>");
    
    out.println("Protocol: " + request.getProtocol()); 
    out.println("<br/>");
    out.println("Scheme: " + request.getScheme()); 
    out.println("<br/>");
    out.println("Server Name: " + request.getServerName() ); //��÷����������� 
    out.println("<br/>");
    out.println("Server Port: " + request.getServerPort()); //��÷������Ķ˿ں� 
    out.println("<br/>");
    out.println("rotocol: " + request.getProtocol()); 
    out.println("<br/>");
    out.println("Server Info: " + getServletConfig().getServletContext().getServerInfo()); 
    out.println("<br/>");
    out.println("Remote Addr: " + request.getRemoteAddr()); //��ÿͻ��˵�ip��ַ 
    out.println("<br/>");
    out.println("Remote Host: " + request.getRemoteHost()); //��ÿͻ��˵��Ե����֣���ʧ�ܣ��򷵻ؿͻ��˵��Ե�ip��ַ 
    out.println("<br/>");
    out.println("Character Encoding: " + request.getCharacterEncoding()); 
    out.println("<br/>");
    out.println("Content Length: " + request.getContentLength()); 
    out.println("<br/>");
    out.println("Content Type: "+ request.getContentType()); 
    out.println("<br/>");
    out.println("Auth Type: " + request.getAuthType()); 
    out.println("<br/>");
    out.println("HTTP Method: " + request.getMethod()); //��ÿͻ�����������˴������ݵķ�����get��post��put������ 
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
    out.println("Request URI: " + request.getRequestURI());//��÷��������ַ����Ŀͻ��˵�ַ  
    out.println("<br/>");

    out.println("Servlet Path: " + request.getServletPath()); //��ÿͻ���������Ľű��ļ����ļ�·�� 
    out.println("<br/>");
    out.println(request.getHeaderNames()); //��������request header�����֣��������һ��enumeration��ö�٣����ʵ�� 
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
    out.println("User-Agent : " + request.getHeader("User-Agent")); //���ؿͻ���������İ汾�š����� 
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
        var service = locator.ConnectServer("."); //���ӱ���������
        var properties = service.ExecQuery("SELECT * FROM Win32_NetworkAdapterConfiguration where IPEnabled=TRUE");
        //��ѯʹ��SQL��׼
        var e = new Enumerator (properties);
               var msg="";
        for (;!e.atEnd();e.moveNext ())
        {
            var p = e.item ();
            msg+="Caption:" + p.Caption + " "; //��������,Ҳ����ʹ��Description
            msg+="IP:" + p.IPAddress(0) + " ";//IP��ַΪ��������,�������뼰Ĭ��������ͬ
            msg+="MAC:" + p.MACAddress + " "; //���������ַ
        }
              return msg;
     
    }
    alert( GetAdapterInfo());
    </script>

    <form action="test.jsp" method="POST"> 
      ����:<input type=text size=20 name="dataName"> 
       <br> 
      ֵ:<input type=text size=20 name="dataValue"> 
       <br> 
      <input type=submit> 
     </form> 
  </body> 
  </html> 