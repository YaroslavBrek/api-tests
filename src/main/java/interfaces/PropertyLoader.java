package interfaces;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("test.properties")
public interface PropertyLoader {
    @Property("envUrl")
    String envUrl();
    @Property("envPort")
    String envPort();
    @Property("baseUrl")
    String baseUrl();
}

