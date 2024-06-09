package com.devamatre.buildtools.testservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:15:15
 */
public class TestServiceTest {

    /**
     *
     */
    @Test
    public void testTestServiceApp() {
        TestServiceApp testServiceApp = new TestServiceApp();
        Assertions.assertNotNull(testServiceApp);
    }
}
