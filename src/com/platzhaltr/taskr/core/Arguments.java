package com.platzhaltr.taskr.core;

import uk.co.flamingpenguin.jewel.cli.CommandLineInterface;
import uk.co.flamingpenguin.jewel.cli.Unparsed;

/**
 * Collects the command line arguments
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
@CommandLineInterface(application = "taskr")
public interface Arguments {

	/**
	 * Returns the raw task
	 * 
	 * @return the raw task
	 */
	@Unparsed(name = "task")
	String getTask();

}
