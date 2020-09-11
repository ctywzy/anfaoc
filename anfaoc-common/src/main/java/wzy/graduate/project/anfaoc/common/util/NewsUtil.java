package wzy.graduate.project.anfaoc.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzy
 * @desc 用来操作新闻，数据库存储对象和文章展示对象相互转换
 *
 */

@Slf4j
public class NewsUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Description 按照YYYY-mm-DD格式，设置章抓取的时间
     * @Date  2020/1/22
     **/
    public static String getNowTime() {
        Date  needFormatDate = new Date();
        return simpleDateFormat.format(needFormatDate);
    }

    /**
     * @Description 图片格式转化简介
     * @Date  2020/5/11
     **/
    public static String doPictureInt(String para) {

        para =  "<div>" +
                "<img style=\"position: relative;left: 60%;top: 50%;width:350px;height: 500px\" src = \" " + para + "\"/>" +
                "</div>";
        return para;
    }

    /**
     * @Description 图片转化详细
     * @Date  2020/5/12
     **/
    public static String doPicture(String para) {

        para =  "<div>" +
                "<img style=\"position: relative;left: 160%;top: 50%;width:250px;height: 300px\" src = \" " + para + "\"/>" +
                "</div>";
        return para;
    }

    /**
     * @Description 段落格式转化
     * @Date  2020/5/11
     **/
    public static String doPara(String para) {

        if(para.contains("<img")){
            StringBuilder sb = new StringBuilder(para);
            sb.insert(5, "style=\"position: relative;left: 160%;top: 50%;width:250px;height: 300px\" ");
            sb.insert(0,"<div> ");
            sb.append("</div>");
            para = sb.toString();
        }
        else{
            para = "<p>" +"  "+para + "</p>";
        }

        return para;
    }

    /**
     * @Description 段落格式转化
     * @Date  2020/5/11
     **/
    public static String doParaInt(String para) {

        if(para.contains("<img")){
            StringBuilder sb = new StringBuilder(para);
            sb.insert(5, "style=\"position: relative;left: 60%;top: 50%;width:350px;height: 500px\" ");
            sb.insert(0,"<div> ");
            sb.append("</div>");
            para = sb.toString();
        }
        else{
            para = "<p>" +"&nbsp;&nbsp;&nbsp;&nbsp;"+para + "</p>";
        }

        return para;
    }
    /**
     * @Description 图片描述转化
     * @Date  2020/5/11
     **/
    public static String doDes(String para) {

        para = "<p style = \"width: 100%;height: 45px;display: block;line-height: 45px;text-align: center;\">" + para + "</p>";
        return para;
    }

    /**
     * @Description 用户收藏
     * @Date  2020/5/13
     **/
    public static String doUserPictureInt(String para) {

        para =  "<div>" +
                "<img style=\"position: relative;left: 115%;top: 50%;width:150px;height: 200px\" src = \" " + para + "\"/>" +
                "</div>";
        return para;
    }

    /**
     * @Description 用户收藏
     * @Date  2020/5/13
     **/
    public static String doUserParaInt(String para) {
        if(para.contains("<img")){
            StringBuilder sb = new StringBuilder(para);
            sb.insert(5, "style=\"position: relative;left: 115%;top: 50%;width:150px;height: 200px\" ");
            sb.insert(0,"<div> ");
            sb.append("</div>");
            para = sb.toString();
        }
        else{
            para = "<p>" +"&nbsp;&nbsp;&nbsp;&nbsp;"+para + "</p>";
        }

        return para;
    }

    /**
     * @Description 将id列表转换成字符串
     * @Date  2020/1/22
     **/
    public String getLabelsIdString(List<String> labelIds){
        String labelIdStr = null;
        try{
            labelIdStr =  objectMapper.writeValueAsString(labelIds);
        }catch (JsonProcessingException e){
            log.error("Json格式转换错误");
        }
        return labelIdStr;
    }

    /**
     * @Description 将label字符串转换回数组
     * @Date  2020/5/11
     **/
    public static List<String> getLabelIds(String labelIdStr){
        List<String> labelIds = null;
        try{
            labelIds = objectMapper.readValue(labelIdStr, new TypeReference<ArrayList<String>>(){});
        }catch (IOException e){
            log.info("标签反序列化出错");
        }
        return labelIds;
    }

    /**
     * @Description 将段落属性保存到json字符串中
     * @Date  2020/1/22
     **/
    public String getParasString(List<ParaEntity> paraEntities){
        String paraEntityStr = null;
        try{
            paraEntityStr = objectMapper.writeValueAsString(paraEntities);
        }catch (JsonProcessingException e){
            log.error("Json格式转换错误");
        }
        return paraEntityStr;
    }

    /**
     * @Description 将段落json反序列化
     * @Date  2020/5/11
     **/
    public static List<ParaEntity> getParas(String paraJson){
        List<ParaEntity> paraEntities = new ArrayList<>();
        try{
            paraEntities = objectMapper.readValue(paraJson,new TypeReference<ArrayList<ParaEntity>>(){});
        }catch (IOException e){
            log.error("段落反序列化出错");
        }

        return paraEntities;
    }
}
