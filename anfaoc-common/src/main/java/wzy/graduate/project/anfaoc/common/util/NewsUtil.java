package wzy.graduate.project.anfaoc.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
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
            labelIds = objectMapper.readValue(labelIdStr, List.class);
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
            paraEntities = objectMapper.readValue(paraJson,List.class);
        }catch (IOException e){
            log.error("段落反序列化出错");
        }

        return paraEntities;
    }
}
