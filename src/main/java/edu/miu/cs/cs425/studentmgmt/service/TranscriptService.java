package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;

import java.util.List;

public interface TranscriptService {
    Transcript addTranscript(Transcript newTranscript);

    Transcript updateTranscript(Transcript newTranscript);

    Transcript getTranscriptById(Long transcriptId);

    List<Transcript> getAllTranscripts();

    void deleteById(Long transcriptId);
}
