package com.kaishun.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Integer ONE = 1;



 /*   @Test
    public  void  testFile(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\17586\\Desktop\\data.txt")),"UTF-8"));
            String lineTxt = null;
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(
                            new File("C:\\Users\\17586\\Desktop\\data2.txt")),"UTF-8"));
            while ((lineTxt = br.readLine()) != null) {
                if(!list.contains(lineTxt)){
                    list.add(lineTxt);

                    bufferedWriter.write(lineTxt);
                    bufferedWriter.newLine();
                }
                if (map.keySet().contains(lineTxt)) {
                    map.put(lineTxt, (map.get(lineTxt) + ONE));
                } else {
                    map.put(lineTxt, ONE);
                }

            }
            System.out.println(map.toString());
            br.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/



/*    @Test
    public void testEasyPoi() throws Exception{
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\17586\\Desktop\\easypoi.xls");

        List<StudentEntity> list = new ArrayList<>();
        for(int i=1;i<100;i++){
            StudentEntity student = new StudentEntity();
            student.setBirthday(new Date());
            student.setId(i+"");
            student.setName("姓名");
            student.setSex(1);
            student.setRegistrationDate(new Date());
            list.add(student);
        }
        ExportParams exportParams =  new ExportParams("表头","sheet名", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                StudentEntity.class, list);
        workbook.write(outputStream);
    }*/



    /*@Test
    public void sendMsg(){
        *//**
         *
         *
         * 业务代码
         *
         *
         *//*
       //发送验证码
        String phoneNumber = "18856034826";
        String code = smsUtils.randomNumeric(6);
        smsUtils.sendMsg(phoneNumber , code);

    }

    *//**
     * @description  校验验证码
     * @author zhoukaishun
     * @date 2020/3/1 17:48
     *//*
    @Test
    public void checkSms(){
        boolean flag = smsUtils.verification("18856034826","216731");
        if(flag){
            logger.info("验证成功！");
            //do something
        }else{
            logger.info("验证失败！");
            //do something
        }
    }

    @Test
    void contextLoads() {
    }


    @Test
    public void str2Md5(){
        //admin-admin
        //kaishun-kaishun
        strToMD5("HWURVeVppkUOT2OLvcoMhmjSaBkiKR1564648957258100360050皖AP18551");
    }

    public static String strToMD5(String sourceStr) {
        String result = "";
        try {
            // 创建具有指定算法名称的信息摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 使用指定的字节数组对摘要进行最后的更新，然后完成摘要计算
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString().toUpperCase();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + result.substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    *//*rabbitmq 单元测试*//*
    @Test
    public void sendDirectMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "rabbitMq test,send hello!";
        String createTime = DateUtil.get14Date();
        Map<String,Object> map = new HashMap<>();
        map.put("massageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        System.out.println("sendDirectMessage successful");
    }

    @Test
    public void sendTopicMessage1(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: Man";
        String createTime = DateUtil.get14Date();
        Map<String,Object> map = new HashMap<>();
        map.put("massageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend("topicExchange","topic.man",map);
        System.out.println("sendTopicMessage1 successful");
    }

    @Test
    public void sendTopicMessage2(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: WOMAN is ALL";
        String createTime = DateUtil.get14Date();
        Map<String,Object> map = new HashMap<>();
        map.put("massageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend("topicExchange","topic.woman",map);
        System.out.println("sendTopicMessage2 woman successful");
    }*/



}
