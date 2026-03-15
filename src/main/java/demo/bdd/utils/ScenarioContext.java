package demo.bdd.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScenarioContext {

    private final ThreadLocal<String> rating;
    private final ThreadLocal<String> originalWindowHandle;
    private final ThreadLocal<String> newWindowHandle;
    private final ThreadLocal<Integer> frameIndex;
    private final ThreadLocal<List<String>> filePaths;
    private final ThreadLocal<String> downloadedFileName;

    public ScenarioContext() {
        rating = ThreadLocal.withInitial(() -> null);
        originalWindowHandle = ThreadLocal.withInitial(() -> null);
        newWindowHandle = ThreadLocal.withInitial(() -> null);
        frameIndex = ThreadLocal.withInitial(() -> 0);
        filePaths = ThreadLocal.withInitial(ArrayList::new);
        downloadedFileName = ThreadLocal.withInitial(() -> null);
    }

    public String getRating() {
        return rating.get();
    }

    public void setRating(String value) {
        rating.set(value);
    }

    public String getOriginalWindowHandle() {
        return originalWindowHandle.get();
    }

    public void setOriginalWindowHandle(String handle) {
        originalWindowHandle.set(handle);
    }

    public String getNewWindowHandle() {
        return newWindowHandle.get();
    }

    public void setNewWindowHandle(String handle) {
        newWindowHandle.set(handle);
    }

    public int getFrameIndex() {
        return frameIndex.get();
    }

    public void setFrameIndex(int index) {
        frameIndex.set(index);
    }

    public List<String> getFilePaths() {
        return filePaths.get();
    }

    public void addFilePath(String filePath) {
        filePaths.get().add(filePath);
    }

    public String getDownloadedFileName() {
        return downloadedFileName.get();
    }

    public void setDownloadedFileName(String fileName) {
        downloadedFileName.set(fileName);
    }
}
