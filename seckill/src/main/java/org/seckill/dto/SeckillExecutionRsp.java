package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * 封装秒杀执行结果
 * Created by hujiayu on 2017/5/28.
 */
public class SeckillExecutionRsp {

    private long seckill;

    //秒杀结果状态
    private int state;

    //  秒杀状态表示
    private String stateInfo;

    //    秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExecutionRsp(long seckill, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckill = seckill;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecutionRsp(long seckill, SeckillStatEnum statEnum) {
        this.seckill = seckill;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "SeckillExecutionRsp{" +
                "seckill=" + seckill +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }

    public long getSeckill() {
        return seckill;
    }

    public void setSeckill(long seckill) {
        this.seckill = seckill;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
