package com.b_noble.n_life.info;

import java.io.Serializable;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：场景实体类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class SenceInfo implements Serializable
{
	private static final long serialVersionUID = 3854276665568461276L;
    // sceneId,it will Automatic generate,don't modify it
    private short sceneId;
    private String sceneName;
    private byte deviceNum;
    private String sceneIconPath;
    
    public SenceInfo()
    {
    	
    }

    public SenceInfo(String senceId, String senceName, String senceIconPath)
	{
    	this.sceneId = Short.parseShort(senceId);
    	this.sceneName = senceName;
    	this.sceneIconPath = senceIconPath;
	}

	public short getSenceId()
    {
        return sceneId;
    }

    public void setSenceId(short senceId)
    {
        this.sceneId = senceId;
    }

    public String getSenceName()
    {
        return sceneName;
    }

    public void setSenceName(String senceName)
    {
        this.sceneName = senceName;
    }

    public byte getDeviceNum()
    {
        return deviceNum;
    }

    public void setDeviceNum(byte deviceNum)
    {
        this.deviceNum = deviceNum;
    }

//    public List<SenceData> getSenceDatas()
//    {
//        return senceDatas;
//    }
//
//    public void setSenceDatas(List<SenceData> senceDatas)
//    {
//        this.senceDatas = senceDatas;
//    }

    public String getSenceIconPath()
    {
        return sceneIconPath;
    }

    public void setSenceIconPath(String senceIconPath)
    {
        this.sceneIconPath = senceIconPath;
    }
}
