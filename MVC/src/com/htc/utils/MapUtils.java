package com.htc.utils;

import java.util.HashMap;
import java.util.Map;

import com.htc.model.IModel;
public class MapUtils {
	private static final Map<String,IModel> map = new HashMap<String,IModel>();

	public static Map<String,IModel> getMap() {
		return map;
	}

	public static IModel getAction(String action) {
		// TODO Auto-generated method stub
		return map.get(action);
	}
	
}
