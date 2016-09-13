package com.b_noble.n_life.info;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：场景联动任务实体类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class TaskDeviceAction implements Serializable
{

	private static final long serialVersionUID = -6788487849446346915L;
    
    private byte[] uId;
    // 设备类型
    private byte[] deviceId;

    private byte condition1;
    private int data1;
    private byte condition2;
    private int data2;

    
    
    @Override
	public String toString() {
		return "TaskDeviceAction [uId=" + Arrays.toString(uId) + ", deviceId=" + Arrays.toString(deviceId)
				+ ", condition1=" + condition1 + ", data1=" + data1 + ", condition2=" + condition2 + ", data2=" + data2
				+ "]";
	}

	public TaskDeviceAction() {
		super();
	}

	public TaskDeviceAction(byte[] uId, byte[] deviceId, byte condition1, int data1, byte condition2, int data2) {
		super();
		this.uId = uId;
		this.deviceId = deviceId;
		this.condition1 = condition1;
		this.data1 = data1;
		this.condition2 = condition2;
		this.data2 = data2;
	}

	public int getData2()
    {
        return data2;
    }

    public void setData2(int data2)
    {
        this.data2 = data2;
    }

    public byte getCondition1()
    {
        return condition1;
    }

    public void setCondition1(byte condition1)
    {
        this.condition1 = condition1;
    }

    public byte getCondition2()
    {
        return condition2;
    }

    public void setCondition2(byte condition2)
    {
        this.condition2 = condition2;
    }

    public int getData1()
    {
        return data1;
    }

    public void setData1(int data1)
    {
        this.data1 = data1;
    }


    public byte[] getuId() {
		return uId;
	}

	public void setuId(byte[] uId) {
		this.uId = uId;
	}

	public byte[] getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(byte[] deviceId)
    {
        this.deviceId = deviceId;
    }

}
