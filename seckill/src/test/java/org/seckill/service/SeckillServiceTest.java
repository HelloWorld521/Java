package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.ExposerRsp;
import org.seckill.dto.SeckillExecutionRsp;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hujiayu on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                       "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    //集成测试代码完整逻辑，注意重复执行
    @Test
    public void seckillLogic() throws Exception {
        long id = 1004;
        ExposerRsp exposerRsp = seckillService.exprotSeckillUrl(id);
        if(exposerRsp.isExposed()){
            logger.info("expose={}",exposerRsp);
            long phone = 13023217863L;
            String md5 = "9f26737a177b65c934341b48e4cdf21c";
            try {
                SeckillExecutionRsp executionRsp = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}",executionRsp);
            } catch (RepeatKillException e){
                logger.error(e.getMessage(), e);
            } catch (SeckillCloseException e){
                logger.error(e.getMessage(), e);
            }
        }else{
            logger.warn("expose={}",exposerRsp);
        }


        //exposed=true,
        // md5='9f26737a177b65c934341b48e4cdf21c',
        // seckillId=1004,
        // now=0,
        // start=0,
        // end=0
    }

//    @Test
//    public void executeSeckill() throws Exception {
//        long id = 1004;
//
//
//
//        //seckill=1004, state=1, stateInfo='秒杀成功',
//        // successKilled=SuccessKilled{seckillId=1004,
//        // userPhone=13023217863, state=0, createTime=Tue Jul 18 23:53:46 CST 2017}
//    }

}