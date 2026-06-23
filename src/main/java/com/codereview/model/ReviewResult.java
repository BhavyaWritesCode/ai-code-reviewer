package com.codereview.model;

public class ReviewResult {

    private int bugs;
    private int secIssues;
    private int qualityScore;
    private int overallScore;

    private String bugReport;
    private String secReport;
    private String qualityReport;

    private long reviewedAt;
    private String code;

    public ReviewResult() {}

    public int getBugs() {
        return bugs;
    }
    public void setBugs(int bugs) {
        this.bugs = bugs;
    }

    public int getSecIssues() {
        return secIssues;
    }
    public void setSecIssues(int secIssues) {
        this.secIssues = secIssues;
    }

    public int getQualityScore() {
        return qualityScore;
    }
    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
    }

    public int getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public String getBugReport() {
        return bugReport;
    }
    public void setBugReport(String bugReport) {
        this.bugReport = bugReport;
    }

    public String getSecReport() {
        return secReport;
    }
    public void setSecReport(String secReport) {
        this.secReport = secReport;
    }

    public String getQualityReport() {
        return qualityReport;
    }
    public void setQualityReport(String qualityReport) {
        this.qualityReport = qualityReport;
    }

    public long getReviewedAt() {
        return reviewedAt;
    }
    public void setReviewedAt(long reviewedAt) {
        this.reviewedAt = reviewedAt;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ReviewResult{" +
                "bugs=" + bugs +
                ", secIssues=" + secIssues +
                ", qualityScore=" + qualityScore +
                ", overallScore=" + overallScore +
                ", reviewedAt=" + reviewedAt +
                '}';
    }
}