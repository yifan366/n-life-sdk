package com.b_noble.n_life.handler.processing;

import java.io.UnsupportedEncodingException;

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
import com.b_noble.n_life.model.RequestLoginGaByLanData;
import com.b_noble.n_life.model.RequestLoginValidateData;
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

import io.netty.buffer.ByteBuf;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司 项目：智能家居 简述：编码处理实现类 作者：zhangfan 时间：2016-08-02 版本：V0.0.1
 */
public class EncoderProcessingRealization {

	/**
	 * 设定指定设备开关状态
	 */
	public static void setDeviceState(RequestSetDeviceStateData data, ByteBuf buf) {

		buf.writeByte(data.getAddressMode());

		buf.writeBytes(data.getUid());

		buf.writeByte(data.getState());

	}

	/**
	 * 添加场景
	 */
	public static void addSence(RequestAddSenceData data, ByteBuf buf) {

		try {
			buf.writeBytes(data.getSenceName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getSenceName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 场景中设备个数
		int size = data.getUid().size();
		buf.writeByte(0x01);

		// shortAddress Endpoint
		for (int i = 0; i < size; i++) {
			buf.writeBytes(data.getUid().get(i));
		}

		// delayTime
		buf.writeByte(data.getDelayTime());
	}

	/**
	 * 调用场景
	 * 
	 * @param data
	 * @param buf
	 */
	public static void recallSence(RequestRecallSceneData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeByte(data.getSceneid());
		try {
			buf.writeBytes(data.getSceneName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getSceneName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 删除场景
	 * 
	 * @param data
	 * @param buf
	 */
	public static void deleteSence(RequestDeleteSceneData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeByte(data.getSceneid());
		try {
			buf.writeBytes(data.getSceneName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getSceneName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 添加传感器任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void addSensorTask(RequestAddTaskData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		// taskType
		buf.writeByte(data.getTaskType());

		System.out.println(data.getTaskName().getBytes().length);
		// taskName
		try {
			buf.writeBytes(data.getTaskName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getTaskName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// judgement
		// uid
		buf.writeBytes(data.getUid());
		// deviceID
		buf.writeBytes(data.getDeviceId());

		// Condition1
		buf.writeByte(data.getCondition1());
		// value1
		buf.writeByte(data.getValue1());
		// Condition2
		buf.writeByte(data.getCondition2());
		// value2
		buf.writeByte(data.getValue2());

		// TBD 7bytes
		for (int i = 0; i < 7; i++) {
			buf.writeByte(0x00);
		}

		// sceneID
		buf.writeByte(data.getSceneId());

		// enable
		buf.writeByte(data.getEnable());

		// alarm
		buf.writeByte(data.getAlarm());

	}

	/**
	 * 添加定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void addTimerTask(RequestAddTimerTaskData data, ByteBuf buf) {

		// taskType
		buf.writeByte(data.getTaskType());

		// taskName
		try {
			buf.writeBytes(data.getTaskName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getTaskName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// judgement 9bytes
		// week
		buf.writeByte(data.getWeek());
		// hour
		buf.writeByte(data.getHour());
		// minute
		buf.writeByte(data.getMinute());
		// Second
		buf.writeByte(data.getSecond());

		// 补位
		for (int i = 0; i < 5; i++) {
			buf.writeByte(0x00);
		}

		// TBD 7bytes
		for (int i = 0; i < 7; i++) {
			buf.writeByte(0x00);
		}

		// sceneID
		buf.writeByte(data.getSceneId());

		// enable
		buf.writeByte(data.getEnable());

		// alarm
		buf.writeByte(data.getAlarm());
	}

	/**
	 * 修改传感器任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void updateSensorTask(RequestUpdateTaskData data, ByteBuf buf) {
		// taskType
		buf.writeByte(data.getTaskType());

		// taskName
		try {
			buf.writeBytes(data.getTaskName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getTaskName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buf.writeByte(data.getSceneId());

		// judgement
		// uid
		buf.writeBytes(data.getUid());
		// deviceID
		buf.writeBytes(data.getDeviceId());
		// Condition1
		buf.writeByte(data.getCondition1());
		// value1
		buf.writeByte(data.getValue1());
		// Condition2
		buf.writeByte(data.getCondition2());
		// value2
		buf.writeByte(data.getValue2());

		// TBD 7bytes
		for (int i = 0; i < 7; i++) {
			buf.writeByte(0x00);
		}

		// sceneID
		buf.writeByte(data.getSceneId());

		// enable
		buf.writeByte(data.getEnable());

		// alarm
		buf.writeByte(data.getAlarm());

	}

	/**
	 * 更新定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void updateTimerTask(RequestUpdateTimerTaskData data, ByteBuf buf) {

		// taskType
		buf.writeByte(data.getTaskType());

		// taskName
		try {
			buf.writeBytes(data.getTaskName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getTaskName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buf.writeByte(data.getSceneId());

		// judgement 9bytes
		// week
		buf.writeByte(data.getWeek());
		// hour
		buf.writeByte(data.getHour());
		// minute
		buf.writeByte(data.getMinute());
		// Second
		buf.writeByte(data.getSecond());

		// 补位
		for (int i = 0; i < 5; i++) {
			buf.writeByte(0x00);
		}

		// TBD 7bytes
		for (int i = 0; i < 7; i++) {
			buf.writeByte(0x00);
		}

		// sceneID
		buf.writeByte(data.getSceneId());

		// enable
		buf.writeByte(data.getEnable());

		// alarm
		buf.writeByte(data.getAlarm());
	}

	/**
	 * 设置灯光亮度
	 * 
	 * @param data
	 * @param buf
	 */
	public static void setDeviceLevel(RequestSetDeviceLevelData data, ByteBuf buf) {

		// addressMode
		buf.writeByte(data.getAddressMode());

		// uid
		buf.writeBytes(data.getUid());

		// brightComand
		buf.writeByte(data.getLevelValue());

		// cutTime
		buf.writeShort(data.getSwitchTime());
	}

	/**
	 * 设置设备颜色（饱和度/色调）
	 * 
	 * @param data
	 * @param buf
	 */
	public static void setDeviceColor(RequestSetDeviceColorData data, ByteBuf buf) {

		// addressMode
		buf.writeByte(data.getAddressMode());

		// uid
		buf.writeBytes(data.getUid());

		// hue
		buf.writeByte(data.getHue());

		// saturation
		buf.writeByte(data.getSat());

		// cutTime
		buf.writeShort(data.getSwitchTime());
	}

	/**
	 * 设置设备色温
	 * 
	 * @param data
	 * @param buf
	 */
	public static void setColorTemperature(RequestSetColorTemperatureData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		// addressMode
		buf.writeByte(data.getAddressMode());

		// uid
		buf.writeBytes(data.getUid());

		// colorTemperature
		buf.writeByte(data.getColorTemperature());

		// cutTime
		buf.writeShort(data.getSwitchTime());
	}

	/**
	 * 删除指定任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void deleteTask(RequestDeleteTaskData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		// taskID
		buf.writeByte(data.getTaskid());

		// checkCode
		buf.writeByte(data.getCheckCode());

		// crc8
		buf.writeByte(data.getCRC8());
	}

	/**
	 * 获取设备开关状态
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getDeviceState(RequestGetDeviceStateData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		// addressMode
		buf.writeByte(data.getAddressMode());

		// shortAddress Endpoint
		buf.writeBytes(data.getUid());
	}

	/**
	 * 删除指定设备
	 * 
	 * @param data
	 * @param buf
	 */
	public static void deleteDevice(RequestDeleteDeviceData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		// addressMode
		buf.writeByte(data.getAddressMode());

		byte[] uid = data.getUid();
		// shortAddress
		buf.writeByte(uid[0]);
		buf.writeByte(uid[1]);

		// ieee
		buf.writeBytes(data.getIeeeAddress());

		// Endpoint
		buf.writeByte(uid[2]);

		// checkCode
		buf.writeByte(data.getCheckCode());

		buf.writeByte(data.getCRC8());
	}

	/**
	 * 更新设备名称
	 * 
	 * @param data
	 * @param buf
	 */
	public static void updateDeviceName(RequestUpdateDeviceData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		// addressMode
		buf.writeByte(data.getAddressMode());

		// shortAddress Endpoint
		buf.writeBytes(data.getUid());
		// deviceName
		try {
			buf.writeBytes(data.getDeviceName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getDeviceName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取设备亮度
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getDeviceLevel(RequestGetDeviceLevelData data, ByteBuf buf) {

		// addressMode
		buf.writeByte(data.getAddressMode());

		// shortAddress Endpoint
		buf.writeBytes(data.getUid());
	}

	/**
	 * 获取设备色调与饱和度
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getDeviceHueAndSat(RequestGetDeviceHueAndSatData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		// addressMode
		buf.writeByte(data.getAddressMode());

		// shortAddress Endpoint
		buf.writeBytes(data.getUid());
	}

	/**
	 * 获取设备色温
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getColorTemperature(RequestGetColorTemperatureData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		// addressMode
		buf.writeByte(data.getAddressMode());

		// shortAddress Endpoint
		buf.writeBytes(data.getUid());
	}

	/**
	 * 更新场景名称
	 * 
	 * @param data
	 * @param buf
	 */
	public static void updateSceneName(RequestUpdateSceneNameData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		// sceneID
		buf.writeByte(data.getSceneid());

		try {
			buf.writeBytes(data.getSceneName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getSceneName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取场景成员
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getSceneMember(RequestGetSceneMemberData data, ByteBuf buf) {

		// sceneID
		buf.writeByte(data.getSceneID());
	}

	/**
	 * 删除指定场景成员
	 * 
	 * @param data
	 * @param buf
	 */
	public static void delteteSceneMember(RequestDeleteSceneMemberData data, ByteBuf buf) {

		// sceneID
		buf.writeByte(data.getSceneID());

		// sceneName
		try {
			buf.writeBytes(data.getSceneName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getSceneName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// totalDelDevices
		buf.writeByte(data.getUids().size());

		// shortAddress endPoint
		for (int i = 0; i < data.getUids().size(); i++) {
			buf.writeBytes(data.getUids().get(i));
		}
	}

	/**
	 * 添加设备到场景
	 * 
	 * @param data
	 * @param buf
	 */
	public static void addDeviceToScene(RequestAddDeviceToSenceData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		// sceneID
		buf.writeByte(data.getSceneID());

		// totalAdddevices
		buf.writeByte(data.getTotalAdddevices());

		// shortAddress endPoint
		for (int i = 0; i < data.getTotalAdddevices(); i++) {
			buf.writeBytes(data.getUids().get(i));
		}

		// delayTime
		buf.writeByte(data.getDelayTime());
	}

	/**
	 * 获取任务详细
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getTaskInfo(RequestGetTaskInfoData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeByte(data.getTaskId());
	}

	/**
	 * 获取指定场景定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getTimerTaskBySceneId(RequestGetTimerTaskBySceneIdData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeByte(data.getSceneId());
	}

	/**
	 * 添加设备定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void addDeviceTimingTask(RequestAddDeviceTimingTaskData data, ByteBuf buf) {

		// timingName
		try {
			buf.writeBytes(data.getTimingName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getTimingName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// uid
		buf.writeBytes(data.getUid());

		// week
		buf.writeByte(data.getTaskTimerAction().getWorkMode());
		// hour
		buf.writeByte(data.getTaskTimerAction().getH());
		// minute
		buf.writeByte(data.getTaskTimerAction().getM());
		// second
		buf.writeByte(data.getTaskTimerAction().getS());

		// switch
		buf.writeByte(data.getSwitchState());

		// brightness
		buf.writeByte(data.getBrightness());

		// hue
		buf.writeByte(data.getHue());

		// saturation
		buf.writeByte(data.getSaturation());

		// colorTemperature
		buf.writeByte(data.getColorTemperature());

		// enable
		buf.writeByte(data.getIsenable());

	}

	/**
	 * 删除指定设备定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void deleteDeviceTimingTask(RequestDeleteDeviceTimingTaskData data, ByteBuf buf) {

		buf.writeByte(data.getTimingID());

		buf.writeByte(data.getCheckCode());

		buf.writeByte(data.getCRC8());
	}

	/**
	 * 更新设备定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void updateDeviceTimingTask(RequestUpdateDeviceTimingTaskData data, ByteBuf buf) {

		// timingId
		buf.writeByte(data.getTimingId());

		// timingName
		try {
			buf.writeBytes(data.getTimingName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getTimingName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// week
		buf.writeByte(data.getTaskTimerAction().getWorkMode());
		// hour
		buf.writeByte(data.getTaskTimerAction().getH());
		// minute
		buf.writeByte(data.getTaskTimerAction().getM());
		// second
		buf.writeByte(data.getTaskTimerAction().getS());

		// switch
		buf.writeByte(data.getSwitchState());

		// brightness
		buf.writeByte(data.getBrightness());

		// hue
		buf.writeByte(data.getHue());

		// saturation
		buf.writeByte(data.getSaturation());

		// colorTemperature
		buf.writeByte(data.getColorTemperature());

		// enable
		buf.writeByte(data.getIsenable());
	}

	/**
	 * 获取设备定时任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getDeviceTimingTask(RequestGetDeviceTimingTaskData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		buf.writeBytes(data.getUid());
	}

	/**
	 * 获取指定设备的联动任务
	 * 
	 * @param data
	 * @param buf
	 */
	public static void getSensorTaskByUid(RequestGetSensorTaskByUidData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeByte(data.getUid()[2]);

		buf.writeByte(data.getUid()[0]);
		buf.writeByte(data.getUid()[1]);
	}

	public static void loginValidate(RequestLoginValidateData data, ByteBuf buf) {
		// TODO Auto-generated method stub

		buf.writeByte(data.getState());

		buf.writeBytes(data.getSn().getBytes());

		buf.writeBytes(data.getToken().getBytes());

		// username
		try {
			buf.writeBytes(data.getLoginName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getLoginName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void verificationManagerPwd(RequestVerificationManagerPwdData data, ByteBuf buf) {

		buf.writeByte(data.getState());

		// username
		try {
			buf.writeBytes(data.getUsername().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getUsername().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pwd
		try {
			buf.writeBytes(data.getManagerPwd().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getManagerPwd().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void modifyPwd(RequestModifyPwdData data, ByteBuf buf) {

		buf.writeByte(data.getState());

		buf.writeByte(data.getPwdType());

		// username
		try {
			buf.writeBytes(data.getUsername().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getUsername().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// oldpwd
		try {
			buf.writeBytes(data.getOldPwd().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getOldPwd().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// newpwd
		try {
			buf.writeBytes(data.getNewPwd().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getNewPwd().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loginGaByLan(RequestLoginGaByLanData data, ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeByte(data.getState());

		// username
		try {
			buf.writeBytes(data.getUserName().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getUserName().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pwd
		try {
			buf.writeBytes(data.getPassWord().getBytes("gbk"));
			for (int i = 0; i < 32 - data.getPassWord().getBytes("gbk").length; i++) {
				buf.writeByte(0x00);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
