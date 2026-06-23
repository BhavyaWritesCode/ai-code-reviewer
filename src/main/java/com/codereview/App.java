package com.codereview;

import com.codereview.model.CodeMetrics;
import com.codereview.model.ReviewResult;
import com.codereview.parser.JavaCodeParser;
import com.codereview.ai.LangChainService;
import com.codereview.ai.ResultMerger;
import com.codereview.storage.ReviewRepo;
public class App {
    public static void main(String[] args) {

        String testCode = """
                public class BadCode {
                    private int x;
                    private String n;
                    
                    public void go() {
                        if (x > 0) {
                            x++;
                        }
                        try {
                            int y = x / 0;
                        } catch (Exception e) {
                            
                        }
                    }
                    
                    public void a() {
                        System.out.println("bad method name");
                    }
                }
                """;

        JavaCodeParser parser = new JavaCodeParser();
        CodeMetrics metrics = parser.parse(testCode);

        LangChainService aiService = new LangChainService();

        String bugReport = aiService.detectBugs(metrics, testCode);
        System.out.println("=== BUG DETECTION REPORT ===");
        System.out.println(bugReport);
        
        String securityReport = aiService.scanSecurity(metrics, testCode);
        System.out.println("=== SECURITY REPORT ===");
        System.out.println(securityReport);

        String qualityReport = aiService.scoreQuality(metrics, testCode);
        System.out.println("=== QUALITY REPORT ===");
        System.out.println(qualityReport);

        ResultMerger merger = new ResultMerger();
        ReviewResult finalResult = merger.merge(bugReport, securityReport, qualityReport, testCode);

        String refactorResult = aiService.refactorCode(testCode, bugReport, securityReport, qualityReport);
        System.out.println("=== REFACTORING SUGGESTION ===");
        System.out.println(refactorResult);

        System.out.println("=== FINAL MERGED RESULT ===");
        System.out.println(finalResult);

        ReviewRepo repo = new ReviewRepo();
        repo.save(finalResult);
    }
}