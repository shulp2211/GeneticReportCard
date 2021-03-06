package org.cggh.bam;

import java.io.File;
import java.util.HashMap;

import org.cggh.common.exceptions.AnalysisException;
import org.cggh.common.sequence.Sequence;
import org.cggh.common.sequence.io.FastaSequenceReader;
import org.cggh.common.sequence.io.SequenceSetReader;

public class ReferenceGenome {

	private static HashMap<String,Sequence> chrSeqByName;
	
	public static void initialize(File refFastaFile) throws AnalysisException {
		try {
			SequenceSetReader seqSetReader = new SequenceSetReader (new FastaSequenceReader());
			Sequence[] chrSequences = seqSetReader.readSequences(refFastaFile);
			chrSeqByName = new HashMap<String,Sequence>();
			for (int i = 0; i < chrSequences.length; i++) {
				String id = chrSequences[i].getId();
				String data = chrSequences[i].getData().toUpperCase(); // Lowercase can cause issues
				chrSeqByName.put(id, new Sequence(id, data));
			}
		} catch (Exception e) {
			throw new AnalysisException ("Error reading genome FASTA file from GenomeCache: "+e);
		}
	}
	
	public static Sequence getChrSequence(String chrName) throws AnalysisException {
		return chrSeqByName.get(chrName);
	}
}
