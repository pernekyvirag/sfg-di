package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
// returns different languages depending on which profile is used
public class I18nController {

    private final GreetingService greetingService;

    // Uses the service annotated with the active Spring Profile
    // Only the active Profile Bean gets created in the context so there is no conflict
    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
