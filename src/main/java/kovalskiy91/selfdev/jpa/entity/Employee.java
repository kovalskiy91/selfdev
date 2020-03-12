package kovalskiy91.selfdev.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = Employee.ID_GENERATOR, sequenceName = "employee-id-seq", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("EMP")
@Getter
@Setter
public class Employee {

    static final String ID_GENERATOR = "idGenerator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_GENERATOR)
    private Long id;

    @Version
    private Long version;

    private String name;
    private String surname;

}
