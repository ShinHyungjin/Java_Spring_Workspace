package com.koreait.fashionshop.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.product.service.TopCategoryService;

public class GlobalDataAspect {
	@Autowired
	private TopCategoryService topCategoryService;
	
	public Object getGlobalData(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		HttpServletRequest request;
		
		for(Object arg : joinPoint.getArgs()) {
			if(arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		List topList =  topCategoryService.selectAll();
		Object returnObj = joinPoint.proceed();
		ModelAndView mav = null;
		if(returnObj instanceof ModelAndView) {
			mav = (ModelAndView)returnObj;
			mav.addObject("topList", topList);
			result = mav;
		}
		
		return result;
	}
}
