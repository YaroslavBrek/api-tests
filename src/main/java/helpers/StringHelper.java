package helpers;

import interfaces.PropertyLoader;

public class StringHelper {
    private static final PropertyLoader props = ru.qatools.properties.PropertyLoader.newInstance()
            .populate(PropertyLoader.class);

    public static String getEnvUrl() {
        return props.baseUrl() + props.envUrl() + ":" + props.envPort();
    }
}
