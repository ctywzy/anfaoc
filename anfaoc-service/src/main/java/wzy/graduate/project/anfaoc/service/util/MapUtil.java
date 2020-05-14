package wzy.graduate.project.anfaoc.service.util;

import com.google.common.collect.Maps;
import wzy.graduate.project.anfaoc.api.Request.NewsPagingRequest;

import java.util.Map;

public class MapUtil {

    private static final Integer PAGE_NUMBER = 15;

    private static final Integer LABEL_PAGE_NUMBER = 60;

    private static final Integer REC_PAGE_NUMBER = 100;

    public static Map<String, Object> toLabelMap(NewsPagingRequest request) {
        Map<String,Object> criteria = Maps.newHashMap();
        Integer pageNo = request.getPagingNo();
        int begin = (pageNo - 1) * LABEL_PAGE_NUMBER;
        criteria.put("offset", begin);
        criteria.put("limit", LABEL_PAGE_NUMBER);
        return criteria;
    }

    public Map<String,Object> toMap(NewsPagingRequest request){
        Map<String,Object> criteria = Maps.newHashMap();
        Integer pageNo = request.getPagingNo();
        int begin = (pageNo - 1) * PAGE_NUMBER;
        criteria.put("offset", begin);
        criteria.put("limit", PAGE_NUMBER);
        return criteria;
    }

    public Map<String, Object> toRecMap(NewsPagingRequest request) {
        Map<String,Object> criteria = Maps.newHashMap();
        Integer pageNo = request.getPagingNo();
        int begin = (pageNo - 1) * REC_PAGE_NUMBER;
        criteria.put("offset", begin);
        criteria.put("limit", REC_PAGE_NUMBER);
        return criteria;
    }
}
