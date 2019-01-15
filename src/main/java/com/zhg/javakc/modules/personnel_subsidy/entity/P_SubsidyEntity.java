package com.zhg.javakc.modules.personnel_subsidy.entity;

import java.util.Date;

import com.zhg.javakc.base.entity.BaseEntity;
import com.zhg.javakc.modules.personnel.entity.PersonnelEntity;
/**
 * 人事处人员补贴实体类
 * @author lzz
 *
 */
public class P_SubsidyEntity extends BaseEntity<P_SubsidyEntity>{
	private String sid;//人员补贴主键
	private double eb;//缴费基数
	private double rate;//缴费基率
	private double m_amount;//个人金额
	private double c_amount;//国家部分金额
	private String reason;//更改原因
	private int type;//补贴类型 1：医保；2：养老保险；3：养老失业；4：职业年金；5：工伤生育；6：物业补贴；7：供暖补贴；8:车补
	private PersonnelEntity pe;//补贴人员外键
	private Date month;//月份
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public double getEb() {
		return eb;
	}
	public void setEb(double eb) {
		this.eb = eb;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getM_amount() {
		return m_amount;
	}
	public void setM_amount(double m_amount) {
		this.m_amount = m_amount;
	}
	public double getC_amount() {
		return c_amount;
	}
	public void setC_amount(double c_amount) {
		this.c_amount = c_amount;
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
	
	@Override
	public String toString() {
		return "P_SubsidyEntity [sid=" + sid + ", eb=" + eb + ", rate=" + rate + ", m_amount="
				+ m_amount + ", c_amount=" + c_amount + ", reason=" + reason + ", type=" + type
				+ ", pe=" + pe + ", month=" + month + "]";
	}
	public PersonnelEntity getPe() {
		return pe;
	}
	public void setPe(PersonnelEntity pe) {
		this.pe = pe;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
}
