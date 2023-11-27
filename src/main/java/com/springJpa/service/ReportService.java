package com.springJpa.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.springJpa.entity.InsuranceEntity;
import com.springJpa.searchReq.SearchRequest;


@Service
public interface ReportService {

	public List<String> getPlanNames(); 
		
	public List<String> getPlanStatus();
	
	public List<InsuranceEntity> search(SearchRequest req);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response)throws Exception;
}
