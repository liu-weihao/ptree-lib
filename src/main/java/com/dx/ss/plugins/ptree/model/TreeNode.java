package com.dx.ss.plugins.ptree.model;

public class TreeNode{

	private Integer id;

	private String name;

    private Integer nlevel;

    private Integer leftId;

    private Integer rightId;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNlevel() {
		return nlevel;
	}

	public void setNlevel(Integer nlevel) {
		this.nlevel = nlevel;
	}

	public Integer getLeftId() {
		return leftId;
	}

	public void setLeftId(Integer leftId) {
		this.leftId = leftId;
	}

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

}
