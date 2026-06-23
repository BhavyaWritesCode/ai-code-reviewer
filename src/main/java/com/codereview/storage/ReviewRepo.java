package com.codereview.storage;

import com.codereview.model.ReviewResult;
import java.sql.*;

public class ReviewRepo {

    private String url = System.getenv("DB_URL");
    private String user = System.getenv("DB_USER");
    private String pass = System.getenv("DB_PASSWORD");

    public void save(ReviewResult res) {
        String sql = "INSERT INTO review_sessions " +
                "(reviewed_at, code_reviewed, bugs, sec_issues, quality_score, overall_score, bug_report, sec_report, quality_report) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, res.getReviewedAt());
            stmt.setString(2, res.getCode());
            stmt.setInt(3, res.getBugs());
            stmt.setInt(4, res.getSecIssues());
            stmt.setInt(5, res.getQualityScore());
            stmt.setInt(6, res.getOverallScore());
            stmt.setString(7, res.getBugReport());
            stmt.setString(8, res.getSecReport());
            stmt.setString(9, res.getQualityReport());

            stmt.executeUpdate();
            System.out.println("Review saved to database.");

        } catch (SQLException e) {
            System.out.println("Error saving review: " + e.getMessage());
        }
    }
}