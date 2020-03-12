package kovalskiy91.selfdev.jpa.inheritance.tablepersubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = Publication.ID_GENERATOR, sequenceName = "publication-id-seq", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("PUB")
@Getter
@Setter
public class Publication {

    static final String ID_GENERATOR = "idGenerator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_GENERATOR)
    private Long id;

    @Version
    private Long version;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
}
