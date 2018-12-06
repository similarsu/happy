package net.similarsu.log4j;

import org.junit.Test;

public class Log4jExampleTests {
    private Log4jExample log4jExample = new Log4jExample();
    private Log4jExample2 log4jExample2 = new Log4jExample2();

    @Test
    public void testExample1(){
        log4jExample.example1();
    }

    @Test
    public void testExample2(){
        log4jExample2.example2();
    }
}
