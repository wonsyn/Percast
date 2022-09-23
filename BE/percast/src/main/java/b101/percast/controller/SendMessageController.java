package b101.percast.controller;

import b101.percast.dto.message.MessageServiceFindAllByTelResponseDto;
import b101.percast.dto.message.MessageServiceSaveRequestDto;
import b101.percast.service.MessageServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class SendMessageController {

    private final MessageServiceService messageServiceService;

    @PostMapping
    public ResponseEntity<?> writeMessage(@RequestBody MessageServiceSaveRequestDto requestDto){
        messageServiceService.save(requestDto);
        return ResponseEntity.created(URI.create("/")).build();
    }

    @GetMapping("{tel}")
    public ResponseEntity<List<MessageServiceFindAllByTelResponseDto>> findAllByTel(@PathVariable String tel){
        return ResponseEntity.ok().body(messageServiceService.findAllByTel(tel));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteMessage(@PathVariable Long id){
        messageServiceService.delete(id);
        return ResponseEntity.ok().build();
    }


}
