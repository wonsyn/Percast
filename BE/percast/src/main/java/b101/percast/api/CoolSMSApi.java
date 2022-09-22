package b101.percast.api;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

import java.util.ArrayList;

@RequiredArgsConstructor
public class CoolSMSApi {
    private static final DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCSDCQYAUV7L5ETN", "DN6GUKD2VCK4SPBG0ZPRFKRYFSJ9CGH5", "https://api.coolsms.co.kr");

    public static Message sendWarningMessage(String tel, String content) {
        Message message = new Message();
        message.setFrom("01027983715");
        message.setTo(tel);
        message.setText(content);
        return message;
    }

    public static void sendAllMessage(ArrayList<Message> messageList) {
        try {
            MultipleDetailMessageSentResponse response = messageService.send(messageList);
            System.out.println(response);
        } catch (NurigoMessageNotReceivedException exception) {
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
