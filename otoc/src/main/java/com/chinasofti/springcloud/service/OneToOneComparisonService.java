package com.chinasofti.springcloud.service;


import com.chinasofti.springcloud.utils.RtrkmsResult;

public interface OneToOneComparisonService {

    RtrkmsResult addIdCardPhoto(String file1, String file2) throws Exception;
}
