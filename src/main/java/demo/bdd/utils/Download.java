package demo.bdd.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Download {

    public static File getFileFromLocation(String filePath, String fileName) {
        File dir = new File(filePath);

        for (File file : dir.listFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }

        return null;
    }

    public static File getFileFromGrid(String gridUrl, String sessionId, String fileName, String saveDirPath) throws Exception {
        waitForFileOnGrid(gridUrl, sessionId, fileName, 15, 2000);

        URL url = new URL(gridUrl + "/session/" + sessionId + "/se/files");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String body = "{\"name\": \"" + fileName + "\"}";
        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes());
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }

        String base64Contents = new JSONObject(response.toString())
                .getJSONObject("value")
                .getString("contents");

        byte[] zipBytes = Base64.getDecoder().decode(base64Contents);
        File saveDir = new File(saveDirPath);

        try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(fileName)) {
                    File outFile = new File(saveDir, fileName);
                    try (FileOutputStream fos = new FileOutputStream(outFile)) {
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                    return outFile;
                }
            }
        }
        return null;
    }

    private static void waitForFileOnGrid(String gridUrl, String sessionId, String fileName, int maxAttempts, long pollIntervalMs) throws Exception {
        for (int i = 0; i < maxAttempts; i++) {
            if (isFileListedOnGrid(gridUrl, sessionId, fileName)) {
                return;
            }
            Thread.sleep(pollIntervalMs);
        }
        throw new RuntimeException("File '" + fileName + "' did not appear on Selenium Grid after " + (maxAttempts * pollIntervalMs / 1000) + " seconds");
    }

    private static boolean isFileListedOnGrid(String gridUrl, String sessionId, String fileName) {
        try {
            URL url = new URL(gridUrl + "/session/" + sessionId + "/se/files");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                return false;
            }

            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONArray names = new JSONObject(response.toString())
                    .getJSONObject("value")
                    .getJSONArray("names");

            for (int i = 0; i < names.length(); i++) {
                if (names.getString(i).equals(fileName)) {
                    return true;
                }
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
