package com.devamatre.buildtools.testservice;

import com.devamatre.buildtools.coreservice.CoreService;
import com.devamatre.buildtools.coreservice.Service;
import com.devamatre.buildtools.coreservice.ServiceManager;
import com.devamatre.buildtools.coreservice.ServiceType;
import com.devamatre.buildtools.extservice.ExtService;

import java.util.Arrays;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 14:40:05
 */
public class TestServiceApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServiceManager.register(ServiceType.CORE_SERVICE, new CoreService());
        ServiceManager.register(ServiceType.EXT_SERVICE, new ExtService());
        ServiceManager.register(ServiceType.TEST_SERVICE, new TestService());

        /**
         *
         */
        Arrays.asList(ServiceType.CORE_SERVICE, ServiceType.EXT_SERVICE, ServiceType.TEST_SERVICE)
                .forEach(serviceType -> {
                    Service service = ServiceManager.getService(serviceType);
                    service.execute(service.getServiceParams());
                });

    }
}
