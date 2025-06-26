@APIFeature
Feature: test API

  @Positive @Get
  Scenario: test get API
    Given [reqres] prepare set request header page to 2
    Given [reqres] prepare set request header x-api-key to "reqres-free-v1"
    When [reqres] send request get list users
    Then [reqres] send request get list users must be 200

  @Positive @Post
  Scenario: test post API
    Given [reqres] prepare set request header x-api-key to "reqres-free-v1"
    When [reqres] prepare set body request name to "monang"
    And [reqres] prepare set body request job to "QA Engineer"
    Then [reqres] send request post users
    And [reqres] send request post users response code must be 201
    And [reqres] send request post users response name must be "monang"
    And [reres] send request post users response job must be "QA Engineer"