package benakka.chatbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@Component
public class AIAgent {


    private ChatClient chatClient;

    public AIAgent(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public Flux<String> ask(@RequestParam String query) {
        return chatClient.prompt()
                .user(query)
                .stream()
                .content();
    }


}