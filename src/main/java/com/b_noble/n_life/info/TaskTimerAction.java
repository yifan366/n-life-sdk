package com.b_noble.n_life.info;

import java.io.Serializable;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：定时任务条件实体类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class TaskTimerAction implements Serializable
{
    private static final long serialVersionUID = 5029772237257296604L;
    private byte WorkMode; //week
    private byte h; //hour
    private byte m; //minute
    private byte s; //second

    
    
    @Override
	public String toString() {
		return "TaskTimerAction [WorkMode=" + WorkMode + ", h=" + h + ", m=" + m + ", s=" + s + "]";
	}

	public TaskTimerAction() {
		super();
	}
    
    public TaskTimerAction(byte workMode, byte h, byte m, byte s) {
		super();
		WorkMode = workMode;
		this.h = h;
		this.m = m;
		this.s = s;
	}

	public byte getWorkMode()
    {
        return WorkMode;
    }

	public void setWorkMode(byte workMode)
    {
        WorkMode = workMode;
    }

    public byte getH()
    {
        return h;
    }

    public void setH(byte h)
    {
        this.h = h;
    }

    public byte getM()
    {
        return m;
    }

    public void setM(byte m)
    {
        this.m = m;
    }

    public byte getS()
    {
        return s;
    }

    public void setS(byte s)
    {
        this.s = s;
    }


}
