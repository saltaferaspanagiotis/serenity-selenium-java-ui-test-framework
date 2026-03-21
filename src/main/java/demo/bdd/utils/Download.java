package demo.bdd.utils;

import com.google.common.collect.ImmutableMap;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.thucydides.core.pages.PageObject;
import net.thucydides.model.util.EnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.http.Contents;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.io.Zip;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Download extends PageObject {

    public static File getFileFromLocation(String filePath, String fileName) {
        File dir = new File(filePath);

        for (File file : dir.listFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }

        return null;
    }

    public static File getFileFromGrid(String fileName, String saveDirPath) throws Exception {
        EnvironmentVariables environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        String remoteUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.remote.url");
        URL gridUrl = new URL(remoteUrl);
        String sessionId = ThucydidesWebDriverSupport.getSessionId().toString();
        String endpoint = "/session/%s/se/files".formatted(sessionId);
        File saveDir = new File(saveDirPath);

        int maxAttempts = 15;
        long pollIntervalMs = 2000;
        Exception lastException = null;

        for (int i = 0; i < maxAttempts; i++) {
            try (HttpClient client = HttpClient.Factory.createDefault().createClient(gridUrl)) {
                HttpRequest request = new HttpRequest(HttpMethod.POST, endpoint);
                String jsonPayload = new Json().toJson(ImmutableMap.of("name", fileName));
                request.setContent(() -> new ByteArrayInputStream(jsonPayload.getBytes(StandardCharsets.UTF_8)));

                HttpResponse response = client.execute(request);
                Map<String, Object> map = new Json().toType(Contents.string(response), Json.MAP_TYPE);
                @SuppressWarnings("unchecked")
                Map<String, Object> valueMap = (Map<String, Object>) map.get("value");
                String encodedContents = valueMap != null ? (String) valueMap.get("contents") : null;

                if (encodedContents != null) {
                    Zip.unzip(encodedContents, saveDir);
                    return new File(saveDir, fileName);
                }
            } catch (Exception e) {
                lastException = e;
            }
            Thread.sleep(pollIntervalMs);
        }

        throw new RuntimeException("File '" + fileName + "' did not appear on Selenium Grid after " +
                (maxAttempts * pollIntervalMs / 1000) + " seconds", lastException);
    }
}
