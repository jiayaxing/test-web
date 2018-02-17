package com.jiayaming.dubbo.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("customerInfoController")
public class CustomerInfoController {
	
	@RequestMapping(value = "onlineState", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> onlineState(HttpServletRequest request,HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<>();
		try{
			String token = request.getHeader("Authorization");
			String customerInfoStr = httpSession.getAttribute(token).toString();
			JSONObject customerInfo = JSONObject.parseObject(customerInfoStr);
			returnMap.put("state", "successe");
			returnMap.put("token", token);
	    	returnMap.put("customerInfo", customerInfo);
			return returnMap;
		}catch (Exception e) {
			e.printStackTrace();
			returnMap.put("state", "fail");
			return returnMap;
		}
	}
}
