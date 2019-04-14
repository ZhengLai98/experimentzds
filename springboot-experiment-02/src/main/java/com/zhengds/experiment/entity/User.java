package com.zhengds.experiment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    /*
    * CascadeType.REMOVE
    Cascade remove operation，级联删除操作。
    删除当前实体时，与它有映射关系的实体也会跟着被删除。*/
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Address> addresses;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;
    public User(int id){this.id=id;}
    public User(String name) {
        this.name = name;
    }
}
