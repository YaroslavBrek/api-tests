package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<String> loadCsvData(String pathToFileInResources) {
        ClassLoader classloader = Thread.currentThread()
                .getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(pathToFileInResources);
        List<String> list = new ArrayList();
        String line;
        try (InputStreamReader streamReader = new InputStreamReader(is,
                StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(
                streamReader)) {
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
