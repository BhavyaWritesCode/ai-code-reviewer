package com.codereview.parser;

import com.codereview.model.CodeMetrics;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.IfStmt;

public class JavaCodeParser {
    public CodeMetrics parse(String javaCode){
        CodeMetrics metrics = new CodeMetrics();
        CompilationUnit tree = StaticJavaParser.parse(javaCode);
        metrics.setTotLines(javaCode.split("\n").length);
        MetricsVisitor visitor = new MetricsVisitor(metrics);

        visitor.visit(tree,null);
        return metrics;
    }   
    
    private class MetricsVisitor extends VoidVisitorAdapter<Void> {
        private final CodeMetrics metrics;

        private MetricsVisitor(CodeMetrics metrics) {
            this.metrics = metrics;
        }
        @Override
        public void visit(ClassOrInterfaceDeclaration c, Void arg) {
            super.visit(c, arg);
            metrics.setClassName(c.getNameAsString());
            metrics.setTotFields(c.getFields().size());
            
        }
        @Override
        public void visit(MethodDeclaration m, Void arg){
            super.visit(m, arg);
            metrics.setTotMethods(metrics.getTotMethods() + 1);
            String methodName = m.getNameAsString();
            if (methodName.length() < 3) {
                metrics.getBadMethods().add(methodName);
            }
            
            int methodLines = m.getEnd().get().line - m.getBegin().get().line;
            if (methodLines > 20) {
                metrics.getlMethods().add(methodName);
            }
            
            metrics.setCcomplexity(metrics.getCcomplexity() + 1);
        }
        @Override
        public void visit(FieldDeclaration f, Void arg) {
            super.visit(f, arg);
            f.getVariables().forEach(v -> {
                if (v.getNameAsString().length() < 2) {
                    metrics.getBadFields().add(v.getNameAsString());
                }
            });
        }
        @Override
        public void visit(CatchClause c, Void arg) {
            super.visit(c, arg);
            if (c.getBody().getStatements().isEmpty()) {
                metrics.getEmptyCatches().add("empty catch at line " + c.getBegin().get().line);
            }
        }
        @Override
        public void visit(IfStmt i, Void arg) {
            super.visit(i, arg);
            metrics.setCcomplexity(metrics.getCcomplexity() + 1);
        }
    }
}
