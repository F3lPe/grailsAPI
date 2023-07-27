package api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PirataServiceSpec extends Specification {

    PirataService pirataService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pirata(...).save(flush: true, failOnError: true)
        //new Pirata(...).save(flush: true, failOnError: true)
        //Pirata pirata = new Pirata(...).save(flush: true, failOnError: true)
        //new Pirata(...).save(flush: true, failOnError: true)
        //new Pirata(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pirata.id
    }

    void "test get"() {
        setupData()

        expect:
        pirataService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pirata> pirataList = pirataService.list(max: 2, offset: 2)

        then:
        pirataList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pirataService.count() == 5
    }

    void "test delete"() {
        Long pirataId = setupData()

        expect:
        pirataService.count() == 5

        when:
        pirataService.delete(pirataId)
        sessionFactory.currentSession.flush()

        then:
        pirataService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pirata pirata = new Pirata()
        pirataService.save(pirata)

        then:
        pirata.id != null
    }
}
