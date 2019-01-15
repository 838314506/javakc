package com.zhg.javakc.base.util.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传操作实现类
 * @author zhou
 * @version v0.1
 */
public class UploadFile {
	
	public static void upload(HttpServletRequest request) throws IOException{
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();       
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        
        Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, MultipartFile> entry = it.next();
            MultipartFile mFile = entry.getValue();
            if(mFile.getSize() != 0 && !"".equals(mFile.getName())){
            	String serverPath = initFilePath(realPath +File.separator+ mFile.getOriginalFilename());
                FileUtils.copyInputStreamToFile(mFile.getInputStream(), new File(serverPath));;
            }
        }
    }
	
	private static String initFilePath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        Long num = new Date().getTime();
        Double d = Math.random()*num;
        return (file.getPath() + "/" + num + d.longValue()).replaceAll(" ", "-");
    }
	
}
