package benakka.chatbot.agents;

import benakka.chatbot.tools.AITools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@Component
public class AIAgent {


    private ChatClient chatClient;

    public AIAgent(ChatClient.Builder builder , ChatMemory memory, AITools aiTools) {
        this.chatClient = builder
                .defaultSystem("""
                        Vous un assistant qui se charge de répondre aux question
                        de l'utilisateur en fonction du contexte fourni.
                        Si aucun contexte n'est fourni, répond avec JE NE SAIS PAS         
                        """)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(memory).build())
                .defaultTools(aiTools)
                .build();
    }

    public Flux<String> ask(@RequestParam String query) {
        return chatClient.prompt()
                .user(query)
                .stream()
                .content();
    }


}