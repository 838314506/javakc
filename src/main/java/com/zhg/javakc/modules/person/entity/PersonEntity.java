package com.zhg.javakc.modules.person.entity;

import java.util.Date;
import java.util.List;

import com.zhg.javakc.base.entity.BaseEntity;

public class PersonEntity extends BaseEntity<PersonEntity>{
	private String pid;//人员主键
	private String pname;//人员姓名
	private String idcard;//人员证件
	private int state;//人员状态1.离休2.退休
	private int grade;//人员职级
	private Date time;//起薪时间
	private List<SubsidyEntity> list;
	public List<SubsidyEntity> getList() {
		return list;
	}
	public void setList(List<SubsidyEntity> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PersonEntity [pid=" + pid + ", pname=" + pname + ", idcard=" + idcard + ", state="
				+ state + ", grade=" + grade + ", time=" + time + ", list=" + list + ", heating="
				+ heating + ", eatate=" + eatate + "]";
	}
	private int heating;//供暖
	private int eatate;//物业
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	public int getHeating() {
		return heating;
	}
	public void setHeating(int heating) {
		this.heating = heating;
	}
	public int getEatate() {
		return eatate;
	}
	public void setEatate(int eatate) {
		this.eatate = eatate;
	}
	
}
