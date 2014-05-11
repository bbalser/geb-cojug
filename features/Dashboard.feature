@web
Feature: Dashboard

  Scenario: Adding an article should save article
    Given select searchTab
    When add article New Title, Larry, txt to phone, 2014-05-13
    Then find article with title New Title

  Scenario: Search shoud find article by title
    Given select searchTab
    And add article Search Title, Larry, txt to phone, 2014-05-13
    When search by title Search Title
    Then find article with title Search Title

  Scenario: Editing article should save changes
    Given select searchTab
    And add article Edit Title, Larry, txt to phone, 2014-05-13
    When edit article with title Edit Title
    And update title to Edit2 Title
    Then find article with title Edit2 Title