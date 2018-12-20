package com.chinasofti.springcloud.controller;


import com.chinasofti.springcloud.service.OneToOneComparisonService;
import com.chinasofti.springcloud.utils.RtrkmsResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 一对一对比
 * @auther wlq
 * @create 2018-05-29 13:30
 */
@Controller
@RequestMapping("/oneTwoOneComparison")
public class OneToOneComparisonController{
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello world";
	}
	
	
    @Autowired
    private OneToOneComparisonService oneToOneComparisonService ;

    /**
     * @Description 用于： 一对一对比
     * @return 返回
     * @author 吴丽群
     * @date 2018/12/11 16:05
     */
    @RequestMapping("/idCardPhoto")
    public void idCardPhoto(HttpServletRequest request, HttpServletResponse response, String file1, String file2) {
        RtrkmsResult r = new RtrkmsResult();
        Gson gson = new Gson();
        try {
            r =  oneToOneComparisonService.addIdCardPhoto(file1,file2);
            PrintWriter pw = response.getWriter();
            //success_jsonpCallback与前台保持一致
            pw.write("success_jsonpCallback"+"("+gson.toJson(r)+")");
            pw.close();
            pw = null;
        } catch (Exception e) {
            System.out.println(e);
        }
        //返回结果


        /*return r;*/
    }

}
