package wzy.graduate.project.anfaoc.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;
import wzy.graduate.project.anfaoc.api.service.NewsCollectionService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.service.dao.NewsCollectionDao;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Objects;

/**
 * @author wangzy
 */
@Service
@Slf4j
public class NewsCollectionServiceImpl implements NewsCollectionService {

    @Autowired
    private NewsCollectionDao newsCollectionDao;

    @Override
    public void addNewsCollection(NewsCollectionDetail detail) {
        try{
            newsCollectionDao.insert(detail);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Boolean newsCollectionOneJudge(NewsCollectionDetail detail) {

        try{
            NewsCollectionDetail newsCollectionDetail = newsCollectionDao.oneJudge(detail);
            if(Objects.nonNull(newsCollectionDetail)){
                return Boolean.FALSE;
            }
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return Boolean.TRUE;
    }

    @Override
    public List<NewsCollectionDetail> getAllColNews(String userId) {
        List<NewsCollectionDetail> details;
        try{
            details = newsCollectionDao.getAllColNews(userId);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return details;
    }
}
