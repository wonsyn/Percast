package b101.percast.service;

import b101.percast.Exception.NoDiseaseDataException;
import b101.percast.Exception.NoOutputDataException;
import b101.percast.api.CoolSMSApi;
import b101.percast.dto.message.MessageServiceFindAllByTelResponseDto;
import b101.percast.dto.message.MessageServiceSaveRequestDto;
import b101.percast.entity.MessageService;
import b101.percast.entity.Output;
import b101.percast.repository.MessageServiceRepository;
import b101.percast.repository.OutputRepository;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.model.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceServiceImpl implements MessageServiceService{
    private static final String[] AREA_LIST = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "세종"};
    private static final String[] RISK_LIST = {"좋음", "관심", "주의", "경계", "심각"};
    private final MessageServiceRepository messageServiceRepository;
    private final OutputRepository outputRepository;

    @Scheduled(cron = "0 11 11 * * ?")
    @Override
    public void sendAll() {
        ArrayList<Message> messageList = new ArrayList<>();
        List<String> telList = messageServiceRepository.findDistinctTelAll();
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        for(String tel : telList) {
            StringBuilder sb = new StringBuilder();
            sb.append("감기 걸리기 딱 좋은 날씨네\n오늘 (").append(localDate).append(")\n");
            List<MessageService> msList = messageServiceRepository.findMessageServiceByTel(tel);
            for(MessageService ms : msList) {
                Long sidoCode = ms.getSidoCode();
                String disease = ms.getDisease();
                double diseaseVal;
                Output output = outputRepository.findById(sidoCode).orElseThrow(NoOutputDataException::new);
                if(disease.equals("cold")) {
                    diseaseVal = output.getCold();
                    disease = "감기";
                } else if (disease.equals("asthma")){
                    diseaseVal = output.getAsthma();
                    disease = "천식";
                } else if (disease.equals("eye")){
                    diseaseVal = output.getEye();
                    disease = "눈병";
                } else if (disease.equals("skin")){
                    diseaseVal = output.getSkin();
                    disease = "피부병";
                } else if (disease.equals("food")){
                    diseaseVal = output.getFoodPoison();
                    disease = "식중독";
                } else {
                    throw new NoDiseaseDataException();
                }

                int riskIdx = -1;

                if (diseaseVal <= 20) riskIdx = 0;
                else if (diseaseVal <= 40) riskIdx = 1;
                else if (diseaseVal <= 60) riskIdx = 2;
                else if (diseaseVal <= 80) riskIdx = 3;
                else riskIdx = 4;

                sb.append(AREA_LIST[Integer.parseInt(Long.toString(sidoCode))]).append(" 지역의 ").append(disease).append(" 위험지수는 \"").append(RISK_LIST[riskIdx]).append("(").append(String.format("%.2f", diseaseVal) ).append(")\"\n");
            }
            sb.append("입니다. 건강 조심하시고 행복한 하루 되십시오.");
            messageList.add(CoolSMSApi.sendWarningMessage(tel, sb.toString()));
        }
        CoolSMSApi.sendAllMessage(messageList);
    }
    public void save(MessageServiceSaveRequestDto requestDto){
        messageServiceRepository.save(requestDto.toEntity());
    }

    @Override
    public List<MessageServiceFindAllByTelResponseDto> findAllByTel(String tel) {
        return messageServiceRepository.findMessageServiceByTel(tel)
                .stream().map(MessageServiceFindAllByTelResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        messageServiceRepository.deleteById(id);
    }
}
