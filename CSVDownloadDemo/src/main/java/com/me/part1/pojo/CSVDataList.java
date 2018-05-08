package com.me.part1.pojo;

import java.util.ArrayList;

public class CSVDataList {
	private ArrayList<CSVData> csvlist;

	public CSVDataList() {
        csvlist = new ArrayList<CSVData>();
    }

	public ArrayList<CSVData> getCsvlist() {
		return csvlist;
	}

	public CSVData addRow() {
		CSVData pd = new CSVData();
		csvlist.add(pd);
		return pd;
	}
}
