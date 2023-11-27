package com.springJpa.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.springJpa.entity.InsuranceEntity;
import com.springJpa.repo.InsuranceRepo;


@Component
public class DataLoader implements ApplicationRunner{

	
	@Autowired
	private InsuranceRepo repo;
	
	 public void run(ApplicationArguments args) throws Exception {
			
		 repo.deleteAll();
		 
		 
		 InsuranceEntity i1 = new InsuranceEntity();
		 i1.setName("Aravind");
		 i1.setGender("Male");
		 i1.setPlanName("Cash");
		 i1.setPlanStatus("Approved");
		 i1.setStartDate(LocalDate.now());
		 i1.setEndDate(LocalDate.now().plusMonths(6));
		 i1.setBenefit_amount(1000.00);
		 
		 InsuranceEntity i2 = new InsuranceEntity();
		 i2.setName("Neelima");
		 i2.setGender("Fe-Male");
		 i2.setPlanName("Cash");
		 i2.setPlanStatus("Approved");
		 i2.setStartDate(LocalDate.now());
		 i2.setEndDate(LocalDate.now().plusMonths(6));
		 i2.setBenefit_amount(1000.00);
		 
		 InsuranceEntity i3 = new InsuranceEntity();
		 i3.setName("Hari");
		 i3.setGender("Male");
		 i3.setPlanName("Cash");
		 i3.setPlanStatus("Declined");
		 i3.setDenial_reason("Income");
		 
		 InsuranceEntity i4 = new InsuranceEntity();
		 i4.setName("Santhu");
		 i4.setGender("Fe-Male");
		 i4.setPlanName("Cash");
		 i4.setPlanStatus("Declined");
		 i4.setDenial_reason("Income");
		 
		 InsuranceEntity i5 = new InsuranceEntity();
		 i5.setName("Venky");
		 i5.setGender("Male");
		 i5.setPlanName("Cash");
		 i5.setPlanStatus("Terminated");
		 i5.setStartDate(LocalDate.now().minusMonths(2));
		 i5.setEndDate(LocalDate.now().plusMonths(4));
		 i5.setTerminated_date(LocalDate.now());
		 i5.setTerminated_reason("Emoloyer");
		 
		 InsuranceEntity i6 = new InsuranceEntity();
		 i6.setName("Divya");
		 i6.setGender("Fe-Male");
		 i6.setPlanName("Cash");
		 i6.setPlanStatus("Terminated");
		 i6.setStartDate(LocalDate.now().minusMonths(1));
		 i6.setEndDate(LocalDate.now().plusMonths(5));
		 i6.setTerminated_date(LocalDate.now());
		 i6.setTerminated_reason("Employee");
		 
		 InsuranceEntity i7 = new InsuranceEntity();
		 i7.setName("Laxman");
		 i7.setGender("Male");
		 i7.setPlanName("Food");
		 i7.setPlanStatus("Approved");
		 i7.setStartDate(LocalDate.now());
		 i7.setEndDate(LocalDate.now().plusMonths(6));
		 i7.setBenefit_amount(1200.00);
		 
		 InsuranceEntity i8 = new InsuranceEntity();
		 i8.setName("Priya");
		 i8.setGender("Fe-Male");
		 i8.setPlanName("Food");
		 i8.setPlanStatus("Approved");
		 i8.setStartDate(LocalDate.now());
		 i8.setEndDate(LocalDate.now().plusMonths(6));
		 i8.setBenefit_amount(1200.00);
		 
		 InsuranceEntity i9 = new InsuranceEntity();
		 i9.setName("Sai");
		 i9.setGender("Male");
		 i9.setPlanName("Food");
		 i9.setPlanStatus("Declined");
		 i9.setDenial_reason("Income");
		 
		 InsuranceEntity i10 = new InsuranceEntity();
		 i10.setName("Vennela");
		 i10.setGender("Fe-Male");
		 i10.setPlanName("Food");
		 i10.setPlanStatus("Declined");
		 i10.setDenial_reason("Income");
		 
		 InsuranceEntity i11 = new InsuranceEntity();
		 i11.setName("Eshwar");
		 i11.setGender("Male");
		 i11.setPlanName("Food");
		 i11.setPlanStatus("Terminated");
		 i11.setStartDate(LocalDate.now().minusMonths(3));
		 i11.setEndDate(LocalDate.now().plusMonths(3));
		 i11.setTerminated_date(LocalDate.now());
		 i11.setTerminated_reason("Emoloyer");
		 
		 InsuranceEntity i12 = new InsuranceEntity();
		 i12.setName("Ramya");
		 i12.setGender("Fe-Male");
		 i12.setPlanName("Food");
		 i12.setPlanStatus("Terminated");
		 i12.setStartDate(LocalDate.now().minusMonths(1));
		 i12.setEndDate(LocalDate.now().plusMonths(5));
		 i12.setTerminated_date(LocalDate.now());
		 i12.setTerminated_reason("Employee");
		 
		 InsuranceEntity i13 = new InsuranceEntity();
		 i13.setName("Bharath");
		 i13.setGender("Male");
		 i13.setPlanName("Medical");
		 i13.setPlanStatus("Approved");
		 i13.setStartDate(LocalDate.now());
		 i13.setEndDate(LocalDate.now().plusMonths(6));
		 i13.setBenefit_amount(1500.00);
		 
		 InsuranceEntity i14 = new InsuranceEntity();
		 i14.setName("Pavani");
		 i14.setGender("Fe-Male");
		 i14.setPlanName("Medical");
		 i14.setPlanStatus("Approved");
		 i14.setStartDate(LocalDate.now());
		 i14.setEndDate(LocalDate.now().plusMonths(6));
		 i14.setBenefit_amount(1500.00);
		 
		 InsuranceEntity i15 = new InsuranceEntity();
		 i15.setName("Rakesh");
		 i15.setGender("Male");
		 i15.setPlanName("Medical");
		 i15.setPlanStatus("Declined");
		 i15.setDenial_reason("Income");
		 
		 InsuranceEntity i16 = new InsuranceEntity();
		 i16.setName("Sravani");
		 i16.setGender("Fe-Male");
		 i16.setPlanName("Medical");
		 i16.setPlanStatus("Declined");
		 i16.setDenial_reason("Income");
		 
		 InsuranceEntity i17 = new InsuranceEntity();
		 i17.setName("Ramana");
		 i17.setGender("Male");
		 i17.setPlanName("Medical");
		 i17.setPlanStatus("Terminated");
		 i17.setStartDate(LocalDate.now().minusMonths(2));
		 i17.setEndDate(LocalDate.now().plusMonths(4));
		 i17.setTerminated_date(LocalDate.now());
		 i17.setTerminated_reason("Emoloyer");
		 
		 InsuranceEntity i18 = new InsuranceEntity();
		 i18.setName("Barsha");
		 i18.setGender("Fe-Male");
		 i18.setPlanName("Medical");
		 i18.setPlanStatus("Terminated");
		 i18.setStartDate(LocalDate.now().minusMonths(4));
		 i18.setEndDate(LocalDate.now().plusMonths(2));
		 i18.setTerminated_date(LocalDate.now());
		 i18.setTerminated_reason("Emoloyer");
		 
		 InsuranceEntity i19 = new InsuranceEntity();
		 i19.setName("Rahul");
		 i19.setGender("Male");
		 i19.setPlanName("Employment");
		 i19.setPlanStatus("Approved");
		 i19.setStartDate(LocalDate.now());
		 i19.setEndDate(LocalDate.now().plusMonths(6));
		 i19.setBenefit_amount(1600.00);
		 
		 InsuranceEntity i20 = new InsuranceEntity();
		 i20.setName("Sindhu");
		 i20.setGender("Fe-Male");
		 i20.setPlanName("Employment");
		 i20.setPlanStatus("Approved");
		 i20.setStartDate(LocalDate.now());
		 i20.setEndDate(LocalDate.now().plusMonths(6));
		 i20.setBenefit_amount(1600.00);
		 
		 InsuranceEntity i21 = new InsuranceEntity();
		 i21.setName("Shiva");
		 i21.setGender("Male");
		 i21.setPlanName("Employment");
		 i21.setPlanStatus("Declined");
		 i21.setDenial_reason("Income");
		 
		 InsuranceEntity i22 = new InsuranceEntity();
		 i22.setName("Kavitha");
		 i22.setGender("Fe-Male");
		 i22.setPlanName("Employment");
		 i22.setPlanStatus("Declined");
		 i22.setDenial_reason("Income");
		 
		 InsuranceEntity i23 = new InsuranceEntity();
		 i23.setName("Devaraju");
		 i23.setGender("Male");
		 i23.setPlanName("Employment");
		 i23.setPlanStatus("Terminated");
		 i23.setStartDate(LocalDate.now().minusMonths(1));
		 i23.setEndDate(LocalDate.now().plusMonths(5));
		 i23.setTerminated_date(LocalDate.now());
		 i23.setTerminated_reason("Emoloyer");
		 
		 InsuranceEntity i24 = new InsuranceEntity();
		 i24.setName("Swapna");
		 i24.setGender("Fe-Male");
		 i24.setPlanName("Employment");
		 i24.setPlanStatus("Terminated");
		 i24.setStartDate(LocalDate.now().minusMonths(3));
		 i24.setEndDate(LocalDate.now().plusMonths(3));
		 i24.setTerminated_date(LocalDate.now());
		 i24.setTerminated_reason("Emoloyer");
		 
		 List<InsuranceEntity> lst = Arrays.asList(i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24);

         repo.saveAll(lst);
		  System.out.println("Data Inserted");
	}

	
}
