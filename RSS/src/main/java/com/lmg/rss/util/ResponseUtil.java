/**
 * @Title: ResponseUtil.java
 * @Package com.webgis.common.utils
 */
package com.lmg.rss.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/***********************************
 * @ClassName: ResponseUtil.java
 * @Description: Response操作
 * @author: luomingguo
 * @createdAt: 2015-4-24 14:03:16
 ***********************************/

public class ResponseUtil {
    
    private static final int BUF_SIZE = 4096;
    
    
    private ResponseUtil() {
        
    }
    
    
    /**
     * 
     * @Title: download
     * @Description: TODO
     * @param response
     * @param path
     * @param fileType
     * @param fileName
     * @throws FileNotFoundException
     * @throws IOException
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午10:50:50
     */
    public static void download(HttpServletResponse response, String path, String fileType, String fileName)
            throws FileNotFoundException, IOException {
        path = StringUtil.replace(path, "\\", "/");
        response.setContentType(fileType);
        response.setHeader("Content-Disposition", "attachment;   filename=\"" + URLEncoder.encode(fileName, "utf8")
                + "\"");
        byte[] buffer = new byte[BUF_SIZE]; // 缓冲区
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        OutputStream out = response.getOutputStream();
        try{
            bos = new BufferedOutputStream(out);
            bis = new BufferedInputStream(new FileInputStream(path));
            int n = (-1);
            while ((n = bis.read(buffer, 0, BUF_SIZE)) > -1){
                bos.write(buffer, 0, n);
            }
            response.flushBuffer();
        } finally{
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
            if (out != null){
                out.flush();
                out.close();
            }
        }
    }
    
    
    /**
     * 
     * @Title: writeJson
     * @Description: TODO
     * @param response
     * @param strJson
     * @throws IOException
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午10:50:41
     */
    public static void writeJson(HttpServletResponse response, String strJson) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.write(strJson);
        } finally{
            if (out != null){
                out.flush();
                out.close();
            }
        }
        
    }
    
}
