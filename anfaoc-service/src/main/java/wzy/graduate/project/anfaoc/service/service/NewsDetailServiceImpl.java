package wzy.graduate.project.anfaoc.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.service.dao.NewsDetailDao;

import java.util.List;

/**
 * @author wangzy
 */
@Slf4j
@Service
public class NewsDetailServiceImpl implements NewsDetailService {

    @Autowired
    private NewsDetailDao newsDetailDao;

    /**
     * @Description 这里解决文章重复问题可以用url+title做为唯一主键
     * @Date  2020/3/11
     **/
    @Override
    public void updateNews(List<NewsDetail> newsList) {
        try{
            newsList.stream().forEach(
                newsDetail -> {
                    newsDetailDao.insertNews(newsDetail);
                }
            );
        }catch (Exception e){
            log.info("新闻插入失败:{}",e.getMessage());
            throw new ServiceException("数据插入失败");
        }
    }

}
