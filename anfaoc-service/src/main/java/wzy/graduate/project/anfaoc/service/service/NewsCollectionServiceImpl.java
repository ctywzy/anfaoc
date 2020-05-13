package wzy.graduate.project.anfaoc.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;
import wzy.graduate.project.anfaoc.api.service.NewsCollectionService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.service.dao.NewsCollectionDao;

import javax.sql.rowset.serial.SerialException;

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
}
