package pojo;

import java.util.List;

public class Courses_ChildGetCourses {

	private List<WebAutomation_Courses> webAutomation;
	private List<Api_Courses> api;
	private List<Mobile_Courses> mobile;
	
	public List<WebAutomation_Courses> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation_Courses> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api_Courses> getApi() {
		return api;
	}
	public void setApi(List<Api_Courses> api) {
		this.api = api;
	}
	public List<Mobile_Courses> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile_Courses> mobile) {
		this.mobile = mobile;
	}	
}
