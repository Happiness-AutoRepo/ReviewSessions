@csvReportDataValidation
Feature: Applicants data cvs report

Background:
	Given User is on Applicants report page

Scenario: Validate UI data against CSV report
	Given User can read applicants data from table
	And csv report is generated
	Then data in UI and csv report should match