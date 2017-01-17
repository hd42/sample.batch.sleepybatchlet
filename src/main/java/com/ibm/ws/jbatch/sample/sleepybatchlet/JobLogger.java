package com.ibm.ws.jbatch.sample.sleepybatchlet;

import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

//import org.apache.batchee.cdi.scope.JobScoped;

//@Dependent - works for single partition job
@ApplicationScoped // doesn't work
//@JobScoped - what we really want
public class JobLogger {

	@Inject
	private JobContext jobContext;
	// private Instance<JobContext> jobContext; //same exception

	private int count = 0; 

	public void log(String message) {
		System.out.println(
				hashCode() + "|" + jobContext.getJobName() + "[" + jobContext.getExecutionId() + "]: " + message);
		// System.out.println(hashCode()+"|"+jobContext.get().getJobName()+"["+jobContext.get().getExecutionId()+"]:
		// "+message);
		
		System.out.println("count=" + ++count);// counts every log statement here, might be triggered by a separate call to display overall progress
	}

}
