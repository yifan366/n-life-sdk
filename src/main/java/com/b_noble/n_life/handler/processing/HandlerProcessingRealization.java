package com.b_noble.n_life.handler.processing;

import java.util.ArrayList;
import java.util.List;

import com.b_noble.n_life.BaseApplication;
import com.b_noble.n_life.info.DeviceInfo;
import com.b_noble.n_life.info.GateWayInfo;
import com.b_noble.n_life.info.SenceInfo;
import com.b_noble.n_life.info.TaskDeviceAction;
import com.b_noble.n_life.info.TaskInfo;
import com.b_noble.n_life.info.TaskTimerAction;
import com.b_noble.n_life.info.TimingInfo;
import com.b_noble.n_life.utils.StringNamesUtils;

import io.netty.buffer.ByteBuf;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居 @简述： handler处理实现类
 * @作者：zhangfan @date：2016-08-04 @版本：V0.0.1
 */
public class HandlerProcessingRealization {

	/**
	 * 获取所有设备返回处理
	 */
	public static void getAllDeviceResponseProcessing(ByteBuf buf) {
		List<DeviceInfo> deviceInfos = new ArrayList<DeviceInfo>();

		byte totalOnlines = buf.readByte();
		// TBD
		for (int i = 0; i < 8; i++) {
			buf.readByte();
		}

		// 循环获取Device
		for (int i = 0; i < totalOnlines; i++) {
			DeviceInfo deviceInfo = new DeviceInfo();

			byte[] IEEE = new byte[8];
			// IEEEAddress
			for (int j = 0; j < 8; j++) {
				IEEE[j] = buf.readByte();
			}

			byte[] shortAddress = new byte[3];
			// shortAddress endPoint
			shortAddress[0] = buf.readByte();
			shortAddress[1] = buf.readByte();
			shortAddress[2] = buf.readByte();

			// profileId
			byte[] profileId = new byte[2];
			profileId[0] = buf.readByte();
			profileId[1] = buf.readByte();

			// deviceId
			byte[] deviceId = new byte[2];
			deviceId[0] = buf.readByte();
			deviceId[1] = buf.readByte();

			// atrrId
			short atrrId = buf.readShort();

			// deviceName
			byte[] dnamebyte = new byte[32];
			for (int j = 0; j < 32; j++) {
				dnamebyte[j] = buf.readByte();
			}
			String deviceName = StringNamesUtils.byteToString(dnamebyte);

			// sn
			byte[] snbyte = new byte[8];
			for (int j = 0; j < 8; j++) {
				snbyte[j] = buf.readByte();
			}
			String sn = "";
			sn = new String(snbyte);
			// recentValue
			byte[] recentValue = new byte[7];
			for (int j = 0; j < 7; j++) {
				recentValue[j] = buf.readByte();
			}

			// TBD
			buf.readByte();
			buf.readByte();

			deviceInfo.setDeviceName(deviceName);
			deviceInfo.setIEEE(IEEE);
			deviceInfo.setProfileId(profileId);
			deviceInfo.setDeviceId(deviceId);
			deviceInfo.setuId(shortAddress);
			deviceInfo.setAtrrId(atrrId);
			deviceInfo.setRecentValue(recentValue);

			deviceInfos.add(deviceInfo);
		}

		// 为回调函数赋值
		BaseApplication.getInstance().newDevice_CallBack(deviceInfos);

	}

	/**
	 * 获取所有场景返回处理
	 */
	public static void getAllSceneResponseProcessing(ByteBuf buf) {
		List<SenceInfo> senceInfos = new ArrayList<SenceInfo>();

		byte totalOnlines = buf.readByte();
		System.out.println("count:" + totalOnlines);

		// 循环获取sence
		for (int i = 0; i < totalOnlines; i++) {
			SenceInfo senceInfo = new SenceInfo();

			// senceid
			byte senceid = buf.readByte();

			// senceName
			byte[] sencebyte = new byte[32];
			for (int j = 0; j < 32; j++) {
				sencebyte[j] = buf.readByte();
			}
			String senceName = StringNamesUtils.byteToString(sencebyte);

			senceInfo.setSenceName(senceName);
			senceInfo.setSenceId(senceid);

			senceInfos.add(senceInfo);
		}
		// TBD
		for (int j = 0; j < 8; j++) {
			buf.readByte();
		}

		// 为回调函数赋值
		BaseApplication.getInstance().newSence_CallBack(senceInfos);

	}

	/**
	 * 获取网关信息返回
	 * 
	 * @param buf
	 */
	public static void getGateinfoResponseProcessing(ByteBuf buf) {

		GateWayInfo gateWayInfo = new GateWayInfo();

		// version
		byte[] versionbyte = new byte[8];
		for (int j = 0; j < 8; j++) {
			versionbyte[j] = buf.readByte();
		}
		String version = new String(versionbyte);

		// sn
		byte[] snbyte = new byte[8];
		for (int i = 0; i < 8; i++) {
			snbyte[i] = buf.readByte();
		}
		String sn = new String(snbyte);

		// user
		byte[] userbyte = new byte[32];
		for (int j = 0; j < 32; j++) {
			userbyte[j] = buf.readByte();
		}
		String user = StringNamesUtils.byteToString(userbyte);

		// passwrd
		byte[] passwrdbyte = new byte[24];
		for (int j = 0; j < 24; j++) {
			passwrdbyte[j] = buf.readByte();
		}
		String passwrd = StringNamesUtils.byteToString(passwrdbyte);

		// totalDevices
		byte totalDevices = buf.readByte();

		// totalGroup
		byte totalGroup = buf.readByte();

		// totalTimers
		byte totalTimers = buf.readByte();

		// totalScenes
		byte totalScenes = buf.readByte();

		// totalTasks
		byte totalTasks = buf.readByte();

		gateWayInfo.setVersion(version);
		gateWayInfo.setSn(sn);
		gateWayInfo.setUser(user);
		gateWayInfo.setPasswrd(passwrd);
		gateWayInfo.setTotalDevices(totalDevices);
		gateWayInfo.setTotalGroup(totalGroup);
		gateWayInfo.setTotalScenes(totalScenes);
		gateWayInfo.setTotalTasks(totalTasks);
		gateWayInfo.setTotalTimers(totalTimers);

		// 为回调函数赋值
		BaseApplication.getInstance().getGateWayInfo_CallBack(gateWayInfo);

	}

	/**
	 * 获取设备开关状态返回
	 * 
	 * @param buf
	 */
	public static void getDeviceStateResponseProcessing(ByteBuf buf) {

		// shortAddress Endpoint
		byte[] uid = new byte[3];
		for (int i = 0; i < 3; i++) {
			uid[i] = buf.readByte();
		}

		// switchState
		byte state = buf.readByte();

		// TBD
		for (int j = 0; j < 8; j++) {
			buf.readByte();
		}

		BaseApplication.getInstance().getDeviceState_CallBack(state, uid);
	}

	/**
	 * 获取设备亮度返回处理
	 * 
	 * @param buf
	 */
	public static void getDeviceLevelProcessing(ByteBuf buf) {

		// shortAddress Endpoint
		byte[] uid = new byte[3];
		for (int i = 0; i < 3; i++) {
			uid[i] = buf.readByte();
		}

		// brightness
		int brightness = buf.readUnsignedByte();

		// TBD
		for (int j = 0; j < 8; j++) {
			buf.readByte();
		}

		BaseApplication.getInstance().getDeviceLevel_CallBack(brightness, uid);
	}

	/**
	 * 获取设备色调与饱和度处理
	 * 
	 * @param buf
	 */
	public static void getDeviceHueProcessing(ByteBuf buf) {
		// TODO Auto-generated method stub
		// shortAddress Endpoint
		byte[] uid = new byte[3];
		for (int i = 0; i < 3; i++) {
			uid[i] = buf.readByte();
		}

		// hue
		int hue = buf.readUnsignedByte();

		// saturation

		int sat = buf.readUnsignedByte();

		// TBD
		for (int j = 0; j < 8; j++) {
			buf.readByte();
		}

		BaseApplication.getInstance().getDeviceHueAndSat_CallBack(hue, sat, uid);
	}

	/**
	 * 获取设备色温返回处理
	 * 
	 * @param buf
	 */
	public static void getColorTemperatureProcessing(ByteBuf buf) {
		// TODO Auto-generated method stub
		// shortAddress Endpoint
		byte[] uid = new byte[3];
		for (int i = 0; i < 3; i++) {
			uid[i] = buf.readByte();
		}

		// colorTemperature
		byte colorTemperature = buf.readByte();

		// TBD
		for (int j = 0; j < 8; j++) {
			buf.readByte();
		}

		BaseApplication.getInstance().getColorTemperature_CallBack(colorTemperature, uid);
	}

	/**
	 * 获取场景成员处理
	 * 
	 * @param buf
	 */
	public static void getSceneMemberProcessing(ByteBuf buf) {

		// sceneID
		int sceneID = buf.readByte();

		// sceneName
		byte[] sceneNamebyte = new byte[32];
		for (int j = 0; j < 32; j++) {
			sceneNamebyte[j] = buf.readByte();
		}
		String sceneName = StringNamesUtils.byteToString(sceneNamebyte);

		// totalDevice
		int totalDevice = buf.readByte();

		List<byte[]> uidlst = new ArrayList<byte[]>();
		// shortAddress endPoint
		for (int i = 0; i < totalDevice; i++) {
			byte[] uid = new byte[3];
			uid[0] = buf.readByte();
			uid[1] = buf.readByte();
			uid[2] = buf.readByte();
			uidlst.add(uid);

			buf.readBytes(8);
		}

		BaseApplication.getInstance().getSenceMember_CallBack(sceneID, sceneName, uidlst);
	}

	/**
	 * 获取所有任务
	 * 
	 * @param buf
	 */
	public static void getAllTaskProcessing(ByteBuf buf) {
		// TODO Auto-generated method stub

		List<TaskInfo> tasks = new ArrayList<TaskInfo>();
		// totalTasks
		int totalTasks = buf.readByte();

		for (int i = 0; i < totalTasks; i++) {
			byte taskType = buf.readByte();
			byte taskID = buf.readByte();

			byte[] taskNamebyte = new byte[32];
			for (int j = 0; j < 32; j++) {
				taskNamebyte[j] = buf.readByte();
			}
			String taskName = StringNamesUtils.byteToString(taskNamebyte);

			TaskInfo info = new TaskInfo();
			info.setTaskId(taskID);
			info.setTaskType(taskType);
			info.setTaskName(taskName);

			tasks.add(info);
		}

		BaseApplication.getInstance().newTask_CallBack(tasks);
	}

	/**
	 * 获取任务详细
	 * 
	 * @param buf
	 */
	public static void getTaskInfoProcessing(ByteBuf buf) {
		// TODO Auto-generated method stub

		TaskTimerAction timerAction = null;
		TaskDeviceAction deviceAction = null;
		TaskInfo taskInfo = new TaskInfo();

		// taskType
		byte taskType = buf.readByte();

		byte[] taskNamebyte = new byte[32];
		for (int j = 0; j < 32; j++) {
			taskNamebyte[j] = buf.readByte();
		}
		String taskName = StringNamesUtils.byteToString(taskNamebyte);

		byte taskId = buf.readByte();

		// judgement 9bytes
		if (taskType == 0x01) {
			byte week = buf.readByte();
			byte hour = buf.readByte();
			byte minute = buf.readByte();
			byte Second = buf.readByte();

			for (int i = 0; i < 5; i++) {
				buf.readByte();
			}
			timerAction = new TaskTimerAction(week, hour, minute, Second);

		} else if (taskType == 0x02) {
			byte[] uid = new byte[3];
			for (int i = 0; i < 3; i++) {
				uid[i] = buf.readByte();
			}

			byte[] deviceID = new byte[2];
			for (int i = 0; i < 2; i++) {
				deviceID[i] = buf.readByte();
			}

			byte condition1 = buf.readByte();

			byte value1 = buf.readByte();

			byte condition2 = buf.readByte();

			byte value2 = buf.readByte();

			deviceAction = new TaskDeviceAction(uid, deviceID, condition1, value1, condition2, value2);
		}

		// TBD
		for (int i = 0; i < 8; i++) {
			buf.readByte();
		}

		// sceneID
		byte sceneID = buf.readByte();

		// alarm
		byte alarm = buf.readByte();

		// enable
		byte enable = buf.readByte();

		// TBD
		for (int j = 0; j < 8; j++) {
			buf.readByte();
		}

		taskInfo.setTaskType(taskType);
		taskInfo.setTaskName(taskName);
		taskInfo.setTaskId(taskId);
		taskInfo.setIsAlarm(alarm);
		taskInfo.setIsAble(enable);

		if (taskType == 0x01) {
			BaseApplication.getInstance().getTimerTaskDetails_CallBack(taskInfo, timerAction, sceneID);
		} else if (taskType == 0x02) {
			BaseApplication.getInstance().getDeviceTaskDetails_CallBack(taskInfo, deviceAction, sceneID, alarm);
		}

	}

	/**
	 * 添加场景后返回
	 * 
	 * @param buf
	 */
	public static void addSenceResponseProcessing(ByteBuf buf) {
		// TODO Auto-generated method stub

		// sceneID
		byte sceneId = buf.readByte();

		// sceneName
		byte[] sceneNamebyte = new byte[32];
		for (int j = 0; j < 32; j++) {
			sceneNamebyte[j] = buf.readByte();
		}
		String sceneName = StringNamesUtils.byteToString(sceneNamebyte);

		// TBD
		for (int i = 0; i < 8; i++) {
			buf.readByte();
		}

		BaseApplication.getInstance().addSence_callBack(sceneId, sceneName);
	}

	/**
	 * 更改设备名称后返回
	 * 
	 * @param buf
	 */
	public static void updateDeviceNameResponseProcessing(ByteBuf buf) {
		// TODO Auto-generated method stub

		// uid
		byte[] uid = new byte[3];
		for (int i = 0; i < uid.length; i++) {
			uid[i] = buf.readByte();
		}

		// deviceName
		byte[] deviceNamebyte = new byte[32];
		for (int j = 0; j < 32; j++) {
			deviceNamebyte[j] = buf.readByte();
		}
		String deviceName = StringNamesUtils.byteToString(deviceNamebyte);

		// TBD
		for (int i = 0; i < 8; i++) {
			buf.readByte();
		}

		BaseApplication.getInstance().ChangeDeviceName_callBack(uid, deviceName);

	}

	/**
	 * 获取指定场景定时任务返回
	 * 
	 * @param buf
	 */
	public static void getTimerTaskBySceneId(ByteBuf buf) {
		// TODO Auto-generated method stub

		System.out.println("获取指定场景定时任务返回！！！！！！！！！！！！");

		List<TaskInfo> tasks = new ArrayList<TaskInfo>();

		// totaltimertask
		byte totaltimertask = buf.readByte();

		for (int i = 0; i < totaltimertask; i++) {

			// taskType
			byte taskType = buf.readByte();

			// taskName
			byte[] taskNamebyte = new byte[32];
			for (int j = 0; j < 32; j++) {
				taskNamebyte[j] = buf.readByte();
			}
			String taskName = StringNamesUtils.byteToString(taskNamebyte);

			// taskID
			byte taskId = buf.readByte();

			// judgement
			byte workMode = buf.readByte();
			byte h = buf.readByte();
			byte m = buf.readByte();
			byte s = buf.readByte();

			TaskTimerAction taskTimerAction = new TaskTimerAction(workMode, h, m, s);

			buf.readBytes(5);

			// sceneID
			buf.readByte();

			// alarm
			byte isAlarm = buf.readByte();
			// enable
			byte isAble = buf.readByte();

			TaskInfo taskInfo = new TaskInfo(taskId, taskName, taskType, isAlarm, isAble, taskTimerAction);

			tasks.add(taskInfo);
		}

		BaseApplication.getInstance().getTimerTaskBySceneId_CallBack(tasks);

	}

	/**
	 * 获取设备定时任务
	 * 
	 * @param buf
	 */
	public static void getTimingTask(ByteBuf buf) {

		List<TimingInfo> timingInfos = new ArrayList<TimingInfo>();

		// totalTimeTasks
		byte totalTimeTasks = buf.readByte();

		for (int i = 0; i < totalTimeTasks; i++) {

			// timingID
			byte timingID = buf.readByte();

			// timingName
			byte[] timingNamebyte = new byte[32];
			for (int j = 0; j < 32; j++) {
				timingNamebyte[j] = buf.readByte();
			}
			String timingName = StringNamesUtils.byteToString(timingNamebyte);

			// uid
			byte[] uid = new byte[3];
			for (int a = 0; a < uid.length; a++) {
				uid[a] = buf.readByte();
			}

			byte week = buf.readByte();
			byte hour = buf.readByte();
			byte minute = buf.readByte();
			byte second = buf.readByte();

			TaskTimerAction taskTimerAction = new TaskTimerAction(week, hour, minute, second);

			// switch
			byte switchState = buf.readByte();
			// brightness
			byte brightness = buf.readByte();
			// hue
			byte hue = buf.readByte();
			// saturation
			byte saturation = buf.readByte();
			// colorTemperature
			byte colorTemperature = buf.readByte();
			// enable
			byte enable = buf.readByte();

			TimingInfo timingInfo = new TimingInfo(timingID, timingName, uid, taskTimerAction, switchState, brightness,
					hue, saturation, colorTemperature, enable);

			timingInfos.add(timingInfo);
		}

		BaseApplication.getInstance().getDeviceTimingTask_CallBack(timingInfos);
	}

	/**
	 * 获取指定设备联动任务
	 * 
	 * @param buf
	 */
	public static void getSensorTaskByUid(ByteBuf buf) {

		List<TaskInfo> tasks = new ArrayList<TaskInfo>();

		// totalScenetask
		byte totalScenetask = buf.readByte();

		for (int i = 0; i < totalScenetask; i++) {

			byte[] uid = new byte[3];
			// Endpoint
			uid[2] = buf.readByte();
			uid[0] = buf.readByte();
			uid[1] = buf.readByte();

			// taskType
			byte taskType = buf.readByte();

			// taskName
			byte[] taskNamebyte = new byte[32];
			for (int j = 0; j < 32; j++) {
				taskNamebyte[j] = buf.readByte();
			}
			String taskName = StringNamesUtils.byteToString(taskNamebyte);

			// alarm
			byte alarm = buf.readByte();

			// taskID
			byte taskId = buf.readByte();

			// judgement
			// juid
			byte[] juid = new byte[3];
			for (int a = 0; a < juid.length; a++) {
				juid[a] = buf.readByte();
			}
			// deviceID
			byte[] deviceId = new byte[2];
			for (int a = 0; a < deviceId.length; a++) {
				deviceId[a] = buf.readByte();
			}
			// Condition1
			byte condition1 = buf.readByte();
			// Value1
			byte data1 = buf.readByte();
			// Condition2
			byte condition2 = buf.readByte();
			// Value2
			byte data2 = buf.readByte();

			TaskDeviceAction taskDeviceAction = new TaskDeviceAction(juid, deviceId, condition1, data1, condition2,
					data2);

			// sceneID
			byte sceneID = buf.readByte();

			// enable
			byte enAble = buf.readByte();

			TaskInfo taskInfo = new TaskInfo(taskId, taskName, taskType, alarm, enAble, taskDeviceAction, sceneID);

			tasks.add(taskInfo);
		}

		BaseApplication.getInstance().getSensorTaskByUid_CallBack(tasks);
	}

	public static void verificationManagerPwd(ByteBuf buf) {
		// TODO Auto-generated method stub

		// state
		byte state = buf.readByte();

		// TBD+CRC
		for (int i = 0; i < 10; i++) {
			buf.readByte();
		}

		BaseApplication.getInstance().verificationManagerPwd_Callback(state);

	}

	public static void modifyPwd(ByteBuf buf) {

		// state
		byte state = buf.readByte();

		// TBD+CRC
		for (int i = 0; i < 10; i++) {
			buf.readByte();
		}

		BaseApplication.getInstance().modifyLoginPwd_Callback(state);
	}

	public static void loginGaByLan(ByteBuf buf) {
		// state
		byte state = buf.readByte();

		// TBD+CRC
		for (int i = 0; i < 10; i++) {
			buf.readByte();
		}

		BaseApplication.getInstance().modifyLoginPwd_Callback(state);
	}

}
