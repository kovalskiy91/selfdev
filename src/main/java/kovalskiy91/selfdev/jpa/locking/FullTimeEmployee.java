package kovalskiy91.selfdev.jpa.locking;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "ft_employee")
@PrimaryKeyJoinColumn(name = "employee_id")
@DiscriminatorValue("FT_EMP")
public class FullTimeEmployee extends Employee {

    private Integer salary;

}
