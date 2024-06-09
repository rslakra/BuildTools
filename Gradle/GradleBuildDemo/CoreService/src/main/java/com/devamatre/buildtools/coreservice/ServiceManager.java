package com.devamatre.buildtools.coreservice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:14:04s
 */
public class ServiceManager {

    // SERVICES
    private static final Map<ServiceType, Service> SERVICES = new HashMap<>();

    public ServiceManager() {
    }

    /**
     * @param service
     */
    public static void register(final ServiceType serviceType, final Service service) {
        SERVICES.put(serviceType, service);
    }

    /**
     * @param serviceType
     */
    public static void unregister(final ServiceType serviceType) {
        SERVICES.remove(serviceType);
    }

    /**
     * @return
     */
    public static Service getService(ServiceType serviceType) {
        return SERVICES.get(serviceType);
    }
}
