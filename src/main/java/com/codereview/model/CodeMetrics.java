package com.codereview.model;
import java.util.*;

public class CodeMetrics{
    private String className;
    private int totLines;
    private int totMethods;
    private int totFields;
    private int ccomplexity;
    private List<String> lMethods;
    private List<String> comMethods;
    private List<String> badMethods;
    private List<String> badFields;
    private List<String> emptyCatches;

    private int count;
    private boolean hasMain;

    public CodeMetrics(){}

    public String getClassName() {
        return className;
    }
    public void setClassName(String n) {
        this.className = n;
    }
    public int getTotLines() {
        return totLines;
    }
    public void setTotLines(int n ) {
        this.totLines = n;
    }
    public int getTotMethods() {
        return totMethods;
    }
    public void setTotMethods(int n) {
        this.totMethods = n;
    }   
    public int getTotFields() {
        return totFields;
    }
    public void setTotFields(int n) {
        this.totFields = n;
    }
    public int getCcomplexity() {
        return ccomplexity;
    }
    public void setCcomplexity(int n) {
        this.ccomplexity = n;
    }
    public List<String> getlMethods() {
        return lMethods;
    }
    public void setlMethods(List<String> l) {
        this.lMethods = l;
    }
    public List<String> getComMethods() {
        return comMethods;
    }
    public void setComMethods(List<String> l) {
        this.comMethods = l;
    }
    public List<String> getBadMethods() {
        return badMethods;
    }
    public void setBadMethods(List<String> l) {
        this.badMethods = l;
    }
    public List<String> getBadFields() {
        return badFields;
    }
    public void setBadFields(List<String> l) {
        this.badFields = l;
    }
    public List<String> getEmptyCatches() {
        return emptyCatches;
    }
    public void setEmptyCatches(List<String> l) {
        this.emptyCatches = l;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int n) {
        this.count = n;
    }
    public boolean isHasMain() {
        return hasMain;
    }
    public void setHasMain(boolean b) {
        this.hasMain = b;
    }
     public boolean hasIssues() {
        return (lMethods != null && !lMethods.isEmpty())
            || (emptyCatches != null && !emptyCatches.isEmpty())
            || (badMethods != null && !badMethods.isEmpty());
    }

    @Override
    public String toString() {
        return className + " | lines=" + totLines
            + " methods=" + totMethods
            + " fields=" + totFields
            + " ccomp=" + ccomplexity
            + " comments=" + count
            + " hasMain=" + hasMain
            + " longMethods=" + lMethods
            + " emptyCatches=" + emptyCatches;
    }
}