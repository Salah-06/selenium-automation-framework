package com.salah.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String captureScreenshot(
        WebDriver driver, String testName
    ) throws IOException {

        File source = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.FILE);

        String path = "screenshots/" + testName
            + "_" + System.currentTimeMillis() + ".png";

        Files.createDirectories(Paths.get("screenshots"));

        Files.copy(source.toPath(), Paths.get(path));

        return path;
    }
}