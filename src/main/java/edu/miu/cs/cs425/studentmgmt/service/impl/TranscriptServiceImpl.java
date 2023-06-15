package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    private final TranscriptRepository transcriptRepository;

    public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript addTranscript(Transcript newTranscript) {
        return transcriptRepository.save(newTranscript);
    }

    @Override
    public Transcript updateTranscript(Transcript newTranscript) {
        transcriptRepository.findById(newTranscript.getTranscriptId())
                .orElseThrow(() -> new RuntimeException("Transcript doesn't exist"));
        return transcriptRepository.save(newTranscript);
    }

    @Override
    public Transcript getTranscriptById(Long transcriptId) {
        return transcriptRepository.findById(transcriptId)
                .orElseThrow(() -> new RuntimeException("Transcript doesn't exist"));
    }

    @Override
    public List<Transcript> getAllTranscripts() {
        return transcriptRepository.findAll();
    }

    @Override
    public void deleteById(Long transcriptId) {
        transcriptRepository.deleteById(transcriptId);
    }
}
