package kovalskiy91.selfdev.jpa.inheritance.tablepersubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "pub_id")
@DiscriminatorValue("POST")
@Getter
@Setter
public class Post extends Publication {

    private LocalDateTime postedAt;

}
