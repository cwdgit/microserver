package com.chinasofti.springcloud.entities;


/**
 * tb_transfer 实体类
 * Wed Dec 12 15:33:22 CST 2018 吴丽群
 */ 

public class TbTransfer {
	private String Id;  //消费记录ID
	private String inId;  //接口id
	private String uId;  //用户id
	private String CallState;  //调用状态（调用成功，调用失败）
	private String Date;  //调用时间
	private String IsDelete;  //用户删除标记

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getInId() {
		return inId;
	}

	public void setInId(String inId) {
		this.inId = inId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getCallState() {
		return CallState;
	}

	public void setCallState(String callState) {
		CallState = callState;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(String isDelete) {
		IsDelete = isDelete;
	}
}

