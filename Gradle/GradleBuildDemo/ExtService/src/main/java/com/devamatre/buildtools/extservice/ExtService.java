package com.devamatre.buildtools.extservice;

import com.devamatre.buildtools.coreservice.AbstractService;
import com.devamatre.buildtools.coreservice.ServiceParams;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:14:35
 */
public class ExtService extends AbstractService {

    public ExtService() {
        super("ExtService");
    }

    /**
     * @return
     */
    @Override
    public ServiceParams getServiceParams() {
        return ServiceParams.newBuilder()
                .of("major", 0)
                .of("minor", 1)
                .of("revision", 1)
                .of("buildNumber", 0)
                .build();
    }
}
