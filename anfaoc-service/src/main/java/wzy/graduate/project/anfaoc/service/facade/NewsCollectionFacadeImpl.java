package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.Request.NewsCollectionRequest;
import wzy.graduate.project.anfaoc.api.domain.dto.NewsCollectionDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;
import wzy.graduate.project.anfaoc.api.facade.NewsCollectionFacade;
import wzy.graduate.project.anfaoc.api.service.NewsCollectionService;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

@Service
@Slf4j
public class NewsCollectionFacadeImpl implements NewsCollectionFacade {

    @Autowired
    private NewsCollectionService newsCollectionService;

    @Override
    public Response<Boolean> addNewsCollection(NewsCollectionDTO newsCollectionDTO) {
        try{
            NewsCollectionDetail detail = new NewsCollectionDetail();
            BeanUtils.copyProperties(newsCollectionDTO,detail);
            detail.setCreateTime(NewsUtil.getNowTime());
            newsCollectionService.addNewsCollection(detail);
        }catch (Exception e){
            log.info("收藏新闻出错:{}",e.getMessage());
            return Response.fail(e.getMessage());
        }
        return Response.ok(Boolean.TRUE);
    }
}
