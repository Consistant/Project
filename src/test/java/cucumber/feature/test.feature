Feature: About Tester
  In order to get a high paid job
  As a manual tester
  I want to learn automation

  Scenario Outline: I am a manual Tester
    Given I am a "<Testtype>" Tester
      | Location | Jobtype    |
      | USA      | Contractor |
      | India    | Permanent  |
    When i apply for job
    Then i got "<salary>" paid job
    And i am "<satisfication_type>" satisfied with my salary
    But my family "<family>" satisfied

    Examples: 
      | Testtype   | salary | satisfication_type | family |
      | Manual     | less   | not                | still  |
      | Automation | high   | very               | highly |
      | Database   | good   | better             | better |
