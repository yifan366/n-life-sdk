package com.b_noble.n_life.handler.processing;

import com.b_noble.n_life.event.ControlTypeEnum;
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

import io.netty.buffer.ByteBuf;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：编码处理类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public class EncoderProcessing {

	public static void processing(RequestMessage requestMessage,ByteBuf buf){
		
		RequestHead head = requestMessage.getHeader();
		
		/**
		 *  设定指定设备开关状态
		 */
		if (head.getControlType() == ControlTypeEnum.SET_DEVICE_STATE.getVal()) {
			
			RequestSetDeviceStateData data = (RequestSetDeviceStateData) requestMessage.getData();
			EncoderProcessingRealization.setDeviceState(data, buf);
		}
		/**
		 * 获取设备开关状态
		 */
		if(head.getControlType() == ControlTypeEnum.GET_DEVICE_STATE.getVal()) {
			
			RequestGetDeviceStateData data = (RequestGetDeviceStateData) requestMessage.getData();
			EncoderProcessingRealization.getDeviceState(data, buf);
		}
		
		/**
		 * 添加场景
		 */
		if (head.getControlType() == ControlTypeEnum.ADD_SENCE.getVal()) {
			
			RequestAddSenceData data = (RequestAddSenceData) requestMessage.getData();
			EncoderProcessingRealization.addSence(data, buf);
		}
		
		/**
		 * 调用场景
		 */
		if (head.getControlType() == ControlTypeEnum.RECALL_SENCE.getVal()) {
			
			RequestRecallSceneData data = (RequestRecallSceneData) requestMessage.getData();
			EncoderProcessingRealization.recallSence(data, buf);
		}
		
		/**
		 * 删除场景
		 */
		if (head.getControlType() == ControlTypeEnum.DELETE_SENCE.getVal()) {
			
			RequestDeleteSceneData data = (RequestDeleteSceneData) requestMessage.getData();
			EncoderProcessingRealization.deleteSence(data, buf);
		}
		
		/**
		 * 增加任务
		 */
		if (head.getControlType() == ControlTypeEnum.ADD_TASK.getVal()) {

			/**
			 * 添加传感器任务
			 */
			if (requestMessage.getData() instanceof RequestAddTaskData) {
				System.out.println("EncoderProcessing类输出： 执行添加传感器任务操作");
				RequestAddTaskData data = (RequestAddTaskData) requestMessage.getData();
				EncoderProcessingRealization.addSensorTask(data, buf);
			}
			/**
			 * 添加定时任务
			 */
			else if(requestMessage.getData() instanceof RequestAddTimerTaskData){
				
				System.out.println("EncoderProcessing类输出： 执行添加定时任务操作");
				RequestAddTimerTaskData data = (RequestAddTimerTaskData) requestMessage.getData();
				EncoderProcessingRealization.addTimerTask(data, buf);
			}
		}
		
		/**
		 * 更新任务
		 */
		if (head.getControlType() == ControlTypeEnum.UPDATE_TASK.getVal()) {

			/**
			 * update传感器任务
			 */
			if (requestMessage.getData() instanceof RequestAddTaskData) {
				System.out.println("EncoderProcessing类输出： 执行更新传感器任务操作");
				RequestUpdateTaskData data = (RequestUpdateTaskData) requestMessage.getData();
				EncoderProcessingRealization.updateSensorTask(data, buf);
			}
			/**
			 * 添加定时任务
			 */
			else if(requestMessage.getData() instanceof RequestUpdateTimerTaskData){
				
				System.out.println("EncoderProcessing类输出： 执行更新定时任务操作");
				RequestUpdateTimerTaskData data = (RequestUpdateTimerTaskData) requestMessage.getData();
				EncoderProcessingRealization.updateTimerTask(data, buf);
			}
		}

		/**
		 * 设定指定设备的亮度
		 */
		if (head.getControlType() == ControlTypeEnum.SET_DEVICE_LEVEL.getVal()) {

			RequestSetDeviceLevelData data = (RequestSetDeviceLevelData) requestMessage.getData();

			EncoderProcessingRealization.setDeviceLevel(data, buf);
		}

		/**//**
		 * 获取指定设备的亮度
		 */
		if (head.getControlType() == ControlTypeEnum.GET_DEVICE_LEVEL.getVal()) {

			RequestGetDeviceLevelData data = (RequestGetDeviceLevelData) requestMessage.getData();

			EncoderProcessingRealization.getDeviceLevel(data, buf);
		}

		
		/**
		 * 设置灯光颜色
		 */
		if (head.getControlType() == ControlTypeEnum.SET_DEVICE_COLOR.getVal()) {

			RequestSetDeviceColorData data = (RequestSetDeviceColorData) requestMessage.getData();

			EncoderProcessingRealization.setDeviceColor(data, buf);
		}
		
		/**
		 * 设置灯色温
		 */
		if (head.getControlType() == ControlTypeEnum.SET_COLOR_TEMPERATURE.getVal()) {

			RequestSetColorTemperatureData data = (RequestSetColorTemperatureData) requestMessage.getData();

			EncoderProcessingRealization.setColorTemperature(data, buf);
		}
		
		/**
		 * 删除指定任务
		 */
		if (head.getControlType() == ControlTypeEnum.DELETE_TASK.getVal()) {

			RequestDeleteTaskData data = (RequestDeleteTaskData) requestMessage.getData();

			EncoderProcessingRealization.deleteTask(data, buf);
		}
		
		/**
		 * 删除指定设备
		 */
		if (head.getControlType() == ControlTypeEnum.DELETE_DEVICE.getVal()) {

			RequestDeleteDeviceData data = (RequestDeleteDeviceData) requestMessage.getData();

			EncoderProcessingRealization.deleteDevice(data, buf);
		}
		
		/**
		 * 更新设备名称
		 */
		if  (head.getControlType() == ControlTypeEnum.UPDATE_DEVICE_NAME.getVal()) {

			RequestUpdateDeviceData data = (RequestUpdateDeviceData) requestMessage.getData();

			EncoderProcessingRealization.updateDeviceName(data, buf);
		}
		/**
		 * 获取设备色调与饱和度
		 */
		if (head.getControlType() == ControlTypeEnum.GET_DEVICE_HUE.getVal()) {

			RequestGetDeviceHueAndSatData data = (RequestGetDeviceHueAndSatData) requestMessage.getData();

			EncoderProcessingRealization.getDeviceHueAndSat(data, buf);
		}
		
		/**
		 * 获取设备色温
		 */
		if (head.getControlType() == ControlTypeEnum.GET_DEVICE_COLORTEMPERATURE.getVal()) {

			RequestGetColorTemperatureData data = (RequestGetColorTemperatureData) requestMessage.getData();

			EncoderProcessingRealization.getColorTemperature(data, buf);
		}
		
		/**
		 * 更新场景名称
		 * 
		 */
		if (head.getControlType() == ControlTypeEnum.UPDATE_SENCE_NAME.getVal()) {

			RequestUpdateSceneNameData data = (RequestUpdateSceneNameData) requestMessage.getData();

			EncoderProcessingRealization.updateSceneName(data, buf);
		}
		
		/**
		 * 获取场景中成员
		 */
		if (head.getControlType() == ControlTypeEnum.GET_SENCE_MEMBER.getVal()) {
			
			RequestGetSceneMemberData data = (RequestGetSceneMemberData) requestMessage.getData();

			EncoderProcessingRealization.getSceneMember(data, buf);
		}
		
		/**
		 * 删除指定场景的成员
		 */
		if (head.getControlType() == ControlTypeEnum.DELETE_SENCE_MEMBER.getVal()) {
			RequestDeleteSceneMemberData data = (RequestDeleteSceneMemberData) requestMessage.getData();

			EncoderProcessingRealization.delteteSceneMember(data, buf);
		}
		
		/**
		 * 将指定设备添加到场景中
		 */
		if (head.getControlType() == ControlTypeEnum.ADD_DEVICE_SENCE.getVal()) {
			RequestAddDeviceToSenceData data = (RequestAddDeviceToSenceData) requestMessage.getData();

			EncoderProcessingRealization.addDeviceToScene(data, buf);
		}
		
		/**
		 * 获取任务详细
		 */
		if (head.getControlType() == ControlTypeEnum.GET_TASK_INFO.getVal()) {
			RequestGetTaskInfoData data = (RequestGetTaskInfoData) requestMessage.getData();
			EncoderProcessingRealization.getTaskInfo(data, buf);
		}
		
		/**
		 * 获取指定场景的定时任务
		 */
		if (head.getControlType() == ControlTypeEnum.GET_TASK_SCENE.getVal()) {
			
			RequestGetTimerTaskBySceneIdData data = (RequestGetTimerTaskBySceneIdData) requestMessage.getData();
			EncoderProcessingRealization.getTimerTaskBySceneId(data, buf);
		}
		
		/**
		 * 添加设备定时任务
		 */
		if (head.getControlType() == ControlTypeEnum.ADD_TIMING_TASK.getVal()) {
			RequestAddDeviceTimingTaskData data = (RequestAddDeviceTimingTaskData) requestMessage.getData();
			EncoderProcessingRealization.addDeviceTimingTask(data,buf);
		}
		
		/**
		 * 删除设备定时任务
		 */
		if (head.getControlType() == ControlTypeEnum.DELETE_TIMING_TASK.getVal()) {
			
			RequestDeleteDeviceTimingTaskData data = (RequestDeleteDeviceTimingTaskData) requestMessage.getData();
			EncoderProcessingRealization.deleteDeviceTimingTask(data,buf);
		}
		
		/**
		 * 更新设备定时任务
		 */
		if (head.getControlType() == ControlTypeEnum.UPDATE_TIMING_TASK.getVal()) {
			RequestUpdateDeviceTimingTaskData data = (RequestUpdateDeviceTimingTaskData) requestMessage.getData();
			EncoderProcessingRealization.updateDeviceTimingTask(data,buf);
		}
		
		/**
		 * 获取设备定时任务
		 */
		if (head.getControlType() == ControlTypeEnum.GET_TIMING_TASK.getVal()) {
			RequestGetDeviceTimingTaskData data = (RequestGetDeviceTimingTaskData) requestMessage.getData();
			EncoderProcessingRealization.getDeviceTimingTask(data,buf);
		}
		
		/**
		 * 获取指定设备联动任务
		 */
		if (head.getControlType() == ControlTypeEnum.GET_TASK_UID.getVal()) {
			
			RequestGetSensorTaskByUidData data = (RequestGetSensorTaskByUidData) requestMessage.getData();
			EncoderProcessingRealization.getSensorTaskByUid(data,buf);
		}
		
		
		/**
		 * 登录验证
		 */
		if (head.getControlType() == ControlTypeEnum.LOGIN_VALODATE.getVal()) {
			RequestLoginValidateData data = (RequestLoginValidateData) requestMessage.getData();
			EncoderProcessingRealization.loginValidate(data,buf);
		}
		
		/**
		 * 获取场景列表
		 */
		if (head.getControlType() == ControlTypeEnum.GET_SENCE.getVal()) {
			//state
			buf.writeByte(0x01);
		}
		/**
		 * 获取设备列表
		 */
		if (head.getControlType() == ControlTypeEnum.GET_DEVICE.getVal()) {
			//state
			buf.writeByte(0x01);
		}
		/**
		 * 发送心跳包
		 */
		if (head.getControlType() == ControlTypeEnum.SEND_HEARTBEAT.getVal()) {
			//state
			buf.writeByte(0x01);
		}
		
		/**
		 * 验证管理密码
		 */
		if (head.getControlType() == ControlTypeEnum.VERIFICATION_MANAGERPWD.getVal()) {
			RequestVerificationManagerPwdData data = (RequestVerificationManagerPwdData) requestMessage.getData();
			EncoderProcessingRealization.verificationManagerPwd(data,buf);
		}
		
		/**
		 * 修改密码
		 */
		if (head.getControlType() == ControlTypeEnum.MODIFY_PASSWORD.getVal()) {
			
			RequestModifyPwdData data = (RequestModifyPwdData) requestMessage.getData();
			EncoderProcessingRealization.modifyPwd(data,buf);
		}
		
		/**
		 * 局域网登录网关
		 */
		if (head.getControlType() == ControlTypeEnum.LOGIN_GA_LAN.getVal()) {
			RequestLoginGaByLanData data = (RequestLoginGaByLanData) requestMessage.getData();
			EncoderProcessingRealization.loginGaByLan(data,buf);
		}
	}
}
