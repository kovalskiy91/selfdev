package kovalskiy91.selfdev.jpa.inheritance.tablepersubclass

import kovalskiy91.selfdev.SelfDevSpec
import org.springframework.beans.factory.annotation.Autowired

import java.sql.ResultSet
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class TablePerSubClassSpec extends SelfDevSpec {

    @Autowired
    private PublicationRepository publicationRepository;

    def "should save superclass"() {
        given:
        def publication = new Publication(
                title: "Publication",
                author: "Publication Author"
        )

        when:
        publicationRepository.save(publication)

        then:
        def id = publication.id
        assertPublicationType(id, "PUB")
    }

    void assertPublicationType(id, type) {
        sql.query("select type from publication where id = $id", { ResultSet rs ->
            rs.next()
            assert rs.getString("type") == type
        })
    }

    def "should save book via superclass"() {
        def publisher = "O'reilly"
        given:
        def book = new Book(
                title: "Book",
                author: "Book Author",
                publisher: publisher
        )

        when:
        publicationRepository.save(book)

        then:
        def id = book.id
        assertPublicationType(id, "BOOK")
        sql.query("select publisher from book where pub_id = $id", { ResultSet rs ->
            rs.next()
            assert rs.getString("publisher") == publisher
        })
    }

    def "should save post via superclass"() {
        def now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
        given:
        def post = new Post(
                title: "Post",
                author: "Post Author",
                postedAt: now
        )

        when:
        publicationRepository.save(post)

        then:
        def id = post.id
        assertPublicationType(id, "POST")
        sql.query("select posted_at from post where pub_id = $id", { ResultSet rs ->
            rs.next()
            assert rs.getTimestamp("posted_at").toLocalDateTime() == now
        })
    }

}
