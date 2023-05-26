package fr.anywr.testanywr.infrastructure.dao;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  @Setter(AccessLevel.NONE)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  @Setter(AccessLevel.NONE)
  private LocalDateTime updatedAt;

  @PrePersist
  private void setCreatedAt() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  private void setUpdatedAt() {
    this.updatedAt = LocalDateTime.now();
  }
}
