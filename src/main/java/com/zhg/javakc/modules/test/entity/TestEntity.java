package com.zhg.javakc.modules.test.entity;

import java.sql.Timestamp;

import com.zhg.javakc.base.entity.BaseEntity;

/**
 * 测试模块实体类
 * @author zhou
 * @version 0.1
 */
public class TestEntity extends BaseEntity<TestEntity>{
	private String testId;
	private String testName;
	private Timestamp testTime;
	private String testLevel;
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Timestamp getTestTime() {
		return testTime;
	}
	public void setTestTime(Timestamp testTime) {
		this.testTime = testTime;
	}
	public String getTestLevel() {
		return testLevel;
	}
	public void setTestLevel(String testLevel) {
		this.testLevel = testLevel;
	}
}
