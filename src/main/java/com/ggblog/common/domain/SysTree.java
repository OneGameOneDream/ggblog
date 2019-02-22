package com.ggblog.common.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SysTree {
	private String id;
	private String pId;
	private String name;
	private boolean open;
	@JsonProperty("isParent")
	private boolean isParent;
	private boolean checked;
	
	
	
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}
	/**
	 * @return the isParent
	 */
	public boolean isParent() {
		return isParent;
	}
	/**
	 * @param isParent the isParent to set
	 */
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the pId
	 */
	public String getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public SysTree(String id, String pId, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}
	
	public SysTree(String id, String pId, String name, boolean open, boolean isParent) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysTree [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + ", isParent=" + isParent
				+ "]";
	}
	public SysTree() {
		super();
	}
	
}
