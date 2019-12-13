package com.psl.ppmtool.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ProjectListExceptionResponse {
	
	public Map<String, String> EmptyProjectListResponse(String ProjectKey,String Projectvalue){
		Map<String,String> ErrorMap = new HashMap<String, String>();
		ErrorMap.put(ProjectKey, Projectvalue);
		return ErrorMap;
	}
}
