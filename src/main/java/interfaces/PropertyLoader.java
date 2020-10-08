package interfaces;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("test.properties")
public interface PropertyLoader {
    @Property("site.url")
    String getUrl();
}

