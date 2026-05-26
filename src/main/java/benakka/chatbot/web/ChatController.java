package benakka.chatbot.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/chat")
    public Flux<String> chat(@RequestParam String query) {
        return chatClient.prompt()
                .user(query)
                .stream()
                .content();
    }
}