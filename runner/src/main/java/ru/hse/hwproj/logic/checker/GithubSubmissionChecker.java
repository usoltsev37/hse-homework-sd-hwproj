package ru.hse.hwproj.logic.checker;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import ru.hse.hwproj.model.HwSubmission;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GithubSubmissionChecker implements SubmissionChecker {
    @Override
    public HwSubmission checkSubmission(String title, HwSubmission hwSubmission) {
        Path fileNamePath = Path.of(hwSubmission.getSolution()).getFileName();
        String request = "git clone " + hwSubmission.getSolution() + ".git --branch " + title;

        try {
            int gitExitCode = executeCommand("bash", "-c", request).waitFor();
            if (gitExitCode != 0) throw new RuntimeException();
            Process checkerProcess = executeCommand("bash", "script.sh", fileNamePath.toString());
            int checkerExitCode = checkerProcess.waitFor();
            String checkerVerdict = new StringBuilder()
                    .append("code = " + checkerExitCode + "\n")
                    .append(new String(checkerProcess.getInputStream().readAllBytes(), StandardCharsets.UTF_8) + "\n")
                    .append(new String(checkerProcess.getErrorStream().readAllBytes(), StandardCharsets.UTF_8)).toString();
            hwSubmission.setCheckerVerdict(checkerVerdict);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        return hwSubmission;
    }

    private Process executeCommand(String... args) {
        try {
            return new ProcessBuilder().command(
                    args
            ).start();
        } catch (IOException e) {
            Logger.getGlobal().log(Level.WARNING, "Error during external command execution");
            throw new RuntimeException();
        }
    }
}
