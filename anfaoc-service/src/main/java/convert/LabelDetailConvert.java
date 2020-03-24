package convert;

import com.google.common.collect.Maps;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @Description 标签参数转化类
 * @Date  2020/3/24
 * @Author wangzy
 **/

public class LabelDetailConvert {

    /**
     * @Description label入参转换成map
     * @Date  2020/3/24
     **/
    public static Map<String,Object> labelDetailToMap(LabelDetail labelDetail){
        Map<String,Object> criteria = Maps.newHashMap();
        if(Objects.isNull(labelDetail)){
            return criteria;
        }
        Optional.ofNullable(labelDetail.getLabelName()).ifPresent(
                it -> {
                    criteria.put("labelName",it);
                }
        );

        Optional.ofNullable(labelDetail.getLabelNum()).ifPresent(
                it -> {
                    criteria.put("labelNum",it);
                }
        );

        Optional.ofNullable(labelDetail.getCreateTime()).ifPresent(
                it -> {
                    criteria.put("createTime",it);
                }
        );
        return criteria;
    }
}
