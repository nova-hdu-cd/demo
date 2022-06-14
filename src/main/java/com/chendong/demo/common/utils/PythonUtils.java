package com.chendong.demo.common.utils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dong.chen
 * @date 2021 10 21 18:37
 */
public class PythonUtils {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis() / 1000;
        ProcessBuilder processBuilder = new ProcessBuilder("python", resolvePythonScriptPath("merging_clos.py"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        List<String> results = readProcessOutput(process.getInputStream());
        long end = System.currentTimeMillis() / 1000;
        System.out.println("results = " + results);
        System.out.println("时间耗时：" + (end - start));
    }

    private static String resolvePythonScriptPath(String fileName) {
        File file = new File("src/main/resources/" + fileName);
        return file.getAbsolutePath();
    }

    private static List<String> readProcessOutput(InputStream inputStream) throws IOException {
        try (BufferedReader output = new BufferedReader(new InputStreamReader(inputStream))) {
            return output.lines().collect(Collectors.toList());
        }
    }

}
