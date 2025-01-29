# Template for API testing automation with Rest Assured

|    Branch    |                                                                                                    Pipeline                                                                                                     |
|:------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|     main     |         [![pipeline](https://github.com/rqcruz/rest-assured-template/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/rqcruz/rest-assured-template/actions?query=branch%3Amain++)         |

|                📊 Test Execution Report                 |
|:-------------------------------------------------------:|
| [link](https://rqcruz.github.io/rest-assured-template/) |

## Welcome 🖐️

Hi folks! Welcome to my project **Template for API testing automation with Rest Assured**.

My name is Ronaldo ([Linkedin](https://www.linkedin.com/in/ronaldo-cruz-58b02ab)), I've been a QA for over 15 years and
I'm always looking for new knowledge and to improve those already acquired.
<br/>

## Index<a name="index"></a>

+ [About the project](#about)
+ [Used technologies](#technologies)
+ [Preparing the environment](#prep-env)
+ [Project structure](#structure)
+ [Test naming patterns](#name-patterns)
+ [Run the tests](#test-running)
+ [Test Report](#test-report)
+ [Debug log](#debug-log)
+ [Tests disabled](#tests-disabled)

## About the project 💪 <a name="about"></a>

Whenever we want to start an automation project, we spend a considerable amount of time on its initial creation. So,
using this template, it is possible to start a project with the architecture and initial configurations already created.
<br/>

## Used technologies 💻 <a name="technologies"></a>

* Programming language: [Java 17](https://www.oracle.com/java/technologies/downloads/?er=221886#java17)
* Runtime and Dependency manager: [Apache Maven](https://maven.apache.org/)
* Test framework:
    * [Rest Assured](https://rest-assured.io/)
    * [Hamcrest Java](http://hamcrest.org/JavaHamcrest/)
    * [JUnit 5](https://junit.org/junit5/)
    * [Datafaker](https://www.datafaker.net/)
* Test Report: [ExtentReports](https://extentreports.com/)

[back to the index 🔝](#index)

## Preparing the environment 🏗️ <a name="prep-env"></a>

To run the project, some prerequisites are necessary.

* Download and install Java JDK 17 ([site](https://www.oracle.com/java/technologies/downloads/?er=221886#java17))
* Download and install Maven ([site](https://maven.apache.org/download.cgi))
* Download and install an IDE, as Eclipse ([site](https://www.eclipse.org/downloads/)) or
  IntelliJ ([site](https://www.jetbrains.com/pt-br/idea/)).

[back to the index 🔝](#index)
<br/>

## Project structure 🗃️ <a name="structure"></a>

The project follows the structure below:

```
.
├── src
│   ├── main
│   │   └── java
│   │       ├── clients
│   │       │   ├── login/
│   │       │   ├── product/
│   │       │   └── users/
│   │       ├── dataprovider/
│   │       ├── dto/
│   │       ├── factory/
│   │       ├── specifications/
│   │       └── utils/
│   └── test
│       ├── java
│       │   ├── runner/
│       │   └── tests
│       │       ├── login/
│       │       ├── products/
│       │       └── users/
│       └── resources
│           ├── properties/
│           └── schema
│               ├── login/
│               └── users/
├── pom.xml
└── README.md
```

- `src/main/java/client`: classes that return methods that trigger clients. Each subfolder represents an API route.
- `src/main/java/dataprovider`: classes that returns a set of data mass.
- `src/main/java/dto`: classes that return objects to be used/serialized in clients.
- `src/main/java/factory`: classes that returns a set of complex objects
- `src/main/java/specifications`: classes with the specifications and other request configurations.
- `src/main/java/utils`: classes with methods to provide auxiliary functionality that does not fit directly into a
  specific class.
- `src/test/java/runner`: classes that run the test suites. They can run a specific group or all the tests in the
  project.
- `src/test/java/tests`: test classes. Each subfolder represents the test suite for an API route.
- `src/test/resources/properties`: files with properties used by other classes.
- `src/test/resources/schema`: files with the JSON schemas of the clients to be used in the contract tests.

[back to the index 🔝](#index)
<br/>

## Test naming patterns 📚 <a name="name-patterns"></a>

To maintain standardization in the naming of test classes, follow these rules:

- **Functional Tests**: They must contain the name of the route and end with `FunctionalTests`.

  > Ex: `LoginFunctionalTests` / `ProductFunctionalTests`

- **Contract Tests**: They must contain the name of the route and end with `ContractTests`.

  > Ex: `LoginContractTests` / `ProductContractTests`

- **Security Tests**: They must contain the name of the route and end with `SecurityTests`.

  > Ex: `LoginSecurityTests` / `ProductSecurityTests`

> ⚠️ **Attention:** This way, the tests are organized and easy to understand. In addition, the test suites were
> configured to run the tests that follow these nomenclatures.

[back to the index 🔝](#index)

## Run the tests 🦾⚙️ <a name="test-running"></a>

1. Clone of the repository.
2. Via IDE:
    - After importing the project, in the directory tree, go to `src/test/java/runner`.
    - Select one of the files `Run***.java` and run as `JUnit Test`.
3. Via command line:
    - Open the terminal.
    - Access the directory where the project was cloned, ex: `C:/Users/rest-assured-template`.
    - Run the command `mvn clean test`.

[back to the index 🔝](#index)

## Test Report 📊 <a name="test-report"></a>

After running the tests, the execution report is generated and can be found at:

*Local execution >*
`target/integrated-test-report/test-execution-report.html`

[back to the index 🔝](#index)

## Debug log 🔍 <a name="debug-log"></a>

We often need to consult the data generated by the request made, whether to fix a bug or even to validate whether the
request construction behaves as expected.

However, in order to avoid generating excessive data from the request body and response in the console log, a feature
was created that allows the developer to enable and disable the generation of this data as needed.

This function is located inside the class `specifications/RequestSpecificationSetup.java`

```java
requestAndResposeLog();
```

To enable and disable logging, simply change the values of the variables `IS_ENABLE_REQUEST_LOG`
and `IS_ENABLE_RESPONSE_LOG` to `true` or `false`.

```java
private static final boolean ENABLE_REQUEST_AND_RESPONSE_LOG = false;
```

[back to the index 🔝](#index)
<br/>

## Tests disabled 🚫 <a name="tests-disabled"></a>

The following tests have been disabled

| Test name             | Reason                                     | Bug ID        |
|-----------------------|--------------------------------------------|---------------|
| ExampleTests.testName | Testing has been disabled due to reason... | link to issue |

[back to the index 🔝](#index)
<br/>
