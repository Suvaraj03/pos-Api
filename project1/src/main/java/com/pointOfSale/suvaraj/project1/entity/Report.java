package com.pointOfSale.suvaraj.project1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private  long id;
	private String reportType;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private LocalDateTime generatedAt;
	public Report(long id, String reportType, LocalDateTime startDate, LocalDateTime endDate,
			LocalDateTime generatedAt) {
		super();
		this.id = id;
		this.reportType = reportType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.generatedAt = generatedAt;
	}
	public Report() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}
	
	

}
