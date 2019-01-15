package com.zhg.javakc.modules.person.entity;

import java.util.Date;

import com.zhg.javakc.base.entity.BaseEntity;

public class SubsidyEntity extends BaseEntity<SubsidyEntity>{
	private String sid;
	private double amount;
	private String reason;
	private int type;
	private PersonEntity pe;
	private Date month;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public PersonEntity getPe() {
		return pe;
	}
	public void setPe(PersonEntity pe) {
		this.pe = pe;
	}
	@Override
	public String toString() {
		return "SubsidyEntity [sid=" + sid + ", amount=" + amount + ", reason=" + reason + ", type="
				+ type + ", pe=" + pe + ", month=" + month + "]";
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
}
