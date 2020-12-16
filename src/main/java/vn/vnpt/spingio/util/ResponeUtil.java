package vn.vnpt.spingio.util;

public class ResponeUtil {
	
	private Boolean success;
	private Integer errorCode;
	private String message;
	private Object data;
	
	public ResponeUtil(Boolean success, Integer errorCode, String message, Object data) {
		this.success = success;
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
