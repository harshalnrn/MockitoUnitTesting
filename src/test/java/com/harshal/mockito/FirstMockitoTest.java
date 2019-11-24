package com.harshal.mockito;

import com.harshal.sample.Customer;
import com.harshal.sample.Feedback;
import com.harshal.sample.WrongDishException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(MockitoJUnitRunner.class)
public class FirstMockitoTest {

//note diff bet junit 4, junit5 wrt annotations

    @InjectMocks
    private Customer customer;
    @Mock
    private Feedback feedback;

    @Before
    public void intializeMockitoBeforeEachMethod() {
        MockitoAnnotations.initMocks(this);               //by 'this', we mean current class
    }


    //pass cases: asserting logic, based upon multiple types of valid inputs

    //1 test method per input (wont it make code too large, if i keep one test method per input ?)
    @Test
    public void test() throws WrongDishException {
        //inputs for pass cases
        //if below not mocked, then null pointer exception, since real feedback object do not exist
        Mockito.when(feedback.getFeedback("dosa")).thenReturn("good");

        customer.eat("dosa");
    }

    @Test
    public void test1() throws WrongDishException {
        //inputs for pass cases
        //if below not mocked, then null pointer exception, since real feedback object do not exist

        Mockito.when(feedback.getFeedback("idli")).thenReturn("bad");
        customer.eat("idli");
    }


    //fail case: asserting exception, or, asserting response for invalid input
    @Test(expected = WrongDishException.class)
    public void test2() throws WrongDishException {
        //inputs for pass, fail cases
        Mockito.when(feedback.getFeedback("chapathi")).thenThrow(new WrongDishException("dish not available"));
        customer.eat("chapathi");

    }
}
