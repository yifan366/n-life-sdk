package com.b_noble.n_life;

import java.util.List;
import java.util.Map;

import com.b_noble.n_life.info.DeviceInfo;
import com.b_noble.n_life.info.GateWayInfo;
import com.b_noble.n_life.info.SenceInfo;
import com.b_noble.n_life.info.TaskDeviceAction;
import com.b_noble.n_life.info.TaskInfo;
import com.b_noble.n_life.info.TaskTimerAction;
import com.b_noble.n_life.info.TimingInfo;

import android.R.integer;
import android.content.Context;

/**
 * @company：深圳市中泰智丰物联网科技有限公司
 * @project：智能家居
 * @describe：app调用接口
 * @author：zhangfan @date：2016-08-04 @version：V0.0.1
 */
public interface Serial {

	public void setmContext(Context mContext);

	/**
	 * 连接到远程的网关
	 * 
	 * @param userName
	 *            用户名
	 * @param passWd
	 *            密码
	 * @return 1，连接成功且已绑定网关,-1为账号或密码错误,0为未绑定网关,-2与网关建立链接失败，-3鉴权系统链接超时
	 */
	public int connectRemoteZll(String userName, String passWd);
	
	/**
	 * 局域网登录网关，执行改方法前需要先执行connectLANZllByIp方法
	 * @param userName
	 *            用户名
	 * @param passWd
	 *            密码
	 * 登录结果在回调loginGaByLan_Callback()中返回
	 */
	public int loginGaByLan(String userName,String passWd);
	
	/**
	 * 向服务端发送登录验证指令
	 */
	public void sendLoginCmd();

	/**
	 * 通过ip、snid、port来连接到本地的网关
	 * 
	 * @param ip
	 * @param snid
	 * @param port
	 * @return -1 连接失败，-3连接超时，>0连接成功
	 */
	public int connectLANZllByIp(String ip, String snid, int port);

	/**
	 * 获取当前找到所有的网关ip,结果在newGate_CallBack中回调返回
	 * 
	 */
	public Map<String, String> getGatewayIps();

	/**
	 * 查看网关信息
	 */
	public void getGateWayInfo();

	/**
	 * 复位网关
	 * 
	 * @return
	 */
	public int resetGateway();

	/**
	 * 获取当前连接的所有设备 可以在newDevice_CallBack（）这个回调中，来获得所有设备
	 */
	public DeviceInfo[] getDevices();

	/**
	 * 更改设备或组名称,传入字符数组
	 * 
	 * @param dInfo
	 *            要更改的设备（必须有device UId 和deviceName）
	 * @param dName
	 *            新的设备名 执行该方法后结果在ChangeDeviceName_callBack(byte[] uid,String
	 *            deviceName) 中返回
	 */
	public int ChangeDeviceName(DeviceInfo dInfo, String dName);

	/**
	 * 删除当前设备
	 * 
	 * @param info
	 *            要删除的设备（必须有device Uid）
	 */
	public int deleteDevice(DeviceInfo info);

	/**
	 * 改变设备状态：1 开/ 0 关
	 * 
	 * @param info
	 *            要改变状态的设备（必须要有Uid）
	 * @param state
	 *            要改变的状态 执行此方法后在setDeviceState_CallBack() 中返回状态
	 */
	public int setDeviceState(DeviceInfo info, int state);

	/**
	 * 获得设备状态，结果在getDeviceState_CallBack这个回调中会有返回
	 * 
	 * @param info
	 *            要获取的设备（必须要有Uid）
	 */
	public int getDeviceState(DeviceInfo info);

	/**
	 * 改变设备值，（亮度）
	 * 
	 * @param info
	 *            要改变设备值的设备（必须要有Uid）
	 * @param value
	 *            要改变的值
	 */
	public int setDeviceLevel(DeviceInfo info, byte value);

	/**
	 * 改变设备值，（亮度）
	 * 
	 * @param info
	 *            要改变设备值的设备（必须要有Uid）
	 * @param value
	 *            要改变的值
	 * @param transitionTime
	 *            延时时间（单位100ms）
	 * @return
	 */
	public int setDeviceLevel(DeviceInfo info, byte value, short transitionTime);

	/**
	 * 获得设备值（输出级别， 如亮度） ， 结果在getDeviceLevel_CallBack这个回调中有返回
	 * 
	 * @param info
	 *            要获取设备值的设备（必须要有Uid）
	 */
	public int getDeviceLevel(DeviceInfo info);

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
	public int setDeviceHueSat(DeviceInfo info, byte hue, byte sat);

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
	public int setDeviceHueSat(DeviceInfo info, byte hue, byte sat, short transitionTime);

	/**
	 * 改变设备色温
	 * 
	 * @param info
	 *            要改变色温的设备
	 * @param value
	 *            色温值
	 */
	public int SetColorTemperature(DeviceInfo info, int value);

	/**
	 * 
	 * 改变设备色温
	 * 
	 * @param info
	 *            要改变色温的设备
	 * @param value
	 *            色温值
	 * @param transitionTime
	 *            延时时间（单位100ms）
	 * @return
	 */
	public int SetColorTemperature(DeviceInfo info, int value, short transitionTime);

	/**
	 * 获取设备色调与饱和度，结果在 getDeviceHueAndSat_CallBack这个回调中
	 * 
	 * @param info
	 *            要获取设备色调的设备 （必须要有Uid）
	 */
	public int getDeviceHueAndSat(DeviceInfo info);

	/**
	 * 获取设备色温值，结果在 getColorTemperature_CallBack这个回调中
	 * 
	 * @param info
	 *            要获取设备色温的设备（必须要有Uid）
	 */
	public int getColorTemperature(DeviceInfo info);

	/***********************************************/
	/* about sence */

	/**
	 * 获取当前所有场景
	 * 
	 * @return 返回NULL，其结果在newSence_CallBack（） 中返回
	 */
	public SenceInfo[] getSences();

	/**
	 * 创建新场景
	 * 
	 * @param senceName
	 *            场景名
	 * @param uid
	 *            设备uid
	 * @param delaytime
	 *            延迟时间为0-60s
	 * 
	 *            添加完成后新场景在addSence_callBack(byte sceneId,String senceName)中返回
	 */
	public int addSence(String senceName, List<byte[]> uid, int delaytime);

	/**
	 * 将指定的设备动作添加到指定的场景中，若场景不存在，则创建新场景
	 * 
	 * @param senceId
	 *            场景id
	 * @param uids
	 *            要添加的设备列表
	 */
	public int addDeviceToSence(int senceId, List<byte[]> uids, int delaytime);

	/**
	 * 打开指定的场景
	 * 
	 * @param senceId
	 *            要打开的场景的ID
	 * @param sceneName
	 *            要打开的场景的name
	 */
	public int recallScene(int sceneId, String sceneName);

	/**
	 * 获取指定场景的详细信息， 结果在getSenceMember_CallBack()这个回调中返回
	 * 
	 * @param senceId
	 *            场景Id
	 */
	public int getSenceMember(int sceneId);

	/**
	 * 删除场景中指定设备成员
	 * 
	 * @param senceName
	 *            场景名
	 * @param uIds
	 *            设备uId列表
	 */
	public int deleteSenceMember(int sceneId, String sceneName, List<byte[]> uIds);

	/**
	 * 删除指定场景
	 * 
	 * @param senceName
	 */
	public int deleteSence(int senceId, String sceneName);

	/**
	 * 修改场景名称
	 * 
	 * @param senceId
	 *            场景Id
	 * @param sName
	 *            新的场景名
	 */
	public int ChangeSceneName(short sceneId, String newSceneName);

	/***********************************************/
	/* about task */
	/***********************************************/
	/**
	 * 获取当前所有任务
	 * 
	 * @return 获取的任务在newTask_CallBack这个回调函数中
	 */
	public void getTasks();

	/**
	 * 简述 根据场景id查询该场景的所有定时任务
	 * 
	 * @param sceneId
	 *            场景id
	 * @author zhangfan
	 * @date 2016-07-26
	 * @return 此方法在getTimerTaskBySceneId_CallBack这个回调方法中返回
	 */
	public void getTimerTaskBySceneId(int sceneId);

	/**
	 * 简述 根据设备uid查询该设备的所有联动任务
	 * 
	 * @param uid
	 *            设备uid shortAddress+endPoint
	 * @author zhangfan
	 * @date 2016-07-27
	 * @return 此方法在getSensorTaskByUid_CallBack这个回调方法中返回
	 */
	public void getSensorTaskByUid(byte[] uid);

	/**
	 * 添加定时任务
	 * 
	 * @param taskInfo
	 * @return
	 */
	public int addTimerTask(String taskName, TaskTimerAction timerAction, int sceneId);

	/**
	 * 添加设备触发任务
	 * 
	 * @param taskName
	 * @param isAlarm
	 *            是否需要报警
	 * @return
	 */
	public int addDeviceTask(String taskName, TaskDeviceAction deviceAction, short sceneId, byte isAlarm);

	/**
	 * 添加设备报警任务
	 * 
	 * @param taskName
	 * @param deviceAction
	 * @param SenceName
	 * @param isAlarm
	 * @return
	 */
	public int addDeviceAlarmTask(String taskName, TaskDeviceAction deviceAction);

	/**
	 * 修改定时任务
	 * 
	 * @param taskInfo
	 * @return
	 */
	public int updateTimerTask(int taksId, String taskName, TaskTimerAction timerAction, short sceneId);

	/**
	 * 修改设备触发任务
	 * 
	 * @param taskName
	 * @param isAlarm
	 *            是否需要报警
	 * @return
	 */
	public int updateDeviceTask(int taskId, String taskName, TaskDeviceAction deviceAction, short sceneId,
			byte isAlarm);

	/**
	 * 修改设备报警任务
	 * 
	 * @param taskName
	 * @param deviceAction
	 * @param SenceName
	 * @param isAlarm
	 * @return
	 */
	public int updateDeviceAlarmTask(int taskId, String taskName, TaskDeviceAction deviceAction);

	/**
	 * 删除指定任务
	 * 
	 * @param taskID
	 *            指定的任务id
	 * @return
	 */
	public int deleteTask(int taskId);

	/**
	 * 查看指定任务的详细信息,结果在getTimerTaskDetails_CallBack/getDeviceTaskDetails_CallBack
	 * 
	 * @param taskId
	 *            指定的任务id
	 * @return
	 */
	public int getTaskInfo(int taskId);

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
			byte brightness, byte hue, byte saturation, byte colorTemperature, byte enable);

	/**
	 * 删除设备定时任务
	 * 
	 * @param timingID
	 * @return
	 */
	public int deleteDeviceTimingTask(byte timingID);

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
			byte switchState, byte brightness, byte hue, byte saturation, byte colorTemperature, byte enable);

	/**
	 * 获取指定设备的所有定时任务，结果在getDeviceTimingTask_CallBack中返回
	 * 
	 * @param uid
	 *            设备唯一标示
	 */
	public void getDeviceTimingTask(byte[] uid);

	/**
	 * 向网关发送心跳信息 响应心跳在sendHeartbeat_CallBack中返回
	 */
	public void sendHeartbeat();

	/**
	 * 允许入网指令，设备入网成功后结果在回调newDevice_Callback()中返回
	 */
	public int permitJoin();
	
	/**
	 * 验证网关管理密码,结果在verificationManagerPwd_Callback()中返回
	 */
	public int verificationManagerPwd(String username,String managerPwd);
	
	/**
	 * 修改管理密码
	 */
	public int modifyManagerPwd(String username,String oldManagerPwd,String newManagerPwd);
	/**
	 * 修改登录密码,修改结果状态在回调方法modifyLoginPwd_Callback()中返回
	 */
	public int modifyLoginPwd(String username,String oldLoginPwd,String newLoginPwd);
	
	

	/**
	 * --------------------------------以下是回调方法----------------------------------
	 * -
	 **/
	/**
	 * 这是一个测试回调方法
	 * 
	 * @param result
	 */
	public void callback(String result);

	/**
	 * 获取所有设备回调方法
	 * 
	 * @param dinfo
	 */
	public void newDevice_CallBack(List<DeviceInfo> dinfos);

	/**
	 * 允许入网回调
	 */
	public void newDevice_Callback(DeviceInfo info);

	/**
	 * 本地查找网关返回
	 * 
	 * @param ip
	 */
	public void newGate_CallBack(String ip, String sn);

	/**
	 * 获取设备的值回调方法
	 */
	public void getDeviceLevel_CallBack(int level, byte[] uId);

	/**
	 * 获取所有场景回调方法
	 * 
	 * @param dinfo
	 */
	public void newSence_CallBack(List<SenceInfo> sinfos);

	/**
	 * 获取网关信息返回
	 */
	public void getGateWayInfo_CallBack(GateWayInfo gainfo);

	/**
	 * 获取设备状态回调,通过state来判断设备状态（>0 开、<= 0关）
	 * 
	 * @param state
	 * @param uId
	 */
	public void getDeviceState_CallBack(int state, byte[] uId);

	/**
	 * 获取设备色调与饱和度回调
	 * 
	 * @param hue
	 *            色调
	 * @param sat
	 *            饱和度
	 * @param uId
	 */
	public void getDeviceHueAndSat_CallBack(int hue, int sat, byte[] uId);

	/**
	 * 获取设备色温值回调
	 * 
	 * @param colorTemperature
	 * @param uId
	 */
	public void getColorTemperature_CallBack(int colorTemperature, byte[] uId);

	/**
	 * 获取场景成员回调
	 */
	public void getSenceMember_CallBack(int sceneId, String sceneName, List<byte[]> uids);

	/**
	 * 获取所有任务回调
	 */
	public void newTask_CallBack(List<TaskInfo> tasks);

	/**
	 * 获取指定场景定时任务 当调用getTimerTaskBySceneId方法后回调
	 */
	public void getTimerTaskBySceneId_CallBack(List<TaskInfo> tasks);

	/**
	 * 获取指定设备联动任务 当条用getSensorTaskByUid方法后回调
	 */
	public void getSensorTaskByUid_CallBack(List<TaskInfo> tasks);

	/**
	 * 当调用getTaskInfo()时返回
	 * 
	 * @param taskId
	 *            task's id
	 * @param taskName
	 *            task's name
	 * @param action1
	 *            first task's action
	 * @param action2
	 *            second task's action
	 */
	public void getTimerTaskDetails_CallBack(TaskInfo taskInfo, TaskTimerAction timerAction, short sceneId);

	/**
	 * 当调用getTaskInfo()时返回，返回获取设备联动任务
	 * 
	 * @param taskName
	 *            任务名
	 * @param deviceAction
	 *            设备联动时，设备动作信息
	 * @param senceName
	 *            联动执行场景
	 * @param isAlarm
	 *            是否报警标志
	 */
	public void getDeviceTaskDetails_CallBack(TaskInfo taskInfo, TaskDeviceAction deviceAction, short sceneId,
			byte isAlarm);

	/**
	 * 当调用addSence后返回
	 * 
	 * @param sceneId
	 *            场景id
	 * 
	 * @param senceName
	 *            场景名称
	 */
	public void addSence_callBack(byte sceneId, String senceName);

	/**
	 * 当调用ChangeDeviceName后返回
	 * 
	 * @param uid
	 *            uid
	 * 
	 * @param deviceName
	 *            设备名称
	 */
	public void ChangeDeviceName_callBack(byte[] uid, String deviceName);

	/**
	 * 传感器推送数据回调
	 * 
	 * @param uid
	 *            设备uid
	 * @param 参数
	 *            请参考recentValue对照表
	 */
	public void sensorReport_callBack(byte[] uid, byte[] recentValue, byte[] deviceId, short attrId);

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
	public void TemperatureAndHumidityReport_callBack(Double temperature, Double humidity, Integer battery);

	/**
	 * 紧急按钮推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void EmergencyButtonReprot_callBack(byte state, byte[] uid);

	/**
	 * 燃气传感器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void GasSensorReprot_callBack(byte state, byte[] uid);

	/**
	 * 烟雾传感器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void FireSensorReprot_callBack(byte state, byte[] uid);

	/**
	 * 一氧化碳传感器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void CoSensorReprot_callBack(byte state, byte[] uid);

	/**
	 * 多功能遥控器推送回调方法
	 * 
	 * @param state
	 *            状态
	 */
	public void KeyFobReprot_callBack(byte state, byte[] uid);

	/**
	 * 客户端离线后回调方法
	 */
	public void clientClose();

	/**
	 * 客户端建立链接回调方法
	 */
	public void clientActive();

	/**
	 * 获取设备定时任务回调方法
	 */
	public void getDeviceTimingTask_CallBack(List<TimingInfo> timingInfos);

	/**
	 * 心跳响应回调方法
	 */
	public void sendHeartbeat_CallBack();
	
	/**
	 * 验证管理面回调方法
	 */
	public void verificationManagerPwd_Callback(int state);
	
	/**
	 * 修改登录密码回调方法
	 * @param state : 0成功，1网关未链接云，2 用户名无效，3 原始密码错误，4新密码无效
	 */
	public void modifyLoginPwd_Callback(int state);
	
	/**
	 * 网关局域网登录验证回调方法
	 * @param state ：0成功，1用户名无效，2密码错误
	 */
	public void loginGaByLan_Callback(int state);
}
