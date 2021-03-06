package org.cggh.bam.grc;

import org.cggh.bam.*;
import org.cggh.bam.target.*;
import org.cggh.common.exceptions.*;
import java.io.*;

public class GrcConfig extends BamConfig {
	
	public static final String PROP_PREFIX = "grc.";
	
	public GrcConfig (File configFile) throws AnalysisException  {
		super(configFile, PROP_PREFIX);
	}
	
	//public TargetLocus[] getLoci() {
	//	return (TargetLocus[])loci;
	//}

	@Override
	public TargetLocus[] parseLocusConfig() throws AnalysisException {
		return 	TargetLocus.parseLocusConfig(this.configProperties, propPrefix);
	}
}
