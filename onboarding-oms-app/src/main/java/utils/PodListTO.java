package utils;

import io.swagger.annotations.ApiModelProperty;

public class PodListTO {
	
	@ApiModelProperty(allowableValues = "Pod3_Checklist")
	private String podName;
	
	private String taskName;
	
	public String getPodName() {
		return podName;
	}
	public void setPodName(String podName) {
		this.podName = podName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

}
