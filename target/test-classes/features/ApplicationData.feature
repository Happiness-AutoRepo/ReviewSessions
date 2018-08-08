
@csvReportDataValidation
Feature: Applicants Data .csv report

Background: 
		Given: User is on applicants report page

@tag1
Scenario: Validate UI data against csv report
    Given User can read applicants data from table
    And .csv report is generated
    Then Data in UI and csv report should match

