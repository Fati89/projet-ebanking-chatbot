package benakka.chatbot.web;

import benakka.chatbot.agents.AIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ChatController {

    // private ChatClient chatClient;
    private AIAgent aiAgent;

    public ChatController(AIAgent aiAgent /*ChatClient.Builder builder*/) {
        // this.chatClient = builder.build();
        this.aiAgent = aiAgent;
    }

    //@GetMapping("/chat")
    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(@RequestParam String query) {
        /*return chatClient.prompt()
                .user(query)
                .stream()
                .content();*/
        return aiAgent.ask(query);
    }
}