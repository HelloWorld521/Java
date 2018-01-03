package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;

/**
 * Created by hujiayu on 2017/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1001L;
        long phone = 150340598L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount:"+insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1001L;
        long phone = 150340598L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
        /**
         * SuccessKilled{
         * seckillId=1000,
         * userPhone=150340598,
         * state=0,
         * createTime=Sat May 27 01:37:27 CST 2017}
         *
         Seckill{seckill=1000,
         name='1000元秒杀iphone7',
         number=100,
         startTime=Mon May 01 00:00:00 CST 2017,
         endTime=Tue May 02 00:00:00 CST 2017,
         createTime=Sun May 07 22:16:59 CST 2017}
         */
    }

}