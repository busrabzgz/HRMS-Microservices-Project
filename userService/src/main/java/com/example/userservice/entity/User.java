package com.example.userservice.entity;

import com.example.userservice.enums.DepartmentEnum;
import com.example.userservice.enums.GenderTypeEnum;
import com.example.userservice.enums.LevelTypeEnum;
import com.example.userservice.enums.PositionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime createDate = LocalDateTime.now();
    @Version
    @Column(columnDefinition = "integer DEFAULT 0", nullable = false)
    private Long version = 0L;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String citizenNumber;

    private Date birthOfDate;

    private BigDecimal salary;

    private LocalDateTime startToWork;



    @Enumerated
    private DepartmentEnum department;
    @Enumerated
    private GenderTypeEnum gender;

    @Enumerated
    private PositionTypeEnum position;

    @Enumerated
    private LevelTypeEnum level;
    private String email;
    private String phoneNumber;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "firsName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", citizenNumber='" + citizenNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", level='" + level + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
