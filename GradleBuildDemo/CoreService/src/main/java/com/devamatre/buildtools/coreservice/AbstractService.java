package com.devamatre.buildtools.coreservice;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since Apr 24, 2021 13:42:46
 */
public abstract class AbstractService implements Service {

    private String name;

    /**
     * @param name
     */
    public AbstractService(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param serviceParams
     */
    @Override
    public void execute(ServiceParams serviceParams) {
        System.out.println(String.format("Executing [%s] with serviceParams:%s", this.getName(), serviceParams));
    }

    /**
     * @param responseBytes
     */
    @Override
    public void postExecute(byte[] responseBytes) {

    }
}
