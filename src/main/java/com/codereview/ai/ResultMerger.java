package com.codereview.ai;

import com.codereview.model.ReviewResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultMerger {

    public ReviewResult merge(String bugRep, String secRep, String qualRep, String code) {
        ReviewResult res = new ReviewResult();

        res.setBugReport(bugRep);
        res.setSecReport(secRep);
        res.setQualityReport(qualRep);
        res.setCode(code);
        res.setReviewedAt(System.currentTimeMillis());

        res.setBugs(getNum(bugRep, "BUGS_FOUND"));
        res.setSecIssues(getNum(secRep, "SECURITY_ISSUES_FOUND"));
        res.setQualityScore(getNum(qualRep, "QUALITY_SCORE"));

        res.setOverallScore(calcScore(res));

        return res;
    }

    private int getNum(String text, String label) {
        Pattern p = Pattern.compile(label + ":\\s*(\\d+)");
        Matcher m = p.matcher(text);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        return 0;
    }

    private int calcScore(ReviewResult res) {
        int bugPenalty = Math.min(res.getBugs() * 10, 100);
        int secPenalty = Math.min(res.getSecIssues() * 15, 100);

        double score = (100 - bugPenalty) * 0.3
                      + (100 - secPenalty) * 0.3
                      + res.getQualityScore() * 0.4;

        return (int) Math.round(score);
    }
}