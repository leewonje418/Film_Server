package com.example.test1.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String user_id;
    private String nickName;
    private String userName;
    private String phoneNumber;
    private LocalDate birthDate;
    private int gender;
    private String email;
    private String password;
    private String storedPath;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modified;

//    public User(Long id, String user_id, String password, String nickName, String userName, String phoneNumber, LocalDate birthDate, int gender, String email) {
//        this.id = id;
//        this.user_id = user_id;
//        this.password = password;
//        this.nickName = nickName;
//        this.userName = userName;
//        this.phoneNumber = phoneNumber;
//        this.birthDate = birthDate;
//        this.gender = gender;
//        this.email = email;
//    }
}
