package com.codereview.ai;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import com.codereview.model.CodeMetrics;

public class LangChainService {

    private final ChatLanguageModel model;

    public LangChainService() {
        String apiKey = System.getenv("GEMINI_API_KEY");

        this.model = GoogleAiGeminiChatModel.builder()
            .apiKey(apiKey)
            .modelName("gemini-2.5-flash")
            .temperature(0.3)
            .build();
    }
    public String detectBugs(CodeMetrics metrics, String code) {
    String prompt = String.format(PromptTemp.BUG_PROMPT, metrics.toString(), code);
    return model.generate(prompt);
    }

    public String scanSecurity(CodeMetrics metrics, String code) {
    String prompt = String.format(PromptTemp.SECURITY_PROMPT, metrics.toString(), code);
    return model.generate(prompt);
    }

    public String scoreQuality(CodeMetrics metrics, String code) {
        String prompt = String.format(PromptTemp.QUALITY_PROMPT, metrics.toString(), code);
        return model.generate(prompt);
    }

    public String refactorCode(String code, String bugRep, String secRep, String qualRep) {
        String prompt = String.format(PromptTemp.REFACTOR_PROMPT, bugRep, secRep, qualRep, code);
        return model.generate(prompt);
    }

}

