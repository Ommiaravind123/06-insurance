package com.springJpa.util;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springJpa.entity.InsuranceEntity;
import com.springJpa.repo.InsuranceRepo;

@Component
public class ExcelGenerator {
	
	@Autowired
	private InsuranceRepo repo;

	
	public void generate(HttpServletResponse response,	List<InsuranceEntity> courses ,File file)throws Exception {
		
		 Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet("plans-data");
			Row row = sheet.createRow(0);

			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("Name");
			row.createCell(2).setCellValue("PlanName");
			row.createCell(3).setCellValue("PlanStatus");
			row.createCell(4).setCellValue("StartDate");
			row.createCell(5).setCellValue("EndDate");
			row.createCell(6).setCellValue("Benefit Amount");

			
			int dataRowIndex = 1;
			

			for (InsuranceEntity course : courses) {
			Row dataRow =   sheet.createRow(dataRowIndex);
				dataRow.createCell(0).setCellValue(course.getId());
				dataRow.createCell(1).setCellValue(course.getName());
				dataRow.createCell(2).setCellValue(course.getPlanName());
				dataRow.createCell(3).setCellValue(course.getPlanStatus());
				dataRow.createCell(4).setCellValue(course.getStartDate());
				dataRow.createCell(5).setCellValue(course.getEndDate());
				if(null!= course.getBenefit_amount()) {
				dataRow.createCell(6).setCellValue(course.getBenefit_amount());
				}
				else {
					dataRow.createCell(6).setCellValue("N/A");
				}
				dataRowIndex++;
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();

			ServletOutputStream ops = response.getOutputStream();
			workbook.write(ops);
			workbook.close();
	}
	
	
}
