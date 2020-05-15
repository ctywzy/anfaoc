package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.dto.UserLabelDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;
import wzy.graduate.project.anfaoc.api.facade.UserLabelFacade;
import wzy.graduate.project.anfaoc.api.service.UserLabelService;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserLableFacadeImpl implements UserLabelFacade {

    @Autowired
    private UserLabelService userLabelService;
    @Override
    public void create(UserLabelDTO userLabelDTO) {

        try{
            UserLabel userLabel = new UserLabel();
            BeanUtils.copyProperties(userLabelDTO,userLabel);
            List<UserLabel> labelList = userLabelService.find(userLabel);
            userLabel.setCreateTime(NewsUtil.getNowTime());
            userLabelService.create(userLabel);
        }catch (Exception e){
            log.info("添加标签失败:{}",e.getMessage());
        }
    }

    @Override
    public void deleteLabel(UserLabelDTO userLabelDTO) {
        try{
            UserLabel userLabel = new UserLabel();
            BeanUtils.copyProperties(userLabelDTO,userLabel);
            userLabelService.delete(userLabel);
        }catch (Exception e){
            log.info("删除标签失败:{}",e.getMessage());
        }
    }

    @Override
    public List<String> findLabelByUserId(String userId) {
        List<UserLabel> userLabels = new ArrayList<>();
        try{
            UserLabel userLabel = new UserLabel();
            userLabel.setUserId(userId);
            userLabels = userLabelService.find(userLabel);
        }catch (Exception e){
            log.info("获取标签id失败:{}",e.getMessage());
        }
        return userLabels.stream().map(UserLabel::getLabelId).map(String::valueOf)
                         .collect(Collectors.toSet())
                         .stream().collect(Collectors.toList());
    }
}
