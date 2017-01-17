package com.ibm.ws.jbatch.sample.sleepybatchlet;

import javax.batch.api.listener.JobListener;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class SimpleJobListener implements JobListener {
	
	@Inject
	private JobLogger logger;

	@Override
	public void beforeJob() throws Exception {
		logger.log("before job");
	}

	@Override
	public void afterJob() throws Exception {
		logger.log("after job");
	}

}
