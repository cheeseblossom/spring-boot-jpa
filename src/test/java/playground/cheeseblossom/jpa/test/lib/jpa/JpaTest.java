package playground.cheeseblossom.jpa.test.lib.jpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import playground.cheeseblossom.jpa.config.JpaConfig;
import playground.cheeseblossom.jpa.config.TestConfig;
import playground.cheeseblossom.jpa.domain.Sample;
import playground.cheeseblossom.jpa.domain.SampleRepository;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(SpringExtension.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = JpaConfig.class))
@Import(TestConfig.class)
public class JpaTest {

  @Autowired
  private SampleRepository sampleRepository;

  @AfterEach
  public void cleanup() {
    sampleRepository.deleteAll();
  }

  @Test
  public void test() {
    // given
    String text = "text";

    // when
    Sample s = Sample.builder()
            .text(text)
            .build();
    sampleRepository.save(s);

    Sample findSample = sampleRepository.findAll().get(0);

    // then
    then(findSample.getText()).isEqualTo(text);
  }

  @Test
  public void queryDslTest() {
    // given
    String text = "text";
    Sample s = Sample.builder()
            .text(text)
            .build();
    sampleRepository.save(s);

    // when
    List<String> result = sampleRepository.findText();

    // then
    then(result.get(0)).isEqualTo(text);
  }
}
