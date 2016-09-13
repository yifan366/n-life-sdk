package com.b_noble.n_life;

import java.util.List;

import com.b_noble.n_life.impl.SerialImpl;
import com.b_noble.n_life.info.DeviceInfo;
import com.b_noble.n_life.info.GateWayInfo;
import com.b_noble.n_life.info.SenceInfo;
import com.b_noble.n_life.info.TaskDeviceAction;
import com.b_noble.n_life.info.TaskInfo;
import com.b_noble.n_life.info.TaskTimerAction;
import com.b_noble.n_life.info.TimingInfo;
import com.b_noble.n_life.utils.Test16Binary;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：SmartHome
 * @简述： callback，must extends SerialImpl
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class SerialSub extends SerialImpl {

	/**
	 * 获取所有设备回调
	 */
	public void newDevice_CallBack(List<DeviceInfo> dinfos) {

		for (DeviceInfo d : dinfos) {
			System.out.println("name:" + d.getDeviceName() + "---uid:" + Test16Binary.bytes2hex03(d.getuId()) +"---deviceId:" + Test16Binary.bytes2hex03(d.getDeviceId())
					+ "---profileId:" + Test16Binary.bytes2hex03(d.getProfileId())+"---attrID:"+Integer.toHexString(d.getAtrrId())+"---recentValue:"+Test16Binary.bytes2hex03(d.getRecentValue()));
		}

	}

	/**
	 * 本地查找网关返回
	 * 
	 * @param ip
	 */
	public void newGate_CallBack(String ip,String sn) {
		// TODO Auto-generated method stub
		System.out.println("回调接收----ip:"+ip+"---sn:"+sn);
	}

	/**
	 * 获取设备的值回调方法
	 */
	public void getDeviceLevel_CallBack(int level, byte[] uId) {

		System.out.println("获取设备亮度回调："+level);
	}

	/**
	 * 新场景加入回调
	 * 
	 * @param dinfo
	 */
	public void newSence_CallBack(List<SenceInfo> sinfos) {

		System.out.println("----------------新场景加入回调:" + sinfos.size());

		for (SenceInfo s : sinfos) {
			System.out.println("name:" + s.getSenceName() + "---sid:" + s.getSenceId());
		}
	}
	
	/**
	 * 获取网关信息返回
	 */
	public void getGateWayInfo_CallBack(GateWayInfo gainfo){
		
		System.out.println("获取网关信息返回："+gainfo.toString());
	}
	
	/***************************************20160630新加***********************************************/
	
	/**
	 *  获取设备状态回调,通过state来判断设备状态（>0 开、<= 0关）
	 * @param state
	 * @param uId
	 */
	public void getDeviceState_CallBack(int state, byte[] uId) {

		System.out.println("设备开关状态返回1："+state);
	}
	
	/**
	 * 获取设备色调与饱和度回调
	 * 
	 * @param hue 色调
	 * @param sat 饱和度
	 * @param uId
	 */
	public void getDeviceHueAndSat_CallBack(int hue,int sat, byte[] uId){
		System.out.println("设备色调与饱和度返回-----色调："+hue+"饱和度："+sat);
	}
	
	/**
	 * 获取设备色温值回调
	 * @param colorTemperature
	 * @param uId
	 */
	public void getColorTemperature_CallBack(int colorTemperature, byte[] uId){
		
		System.out.println("设备色温返回-----色温："+colorTemperature);
	}

	
	/************************************20160702新加***************************/
	/**
	 * 获取场景成员回调
	 */
	public void getSenceMember_CallBack(int sceneId,String sceneName,List<byte[]> uids){
		
		System.out.println("获取场景成员返回---sceneId："+sceneId+" sceneName:"+sceneName+" uids:"+uids);
		for (int i = 0; i < uids.size(); i++) {
			System.out.println(Test16Binary.bytes2hex03(uids.get(i)));
		}
	}
	
	/**
	 * 允许入网回调
	 */
	public void newDevice_Callback(DeviceInfo info){
		System.out.println("允许入网回调返回---"+info.getDeviceId()+"--"+info.getProfileId()+"---"+info.getuId());
	}
	
	/**
	 * 获取所有任务回调
	 */
	public void newTask_CallBack(List<TaskInfo> tasks){
		
		System.out.println("获取所有任务回调：");
		for (TaskInfo info : tasks) {
			System.out.println(info.toString1());
		}
	}
	
	
	/**
	 * 当调用getTaskInfo()时返回
	 * 
	 * @param taskInfo
	 * 
	 * @param action1
	 *            first task's action
	 * @param action2
	 *            second task's action
	 */
	public void getTimerTaskDetails_CallBack(TaskInfo taskInfo, TaskTimerAction timerAction, short sceneId) 
	{
		
		System.out.println("定时任务返回"+taskInfo.getTaskName()+"--TaskType:"+taskInfo.getTaskType()+"--"+sceneId);
	}

	/**
	 * 当调用getTaskInfo()时返回，返回获取设备联动任务
	 * 
	 * @param TaskInfo taskInfo
	 * @param deviceAction
	 *            设备联动时，设备动作信息
	 * @param senceName
	 *            联动执行场景
	 * @param isAlarm
	 *            是否报警标志
	 */
	public void getDeviceTaskDetails_CallBack(TaskInfo taskInfo, TaskDeviceAction deviceAction, short sceneId, byte isAlarm)
	{
		System.out.println("设备触发任务"+taskInfo.getTaskName()+"--TaskType:"+taskInfo.getTaskType()+"--"+sceneId);
	}
	
	
	//**********************************************0707新加******************************************/
	/**
	 * 当调用addSence后返回
	 * 
	 * @param sceneId  场景id
	 * 
	 * @param senceName 场景名称
	 */
	public void addSence_callBack(byte sceneId,String senceName){
		System.out.println("场景添加后回调：sceneId "+sceneId+" senceName "+senceName);
	}
	
	/**
	 * 当调用ChangeDeviceName后返回
	 *  @param uid  uid
	 * 
	 * @param deviceName 设备名称
	 */
	public void ChangeDeviceName_callBack(byte[] uid,String deviceName){
		
		System.out.println("更改设备名称后回调----uid: "+Test16Binary.bytes2hex03(uid)+" deviceName: "+deviceName);
	}
	
	
	/**
	 * 传感器推送数据回调
	 * @param uid 设备uid 
	 * @param 参数 请参考recentValue对照表 
	 */
	public void sensorReport_callBack(byte[] uid,byte[] recentValue,byte[] deviceId,short attrId) {
		// TODO Auto-generated method stub
		
		
		System.out.println("传感器推送返回--- uid:"+Test16Binary.bytes2hex03(uid)+"  recentValue:"+Test16Binary.bytes2hex03(recentValue));
	}
	
	/**
	 * 温湿度传感器推送回调方法
	 * @param temperature 温度
	 * @param humidity 湿度
	 * @param battery 电量  0正常，1低电量
	 */
	public void TemperatureAndHumidityReport_callBack(Double temperature,Double humidity,Integer battery){
		
		System.out.println("温湿度传感器返回：----temperature："+temperature+"  humidity:"+humidity+"  battery"+battery);
	}
	
	/**
	 * 紧急按钮推送回调方法
	 * @param state 状态 
	 */
	public void EmergencyButtonReprot_callBack(byte state,byte[] uid){
		
		System.out.println("紧急按钮推送：----state:"+state);
	}
	
	/**
	 * 燃气传感器推送回调方法
	 * @param state 状态 
	 */
	public void GasSensorReprot_callBack(byte state,byte[] uid){
		
		System.out.println("燃气传感器推送：----state:"+state);
	} 
	
	/**
	 * 烟雾传感器推送回调方法
	 * @param state 状态 
	 */
	public void FireSensorReprot_callBack(byte state,byte[] uid){
		System.out.println("烟雾传感器推送：----state:"+state);
	}
	
	/**
	 * 一氧化碳传感器推送回调方法
	 * @param state 状态 
	 */
	public void CoSensorReprot_callBack(byte state,byte[] uid){
		System.out.println("一氧化碳传感器推送：----state:"+state);
	} 
	
	/**
	 * 多功能遥控器推送回调方法
	 * @param state 状态 
	 */
	public void KeyFobReprot_callBack(byte state,byte[] uid){
		System.out.println("多功能遥控器推送：----state:"+state);
	}
	
	/**
	 * 客户端离线后回调方法
	 */
	public void clientClose(){
		
		System.out.println("客户端已离线");
	}
	
	/**
	 * 客户端建立链接回调方法
	 */
	public void clientActive(){
		System.out.println("客户端建立链接");
	}
	
	/**
	 * 获取指定场景定时任务
	 * 当调用getTimerTaskBySceneId方法后回调
	 */
	public void getTimerTaskBySceneId_CallBack(List<TaskInfo> tasks){
		
		for (TaskInfo t : tasks) {
			System.out.println(t.toString());
		}
		
	}
	
	/**
	 * 获取指定设备联动任务
	 * 当条用getSensorTaskByUid方法后回调
	 */
	public void getSensorTaskByUid_CallBack(List<TaskInfo> tasks){
		
		for (TaskInfo t : tasks) {
			System.out.println(t.toTaskDeviceActionString());
		}
	}
	
	/**
	 * 获取设备定时任务回调方法
	 */
	public void getDeviceTimingTask_CallBack(List<TimingInfo> timingInfos){
		
		for (TimingInfo t : timingInfos) {
			System.out.println(t.toString());
		}
	}
	
	/**
	 * 心跳响应回调方法
	 */
	public void sendHeartbeat_CallBack(){
		System.out.println("响应心跳");
	}
	
	/**
	 * 修改密码回调
	 */
	/**
	 * 修改登录密码回调方法
	 * @param state : 0成功，1网关为链接云，2 用户名无效，3 原始密码错误，4新密码无效
	 */
	public void modifyLoginPwd_Callback(int state){
		
		System.out.println("修改密码状态返回："+state);
	}
}
