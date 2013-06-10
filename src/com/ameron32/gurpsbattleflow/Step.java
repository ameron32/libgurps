package com.ameron32.gurpsbattleflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Step implements Serializable {
	private static final long serialVersionUID = 2748197057979662966L;

	String stepName;
	int ver;
	List<String> goToOpts;
	List<String> splitToOpts;
	List<String> refs;
	String table;

	String description;

	public Step(String stepName, int ver, String goToOpts, String splitToOpts,
			String refs, String table, String description) {
		this.stepName = stepName;
		this.ver = ver;
		this.goToOpts = StringTools.genList(goToOpts);
		this.splitToOpts = StringTools.genList(splitToOpts);
		this.refs = StringTools.genList(refs);
		this.table = table;
		this.description = description;
	}



	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

	public List<String> getGoToOpts() {
		return goToOpts;
	}

	public void setGoToOpts(List<String> goToOpts) {
		this.goToOpts = goToOpts;
	}

	public List<String> getSplitToOpts() {
		return splitToOpts;
	}

	public void setSplitToOpts(List<String> splitToOpts) {
		this.splitToOpts = splitToOpts;
	}

	public List<String> getRefs() {
		return refs;
	}

	public void setRefs(List<String> refs) {
		this.refs = refs;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Step [stepName=" + stepName + ", ver=" + ver + "\n"
				+ ", goToOpts=");
		sb.append("#" + goToOpts.size() + stringMe(goToOpts));
		sb.append(", " + "\n" + "splitToOpts=");
		sb.append("#" + splitToOpts.size() + stringMe(splitToOpts));
		sb.append(", " + "\n" + "refs=");
		sb.append("#" + refs.size() + stringMe(refs));
		sb.append(", " + "\n" + "table=" + table + "\n" + ", description="
				+ "\n" + description + "]");
		return sb.toString();
	}

	private String stringMe(List<String> ss) {
		StringBuilder sb = new StringBuilder();
		for (String s : ss) {
			sb.append(" [" + s + "]" + ", " + "\n");
		}
		return sb.toString();
	}

}
