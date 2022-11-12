# Assignment 4  

## Group Members
  
- Jean-Poul Leth-Møller, cph-jl360@cphbusiness.dk  
- Magdalena Wawrzak cph-mw216@cphbusiness.dk  
- Tobias Zimmermann cph-tz11@cphbusiness.dk  
     
This assignment has been solved with **Java 17** and has been done with a BDD and TDD approach combined with frameworks such as:  
- Cucumber
- JaCoCo
- JUnit 5  
- Maven
- PITest
- PMD

    
## 1.0 Mockito Powerups :computer: 
*Answer the following questions about Mockito. Use code examples in your explanations*    
To begin with we will have to **mock** a class which we will be using throughout all our answers. This is done with Mockito in the following way:  
```java
List<String> mockedList = mock(MyList.class);  
``` 
    
MyList class extends AbstractList<String>.   
     
- How do you verify that a mock was called?   
With Mockito we can verify a call with the **verify** method in the following way:  
```java  
mockedList.size();  
verify(mockedList, times(1)).size();  
```  
**Note** that we are calling the *size* method to then be able to verify that the method size was only called once, which is specified in the verify method.  
 
- How do you verify that a mock was NOT called?  
To be able to verify that a mock has not been called we can use the *verifyNoInteractions* method in the following way:  
```java  
verifyNoInteractions(mockedList);  
```  
 
- How do you specify how many times a mock should have been called?  
This can be done in several ways. To begin with this can be specified as a parameter in the **verify** method (See the code example from question #1) where we use the **times(1)** method.  
This can also be achieved by using methods such as **atLeast** and **atMost**.  
```java  
mockedList.size();
mockedList.size();
mockedList.size();

verify(mockedList, atLeast(1)).size();
verify(mockedList, atMost(10)).size();  
```  
   
- How do you verify that a mock was called with specific arguments?  
We can verify that a mock has been called with specific arguments by using the **verify** method in the following way:  
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
  
        ... more code between here...  
  
        // Functionality  
        Assertions.assertEquals(bookingStorageMock.createBooking(new BookingCreation(customerID, employeeID, date, start, end)), actual);  
        // Behavior  
        verify(bookingStorageMock, times(2))  
                .createBooking(  
                        argThat(x -> x.getCustomerID() == (customerID) &&  
                                x.getEmployeeID() == (employeeID)));  
```  
  
**Note** that this can also be done in the *oldschool* way, if Mockito 2+ is not an option, with ArgumentCaptor but this is a bit more verbose.  
     
## 2.0 At least one
*Make at least one of the following three tasks: A, B or C. Whatever you choose, include coverage report (e.g Jacoco) and mutation testing (e.g. PITest, and static analysis (e.g. Findbugs, PMD, CheckStyle)).*

[Assignment description: A, B and C](https://github.com/Jean-Poul/Test-Assignment-4/blob/main/Assignment-04.pdf)  

We have chosen to go with option C and made a Tic-Tac-Toe game. 
  
### 2.1 Instructions

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
  
**All generated reports can be found in the target/site/ and target/pmd/ folders.**    
  
## 3.0 Results  
**Tests run:**    
![Green test](https://github.com/Jean-Poul/Test-Assignment-4/blob/main/pictures/green-test.PNG)  
  
High five :raised_hands:
