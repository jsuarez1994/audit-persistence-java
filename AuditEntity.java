import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class AuditEntity {

  @Column(name = "created_at")
  @NotNull
  @CreatedDate
  protected ZonedDateTime createdAt;

  @Column(name = "updated_at")
  @NotNull
  @LastModifiedDate
  protected ZonedDateTime updatedAt;

  @Column(name = "created_by")
  @NotNull
  @CreatedBy
  protected String createdBy;

  @Column(name = "updated_by")
  @NotNull
  @LastModifiedBy
  protected String updatedBy;
}