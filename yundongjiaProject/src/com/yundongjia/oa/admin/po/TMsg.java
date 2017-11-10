package com.yundongjia.oa.admin.po;

public class TMsg {
    private Integer verifyid;

	private String verifycode;

	private String mobilephoneno;

	private String status;

	private String createdate;

	private Integer codetype;

	private Integer fromid;

	private String ip;

	public Integer getVerifyid() {
		return verifyid;
	}

	public void setVerifyid(Integer verifyid) {
		this.verifyid = verifyid;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode == null ? null : verifycode.trim();
	}

	public String getMobilephoneno() {
		return mobilephoneno;
	}

	public void setMobilephoneno(String mobilephoneno) {
		this.mobilephoneno = mobilephoneno == null ? null : mobilephoneno.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate == null ? null : createdate.trim();
	}

	public Integer getCodetype() {
		return codetype;
	}

	public void setCodetype(Integer codetype) {
		this.codetype = codetype;
	}

	public Integer getFromid() {
		return fromid;
	}

	public void setFromid(Integer fromid) {
		this.fromid = fromid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}
}