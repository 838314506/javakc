package com.zhg.javakc.modules.personnel.entity;
/**
 * 人事处人员补贴实体类
 * @author lzz
 *
 */
public class TypeEntity {
	private String tid;//补贴主键
	private int heating;//供暖补贴
	private int eatate;//物业补贴
	private int car;//车补
	private int hi;//医疗保险
	private int ei;//养老保险
	private int unemp;//失业保险
	private int oa;//职业年金
	private int oibirth;//工伤生育
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
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
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public int getHi() {
		return hi;
	}
	public void setHi(int hi) {
		this.hi = hi;
	}
	public int getEi() {
		return ei;
	}
	public void setEi(int ei) {
		this.ei = ei;
	}
	public int getUnemp() {
		return unemp;
	}
	public void setUnemp(int unemp) {
		this.unemp = unemp;
	}
	public int getOa() {
		return oa;
	}
	public void setOa(int oa) {
		this.oa = oa;
	}
	public int getOibirth() {
		return oibirth;
	}
	public void setOibirth(int oibirth) {
		this.oibirth = oibirth;
	}
	@Override
	public String toString() {
		return "TypeEntity [tid=" + tid + ", heating=" + heating + ", eatate=" + eatate + ", car="
				+ car + ", hi=" + hi + ", ei=" + ei + ", unemp=" + unemp + ", oa=" + oa
				+ ", oibirth=" + oibirth + "]";
	}
}
