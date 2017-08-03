
  Feature: Enter a Jira

    Scenario Outline: Search results should be retrieved for the JQL
      Given a JIRA search page
      When I enter the search term "<search_term>"
      Then results should be retrieved

      Examples:
      |search_term                                                                       |
      | project = "Medical Reporting 2.0" and sprint = "Sprint 30 - Gene U (7/13-7/26)"  |