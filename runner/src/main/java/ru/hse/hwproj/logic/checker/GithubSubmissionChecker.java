package ru.hse.hwproj.logic.checker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.model.HwSubmission;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

@Component
public class GithubSubmissionChecker implements SubmissionChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubSubmissionChecker.class);

    @Override
    public HwSubmission checkSubmission(String title, HwSubmission hwSubmission) {
        Path fileNamePath = Path.of(hwSubmission.getSolution()).getFileName();
        String request = "git clone " + hwSubmission.getSolution() + ".git --branch " + title;

        try {
            int gitExitCode = executeCommand("/bin/bash", "-c", request).waitFor();
            if (gitExitCode != 0) LOGGER.error("Git clone was unsuccessful");

            Process checkerProcess = executeCommand("/bin/bash", "-c", "script.sh", fileNamePath.toString());
            int checkerExitCode = checkerProcess.waitFor();

            String checkerVerdict = new StringBuilder()
                    .append("code = " + checkerExitCode + "\n")
                    .append(new String(checkerProcess.getInputStream().readAllBytes(), StandardCharsets.UTF_8) + "\n")
                    .append(new String(checkerProcess.getErrorStream().readAllBytes(), StandardCharsets.UTF_8)).toString();
            hwSubmission.setCheckerVerdict(checkerVerdict);
        } catch (InterruptedException | IOException e) {
            hwSubmission.setCheckerVerdict("Error during checking");
            LOGGER.error("Error during external command execution");
        }

        return hwSubmission;
    }

    private Process executeCommand(String... args) throws IOException {
        try {
            return new ProcessBuilder(args).start();
        } catch (IOException e) {
            LOGGER.error("Error during external command execution");
            throw new IOException();
        }
    }
}
