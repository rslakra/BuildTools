package com.devamatre.buildtools.coreservice;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:23:36
 */
public interface Service {

    /**
     * @return
     */
    String getName();


    /**
     * @return
     */
    ServiceParams getServiceParams();

    /**
     * @param serviceParams
     */
    void execute(ServiceParams serviceParams);

    /**
     * @param responseBytes
     */
    public void postExecute(byte[] responseBytes);
}
