package com.rds.stock.dto;

import java.math.BigDecimal;

public class GoogleStockResponse {
	Long id;
	String t;
	String e;
	BigDecimal l;
	String l_fix;
	String l_cur;
	String s;
	String ltt;
	String lt;
	String lt_tds;
	String c;
	String c_fix;
	String cp;
	String cp_fix;
	String ccol;
	String pcls_fix;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public BigDecimal getL() {
		return l;
	}
	public void setL(BigDecimal l) {
		this.l = l;
	}
	public String getL_fix() {
		return l_fix;
	}
	public void setL_fix(String l_fix) {
		this.l_fix = l_fix;
	}
	public String getL_cur() {
		return l_cur;
	}
	public void setL_cur(String l_cur) {
		this.l_cur = l_cur;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getLtt() {
		return ltt;
	}
	public void setLtt(String ltt) {
		this.ltt = ltt;
	}
	public String getLt() {
		return lt;
	}
	public void setLt(String lt) {
		this.lt = lt;
	}
	public String getLt_tds() {
		return lt_tds;
	}
	public void setLt_tds(String lt_tds) {
		this.lt_tds = lt_tds;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getC_fix() {
		return c_fix;
	}
	public void setC_fix(String c_fix) {
		this.c_fix = c_fix;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCp_fix() {
		return cp_fix;
	}
	public void setCp_fix(String cp_fix) {
		this.cp_fix = cp_fix;
	}
	public String getCcol() {
		return ccol;
	}
	public void setCcol(String ccol) {
		this.ccol = ccol;
	}
	public String getPcls_fix() {
		return pcls_fix;
	}
	public void setPcls_fix(String pcls_fix) {
		this.pcls_fix = pcls_fix;
	}
}