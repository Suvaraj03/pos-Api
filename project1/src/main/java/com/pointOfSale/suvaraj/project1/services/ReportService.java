package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Report;
import com.pointOfSale.suvaraj.project1.repository.ReportRepository;

@Service
public class ReportService implements IReportService {
	
	@Autowired
	private ReportRepository repo;

	@Override
	public Report addReport(Report report) {
		
		return repo.save(report);
	}

	@Override
	public Report getReport(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Report> getReports() {
		
		return repo.findAll();
	}

	@Override
	public Report updateReport(long id, Report report) {
		if(repo.findById(id).isEmpty()){
			throw new RuntimeException("Payment  ID is not found");
		}
		else {
			report.setId(id);
			addReport(report);
		}
		return report;
	}

	@Override
	public String deleteReport(long id) {
		repo.deleteById(id);
		return "Your Report is Deleted successfully";
	}

}
