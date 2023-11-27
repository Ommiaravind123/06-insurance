package com.springJpa.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springJpa.entity.InsuranceEntity;
import com.springJpa.repo.InsuranceRepo;

@Component
public class PdfGenerator {

	@Autowired
	private InsuranceRepo repo;
	
	public void generate(HttpServletResponse response,List<InsuranceEntity> findAll,File f)throws Exception {
	Document d = new Document(PageSize.A4);
	
	PdfWriter.getInstance(d, response.getOutputStream());
	PdfWriter.getInstance(d, new FileOutputStream(f));
	d.open();
	
	Paragraph p = new Paragraph("Citizen Plans Info");
	
	d.add(p);
    
	PdfPTable table = new PdfPTable(6);
	
	table.addCell("id");
	table.addCell("name");
	table.addCell("planName");
	table.addCell("planStatus");
	table.addCell("startDate");
	table.addCell("endDate");
	
	
    
	for(InsuranceEntity list: findAll) {
		table.addCell(list.getId()+"");
		table.addCell(list.getName());
		table.addCell(list.getPlanName());
		table.addCell(list.getPlanStatus());
		table.addCell(list.getStartDate()+"");
		table.addCell(list.getEndDate()+"");
	}
	
	d.add(table);
	
	d.close();
}
}
