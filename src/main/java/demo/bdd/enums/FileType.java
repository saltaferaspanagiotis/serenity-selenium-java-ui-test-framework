package demo.bdd.enums;

public enum FileType {
    DOCX("docx", "src/test/resources/testdata/sample1.docx", "sample1.docx"),
    TXT("txt", "src/test/resources/testdata/sample2.txt", "sample2.txt");


    private final String type;
    private final String path;
    private final String name;

    FileType(String type, String path, String name) {
        this.type = type;
        this.path = path;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public static FileType fromType(String type) {
        for (FileType fileType : values()) {
            if (fileType.type.equalsIgnoreCase(type)) {
                return fileType;
            }
        }
        throw new IllegalArgumentException("Unknown file type: " + type);
    }

    public static String getFilePathBasedOnType(String type) {
        FileType fileType = FileType.fromType(type);
        return fileType.getPath();
    }

    public static String getFileNameBasedOnType(String type) {
        FileType fileType = FileType.fromType(type);
        return fileType.getName();
    }

    public static String getFileNameBasedOnFilePath(String filePath) {
        for (FileType fileType : values()) {
            if (fileType.getPath().equals(filePath)) {
                return fileType.getName();
            }
        }
        throw new IllegalArgumentException("Unknown file path: " + filePath);
    }
}