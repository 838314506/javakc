package com.zhg.javakc.modules.myorgtree.entity;

import java.util.Date;

import com.zhg.javakc.base.entity.BaseEntity;
/**
 * 机构树实体类
 * @author lzz
 *
 */
public class OrgEntity extends BaseEntity<OrgEntity>{
	private String orgId;
	private String orgName;
	private String orgParentId;
	private String orgOpen;
	private String orgLevel;
	private int orgOrder;
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgParentId() {
		return orgParentId;
	}
	public void setOrgParentId(String orgParentId) {
		this.orgParentId = orgParentId;
	}
	public String getOrgOpen() {
		return orgOpen;
	}
	public void setOrgOpen(String orgOpen) {
		this.orgOpen = orgOpen;
	}
	public String getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	public int getOrgOrder() {
		return orgOrder;
	}
	public void setOrgOrder(int orgOrder) {
		this.orgOrder = orgOrder;
	}
	@Override
	public String toString() {
		return "OrgEntity [orgId=" + orgId + ", orgName=" + orgName + ", orgParentId=" + orgParentId
				+ ", orgOpen=" + orgOpen + ", orgLevel=" + orgLevel + ", orgOrder=" + orgOrder
				+ "]";
	}

}
