# Nets
This project is developed with Rest Assured Libraryfor API Testing

**IDE** : Eclipse,<br />
**Programming Language** : Java,<br />
**Library Used** : Rest Assured , TestNG<br />
**Build Tool** : Maven<br />

## the reason behind the chosen framework and pattern:
Rest assured is open source library and supports to Java and TestNG framework


## How to Clone project:
1. Download and Install Git from https://git-scm.com/downloads,<br />
2. Navigate to computer drive<br />
3. Open command prompt<br />
3. Enter command git clone https://github.com/stephenshinde/Nets.git<br />

## Install Maven build tool
1. Download Apache Maven<br />
2. Set enviornment variable path<br />

## How to Run Project:
**First Way**
1. Open command prompt <br />
2. Navigate to the project directory, where you are able to see project files and pom.xml<br />
3. Execute pom. xml file with command **mvn clean test** <br />

**Second Way**
1. Import the maven existing project in eclipse editor<br />
2. Right click on project and run as with mvn test<br />

**Third Way**
1. Right click on project and run as with testng test<br />


## How to access report
1. Once the execution is done<br />
2. report will generated in Reports folder and you can open with web browser<br />
Please note- Report template is added more modification required in reporting feature



## Project Structure:

1. com.APITests : Test cases<br />
2. com.base : base folder whicch contains base class<br />
3. com.Utility : Reusable utility for json path and pojo class<br />
4. com.automation.config : provides configuration file<br />
5. com.automation.helpers - provides helper class required to create reusable helpers<br />
6. testng.xml : testng executable file<br />
7. pom.xml : maven dependency file <br />

## Continuous Integration :
Navigate to Github repository-> Actions tab
