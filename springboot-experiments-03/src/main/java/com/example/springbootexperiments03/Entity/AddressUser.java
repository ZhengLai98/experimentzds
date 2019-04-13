package com.example.springbootexperiments03.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AddressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Address address;
    @Column(columnDefinition = "timestamp not null default current_timestamp",
    updatable = false,insertable = false)
    private LocalDateTime insertTime;
    public AddressUser(User user,Address address){
        this.user=user;
        this.address=address;
    }

}
