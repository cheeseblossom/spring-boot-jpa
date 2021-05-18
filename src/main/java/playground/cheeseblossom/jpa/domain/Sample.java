package playground.cheeseblossom.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import playground.cheeseblossom.jpa.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "T_SAMPLE")
@DynamicInsert
@DynamicUpdate
public class Sample extends BaseEntity {

  @Column(name = "text", length = 10, nullable = false)
  private String text;

  @Builder
  public Sample(String text) {
    this.text = text;
  }
}
