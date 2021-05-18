package playground.cheeseblossom.jpa.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static playground.cheeseblossom.jpa.domain.QSample.sample;

@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<String> findText() {
    return jpaQueryFactory
            .select(sample.text)
            .from(sample)
            .fetch();
  }
}
