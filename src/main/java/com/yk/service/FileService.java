package com.yk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.FileMapper;
import com.yk.dao.MyFileMapper;
import com.yk.pojo.File;

import net.sf.json.JSONObject;

@Service
public class FileService {
	
	@Autowired
	FileMapper fileMapper;
	
	@Autowired
	MyFileMapper myFileMapper;

	public void uploadFile(JSONObject messageJson) {
		String filename = messageJson.getString("filename");
		System.out.println("filename:"+filename);
		if(filename.equals("")) {
			return;
		}
		File file = new File();
		Integer meettingid = Integer.parseInt(messageJson.getString("meettingid"));
		file.setMeettingid(meettingid);
		file.setFilename(filename);
		file.setFiledir(messageJson.getString("objURL"));
		//保存文件
		fileMapper.insert(file);
	}

	public File getFileInfo(Integer meettingId) {
		return myFileMapper.getFileInfo(meettingId);
	}

}
