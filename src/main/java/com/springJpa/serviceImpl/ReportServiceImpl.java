package com.springJpa.serviceImpl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springJpa.entity.InsuranceEntity;
import com.springJpa.repo.InsuranceRepo;
import com.springJpa.searchReq.SearchRequest;
import com.springJpa.service.ReportService;
import com.springJpa.util.EmailUtil;
import com.springJpa.util.ExcelGenerator;
import com.springJpa.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private InsuranceRepo repo;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private PdfGenerator pdfGenerator;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repo.getPlanName();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatuses = repo.getPlanStatus();
		return planStatuses;
	}

	@Override
	public List<InsuranceEntity> search(SearchRequest request) {
		InsuranceEntity entity = new InsuranceEntity();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startdate = request.getStartDate();
			System.out.println("Starting date " + startdate);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// converting String to LocalDate
			LocalDate localdate = LocalDate.parse(startdate, date);
			System.out.println("local date " + localdate);

			entity.setStartDate(localdate);
		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String startdate = request.getEndDate();
			System.out.println("Starting date " + startdate);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// converting String to LocalDate
			LocalDate localdate = LocalDate.parse(startdate, date);
			System.out.println("local date " + localdate);

			entity.setEndDate(localdate);
		}
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		File f = new File("plans.xls");
		List<InsuranceEntity> courses = repo.findAll();

		excelGenerator.generate(response, courses, f);

		String subject = "Test mail subject";
		String body = "<h4>Test mail body</h4>";
		String to = "nallamaduguanusha@gmail.com";

		emailUtil.sendEmail(subject, body, to, f);
		f.delete();
		return true;

	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");

		List<InsuranceEntity> findAll = repo.findAll();
		pdfGenerator.generate(response, findAll, f);

		String subject = "Test mail subject";
		String body = "<h4>Test mail body</h4>";
		String to = "nallamaduguanusha@gmail.com";

		emailUtil.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}
}
