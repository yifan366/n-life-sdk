package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：请求数据实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestMessage {

	private RequestHead header;
	
	private Object data;

	
	@Override
	public String toString() {
		return "RequestMessage [header=" + header.toString() + ", data=" + data + "]";
	}

	
	public RequestMessage(RequestHead header, Object data) {
		super();
		this.header = header;
		this.data = data;
	}

	public RequestHead getHeader() {
		return header;
	}

	public void setHeader(RequestHead header) {
		this.header = header;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
