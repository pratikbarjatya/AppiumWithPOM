$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("productWatch.feature");
formatter.feature({
  "line": 1,
  "name": "Watching a Product",
  "description": "As an application user,\nI should be able to watch a product in the app",
  "id": "watching-a-product",
  "keyword": "Feature"
});
formatter.before({
  "duration": 25440939668,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Guest user watching a product",
  "description": "",
  "id": "watching-a-product;guest-user-watching-a-product",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I search for a product \"oneplus 5t\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I sort the search results by \"Highest Price\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I select the \"first\" available product",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I watch the product",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter my credentials to sign in",
  "rows": [
    {
      "cells": [
        "emailId",
        "password"
      ],
      "line": 11
    },
    {
      "cells": [
        "helloworld@gmail.com",
        "helloworld"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I close the sign in page",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I press back button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I want to print first \"2\" search results",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "oneplus 5t",
      "offset": 24
    }
  ],
  "location": "ProductWatchSteps.java:27"
});
formatter.result({
  "duration": 10069366443,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Highest Price",
      "offset": 30
    }
  ],
  "location": "ProductWatchSteps.java:32"
});
formatter.result({
  "duration": 10835211547,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "first",
      "offset": 14
    }
  ],
  "location": "ProductWatchSteps.java:38"
});
formatter.result({
  "duration": 2130804647,
  "status": "passed"
});
formatter.match({
  "location": "ProductWatchSteps.java:42"
});
formatter.result({
  "duration": 7796453662,
  "status": "passed"
});
formatter.match({
  "location": "ProductWatchSteps.java:46"
});
formatter.result({
  "duration": 17994763992,
  "status": "passed"
});
formatter.match({
  "location": "ProductWatchSteps.java:52"
});
formatter.result({
  "duration": 1273440648,
  "status": "passed"
});
formatter.match({
  "location": "ProductWatchSteps.java:56"
});
formatter.result({
  "duration": 956365775,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 23
    }
  ],
  "location": "ProductWatchSteps.java:60"
});
formatter.result({
  "duration": 6351848542,
  "status": "passed"
});
formatter.after({
  "duration": 3499084077,
  "status": "passed"
});
});