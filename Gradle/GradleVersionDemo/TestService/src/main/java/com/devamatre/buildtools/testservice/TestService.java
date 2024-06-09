package com.devamatre.buildtools.testservice;

import com.devamatre.buildtools.coreservice.AbstractService;
import com.devamatre.buildtools.coreservice.ServiceParams;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:15:02
 */
public class TestService extends AbstractService {

    public TestService() {
        super("TestService");
    }

    /**
     * @return
     */
    @Override
    public ServiceParams getServiceParams() {
        return ServiceParams.newBuilder()
                .of("major", 1)
                .of("minor", 1)
                .of("revision", 1)
                .of("buildNumber", 0)
                .build();
    }

}
