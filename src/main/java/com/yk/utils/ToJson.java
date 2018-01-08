package com.yk.utils;

import net.sf.json.JSONObject;

public class ToJson {
	
	public static JSONObject toJson(Object json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject;
	}
}
