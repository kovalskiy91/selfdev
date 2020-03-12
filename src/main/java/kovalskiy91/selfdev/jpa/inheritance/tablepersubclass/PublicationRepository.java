package kovalskiy91.selfdev.jpa.inheritance.tablepersubclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
