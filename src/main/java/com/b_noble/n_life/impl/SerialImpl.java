package com.b_noble.n_life.impl;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.b_noble.n_life.BaseApplication;
import com.b_noble.n_life.Serial;
import com.b_noble.n_life.event.ControlTypeEnum;
import com.b_noble.n_life.info.DeviceInfo;
import com.b_noble.n_life.info.GateWayInfo;
import com.b_noble.n_life.info.SenceInfo;
import com.b_noble.n_life.info.TaskDeviceAction;
import com.b_noble.n_life.info.TaskInfo;
import com.b_noble.n_life.info.TaskTimerAction;
import com.b_noble.n_life.info.TimingInfo;
import com.b_noble.n_life.model.RequestAddDeviceTimingTaskData;
import com.b_noble.n_life.model.RequestAddDeviceToSenceData;
import com.b_noble.n_life.model.RequestAddSenceData;
import com.b_noble.n_life.model.RequestAddTaskData;
import com.b_noble.n_life.model.RequestAddTimerTaskData;
import com.b_noble.n_life.model.RequestDeleteDeviceData;
import com.b_noble.n_life.model.RequestDeleteDeviceTimingTaskData;
import com.b_noble.n_life.model.RequestDeleteSceneData;
import com.b_noble.n_life.model.RequestDeleteSceneMemberData;
import com.b_noble.n_life.model.RequestDeleteTaskData;
import com.b_noble.n_life.model.RequestGetColorTemperatureData;
import com.b_noble.n_life.model.RequestGetDeviceHueAndSatData;
import com.b_noble.n_life.model.RequestGetDeviceLevelData;
import com.b_noble.n_life.model.RequestGetDeviceStateData;
import com.b_noble.n_life.model.RequestGetDeviceTimingTaskData;
import com.b_noble.n_life.model.RequestGetSceneMemberData;
import com.b_noble.n_life.model.RequestGetSensorTaskByUidData;
import com.b_noble.n_life.model.RequestGetTaskInfoData;
import com.b_noble.n_life.model.RequestGetTimerTaskBySceneIdData;
import com.b_noble.n_life.model.RequestHead;
import com.b_noble.n_life.model.RequestLoginGaByLanData;
import com.b_noble.n_life.model.RequestLoginValidateData;
import com.b_noble.n_life.model.RequestMessage;
import com.b_noble.n_life.model.RequestModifyPwdData;
import com.b_noble.n_life.model.RequestRecallSceneData;
import com.b_noble.n_life.model.RequestSetColorTemperatureData;
import com.b_noble.n_life.model.RequestSetDeviceColorData;
import com.b_noble.n_life.model.RequestSetDeviceLevelData;
import com.b_noble.n_life.model.RequestSetDeviceStateData;
import com.b_noble.n_life.model.RequestUpdateDeviceData;
import com.b_noble.n_life.model.RequestUpdateDeviceTimingTaskData;
import com.b_noble.n_life.model.RequestUpdateSceneNameData;
import com.b_noble.n_life.model.RequestUpdateTaskData;
import com.b_noble.n_life.model.RequestUpdateTimerTaskData;
import com.b_noble.n_life.model.RequestVerificationManagerPwdData;
import com.b_noble.n_life.utils.BroadcastUdpUtils;
import com.b_noble.n_life.utils.Global;
import com.b_noble.n_life.utils.HttpRequest;
import com.b_noble.n_life.utils.NettySendMessageUtil;
import com.b_noble.n_life.utils.SocketUtil;

import android.content.Context;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：app接口实现类
 * @作者：zhangfan @date：2016-08-04 @版本：V0.0.1
 */
public class SerialImpl implements Serial {

	public static Context mContext;

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	/**
	 * 连接到远程的网关
	 * 
	 * @param userName
	 *            用户名
	 * @param passWd
	 *            密码
	 * @return 1，连接成功且已绑定网关,-1为账号或密码错误,0为未绑定网关,-2与网关建立链接失败，-3鉴权系统链接超时
	 */
	public int connectRemoteZll(String userName, String passWd) {
		// TODO Auto-generated method stub

		
		try {
			String msg  = HttpRequest.sendPost(
					"http://120.76.223.218:8080/manaplatform/mobileTerminal_http/validateLoginNamePwd",
					"loginName=" + userName + "&loginPwd=" + passWd);

			JSONObject json = JSONObject.fromObject(msg);

			String state = json.getString("flag");
			// 用户名或密码错误
			if ("-2".equals(state)) {
				return -1;
			}
			// 登录成功但网关未绑定
			else if ("0".equals(state)) {
				return 0;
			}
			// 登录成功且有绑定网关
			else if ("1".equals(state)) {
				String datastr = json.getString("data");
				datastr = datastr.substring(1, datastr.length() - 1);
				System.out.println(datastr);

				JSONObject datajson = JSONObject.fromObject(datastr);
				String ip = datajson.getString("ip");
				String port = datajson.getString("port");
				String token = datajson.getString("token");
				String sn = datajson.getString("sn");
				
				Global.sncode = sn;
				Global.token = token;
				
				Global.loginName = userName;
				
				CountDownLatch threadSignal = new CountDownLatch(1);// 初始化countDown
				SocketUtil su = new SocketUtil(ip, Integer.parseInt(port), threadSignal);
				//SocketUtil su = new SocketUtil("192.168.1.103", 8001, threadSignal);
				
				su.start();

				try {
					threadSignal.await();// 等待所有子线程执行完
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (Global.group.size() == 0) {
					return -2;
				} else {
					
					//向服务端发送登录验证指令
					BaseApplication.getInstance().sendLoginCmd();
					
					return 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof SocketTimeoutException) {
				return -3;
			}
			if (e instanceof JSONException) {
				return 0;
			}
			if (e instanceof ConnectException) {
				return -3;
			}
		}
		return 0;

	}
	
	/**
	 * 局域网登录网关，执行改方法前需要先执行connectLANZllByIp方法
	 * @param userName
	 *            用户名
	 * @param passWd
	 *            密码
	 * 登录结果在回调loginGaByLan_Callback()中返回
	 */
	public int loginGaByLan(String userName,String passWd){
		
		RequestLoginGaByLanData data = new RequestLoginGaByLanData((byte) 0x00, userName, passWd);
		RequestHead header = new RequestHead(90, Global.sncode, ControlTypeEnum.LOGIN_GA_LAN.getVal());
		RequestMessage requestMessage = new RequestMessage(header, data);

		if (Global.group.size() > 0) {
			NettySendMessageUtil.send(requestMessage);
		}
		
		return 1;
		
	}

	/**
	 * 向服务端发送登录验证指令
	 */
	public void sendLoginCmd() {

		RequestLoginValidateData data = new RequestLoginValidateData((byte) 0x00, Global.sncode, Global.token,Global.loginName);
		RequestHead header = new RequestHead(66+32, Global.sncode, ControlTypeEnum.LOGIN_VALODATE.getVal());
		RequestMessage requestMessage = new RequestMessage(header, data);

		if (Global.group.size() > 0) {
			NettySendMessageUtil.send(requestMessage);
		}
	}

	/**
	 * 通过输入ip的方式来连接到本地的网关
	 * 
	 * @param ip
	 * @param snid
	 * @return -1 连接失败，-3连接超时，>0连接成功
	 */
	public int connectLANZllByIp(String ip, String snid, int port) {
		// TODO Auto-generated method stub
		Global.sncode = snid;
		CountDownLatch threadSignal = new CountDownLatch(1);// 初始化countDown
		SocketUtil su = new SocketUtil(ip, port, threadSignal);
		su.start();

		try {
			threadSignal.await();// 等待所有子线程执行完
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Global.group.size() == 0) {
			return -3;
		} else {
			return 1;
		}

	}

	/**
	 * 获取当前找到所有的网关ip
	 * 
	 * @return
	 */
	public Map<String, String> getGatewayIps() {
		// TODO Auto-generated method stub

		CountDownLatch threadSignal = new CountDownLatch(1);// 初始化countDown

		BroadcastUdpUtils bu = new BroadcastUdpUtils(threadSignal);
		bu.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Global.ips;

	}

	/**
	 * 查看网关信息
	 */
	public void getGateWayInfo() {

		byte[] data = new byte[0];
		RequestHead header = new RequestHead(21, Global.sncode, ControlTypeEnum.GET_GATEWAY_INFO.getVal());
		RequestMessage requestMessage = new RequestMessage(header, data);

		if (Global.group.size() > 0) {
			NettySendMessageUtil.send(requestMessage);
		}

	}

	/**
	 * 复位网关
	 * 
	 * @return
	 */
	public int resetGateway() {
		return 0;
		// TODO Auto-generated method stub

		/*
		 * if (Global.group.size()>0) { String result = (String)
		 * NettySendMessageUtil.send("{v:resetGateway,t:2}");
		 * System.out.println(result+"-----------------------------------");
		 * return 1; }else{ return 0; }
		 */

	}

	/**
	 * 获取当前连接的所有设备 可以在newDevice_CallBack（）这个回调中，来获得所有设备
	 */
	public DeviceInfo[] getDevices() {
		// TODO Auto-generated method stub

		byte[] data = new byte[0];
		RequestHead header = new RequestHead(21+5, Global.sncode, ControlTypeEnum.GET_DEVICE.getVal());
		RequestMessage requestMessage = new RequestMessage(header, data);

		if (Global.group.size() > 0) {
			NettySendMessageUtil.send(requestMessage);
		}
		return null;
	}

	/**
	 * 更改设备或组名称,传入字符数组
	 * 
	 * @param dInfo
	 *            要更改的设备（必须有device UId 和deviceName）
	 * @param dName
	 *            新的设备名
	 */
	public int ChangeDeviceName(DeviceInfo dInfo, String dName) {
		// TODO Auto-generated method stub

		RequestHead header = new RequestHead(57, Global.sncode, ControlTypeEnum.UPDATE_DEVICE_NAME.getVal());

		RequestUpdateDeviceData data = new RequestUpdateDeviceData(dInfo.getuId(), dName);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 删除当前设备
	 * 
	 * @param info
	 *            要删除的设备（必须有device Uid）
	 */
	public int deleteDevice(DeviceInfo info) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(35, Global.sncode, ControlTypeEnum.DELETE_DEVICE.getVal());

		RequestDeleteDeviceData data = new RequestDeleteDeviceData(info.getuId(), info.getIEEE(), (byte) 0x00);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 改变设备状态：1 开/ 0 关
	 * 
	 * @param info
	 *            要改变状态的设备（必须要有Uid）
	 * @param state
	 *            要改变的状态
	 */
	public int setDeviceState(DeviceInfo info, int state) {
		// TODO Auto-generated method stub

		RequestHead header = new RequestHead(26, Global.sncode, ControlTypeEnum.SET_DEVICE_STATE.getVal());

		RequestSetDeviceStateData data = new RequestSetDeviceStateData(info.getuId(), state);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 获得设备状态，结果在getDeviceState_CallBack这个回调中会有返回
	 * 
	 * @param info
	 *            要获取的设备（必须要有Uid）
	 */
	public int getDeviceState(DeviceInfo info) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(25, Global.sncode, ControlTypeEnum.GET_DEVICE_STATE.getVal());

		RequestGetDeviceStateData data = new RequestGetDeviceStateData(info.getuId());

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 改变设备值，（亮度）
	 * 
	 * @param info
	 *            要改变设备值的设备（必须要有Uid）
	 * @param value
	 *            要改变的值
	 */
	public int setDeviceLevel(DeviceInfo info, byte value) {
		// TODO Auto-generated method stub

		return setDeviceLevel(info, value, (short) 0);
	}

	/**
	 * 改变设备值，（亮度）
	 * 
	 * @param info
	 *            要改变设备值的设备（必须要有Uid）
	 * @param value
	 *            要改变的值
	 * @param transitionTime
	 *            延时时间
	 * @return
	 */
	public int setDeviceLevel(DeviceInfo info, byte value, short transitionTime) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(28, Global.sncode, ControlTypeEnum.SET_DEVICE_LEVEL.getVal());

		RequestSetDeviceLevelData data = new RequestSetDeviceLevelData(info.getuId(), value, transitionTime);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 获得设备值（输出级别， 如亮度） ， 结果在getDeviceLevel_CallBack这个回调中有返回
	 * 
	 * @param info
	 *            要获取设备值的设备（必须要有Uid）
	 */
	public int getDeviceLevel(DeviceInfo info) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(25, Global.sncode, ControlTypeEnum.GET_DEVICE_LEVEL.getVal());

		RequestGetDeviceLevelData data = new RequestGetDeviceLevelData(info.getuId());

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 改变设备色调、饱和度
	 * 
	 * @param info
	 *            要改变色调、饱和度的设备
	 * @param hue
	 *            色调
	 * @param sat
	 *            饱和度
	 */
	public int setDeviceHueSat(DeviceInfo info, byte hue, byte sat) {
		// TODO Auto-generated method stub
		return setDeviceHueSat(info, hue, sat, (short) 0);
	}

	/**
	 * 改变设备色调、饱和度
	 * 
	 * @param info
	 *            要改变色调、饱和度的设备
	 * @param hue
	 *            色调
	 * @param sat
	 *            饱和度
	 * @param transitionTime
	 *            延时时间（单位100ms）
	 * 
	 * @return
	 */
	public int setDeviceHueSat(DeviceInfo info, byte hue, byte sat, short transitionTime) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(29, Global.sncode, ControlTypeEnum.SET_DEVICE_COLOR.getVal());

		RequestSetDeviceColorData data = new RequestSetDeviceColorData(info.getuId(), hue, sat, transitionTime);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 改变设备色温
	 * 
	 * @param info
	 *            要改变设备的色温
	 * @param value
	 *            色温值
	 */
	public int SetColorTemperature(DeviceInfo info, int value) {
		// TODO Auto-generated method stub
		return SetColorTemperature(info, value, (short) 0);
	}

	/**
	 * 
	 * 改变设备色温
	 * 
	 * @param info
	 *            要改变设备的色温
	 * @param value
	 *            色温值
	 * @param transitionTime
	 *            延时时间（单位100ms）
	 * @return
	 */
	public int SetColorTemperature(DeviceInfo info, int value, short transitionTime) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(28, Global.sncode, ControlTypeEnum.SET_COLOR_TEMPERATURE.getVal());

		RequestSetColorTemperatureData data = new RequestSetColorTemperatureData(info.getuId(), value, transitionTime);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 获取设备色调与饱和度，结果在 getDeviceHueAndSat_CallBack这个回调中
	 * 
	 * @param info
	 *            要获取设备色调的设备 （必须要有Uid）
	 */
	public int getDeviceHueAndSat(DeviceInfo info) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(25, Global.sncode, ControlTypeEnum.GET_DEVICE_HUE.getVal());

		RequestGetDeviceHueAndSatData data = new RequestGetDeviceHueAndSatData(info.getuId());

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 获取设备色温值，结果在 getColorTemperature_CallBack这个回调中
	 * 
	 * @param info
	 *            要获取设备色温的设备（必须要有Uid）
	 */
	public int getColorTemperature(DeviceInfo info) {

		RequestHead header = new RequestHead(25, Global.sncode, ControlTypeEnum.GET_DEVICE_COLORTEMPERATURE.getVal());

		RequestGetColorTemperatureData data = new RequestGetColorTemperatureData(info.getuId());

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 获取当前所有场景
	 * 
	 * @return 当是串口连接时，会立即返回当前所有场景；当是lan、net连接时，返回NULL，其结果在newSence_CallBack（）
	 *         中返回
	 */
	public SenceInfo[] getSences() {
		// TODO Auto-generated method stub
		
		System.out.println("-----------------------------------sncode:"+ Global.sncode+"------------------------------------");
		
		byte[] data = new byte[0];
		RequestHead header = new RequestHead(21+5, Global.sncode, ControlTypeEnum.GET_SENCE.getVal());
		RequestMessage requestMessage = new RequestMessage(header, data);

		if (Global.group.size() > 0) {
			NettySendMessageUtil.send(requestMessage);
		}
		return null;
	}

	/**
	 * 创建新场景
	 * 
	 * @param senceName
	 *            场景名
	 * @param uid
	 *            设备uid
	 * @param delaytime
	 *            延迟时间为0-60s
	 */
	public int addSence(String senceName, List<byte[]> uid, int delaytime) {

		int length = 47 + uid.size() * 3;
		RequestHead header = new RequestHead(length, Global.sncode, ControlTypeEnum.ADD_SENCE.getVal());

		RequestAddSenceData data = new RequestAddSenceData(senceName, uid.size(), uid, delaytime);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 将指定的设备动作添加到指定的场景中
	 * 
	 * @param senceId
	 *            场景id
	 * @param uids
	 *            要添加的设备列表
	 */
	public int addDeviceToSence(int senceId, List<byte[]> uids, int delaytime) {

		int length = 16 + uids.size() * 3;
		RequestHead header = new RequestHead(length, Global.sncode, ControlTypeEnum.ADD_DEVICE_SENCE.getVal());

		RequestAddDeviceToSenceData data = new RequestAddDeviceToSenceData(senceId, uids.size(), uids, delaytime);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 打开指定的场景
	 * 
	 * @param senceId
	 *            要打开的场景的ID
	 * @param sceneName
	 *            要打开的场景的name
	 */
	public int recallScene(int sceneId, String sceneName) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(54, Global.sncode, ControlTypeEnum.RECALL_SENCE.getVal());

		RequestRecallSceneData data = new RequestRecallSceneData(sceneId, sceneName);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 获取指定场景的详细信息， 结果在getSenceMember_CallBack()这个回调中返回
	 * 
	 * @param senceId
	 *            场景Id
	 */
	public int getSenceMember(int sceneId) {

		RequestHead header = new RequestHead(54, Global.sncode, ControlTypeEnum.GET_SENCE_MEMBER.getVal());

		RequestGetSceneMemberData data = new RequestGetSceneMemberData(sceneId);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 删除场景中指定设备成员
	 * 
	 * @param senceName
	 *            场景名
	 * @param uIds
	 *            设备uId列表
	 */
	public int deleteSenceMember(int sceneId, String sceneName, List<byte[]> uId) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(47, Global.sncode, ControlTypeEnum.DELETE_SENCE_MEMBER.getVal());

		RequestDeleteSceneMemberData data = new RequestDeleteSceneMemberData(sceneId, sceneName, uId);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 删除指定场景
	 * 
	 * @param senceId
	 * @param senceName
	 */
	public int deleteSence(int senceId, String sceneName) {
		// TODO Auto-generated method stub

		RequestHead header = new RequestHead(54, Global.sncode, ControlTypeEnum.DELETE_SENCE.getVal());

		RequestDeleteSceneData data = new RequestDeleteSceneData(senceId, sceneName);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 修改场景名称
	 * 
	 * @param senceId
	 *            场景Id
	 * @param sName
	 *            新的场景名
	 */
	public int ChangeSceneName(short sceneId, String newSceneName) {

		RequestHead header = new RequestHead(54, Global.sncode, ControlTypeEnum.UPDATE_SENCE_NAME.getVal());

		RequestUpdateSceneNameData data = new RequestUpdateSceneNameData(sceneId, newSceneName);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 获取当前所有任务
	 * 
	 * @return 获取的任务在newTask_CallBack这个回调函数中
	 */
	public void getTasks() {

		RequestHead header = new RequestHead(21, Global.sncode, ControlTypeEnum.GET_ALL_TASK.getVal());

		RequestMessage message = new RequestMessage(header, null);

		NettySendMessageUtil.send(message);

	}

	/**
	 * 简述 根据场景id查询该场景的所有定时任务
	 * 
	 * @param sceneId
	 *            场景id
	 * @author zhangfan
	 * @date 2016-07-26
	 * @return 此方法在getTimerTaskBySceneId_CallBack这个回调方法中返回
	 */
	public void getTimerTaskBySceneId(int sceneId) {

		RequestHead header = new RequestHead(14, Global.sncode, ControlTypeEnum.GET_TASK_SCENE.getVal());

		RequestGetTimerTaskBySceneIdData data = new RequestGetTimerTaskBySceneIdData(sceneId);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

	}

	/**
	 * 简述 根据设备uid查询该设备的所有联动任务
	 * 
	 * @param uid
	 *            设备uid shortAddress+endPoint
	 * @author zhangfan
	 * @date 2016-07-27
	 * @return 此方法在getSensorTaskByUid_CallBack这个回调方法中返回
	 */
	public void getSensorTaskByUid(byte[] uid) {

		RequestHead header = new RequestHead(16, Global.sncode, ControlTypeEnum.GET_TASK_UID.getVal());

		RequestGetSensorTaskByUidData data = new RequestGetSensorTaskByUidData(uid);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);
	}

	/**
	 * 添加定时任务
	 * 
	 * @param timerAction
	 * @return
	 */
	public int addTimerTask(String taskName, TaskTimerAction timerAction, int sceneId) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(73, Global.sncode, ControlTypeEnum.ADD_TASK.getVal());

		RequestAddTimerTaskData data = new RequestAddTimerTaskData();

		data.setTaskName(taskName);
		data.setSceneId(sceneId);
		data.setEnable(0x01);
		data.setAlarm(0x00);
		data.setWeek(timerAction.getWorkMode());
		data.setHour(timerAction.getH());
		data.setMinute(timerAction.getM());
		data.setSecond(timerAction.getS());

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 添加设备触发任务
	 * 
	 * @param taskInfo
	 * @param isAlarm
	 *            是否需要报警
	 * @return
	 */
	public int addDeviceTask(String taskName, TaskDeviceAction deviceAction, short sceneId, byte isAlarm) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(73, Global.sncode, ControlTypeEnum.ADD_TASK.getVal());

		RequestAddTaskData data = new RequestAddTaskData();

		data.setTaskName(taskName);
		data.setSceneId(sceneId);
		data.setEnable(0x01);
		data.setAlarm(isAlarm);
		data.setUid(deviceAction.getuId());
		data.setDeviceId(deviceAction.getDeviceId());
		data.setCondition1(deviceAction.getCondition1());
		data.setValue1(deviceAction.getData1());
		data.setCondition2(deviceAction.getCondition2());
		data.setValue2(deviceAction.getData2());

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 添加设备报警任务
	 * 
	 * @param taskName
	 * @param deviceAction
	 * @return
	 */
	public int addDeviceAlarmTask(String taskName, TaskDeviceAction deviceAction) {
		// TODO Auto-generated method stub

		return addDeviceTask(taskName, deviceAction, (short) 0, (byte) 0x01);
	}

	/**
	 * 修改定时任务
	 * 
	 * @param taskInfo
	 * @return
	 */
	public int updateTimerTask(int taskId, String taskName, TaskTimerAction timerAction, short sceneId) {
		RequestHead header = new RequestHead(74, Global.sncode, ControlTypeEnum.UPDATE_TASK.getVal());

		RequestUpdateTimerTaskData data = new RequestUpdateTimerTaskData();

		data.setTaskName(taskName);
		data.setSceneId(sceneId);
		data.setEnable(0x01);
		data.setAlarm(0x00);
		data.setWeek(timerAction.getWorkMode());
		data.setHour(timerAction.getH());
		data.setMinute(timerAction.getM());
		data.setSecond(timerAction.getS());
		data.setTaskId(taskId);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 修改设备触发任务
	 * 
	 * @param taskName
	 * @param isAlarm
	 *            是否需要报警
	 * @return
	 */
	public int updateDeviceTask(int taskId, String taskName, TaskDeviceAction deviceAction, short sceneId,
			byte isAlarm) {
		RequestHead header = new RequestHead(74, Global.sncode, ControlTypeEnum.UPDATE_TASK.getVal());

		RequestUpdateTaskData data = new RequestUpdateTaskData();

		data.setTaskName(taskName);
		data.setSceneId(sceneId);
		data.setEnable(0x01);
		data.setAlarm(isAlarm);
		data.setUid(deviceAction.getuId());
		data.setDeviceId(deviceAction.getDeviceId());
		data.setCondition1(deviceAction.getCondition1());
		data.setValue1(deviceAction.getData1());
		data.setCondition2(deviceAction.getCondition2());
		data.setValue2(deviceAction.getData2());
		data.setTaskId(taskId);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 修改设备报警任务
	 * 
	 * @param taskName
	 * @param deviceAction
	 * @param SenceName
	 * @param isAlarm
	 * @return
	 */
	public int updateDeviceAlarmTask(int taskId, String taskName, TaskDeviceAction deviceAction) {
		return updateDeviceTask(taskId, taskName, deviceAction, (short) 0, (byte) 0x01);

	}

	/**
	 * 删除指定任务
	 * 
	 * @param taskID
	 *            指定的任务id
	 * @return
	 */
	public int deleteTask(int taskId) {

		RequestHead header = new RequestHead(24, Global.sncode, ControlTypeEnum.DELETE_TASK.getVal());

		RequestDeleteTaskData data = new RequestDeleteTaskData(taskId, (byte) 0x00);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 查看指定任务的详细信息,结果在getTimerTaskDetails_CallBack/getDeviceTaskDetails_CallBack
	 * 
	 * @param taskId
	 *            指定的任务id
	 * @return
	 */
	public int getTaskInfo(int taskId) {
		// TODO Auto-generated method stub
		RequestHead header = new RequestHead(22, Global.sncode, ControlTypeEnum.GET_TASK_INFO.getVal());

		RequestGetTaskInfoData data = new RequestGetTaskInfoData(taskId);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 添加设备定时任务
	 * 
	 * @param timingName
	 *            任务名称
	 * @param uid
	 *            设备唯一标示
	 * @param taskTimerAction
	 *            定时信息
	 * @param switchState
	 *            开关状态
	 * @param brightness
	 *            灯光亮度
	 * @param hue
	 *            饱和度
	 * @param saturation
	 *            色调
	 * @param colorTemperature
	 *            色温
	 * @param enable
	 * @return
	 */
	public int addDeviceTimingTask(String timingName, byte[] uid, TaskTimerAction taskTimerAction, byte switchState,
			byte brightness, byte hue, byte saturation, byte colorTemperature, byte enable) {

		RequestHead header = new RequestHead(58, Global.sncode, ControlTypeEnum.ADD_TIMING_TASK.getVal());

		RequestAddDeviceTimingTaskData data = new RequestAddDeviceTimingTaskData(timingName, uid, taskTimerAction,
				switchState, brightness, hue, saturation, colorTemperature, enable);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 删除设备定时任务
	 * 
	 * @param timingID
	 * @return
	 */
	public int deleteDeviceTimingTask(byte timingID) {

		RequestHead header = new RequestHead(24, Global.sncode, ControlTypeEnum.DELETE_TIMING_TASK.getVal());

		RequestDeleteDeviceTimingTaskData data = new RequestDeleteDeviceTimingTaskData(timingID);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;
	}

	/**
	 * 更新设备定时任务
	 * 
	 * @param timingID
	 *            任务id
	 * @param timingName
	 *            任务名称
	 * @param uid
	 *            设备唯一标示
	 * @param taskTimerAction
	 *            定时信息
	 * @param switchState
	 *            开关状态
	 * @param brightness
	 *            灯光亮度
	 * @param hue
	 *            饱和度
	 * @param saturation
	 *            色调
	 * @param colorTemperature
	 *            色温
	 * @param enable
	 * @return
	 */
	public int updateDeviceTimingTask(byte timingID, String timingName, byte[] uid, TaskTimerAction taskTimerAction,
			byte switchState, byte brightness, byte hue, byte saturation, byte colorTemperature, byte enable) {

		RequestHead header = new RequestHead(56, Global.sncode, ControlTypeEnum.UPDATE_TIMING_TASK.getVal());

		RequestUpdateDeviceTimingTaskData data = new RequestUpdateDeviceTimingTaskData(timingID, timingName, uid,
				taskTimerAction, switchState, brightness, hue, saturation, colorTemperature, enable);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);

		return 1;

	}

	/**
	 * 获取指定设备的所有定时任务，结果在getDeviceTimingTask_CallBack中返回
	 * 
	 * @param uid
	 *            设备唯一标示
	 */
	public void getDeviceTimingTask(byte[] uid) {

		RequestHead header = new RequestHead(16, Global.sncode, ControlTypeEnum.GET_TIMING_TASK.getVal());

		RequestGetDeviceTimingTaskData data = new RequestGetDeviceTimingTaskData(uid);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);
	}

	/**
	 * 向网关发送心跳信息
	 */
	public void sendHeartbeat() {
		RequestHead header = new RequestHead(13+5, Global.sncode, ControlTypeEnum.SEND_HEARTBEAT.getVal());

		RequestMessage message = new RequestMessage(header, null);

		NettySendMessageUtil.send(message);

	}

	/**
	 * 允许入网指令，设备入网成功后结果在回调newDevice_Callback()中返回
	 */
	public int permitJoin() {
		// TODO Auto-generated method stub

		byte[] data = new byte[0];
		RequestHead header = new RequestHead(21, Global.sncode, ControlTypeEnum.ALLOW_NET.getVal());
		RequestMessage requestMessage = new RequestMessage(header, data);

		if (Global.group.size() > 0) {
			NettySendMessageUtil.send(requestMessage);
		}

		return 1;
	}

	
	/**
	 * 验证网关管理密码,结果在verificationManagerPwd_Callback()中返回
	 */
	public int verificationManagerPwd(String username,String managerPwd){
		RequestHead header = new RequestHead(90, Global.sncode, ControlTypeEnum.VERIFICATION_MANAGERPWD.getVal());

		RequestVerificationManagerPwdData data = new RequestVerificationManagerPwdData((byte)0x00,username,managerPwd);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);
		
		return 1;
		
	}
	
	/**
	 * 修改管理密码
	 */
	public int modifyManagerPwd(String username,String oldManagerPwd,String newManagerPwd){
		
		RequestHead header = new RequestHead(123, Global.sncode, ControlTypeEnum.MODIFY_PASSWORD.getVal());

		RequestModifyPwdData data = new RequestModifyPwdData((byte)0x00,(byte)0x01,username,oldManagerPwd,newManagerPwd);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);
		
		return 1;
		
	}
	/**
	 * 修改登录密码
	 */
	public int modifyLoginPwd(String username,String oldLoginPwd,String newLoginPwd){
		
		RequestHead header = new RequestHead(123, Global.sncode, ControlTypeEnum.MODIFY_PASSWORD.getVal());

		RequestModifyPwdData data = new RequestModifyPwdData((byte)0x00,(byte)0x00,username,oldLoginPwd,newLoginPwd);

		RequestMessage message = new RequestMessage(header, data);

		NettySendMessageUtil.send(message);
		
		return 1;
		
	}
	
	
	/*************************以下是回调方法实现************************************/
	
	/**
	 * 回调方法测试
	 */
	public void callback(String result) {
		// TODO Auto-generated method stub
		System.out.println("result:" + result);

	}

	/**
	 * 获取所有设备回调
	 */
	public void newDevice_CallBack(List<DeviceInfo> dinfos) {

	}

	/**
	 * 本地查找网关返回
	 * 
	 * @param ip
	 */
	public void newGate_CallBack(String ip, String sn) {
		// TODO Auto-generated method stub
	}

	/**
	 * 获取设备的值回调方法
	 */
	public void getDeviceLevel_CallBack(int level, byte[] uId) {
	}

	/**
	 * 获取所有场景回调
	 * 
	 * @param dinfo
	 */
	public void newSence_CallBack(List<SenceInfo> sinfos) {

	}

	/**
	 * 获取网关信息返回
	 */
	public void getGateWayInfo_CallBack(GateWayInfo gainfo) {

	}

	public void getDeviceState_CallBack(int state, byte[] uId) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取设备色调与饱和度回调
	 * 
	 * @param hue
	 *            色调
	 * @param sat
	 *            饱和度
	 * @param uId
	 */
	public void getDeviceHueAndSat_CallBack(int hue, int sat, byte[] uId) {

	}

	/**
	 * 获取设备色温值回调
	 * 
	 * @param colorTemperature
	 * @param uId
	 */
	public void getColorTemperature_CallBack(int colorTemperature, byte[] uId) {

	}

	/**
	 * 获取场景成员回调
	 */
	public void getSenceMember_CallBack(int sceneId, String sceneName, List<byte[]> uids) {

	}

	/**
	 * 允许入网回调
	 */
	public void newDevice_Callback(DeviceInfo info) {

	}

	/**
	 * 获取所有任务回调
	 */
	public void newTask_CallBack(List<TaskInfo> tasks) {

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
	public void getTimerTaskDetails_CallBack(TaskInfo taskInfo, TaskTimerAction timerAction, short sceneId) {
	}

	/**
	 * 当调用getTaskInfo()时返回，返回获取设备联动任务
	 * 
	 * @param TaskInfo
	 *            taskInfo
	 * @param deviceAction
	 *            设备联动时，设备动作信息
	 * @param senceName
	 *            联动执行场景
	 * @param isAlarm
	 *            是否报警标志
	 */
	public void getDeviceTaskDetails_CallBack(TaskInfo taskInfo, TaskDeviceAction deviceAction, short sceneId,
			byte isAlarm) {
	}

	/**
	 * 当调用addSence后返回
	 * 
	 * @param sceneId
	 *            场景id
	 * 
	 * @param senceName
	 *            场景名称
	 */
	public void addSence_callBack(byte sceneId, String senceName) {

	}

	/**
	 * 当调用ChangeDeviceName后返回
	 * 
	 * @param uid
	 *            uid
	 * 
	 * @param deviceName
	 *            设备名称
	 */
	public void ChangeDeviceName_callBack(byte[] uid, String deviceName) {
	}

	/**
	 * 传感器推送数据回调
	 * 
	 * @param uid
	 *            设备uid
	 * @param 参数
	 *            请参考recentValue对照表
	 */
	public void sensorReport_callBack(byte[] uid, byte[] recentValue, byte[] deviceId, short attrId) {
		// TODO Auto-generated method stub

	}

	/**
	 * 温湿度传感器推送回调方法
	 * 
	 * @param temperature
	 *            温度
	 * @param humidity
	 *            湿度
	 * @param battery
	 *            电量 0正常，1低电量
	 */
	public void TemperatureAndHumidityReport_callBack(Double temperature, Double humidity, Integer battery) {

	}

	/**
	 * 紧急按钮推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void EmergencyButtonReprot_callBack(byte state, byte[] uid) {
	}

	/**
	 * 燃气传感器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void GasSensorReprot_callBack(byte state, byte[] uid) {
	}

	/**
	 * 烟雾传感器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void FireSensorReprot_callBack(byte state, byte[] uid) {
	}

	/**
	 * 一氧化碳传感器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void CoSensorReprot_callBack(byte state, byte[] uid) {
	}

	/**
	 * 多功能遥控器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void KeyFobReprot_callBack(byte state, byte[] uid) {
	}

	/**
	 * 客户端离线后回调方法
	 */
	public void clientClose() {
	}

	/**
	 * 客户端建立链接回调方法
	 */
	public void clientActive() {
	}

	/**
	 * 获取指定场景定时任务 当调用getTimerTaskBySceneId方法后回调
	 */
	public void getTimerTaskBySceneId_CallBack(List<TaskInfo> tasks) {
	}

	/**
	 * 获取指定设备联动任务 当条用getSensorTaskByUid方法后回调
	 */
	public void getSensorTaskByUid_CallBack(List<TaskInfo> tasks) {
	}

	/**
	 * 获取设备定时任务回调方法
	 */
	public void getDeviceTimingTask_CallBack(List<TimingInfo> timingInfos) {

	}

	/**
	 * 心跳响应回调方法
	 */
	public void sendHeartbeat_CallBack() {
	}
	
	/**
	 * 验证管理面回调方法
	 */
	public void verificationManagerPwd_Callback(int state){}
	
	/**
	 * 修改登录密码回调方法
	 * @param state : 0成功，1网关为链接云，2 用户名无效，3 原始密码错误，4新密码无效
	 */
	public void modifyLoginPwd_Callback(int state){}
	
	/**
	 * 网关局域网登录验证回调方法
	 * @param state ：0成功，1用户名无效，2密码错误
	 */
	public void loginGaByLan_Callback(int state){}

}
