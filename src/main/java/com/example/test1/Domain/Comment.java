package com.example.test1.Domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private Long user_id;
    private String comment;
    private String storedPath;
    private String originalName;
    @CreationTimestamp
    private LocalDateTime createdat;
    @UpdateTimestamp
    private LocalDateTime modified;
    public Comment(Comment c) {
        this.id = c.getId();
        this.user_id = c.getUser_id();
        this.comment = c.getComment();
        this.createdat = c.getCreatedat();
        this.modified = c.getModified();
    }
}
