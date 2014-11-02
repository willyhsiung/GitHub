package com.yihong.seniorcare.web.helper;

import java.util.*;

import com.yihong.seniorcare.common.ProductProperties;


public class PagingMgr {
	@SuppressWarnings("unused")
	
	
    private int recordsPerPage;
    private int recordFrom;
    private int recordTo;
    private static int numberofRecords = -1;
   // @SuppressWarnings("unchecked")
	private List pages;
    private int numberofPages;
    ProductProperties productProperties = null;

    public void setPagingProperties(int pageNumber) {
    	productProperties = new ProductProperties();
    	//productProperties.initialize();
        recordsPerPage = Integer.parseInt(productProperties.getProperty("recordsPerPage", "20"));

        recordFrom = (pageNumber - 1) * recordsPerPage + 1;

        if (numberofRecords < 0) {
            recordTo = recordFrom + recordsPerPage - 1;
        }
        else {
            recordTo = Math.min(numberofRecords, recordFrom + recordsPerPage - 1);
            numberofPages = (int) Math.ceil((double) numberofRecords / (double) recordsPerPage);
        }
        pages = PagesStrings(numberofPages);
    }

    @SuppressWarnings("unchecked")
	private List PagesStrings(int numberofPages) {
	    List pages = new ArrayList(numberofPages);
	    for (int i = 0; i < numberofPages; i++) {
	        pages.add(i, String.valueOf(i + 1));
	    }
	    return pages;
    }

    @SuppressWarnings("static-access")
	public void setNumberofRecords(String numberofRecords) {
        this.numberofRecords = Integer.parseInt(numberofRecords);
    }

    public String getRecordFrom() {
        return String.valueOf(recordFrom);
    }

    public String getRecordTo() {
        return String.valueOf(recordTo);
    }

    public String getNumberofRecords() {
        return String.valueOf(numberofRecords);
    }

    @SuppressWarnings("unchecked")
	public List getPages() {
        return pages;
    }
}
