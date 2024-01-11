package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class singleton_test {

    newIdea temp;
    @Before
    public void beforeclass()
    {
        temp= new newIdea();
    }


    @Test
    public void test_Singleton() {
        user_class obj1= user_class.getInstance(temp.getUser());
        assertNotNull(obj1);

        user_class obj2= user_class.getInstance(temp.getUser());

        System.out.println("obj1 is "+obj1);
        System.out.println("obj2 is "+obj2);
        assertEquals(obj1,obj2);

    }

}