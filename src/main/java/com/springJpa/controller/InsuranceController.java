package com.springJpa.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springJpa.entity.InsuranceEntity;
import com.springJpa.searchReq.SearchRequest;
import com.springJpa.service.ReportService;

@Controller
public class InsuranceController {
	
	@Autowired
	public ReportService service;
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");

      service.exportExcel(response);


	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");

      service.exportPdf(response);


	}
	
	@PostMapping("/search")
	public String search( SearchRequest request, Model model) {
		List<InsuranceEntity> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);
		model.addAttribute("search",request);
		
		return "index";
		
	}
	
	@GetMapping("/")
	public String indexpage(Model model) {

		init(model);
		
	    return "index";
	
	}

	private void init(Model model) {
		model.addAttribute("search",new  SearchRequest());
		model.addAttribute("names",service.getPlanNames());
	    model.addAttribute("status",service.getPlanStatus());
	}


}
