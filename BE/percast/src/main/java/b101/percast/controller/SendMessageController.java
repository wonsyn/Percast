package b101.percast.controller;

import b101.percast.dto.message.SendMessageResponse;
import b101.percast.service.MessageServiceService;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class SendMessageController {

    private final MessageServiceService messageServiceService;

    }
}
