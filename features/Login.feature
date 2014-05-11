@web
Feature: Login

  Scenario: Successful login should land user on dashboard
    Given navigate to pages.LoginPage
    When login attempt with bbalser, password
    Then current page is pages.DashboardPage

  Scenario: Unsuccessful login should land user on login failure page
    Given navigate to pages.LoginPage
    When login attempt with chucky, chucky
    Then current page is pages.LoginFailurePage

  Scenario: User logout should navigate to login page
    Given select logoutTab
    When click logout button
    Then current page is pages.LoginPage
