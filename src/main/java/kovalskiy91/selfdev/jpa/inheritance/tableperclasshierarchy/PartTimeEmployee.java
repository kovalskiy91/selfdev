package kovalskiy91.selfdev.jpa.inheritance.tableperclasshierarchy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("PT_EMP")
public class PartTimeEmployee extends Employee {

    private Integer hourlyWage;

}
