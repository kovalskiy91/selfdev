package kovalskiy91.selfdev.jpa.inheritance.tableperclasshierarchy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("FT_EMP")
public class FullTimeEmployee extends Employee {

    private Integer salary;

}
