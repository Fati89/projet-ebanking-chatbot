package benakka.chatbot.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AITools {
    @Tool(name = "getEmployee",
            description = "Get information about a given employe")
    public Employee getEmployee(@ToolParam(description = "The Employe name") String name) {
        return new Employee(name, 12300, 4);

    }
    @Tool(description = "Get All Employees")
    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee("Hassan", 52100, 4),
                new Employee("Mohamed", 57800, 2),
                new Employee("Imane", 257000, 54)
        );
    }

    record Employee(String name, double salary, int seniority){}
}