package scomp.simulatorRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SimulatorRunner {

    public static boolean runSimulator(String filePath, int collisionsThreshold) {
        Properties properties = new Properties();
        try (InputStream input = SimulatorRunner.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading config.properties");
            e.printStackTrace();
            return false;
        }
        final String simulatorPath = properties.getProperty("FilePath");
        String command = String.format("cd \"%s\" && ./projeto \"%s\" %d",simulatorPath, filePath, collisionsThreshold);
        ProcessBuilder builder = new ProcessBuilder("wsl", "bash", "-c", command);
        try {
            Process processo = builder.start();

            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getErrorStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            processo.waitFor();
            return processo.exitValue() == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
