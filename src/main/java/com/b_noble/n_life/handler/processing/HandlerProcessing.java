package com.b_noble.n_life.handler.processing;

import com.b_noble.n_life.BaseApplication;
import com.b_noble.n_life.event.AttrIdEnum;
import com.b_noble.n_life.event.ResponseTypeEnum;
import com.b_noble.n_life.info.DeviceInfo;
import com.b_noble.n_life.utils.Test16Binary;

import io.netty.buffer.ByteBuf;

/**
 * @公司 深圳市中泰智丰物联网科技有限公司
 * @项目 智能家居sdk
 * @简述 handler处理类
 * @作者 zhangfan
 * @date 2016-08-02
 * @版本 V0.0.1
 */
public class HandlerProcessing {

	public static void processing(int responseType, ByteBuf buf) {

		/**
		 * 获取网关信息返回处理
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_GATE_INFO.getVal()) {

			System.out.println("获取网关信息返回！！！！！！！！！");
			HandlerProcessingRealization.getGateinfoResponseProcessing(buf);
		}

		/**
		 * 获取所有设备返回处理
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_DEVICE.getVal()) {

			System.out.println("获取所有设备网关返回来了！！！！！！！！！！");
			HandlerProcessingRealization.getAllDeviceResponseProcessing(buf);

		}

		/**
		 * 设置设备开关状态返回处理
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_SET_DEVICE_STATE.getVal()) {

			System.out.println("设置设备开关网关返回来了！！！！！！！！！！");

		}

		/**
		 * 获取设备开关状态返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_DEVICE_STATE.getVal()) {

			System.out.println("获取设备开关网关返回来了！！！！！！！！！！");

			HandlerProcessingRealization.getDeviceStateResponseProcessing(buf);

		}

		/**
		 * 获取所有场景返回处理
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_SENCE.getVal()) {

			System.out.println("获取所有场景网关返回来了！！！！！！！！！！");
			HandlerProcessingRealization.getAllSceneResponseProcessing(buf);

		}

		/**
		 * 添加场景返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_ADD_SENCE.getVal()) {
			System.out.println("添加场景网关返回来了！！！！！！！！！！");

			HandlerProcessingRealization.addSenceResponseProcessing(buf);

		}

		/**
		 * 调用场景返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_RECALL_SCENE.getVal()) {
			System.out.println("调用场景网关返回来了！！！！！！！！！！");
		}

		/**
		 * 删除场景返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_DELETE_SCENE.getVal()) {
			System.out.println("删除场景网关返回来了！！！！！！！！！！");
		}

		/**
		 * 增加任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_ADD_TASK.getVal()) {
			System.out.println("增加任务网关返回来了！！！！！！！！！！");
		}

		/**
		 * 设置灯光亮度返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_SET_DEVICE_LEVEL.getVal()) {
			System.out.println("设置灯光亮度网关返回来了！！！！！！！！！！");
		}

		/**
		 * 设置设备颜色（饱和度/色调）返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_SET_DEVICE_HUE.getVal()) {
			System.out.println("设置灯光色调饱和度网关返回来了！！！！！！！！！！");
		}

		/**
		 * 设置设备色温返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_SET_COLOR_TEMPERATURE.getVal()) {
			System.out.println("设置灯光色温网关返回来了！！！！！！！！！！");
		}

		/**
		 * 删除指定任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_DELETE_TASK.getVal()) {

			System.out.println("删除指定任务网关返回！！！！！！！！");
		}

		/**
		 * 删除设备返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_DELETE_DEVICE.getVal()) {

			System.out.println("删除指定设备网关返回！！！！！！！！");
		}

		/**
		 * 更新设备名称返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_UPDATE_DEVICENAME.getVal()) {

			System.out.println("更新设备名称网关返回！！！！！！！");
			HandlerProcessingRealization.updateDeviceNameResponseProcessing(buf);
		}

		/**
		 * 获取设备亮度返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_DEVICE_LEVEL.getVal()) {

			System.out.println("获取设备亮度网关返回！！！！！！！");
			HandlerProcessingRealization.getDeviceLevelProcessing(buf);
		}

		/**
		 * 获取设备 色调与饱和度返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_DEVICE_HUE.getVal()) {

			System.out.println("获取设备色调与饱和度网关返回！！！！！！！");
			HandlerProcessingRealization.getDeviceHueProcessing(buf);
		}

		/**
		 * 获取设备 色温返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_DEVICE_COLORTEMPERATURE.getVal()) {

			System.out.println("获取设备色温网关返回！！！！！！！");
			HandlerProcessingRealization.getColorTemperatureProcessing(buf);
		}

		/**
		 * 更新场景名称
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_UPDATE_SCENENAME.getVal()) {

			System.out.println("更新场景名称网关返回！！！！！！！");
		}

		/**
		 * 获取场景成员
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_SENCE_DETAILED.getVal()) {

			System.out.println("获取场景成员返回！！！！！！");
			HandlerProcessingRealization.getSceneMemberProcessing(buf);
		}
		/**
		 * 删除指定场景成员
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_DELETE_SENCE_MEMBER.getVal()) {

			System.out.println("删除指定场景成员返回！！！！！");
		}

		/**
		 * 将指定设备添加到场景中
		 */
		if (responseType == ResponseTypeEnum.REPOSNE_ADD_DEVICE_SENCE.getVal()) {
			System.out.println("添加设备到场景返回！！！！！");
		}

		/**
		 * 获取所有任务
		 */
		if (responseType == ResponseTypeEnum.REPOSNE_GET_ALL_TASK.getVal()) {
			System.out.println("获取所有任务返回！！！！！");
			HandlerProcessingRealization.getAllTaskProcessing(buf);
		}

		/**
		 * 获取任务详细
		 */
		if (responseType == ResponseTypeEnum.REPOSNE_GET_TASKINFO.getVal()) {
			System.out.println("获取任务详细返回！！！！！");
			HandlerProcessingRealization.getTaskInfoProcessing(buf);
		}

		/**
		 * 更新任务后返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_UPDATE_TASK.getVal()) {

			System.out.println("更新任务返回！！！！！！");
		}

		/**
		 * 获取指定场景定时任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_TASK_SCENE.getVal()) {
			HandlerProcessingRealization.getTimerTaskBySceneId(buf);
		}

		/**
		 * 添加设备定时任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_ADD_TIMING_TASK.getVal()) {

			System.out.println("添加设备定时任务返回！！！！！");
		}

		/**
		 * 删除设备定时任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_DELETE_TIMING_TASK.getVal()) {

			System.out.println("删除设备定时任务返回！！！！！");
		}
		/**
		 * 更新设备定时任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_UPDATE_TIMING_TASK.getVal()) {

			System.out.println("更新设备定时任务返回！！！！！");
		}

		/**
		 * 获取设备定时任务返回
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_GET_TIMING_TASK.getVal()) {
			HandlerProcessingRealization.getTimingTask(buf);
		}

		/**
		 * 获取指定设备的联动任务
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_TASK_UID.getVal()) {

			HandlerProcessingRealization.getSensorTaskByUid(buf);
		}

		/**
		 * 获取心跳响应
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_SEND_HEARTBEAT.getVal()) {

			BaseApplication.getInstance().sendHeartbeat_CallBack();
		}
		
		/**
		 * 获取验证管理密码响应
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_VERIFICATION_MANAGERPWD.getVal()) {
			
			HandlerProcessingRealization.verificationManagerPwd(buf);
		}
		
		/**
		 * 修改登录密码响应
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_MODIFY_PWD.getVal()) {
			
			HandlerProcessingRealization.modifyPwd(buf);
		}
		
		/**
		 * 局域网登录网关
		 */
		if (responseType == ResponseTypeEnum.RESPONSE_LOGIN_LAN.getVal()) {
			
			HandlerProcessingRealization.loginGaByLan(buf);
		}
		

	}

	/**
	 * report new device
	 * 
	 * @param buf
	 */
	public static void reportNewDevice(ByteBuf buf) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++) {
			buf.readByte();
		}

		// controlType
		buf.readByte();
		// IEEEAddress
		byte[] IEEEAddress = new byte[8];
		for (int i = 0; i < 8; i++) {
			IEEEAddress[i] = buf.readByte();
		}
		// shortAddress endPoint
		byte[] uid = new byte[3];
		for (int i = 0; i < 3; i++) {
			uid[i] = buf.readByte();
		}

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

		for (int i = 0; i < 8; i++) {
			buf.readByte();
		}

		DeviceInfo info = new DeviceInfo();
		info.setDeviceId(deviceId);
		info.setuId(uid);
		info.setIEEE(IEEEAddress);
		info.setProfileId(profileId);
		info.setAtrrId(atrrId);

		BaseApplication.getInstance().newDevice_Callback(info);

	}

	/**
	 * 传感器推送
	 * 
	 * @param buf
	 */
	public static void sensorReport(ByteBuf buf) {

		for (int i = 0; i < 7; i++) {
			buf.readByte();
		}

		// controlFlag
		int controlFlag = buf.readByte();

		// controlType
		int controlType = buf.readByte();

		if (controlType == -95) {
			// numberReports
			byte numberReports = buf.readByte();
			for (int i = 0; i < numberReports; i++) {

				// shortAddress Endpoint
				byte[] uid = new byte[3];
				for (int j = 0; j < uid.length; j++) {
					uid[j] = buf.readByte();
				}

				// deviceId
				byte[] deviceId = new byte[2];
				deviceId[0] = buf.readByte();
				deviceId[1] = buf.readByte();

				// atrrId
				short atrrId = buf.readShort();

				String did = Test16Binary.bytes2hex03(deviceId).replaceAll(" ", "");
				if (did.equals("0302")) {
					// 温湿度传感器数据解析
					byte onlineState = buf.readByte();
					int TemperatureInt = buf.readUnsignedShort();
					int HumidityInt = buf.readUnsignedShort();
					int Interval = buf.readUnsignedShort();

					System.out.println(TemperatureInt + "  " + HumidityInt);

					Double Temperature = (double) (TemperatureInt / 100.d);
					Double Humidity = (double) (HumidityInt / 100.d);
					Integer battery = 0;

					for (int j = 0; j < 8; j++) {
						buf.readByte();
					}

					BaseApplication.getInstance().TemperatureAndHumidityReport_callBack(Temperature, Humidity, battery);
				} else {
					// recentValue
					byte[] recentValue = new byte[7];
					for (int j = 0; j < recentValue.length; j++) {
						recentValue[j] = buf.readByte();
					}

					for (int j = 0; j < 8; j++) {
						buf.readByte();
					}

					// 紧急按钮
					if (atrrId == AttrIdEnum.PERSONAL_EMERGENCY.getVal()) {
						BaseApplication.getInstance().EmergencyButtonReprot_callBack(recentValue[1], uid);
					} else if (atrrId == AttrIdEnum.GAS_SENSOR.getVal()) {
						BaseApplication.getInstance().GasSensorReprot_callBack(recentValue[1], uid);
					} else if (atrrId == AttrIdEnum.CO_SENSOR.getVal()) {
						BaseApplication.getInstance().CoSensorReprot_callBack(recentValue[1], uid);
					} else if (atrrId == AttrIdEnum.KEY_FOB.getVal()) {
						BaseApplication.getInstance().KeyFobReprot_callBack(recentValue[1], uid);
					} else if (atrrId == AttrIdEnum.FIRE_SENSOR.getVal()) {
						BaseApplication.getInstance().FireSensorReprot_callBack(recentValue[1], uid);
					} else {
						// 回调方法中赋值
						BaseApplication.getInstance().sensorReport_callBack(uid, recentValue, deviceId, atrrId);
					}

				}

			}
		}
	}

}
