package com.yihong.seniorcare.actionforms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public abstract class ListActionForm extends ActionForm {
	@SuppressWarnings("unused")
	
	// Paging Properties
	private String numberofRecords;
    private String recordFrom;
    private String recordTo;
	@SuppressWarnings("rawtypes")
	private List pagesList;
    private String pageNumber;
    private String isNewQuery;
    private String topPageSelector;
    private String botPageSelector;
    
	private String retrieve;
	private String clear;
	private String add;
	private String deleteUsers;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {	
		numberofRecords = "";
		recordFrom = "";
		recordTo = "";
		pageNumber = "" ;
	}

	public String getNumberofRecords() {
		return numberofRecords;
	}

	public void setNumberofRecords(String numberofRecords) {
		this.numberofRecords = numberofRecords;
	}

	public String getRecordFrom() {
		return recordFrom;
	}

	public void setRecordFrom(String recordFrom) {
		this.recordFrom = recordFrom;
	}

	public String getRecordTo() {
		return recordTo;
	}

	public void setRecordTo(String recordTo) {
		this.recordTo = recordTo;
	}

	@SuppressWarnings("rawtypes")
	public List getPagesList() {
		return pagesList;
	}

	@SuppressWarnings("rawtypes")
	public void setPagesList(List pagesList) {
		this.pagesList = pagesList;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getIsNewQuery() {
		return isNewQuery;
	}

	public void setIsNewQuery(String isNewQuery) {
		this.isNewQuery = isNewQuery;
	}

	public String getTopPageSelector() {
		return topPageSelector;
	}

	public void setTopPageSelector(String topPageSelector) {
		this.topPageSelector = topPageSelector;
	}

	public String getBotPageSelector() {
		return botPageSelector;
	}

	public void setBotPageSelector(String botPageSelector) {
		this.botPageSelector = botPageSelector;
	}

	public String getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(String retrieve) {
		this.retrieve = retrieve;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getDeleteUsers() {
		return deleteUsers;
	}

	public void setDeleteUsers(String deleteUsers) {
		this.deleteUsers = deleteUsers;
	}
}
