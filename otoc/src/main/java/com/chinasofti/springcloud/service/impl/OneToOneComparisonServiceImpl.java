package com.chinasofti.springcloud.service.impl;


import com.chinasofti.springcloud.dao.OneToOneComparisonMapper;

import com.chinasofti.springcloud.entities.TbTransfer;
import com.chinasofti.springcloud.service.OneToOneComparisonService;
import com.chinasofti.springcloud.utils.RtrkmsResult;
import com.chinasofti.springcloud.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service("OneToOneComparisonService")
public class OneToOneComparisonServiceImpl implements OneToOneComparisonService {
     @Autowired
     private OneToOneComparisonMapper oneToOneComparisonMapper;


    @Override
    public RtrkmsResult addIdCardPhoto(String file1, String file2) throws Exception {
        int bg = 0;
        TbTransfer tbTransfer =new TbTransfer();
        String Similarity="";
        String flag;
        Double random;
        //定义一个数组
        Double [] doc = new Double[]{40.864545,71.596584,76.324523,79.897854,90.568754,74.218695,10.124523,82.966452,75.464213,87.6445682};
        int index = (int) (Math.random() * doc.length);
        random = doc[index];
        /*FaceMatch faceMatch =new FaceMatch();
        String one ="C:\\Users\\liqun\\Desktop\\图片\\9f24a01fee.jpg";
        String two="C:\\Users\\liqun\\Desktop\\图片\\9f24a01fee.jpg";
        Gson gson= new Gson();
        FaceResult faceResult = gson.fromJson(faceMatch.match(file1,file2), FaceResult.class);
        random = faceResult.getResult()[0].getScore();*/

        if(random>90){
            Similarity =" 照片中人物与身份证是同一个人的可能性很高";
        }else if (random>70){
            Similarity =" 照片中人物与身份证是同一个人的可能性较高";
        }else if (random>50){
            Similarity =" 照片中人物与身份证是同一个人的可能性很低";
        }else{
            Similarity =" 照片中人物与身份证是同一个人的可能性极低";
        }
        //定义一个数组返回需要的结果
        ArrayList<HashMap<String, Object>> listData = new ArrayList();
        //最终输出的map结果集
        HashMap<String, Object> map = new HashMap();
        //前台需要返回的结果集
        HashMap<String, Object> mapneet = new HashMap();
        //face_list需要返回的结果集
        HashMap<String, Object> mapfacelist = new HashMap();
        //存放人脸识别度，与评语
        LinkedHashMap<String, Object> mapface = new LinkedHashMap();
        mapneet.put("score",random);
        mapneet.put("Similarity",Similarity);
        map.put("mapneet",mapneet);

        mapfacelist.put("face_token","e66c466a16aa728aa79514134ac6f783");
        listData.add(mapfacelist);
        mapfacelist.put("face_token","3bc834fb683be071e24ec43cab006d81");
        listData.add(mapfacelist);
        mapface.put("score",random);
        mapface.put("face_list",listData);
        map.put("face_list",mapface);
        //调用记录每次对比需要往接口调用记录表添加记录
        tbTransfer.setId(UuidUtil.get32UUID());
        tbTransfer.setInId("e42a3fdc8f834fff9aaa476174fe2390");
        tbTransfer.setuId("8948cf3f40e744b99579210dffe77f34");
        tbTransfer.setCallState("Y");
        tbTransfer.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        tbTransfer.setIsDelete("N");
        bg =this.oneToOneComparisonMapper.addCallRecord(tbTransfer);
        if(map!=null){
            flag="success";
        }else{
            flag="error";
        }
        return RtrkmsResult.resultOk(flag,map);
    }



}
