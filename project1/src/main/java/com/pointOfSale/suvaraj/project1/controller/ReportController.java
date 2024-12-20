package com.pointOfSale.suvaraj.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.pointOfSale.suvaraj.project1.entity.Report;
import com.pointOfSale.suvaraj.project1.services.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping
	public Report createReport(@RequestBody Report report) {
		return reportService.addReport(report);
	}
	
	@GetMapping("/{id}")
	public  Report reportById(@PathVariable Long id) {
		return reportService.getReport(id);
	}
	
	@GetMapping
	public List<Report> reportAll(){
		return reportService.getReports();
	}
	@PutMapping("/{id}")
	public Report editReport(@PathVariable long id,@RequestBody Report report) {
		return reportService.updateReport(id, report);
	}
	@DeleteMapping("/{id}")
	public String removeReport(@PathVariable long id) {
		reportService.deleteReport(id);
		return "Successfully Deleted";
	}
	
     

}
