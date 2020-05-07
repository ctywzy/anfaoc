package wzy.graduate.project.anfaoc.service.util;

import com.google.common.collect.Maps;
import wzy.graduate.project.anfaoc.api.Request.NewsPagingRequest;

import java.util.Map;

public class MapUtil {

    public Map<String,Object> toMap(NewsPagingRequest request){
        Map<String,Object> criteria = Maps.newHashMap();
        criteria.put("pageNo", request.getPagingNo());
        criteria.put("pageSize", request.getPageSize());
        criteria.put("pagingType", request.getPagingType());
        return criteria;
    }
    
}
