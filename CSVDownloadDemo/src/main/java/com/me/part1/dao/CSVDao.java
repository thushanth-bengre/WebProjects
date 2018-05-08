package com.me.part1.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.me.part1.pojo.CSVData;
import com.me.part1.pojo.CSVDataList;



public class CSVDao extends DAO {
	private int ROWS_TO_DISPLAY = 500; // Number of rows to display
	private ArrayList<CSVData> dataList;
	private String dir = "C:\\Users\\thush\\Documents\\SpringProjects\\HW6Part1\\";
	private int rows = 0;

	public int getCsvCount(String filename) {
		try {
			Class.forName("org.relique.jdbc.csv.CsvDriver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:relique:csv:" + dir);
			Statement stmt = conn.createStatement();

			String query = "SELECT COUNT(*) AS totalRows FROM " + filename;
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				rows = rs.getInt(1);
			}
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<CSVData> getCsvData(String filename, Integer pageNum) {
		int offsetVal = 0;
		try {
			Class.forName("org.relique.jdbc.csv.CsvDriver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:relique:csv:" + dir);
			Statement stmt = conn.createStatement();
			if (pageNum == 1) {
				offsetVal = 1;
			} else {
				offsetVal = (int) (ROWS_TO_DISPLAY * (pageNum - 1));
			}
			String query = "SELECT * FROM " + filename + " LIMIT " + ROWS_TO_DISPLAY + " OFFSET " + offsetVal;
			ResultSet rs = stmt.executeQuery(query);

			dataList = new ArrayList<CSVData>();
			CSVDataList cData = new CSVDataList();

			while (rs.next()) {
				CSVData cv = new CSVData();
				cv = cData.addRow();
				cv.setSalesOrder(rs.getString("SalesOrderID"));
				cv.setRevisionNumber(rs.getString("RevisionNumber"));
				cv.setOrderDate(rs.getString("OrderDate"));
				cv.setDueDate(rs.getString("DueDate"));
				cv.setShipDate(rs.getString("ShipDate"));
				cv.setStatus(rs.getString("Status"));
				cv.setOnlineOrderFlag(rs.getString("OnlineOrderFlag"));
				cv.setSalesOrderNumber(rs.getString("SalesOrderNumber"));
				cv.setPurchaseOrderNumber(rs.getString("PurchaseOrderNumber"));
				cv.setAccountNumber(rs.getString("AccountNumber"));
				cv.setCustomerID(rs.getString("CustomerID"));
				cv.setSalesPersonID(rs.getString("SalesPersonID"));
				cv.setTerritoryID(rs.getString("TerritoryID"));
				cv.setBillToAddressID(rs.getString("BillToAddressID"));
				cv.setShipToAddressID(rs.getString("ShipToAddressID"));
				cv.setShipMethodID(rs.getString("ShipMethodID"));
				cv.setCreditCardID(rs.getString("CreditCardID"));
				cv.setCreditCardApprovalCode(rs.getString("CreditCardApprovalCode"));
				cv.setCurrencyRateID(rs.getString("CurrencyRateID"));
				cv.setSubTotal(rs.getString("SubTotal"));
				cv.setTaxAmt(rs.getString("TaxAmt"));
				cv.setFreight(rs.getString("Freight"));
				cv.setTotalDue(rs.getString("TotalDue"));
				cv.setComment(rs.getString("Comment"));
				cv.setModifiedDate(rs.getString("ModifiedDate"));

				dataList.add(cv);
			}
			return dataList;

			// getSession().createSQLQuery("LOAD DATA INFILE :filename INTO TABLE testtable
			// (text,price)")
			// .setString("filename", dir+filename).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getDataCount() {
		return dataList.size();
	}
}
