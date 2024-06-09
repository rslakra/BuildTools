package com.devamatre.buildtools.coreservice;

import java.util.HashMap;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:36:46
 */
public final class ServiceParams extends HashMap<String, Object> {

    public ServiceParams() {
        super();
    }

    public ServiceParams(ServiceParamBuilder serviceParams) {
        super(serviceParams);
    }

    /**
     *
     */
    public static class ServiceParamBuilder extends HashMap<String, Object> {

        /**
         * @param key
         * @param value
         * @return
         */
        public ServiceParamBuilder of(final String key, final Object value) {
            super.put(key, value);
            return this;
        }

        /**
         * @return
         */
        public ServiceParams build() {
            return new ServiceParams(this);
        }
    }

    /**
     * @return
     */
    public static ServiceParamBuilder newBuilder() {
        return new ServiceParamBuilder();
    }

}
