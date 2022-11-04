# Assignment 4  
  
This assignment has been solved with **Java** and has been done with the use of BDD combined with frameworks such as:  
- Cucumber    
- Faker
- Flyway 
- JaCoCo
- JUnit 5  
- Maven
- Mockito
- PITest
- PMD

    
## 1.0 Mockito Powerups :computer: 
*Answer the following questions about Mockito. Use code examples in your explanations*  
To begin with I will have to **mock** a class which I will be using throughout all my answers. This is done with Mockito in the following way:  
```java
List<String> mockedList = mock(MyList.class);  
``` 
    
MyList class extends AbstractList<String>.   
     
- How do you verify that a mock was called?   
With Mockito i can verify a call with the **verify** method in the following way:  
```java  
mockedList.size();  
verify(mockedList, times(1)).size();  
```  
Note that I am calling the *size* method to then be able to verify that the method size was only called once, which is specified in the verify method.  
 
- How do you verify that a mock was NOT called?  
To be able to verify that a mock has not been called I can make use of *verifyNoInteractions* method in the following way:  
```java  
verifyNoInteractions(mockedList);  
```  
 
- How do you specify how many times a mock should have been called?  
This can be done in several ways. To begin with this can be specified as a parameter in the **verify** method (See the code example from question #1) where I use the **times(1)** method.  
This can also be achieved by using methods such as **atLeast** and **atMost**.  
```java  
mockedList.size();
mockedList.size();
mockedList.size();

verify(mockedList, atLeast(1)).size();
verify(mockedList, atMost(10)).size();  
```  
   
- How do you verify that a mock was called with specific arguments?  
I can verify that a mock has been called with specific arguments by useding the **verify** method in the following way:  
```java  
mockedList.add("Some Argument");
verify(mockedList).add("Some Argument");  
```    
      
- How do you use a predicate to verify the properties of the arguments given to a call to the mock?  
I did this in my previous test assignment by using **Mockito ArgumentMatchers** and more specific by using **argThat**. This was achieved in the following way:  
```java  
private BookingStorage bookingStorageMock;  
  
    @BeforeAll
    public void beforeAll() {
        bookingStorageMock = mock(BookingStorage.class);  
    }  
  
        ... more code inbetween here...  
  
        // Functionality  
        Assertions.assertEquals(bookingStorageMock.createBooking(new BookingCreation(customerID, employeeID, date, start, end)), actual);  
        // Behavior  
        verify(bookingStorageMock, times(2))  
                .createBooking(  
                        argThat(x -> x.getCustomerID() == (customerID) &&  
                                x.getEmployeeID() == (employeeID)));  
```  
  
Note that this can also be done in the *oldschool* way, if Mockito 2+ is not an option, with ArgumentCaptor but this is a bit more verbose.  
     
## 2.0 At least one
*Make at least one of the following three tasks: A, B or C. Whatever you choose, include coverage report (e.g Jacoco) and mutation testing (e.g. PITest, and static analysis (e.g. Findbugs, PMD, CheckStyle)).*

[Assignment description: A, B and C](https://github.com/Jean-Poul/Test-Assignment-4/blob/main/Assignment-04.pdf)  

We have chosen to go with option C - Tic-Tac-Toe  


*********************** NEDENFOR SKAL RETTES/SLETTES ***********************

### 1.1 In-depth explanation
*Further explanation for this assignment can be found at the following link: :point_down:*  
[Assignment 3](https://www.example.com)  
  
**Results:**  
![Green test](https://github.com/Jean-Poul/Test-Assignment-3/blob/main/pictures/results.PNG)  
  
### 1.2 Instructions

Use the following command to run a MySQL docker container:  
`docker run -d --rm --name mysql-test-db -e MYSQL_ROOT_PASSWORD=testuser123 -p 3307:3306 mysql`  
  
To make a clean build use the following command:  
`mvn clean install`  
  
To run all tests use the following command:  
`mvn test`    
  
To make a JaCoCo report use the following command:  
`mvn jacoco:report`  

To get a PMD report use the following command:  
`mvn compile site`
    
To run mutation test use the following command:  
`mvn test-compile org.pitest:pitest-maven:mutationCoverage`
  
**All generated reports can be found in the target/site/ folder.**    
  
High five :raised_hands:
  
---  
    
#### 2.0 TODO    
- Refactor code logic
- Refactor and split up tests
- Refactoring to kill more mutators  
- Test for not null and if an exception has been thrown  
- Make negative tests
- Refactor sms "system" code
- Clean the docker MySQL database before test (better solution would be to use an in-memory database like H2 for testing)
