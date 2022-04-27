package org.tms.test;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.model.Car;

@Log4j2
public class CarTest{

    @Test
    public void compareCarTest(){
        Car car1 = new Car("bmw", "6", "red");
        Car car2 = new Car("bmw","6", "red");
        Car car3 = new Car();
        car3.setColor("black");
        car3.setBrand("audi");
        car3.setModel("7");
        Car car4 = Car.builder()
                          .brand("audi")
                          .color("red")
                          .build();
        Assert.assertEquals(car1,car2);

    }

    @Test
    public void loggerTest(){
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trance");
    }
}
