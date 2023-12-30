import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PyLangManager {

    private static final String PYTHON_CODE_FILE = "TempPythonCode.py";

    public static void runPythonCode(String pythonCode) throws IOException, InterruptedException {
        writePythonCodeToFile(pythonCode);
        executePythonCode();
        cleanup();
    }

    private static void writePythonCodeToFile(String pythonCode) throws IOException {
        try (FileWriter fileWriter = new FileWriter(PYTHON_CODE_FILE)) {
            fileWriter.write(pythonCode);
        }
    }

    private static void executePythonCode() throws IOException, InterruptedException {
        String executeCommand = "python " + PYTHON_CODE_FILE;

        Process executeProcess = Runtime.getRuntime().exec(executeCommand);

        Scanner scanner = new Scanner(executeProcess.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        executeProcess.waitFor();
    }

    private static void cleanup() {
        Path pythonCodePath = Paths.get(PYTHON_CODE_FILE);

        try {
            Files.deleteIfExists(pythonCodePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
