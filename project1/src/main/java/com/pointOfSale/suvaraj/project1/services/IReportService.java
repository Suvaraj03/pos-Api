package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Report;

public interface IReportService {
	public Report addReport(Report report);
	//public Report addCountries(List<E>);
	public Report getReport(long id);
	public List<Report> getReports();
	public Report updateReport(long id,Report report);
	public String  deleteReport(long id);

}
