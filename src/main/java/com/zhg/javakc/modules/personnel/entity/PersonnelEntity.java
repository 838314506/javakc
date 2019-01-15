package com.zhg.javakc.modules.personnel.entity;

import java.util.Date;

import com.zhg.javakc.base.entity.BaseEntity;
/**
 * 人事处人员管理实体类
 * @author lzz
 *
 */
public class PersonnelEntity extends BaseEntity<PersonnelEntity>{
	private String peid;//人员主键
	private String pename;//人员姓名
	private String idcard;//人员证件
	private int state;//人员在职状态1：在职；2：休假
	private int grade;//人员职级
	private Date time;//人员起薪时间
	private int compact;//人员是否合同制1：是；2：否
	private TypeEntity te;//人员补贴项对象对应数据库中cadre_personnel_type中的主键
	private String reason;//更改原因
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	@Override
	public String toString() {
		return "PersonnelEntity [peid=" + peid + ", pename=" + pename + ", idcard=" + idcard
				+ ", state=" + state + ", grade=" + grade + ", time=" + time + ", compact="
				+ compact + ", te=" + te + ", reason=" + reason + "]";
	}
	public String getPeid() {
		return peid;
	}
	public void setPeid(String peid) {
		this.peid = peid;
	}
	public String getPename() {
		return pename;
	}
	public void setPename(String pename) {
		this.pename = pename;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getCompact() {
		return compact;
	}
	public void setCompact(int compact) {
		this.compact = compact;
	}
	public TypeEntity getTe() {
		return te;
	}
	public void setTe(TypeEntity te) {
		this.te = te;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
