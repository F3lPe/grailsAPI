package api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FrotaServiceSpec extends Specification {

    FrotaService frotaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Frota(...).save(flush: true, failOnError: true)
        //new Frota(...).save(flush: true, failOnError: true)
        //Frota frota = new Frota(...).save(flush: true, failOnError: true)
        //new Frota(...).save(flush: true, failOnError: true)
        //new Frota(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //frota.id
    }

    void "test get"() {
        setupData()

        expect:
        frotaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Frota> frotaList = frotaService.list(max: 2, offset: 2)

        then:
        frotaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        frotaService.count() == 5
    }

    void "test delete"() {
        Long frotaId = setupData()

        expect:
        frotaService.count() == 5

        when:
        frotaService.delete(frotaId)
        sessionFactory.currentSession.flush()

        then:
        frotaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Frota frota = new Frota()
        frotaService.save(frota)

        then:
        frota.id != null
    }
}
