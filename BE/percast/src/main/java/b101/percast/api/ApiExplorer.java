package b101.percast.api;

import b101.percast.dto.input.InputSaveRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ApiExplorer {
    private static final String[] AREA_LIST = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "세종"};
    private static final String[] AREA_LIST_CODE
            = {"1100000000", "2600000000", "2700000000", "2800000000", "2900000000", "3000000000", "3100000000", "3600000000", "4200000000", "4300000000", "4400000000", "4500000000", "4600000000", "4700000000", "4800000000", "5000000000", "3600000000"};


    private static final String[] NX = {"60", "98", "89", "55", "58", "67", "102", "66", "60", "73", "69", "68", "63", "51", "89", "91", "52"};
    private static final String[] NY = {"127", "76", "90", "124", "74", "100", "84", "103", "120", "134", "107", "100", "89", "67", "91", "77", "38"};

    private final static InputSaveRequest[] DTO_LIST = new InputSaveRequest[AREA_LIST.length];

    public static InputSaveRequest[] getDtoList() throws IOException {
        getPollution();
        getWeather();
        return DTO_LIST;
    }

    public static List<String> getFoodPoison() throws IOException {
        LocalDateTime localDate = LocalDateTime.now();
        List<String> list = new ArrayList<>();
        /*URL*/
        for (int i = 0; i < AREA_LIST_CODE.length; i++) {
            String urlBuilder =
                    "http://apis.data.go.kr/1360000/HealthWthrIdxServiceV2/getFoodPoisoningIdxV2" + "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) + "=x1nvvz%2B%2B9YKLTlgfoIvJNq3js7dxUm%2FrNmb6%2BdZZIabhci9k93C3T%2Ft0BWUxQW3sT648oKcv9f%2B6PqkNHnJyrw%3D%3D" + /*Service Key*/
                            "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8) + /*한 페이지 결과 수 Default: 10*/
                            "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8) + /*페이지 번호 Default: 1*/
                            "&" + URLEncoder.encode("dataType", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("JSON", StandardCharsets.UTF_8) + /*요청자료형식(XML/JSON) Default: XML*/
                            "&" + URLEncoder.encode("areaNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(AREA_LIST_CODE[i], StandardCharsets.UTF_8) + /*서울지점 공백일때: 전체지점조회*/
                            "&" + URLEncoder.encode("time", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(localDate.format(DateTimeFormatter.ofPattern("yyyyMMddHH")), StandardCharsets.UTF_8); /*‘21년7월6일 18시 발표*/
            URL url = new URL(urlBuilder);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            String item = new JSONObject(sb.toString()).getJSONObject(("response"))
                    .getJSONObject("body").getJSONObject("items").getJSONArray("item").getJSONObject(0).getString("today");
            if(item.length() == 0) {
                list.add("0");
            } else {
                list.add(item);
            }
        }
        return list;
    }


    private static void getPollution() throws IOException {
        for (int i = 0; i < AREA_LIST.length; i++) {
            DTO_LIST[i] = new InputSaveRequest();
            DTO_LIST[i].setSidoCode(Long.parseLong(Integer.toString(i)));
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=kImpf2I8kzldmg5CDHLvX%2FkS%2FBXCIztnt9ZS6BMIImOkrTGNWe3otNY3jQwogBALApPcSRwVLFQl8BrNj8gywA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("sidoName", "UTF-8") + "=" + URLEncoder.encode(AREA_LIST[i], "UTF-8")); /*sidoName = 서울, 충남 등등*/
            urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONObject response = jsonObject.getJSONObject("response");
            JSONObject body = response.getJSONObject("body");
            JSONArray items = body.getJSONArray("items");
            InputSaveRequest dto = new InputSaveRequest();
            int so2Count = 0, coCount = 0, o3Count = 0, no2Count = 0, pm10Count = 0;
            double so2Sum = 0, coSum = 0, o3Sum = 0, no2Sum = 0, pm10Sum = 0;
            for (int j = 0; j < items.length(); j++) {
                JSONObject item = items.getJSONObject(j);
                if (item.isNull("so2Flag")) {
                    double temp = item.getDouble("so2Value");
                    so2Sum += temp;
                    so2Count++;
                }
                if (item.isNull("coFlag")) {
                    double temp = item.getDouble("coValue");
                    coSum += temp;
                    coCount++;
                }
                if (item.isNull("o3Flag")) {
                    double temp = item.getDouble("o3Value");
                    o3Sum += temp;
                    o3Count++;
                }
                if (item.isNull("no2Flag")) {
                    double temp = item.getDouble("no2Value");
                    no2Sum += temp;
                    no2Count++;
                }
                if (item.isNull("pm10Flag")) {
                    double temp = item.getDouble("pm10Value");
                    pm10Sum += temp;
                    pm10Count++;
                }
            }
            if(so2Count != 0) DTO_LIST[i].setSo2(so2Sum / so2Count);
            if(coCount != 0) DTO_LIST[i].setCo(coSum / coCount);
            if(o3Count != 0) DTO_LIST[i].setO3(o3Sum / o3Count);
            if(no2Count != 0) DTO_LIST[i].setNo2(no2Sum / no2Count);
            if(pm10Count != 0) DTO_LIST[i].setPm10(pm10Sum / pm10Count);
        }
    }

    private static void getWeather() throws IOException{
        LocalDateTime localDate = LocalDateTime.now().plusHours(9);
        if(localDate.getHour() < 2) {
            localDate = localDate.minusDays(1);
        }
        String date = "" + localDate.getYear();
        if(localDate.getMonthValue() < 10) date += "0" + localDate.getMonthValue();
        else date += localDate.getMonthValue();
        if(localDate.getDayOfMonth() < 10) date += "0" + localDate.getDayOfMonth();
        else date += localDate.getDayOfMonth();
        for(int i = 0; i < NX.length; i++) {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=kImpf2I8kzldmg5CDHLvX%2FkS%2FBXCIztnt9ZS6BMIImOkrTGNWe3otNY3jQwogBALApPcSRwVLFQl8BrNj8gywA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("290", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*‘21년 6월 28일 발표*/
            urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode("0200", "UTF-8")); /*06시 발표(정시단위) */
            urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(NX[i], "UTF-8")); /*예보지점의 X 좌표값*/
            urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(NY[i], "UTF-8")); /*예보지점의 Y 좌표값*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            JSONObject jsonObeject = new JSONObject(sb.toString());
            JSONObject list = jsonObeject.getJSONObject("response").getJSONObject("body").getJSONObject("items");
            JSONArray items = list.getJSONArray("item");

            int pcpCount = 0, rehCount = 0, tmpCount = 0, tmnCount = 0, tmxCount = 0, wsdCount = 0;
            double pcpSum = 0, rehSum = 0, tmpSum = 0, tmnSum = 0, tmxSum = 0, wsdSum = 0;
            LocalDateTime now = LocalDateTime.now().plusHours(9);
            String nowDate = "" + now.getYear();
            if(now.getMonthValue() < 10) nowDate += "0" + now.getMonthValue();
            else nowDate += now.getMonthValue();
            if(now.getDayOfMonth() < 10) nowDate += "0" + now.getDayOfMonth();
            else nowDate += now.getDayOfMonth();
            String nowTime = "" + now.getHour() + "00";
            if (now.getHour() < 10) nowTime = "0" + now.getHour();
            for(int j = 0; j < items.length(); j++) {
                JSONObject item = items.getJSONObject(j);
                String type = item.getString("category").trim();
                String fcstDate = item.getString("fcstDate");
                String fcstTime = item.getString("fcstTime");
                if(fcstDate.equals(nowDate) && fcstTime.equals(nowTime)) {
                    if (type.equals("PCP")) {
                        pcpCount++;
                        String rain = item.getString("fcstValue");
                        if(!rain.equals("강수없음")) {
                            rain = rain.replaceAll("[^0-9.]", "");
                            pcpSum += Double.parseDouble(rain);
                        }
                    } else if (type.equals("REH")) {
                        rehCount++;
                        double temp = item.getDouble("fcstValue");
                        rehSum += temp;
                    } else if (type.equals("TMP")) {
                        tmpCount++;
                        double temp = item.getDouble("fcstValue");
                        tmpSum += temp;
                    } else if (type.equals("WSD")) {
                        wsdCount++;
                        double temp = item.getDouble("fcstValue");
                        wsdSum += temp;
                    }
                }
                if (type.equals("TMN")) {
                    tmnCount++;
                    double temp = item.getDouble("fcstValue");
                    tmnSum += temp;
                } else if (type.equals("TMX")) {
                    tmxCount++;
                    double temp = item.getDouble("fcstValue");
                    tmxSum += temp;
                }
            }
            if(pcpCount != 0) DTO_LIST[i].setRain(pcpSum / pcpCount);
            if(rehCount != 0) DTO_LIST[i].setHumid(rehSum / rehCount);
            if(tmpCount != 0) DTO_LIST[i].setTempAvg(tmpSum / tmpCount);
            if(tmnCount != 0) DTO_LIST[i].setTempMin(tmnSum / tmnCount);
            if(tmxCount != 0) DTO_LIST[i].setTempMax(tmxSum / tmxCount);
            if(wsdCount != 0) DTO_LIST[i].setWindAvg(wsdSum / wsdCount);
        }
    }
}