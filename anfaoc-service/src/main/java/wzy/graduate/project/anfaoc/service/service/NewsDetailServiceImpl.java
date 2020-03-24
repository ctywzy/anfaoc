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
import java.util.Objects;

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
        log.info("新闻总数：{}",newsList.size());
        final int[] index = {0};

        //TODO 新闻去重问题没有插入，有的话更新为1.5倍
        newsList.stream().forEach(
                newsDetail -> {
                    index[0] +=1;
                    try{
                        NewsDetail judge = newsDetailDao.judgeNewPresence(newsDetail);
                        if(Objects.nonNull(judge)){
                            newsDetailDao.updateNewNum(newsDetail);
                        }else{
                            newsDetailDao.insertNews(newsDetail);
                        }

                    }catch (Exception e){
                        log.info("新闻插入失败:{}",e.getMessage());
                        log.info("错误的新闻段落：{},{}",newsDetail.getNewParas(),newsDetail.getNewUrl());
                    }

                }
        );
        log.info("执行了多少条:{}",index[0]);
    }

}
