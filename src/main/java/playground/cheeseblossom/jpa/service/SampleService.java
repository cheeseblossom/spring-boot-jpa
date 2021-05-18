package playground.cheeseblossom.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import playground.cheeseblossom.jpa.domain.Sample;
import playground.cheeseblossom.jpa.domain.SampleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SampleService {

  private final SampleRepository sampleRepository;

  @Transactional
  public void save() {
    Sample s = Sample.builder()
            .text(UUID.randomUUID().toString().substring(0, 10))
            .build();
    sampleRepository.save(s);
  }

  public List<String> findText() {
    return sampleRepository.findText();
  }
}
