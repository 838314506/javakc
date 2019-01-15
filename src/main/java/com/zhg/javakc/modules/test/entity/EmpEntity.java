package com.zhg.javakc.modules.test.entity;

import java.util.Date;

/**
 * 员工表实体类
 * @author lzz
 *
 */
public class EmpEntity {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hireDate;
	private double sal;
	private double comm;
	private int deptno;
	@Override
	public String toString() {
		return "EmpEntity [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr
				+ ", hireDate=" + hireDate + ", sal=" + sal + ", comm=" + comm + ", deptno="
				+ deptno + "]";
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
