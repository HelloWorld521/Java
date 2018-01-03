package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit的整合，junit整合加载spingIOC容器
 * spring-test,junit
 * Created by hujiayu on 2017/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit，spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /**
         * 1000元秒杀iphone7
         Seckill{seckill=1000,
         name='1000元秒杀iphone7',
         number=100,
         startTime=Mon May 01 00:00:00 CST 2017,
         endTime=Tue May 02 00:00:00 CST 2017,
         createTime=Sun May 07 22:16:59 CST 2017}
         */
    }

    @Test
    public void queryAll() throws Exception {
        //Java虚拟机不保存形参
        //queryAll(int offset,int limit) -> queryAll(arg0,arg1)
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount:" + updateCount);
    }


}