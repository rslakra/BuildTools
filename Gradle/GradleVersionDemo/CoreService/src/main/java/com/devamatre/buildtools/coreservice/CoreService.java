package com.devamatre.buildtools.coreservice;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:33:51
 */
public class CoreService extends AbstractService {

    public CoreService() {
        super("CoreService");
    }

    /**
     * @return
     */
    @Override
    public ServiceParams getServiceParams() {
        return ServiceParams.newBuilder()
                .of("major", 0)
                .of("minor", 0)
                .of("revision", 1)
                .of("buildNumber", 0)
                .build();
    }

    /**
     * @param responseBytes
     */
    @Override
    public void postExecute(byte[] responseBytes) {

    }
}
