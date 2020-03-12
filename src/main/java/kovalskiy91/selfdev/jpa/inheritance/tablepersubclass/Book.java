package kovalskiy91.selfdev.jpa.inheritance.tablepersubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "pub_id")
@DiscriminatorValue("BOOK")
@Getter
@Setter
public class Book extends Publication {

    private String publisher;

}
