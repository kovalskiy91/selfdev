package kovalskiy91.selfdev.jpa.inheritance.tableperclasshierarchy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = Employee.ID_GENERATOR, sequenceName = "employee-id-seq", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Getter
@Setter
public abstract class Employee {

    static final String ID_GENERATOR = "idGenerator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_GENERATOR)
    private Long id;

    @Version
    private Long version;

    private String name;
    private String surname;

}
