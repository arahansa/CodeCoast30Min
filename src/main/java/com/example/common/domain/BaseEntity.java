package com.example.common.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jarvis on 2016. 5. 6..
 */
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;

    @Column(name = "modification_time", nullable = false)
    private LocalDateTime modificationTime;

    @Version
    private long version;

    public abstract ID getId();

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public long getVersion() {
        return version;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = now;
        this.modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = LocalDateTime.now();
    }
}
