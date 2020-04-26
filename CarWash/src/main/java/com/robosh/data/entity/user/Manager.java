package com.robosh.data.entity.user;

import javax.persistence.Entity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
public class Manager extends User {

    @Builder
    public Manager(Long id, String firstName, String secondName,
        String email, String password) {
        super(id, firstName, secondName, email, password);
    }
}
