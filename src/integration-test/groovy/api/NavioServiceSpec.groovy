package api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NavioServiceSpec extends Specification {

    NavioService navioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Navio(...).save(flush: true, failOnError: true)
        //new Navio(...).save(flush: true, failOnError: true)
        //Navio navio = new Navio(...).save(flush: true, failOnError: true)
        //new Navio(...).save(flush: true, failOnError: true)
        //new Navio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //navio.id
    }

    void "test get"() {
        setupData()

        expect:
        navioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Navio> navioList = navioService.list(max: 2, offset: 2)

        then:
        navioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        navioService.count() == 5
    }

    void "test delete"() {
        Long navioId = setupData()

        expect:
        navioService.count() == 5

        when:
        navioService.delete(navioId)
        sessionFactory.currentSession.flush()

        then:
        navioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Navio navio = new Navio()
        navioService.save(navio)

        then:
        navio.id != null
    }
}
