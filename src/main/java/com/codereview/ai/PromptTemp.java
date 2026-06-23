package com.codereview.ai;

public class PromptTemp {
    public static final String BUG_PROMPT = """
        You are an expert Java code reviewer specializing in bug detection.
        
        Analyze the following Java code for logical bugs, null pointer risks,
        off-by-one errors, infinite loop risks, and incorrect conditional logic.
        
        Respond in this exact format:
        BUGS_FOUND: <number>
        - <bug description with line reference if possible>
        - <bug description with line reference if possible>
        
        If no bugs are found, respond with:
        BUGS_FOUND: 0
        No bugs detected.
        
        Code metrics:
        %s
        
        Code to review:
        %s
        """;
    public static final String SECURITY_PROMPT = """
        You are an expert Java security auditor.
        
        Analyze the following Java code for security vulnerabilities including
        hardcoded credentials or API keys, SQL injection risks, unsafe input
        handling, insecure deserialization, and improper exception exposure.
        
        Respond in this exact format:
        SECURITY_ISSUES_FOUND: <number>
        - <issue description with line reference if possible>
        - <issue description with line reference if possible>
        
        If no issues are found, respond with:
        SECURITY_ISSUES_FOUND: 0
        No security issues detected.
        
        Code metrics:
        %s
        
        Code to review:
        %s
        """;
    public static final String QUALITY_PROMPT = """
        You are an expert Java code quality reviewer.
        
        Evaluate the following Java code on naming conventions, method length,
        cyclomatic complexity, modularity, and adherence to clean code principles.
        
        Use the provided metrics to support your evaluation.
        
        Respond in this exact format:
        QUALITY_SCORE: <number from 0 to 100>
        - <observation about naming conventions>
        - <observation about method length/complexity>
        - <observation about modularity>
        
        Code metrics:
        %s
        
        Code to review:
        %s
        """;
    public static final String REFACTOR_PROMPT = """
        You are an expert Java developer specializing in code refactoring and mentorship.
        
        You are given a piece of Java code along with bug, security, and quality reports
        identifying issues in it. Fix every issue mentioned across all 3 reports.
        
        Respond in this exact format:
        
        REFACTORED_CODE:
        <the complete corrected Java code>
        
        EXPLANATIONS:
        - <explain what was fixed and why, tied to a specific issue from the reports>
        - <explain what was fixed and why, tied to a specific issue from the reports>
        
        Bug report:
        %s
        
        Security report:
        %s
        
        Quality report:
        %s
        
        Original code:
        %s
        """;
}
