package com.FinalProject.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.FinalProject.Entity.VendorRatings;
import com.FinalProject.Entity.foodie;

public class UserExcelExporter {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<VendorRatings> vrlist;
	
	
	
	/*public UserExcelExporter(List<foodie> flist) {
		super();
		this.flist = flist;
		workbook =new XSSFWorkbook();
		sheet=workbook.createSheet("foodie");
		
	}*/
	
	public UserExcelExporter(List<VendorRatings> vrlist) {
		super();
		this.vrlist = vrlist;
		workbook =new XSSFWorkbook();
		sheet=workbook.createSheet("ratings");
	}
	
	private void writeHeaderRow() {
		
		Row row=sheet.createRow(0);
		
		CellStyle style=workbook.createCellStyle();
		XSSFFont font =workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		Cell cell=row.createCell(0);
		cell.setCellValue("VendorName");
		cell.setCellStyle(style);
		
		cell=row.createCell(1);
		cell.setCellValue("Number Of Ratings");
		cell.setCellStyle(style);
		
		cell=row.createCell(2);
		cell.setCellValue("Ratings for 1");
		cell.setCellStyle(style);
		
		cell=row.createCell(3);
		cell.setCellValue("Ratings for 2");
		cell.setCellStyle(style);
		
		cell=row.createCell(4);
		cell.setCellValue("Ratings for 3");
		cell.setCellStyle(style);
		
		cell=row.createCell(5);
		cell.setCellValue("Ratings for 4");
		cell.setCellStyle(style);
		
		cell=row.createCell(6);
		cell.setCellValue("Ratings for 5");
		cell.setCellStyle(style);
		
		
	}

	

	private void writeDataRows() {
		
		int rowCount=1;
		
		CellStyle style=workbook.createCellStyle();
		XSSFFont font =workbook.createFont();
		font.setBold(true);
		font.setFontHeight(14);
		style.setFont(font);
		
		for(VendorRatings ob:vrlist) {
			Row row=sheet.createRow(rowCount++);
			
			Cell cell=row.createCell(0);
			cell.setCellValue(ob.getVendorname());
			sheet.autoSizeColumn(0);
			
			cell=row.createCell(1);
			cell.setCellValue(ob.getNoofreviews());
			sheet.autoSizeColumn(1);
			
			cell=row.createCell(2);
			cell.setCellValue(ob.getNoofones());
			sheet.autoSizeColumn(2);
			
			cell=row.createCell(3);
			cell.setCellValue(ob.getNooftwos());
			sheet.autoSizeColumn(3);
			
			cell=row.createCell(4);
			cell.setCellValue(ob.getNoofthrees());
			sheet.autoSizeColumn(4);
			
			cell=row.createCell(5);
			cell.setCellValue(ob.getNooffours());
			sheet.autoSizeColumn(5);
			
			cell=row.createCell(6);
			cell.setCellValue(ob.getNooffives());
			sheet.autoSizeColumn(6);
			
			
			
			
		}
		
		/*for(foodie f: flist) {
			
			Row row=sheet.createRow(rowCount++);
			
			Cell cell=row.createCell(0);
			cell.setCellValue(f.getFoodieid());
			sheet.autoSizeColumn(0);
			
			cell=row.createCell(1);
			cell.setCellValue(f.getFirstname());
			sheet.autoSizeColumn(1);
			
			cell=row.createCell(2);
			cell.setCellValue(f.getLastname());
			sheet.autoSizeColumn(2);
			
			cell=row.createCell(3);
			cell.setCellValue(f.getEmailid());
			sheet.autoSizeColumn(3);
			
			cell=row.createCell(4);
			cell.setCellValue(f.getGender());
			sheet.autoSizeColumn(4);
		}*/
		
	}
	
	public void export(HttpServletResponse response) throws IOException {
		
		writeHeaderRow();
		writeDataRows();
		
		ServletOutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
