package kr.co.kosmo.mvc.vo;

public class SawonVO {
	    private int sabun,deptno,sapay,samgr;
	    private String saname,sajob,sahire,sasex;
	
	    // has one : ��� �Ѹ�� phone�� ������ ����
	    // ResultMap : Association ���� 
	    private SawonPhoneVO sphone;
	    
		public SawonPhoneVO getSphone() {
			return sphone;
		}
		public void setSphone(SawonPhoneVO sphone) {
			this.sphone = sphone;
		}
		public int getSabun() {
			return sabun;
		}
		public void setSabun(int sabun) {
			this.sabun = sabun;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		public int getSapay() {
			return sapay;
		}
		public void setSapay(int sapay) {
			this.sapay = sapay;
		}
		public int getSamgr() {
			return samgr;
		}
		public void setSamgr(int samgr) {
			this.samgr = samgr;
		}
		public String getSaname() {
			return saname;
		}
		public void setSaname(String saname) {
			this.saname = saname;
		}
		public String getSajob() {
			return sajob;
		}
		public void setSajob(String sajob) {
			this.sajob = sajob;
		}
		public String getSahire() {
			return sahire;
		}
		public void setSahire(String sahire) {
			this.sahire = sahire;
		}
		public String getSasex() {
			return sasex;
		}
		public void setSasex(String sasex) {
			this.sasex = sasex;
		}

		
	    
}
