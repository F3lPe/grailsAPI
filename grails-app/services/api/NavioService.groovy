package api

import grails.gorm.services.Service

@Service(Navio)
interface NavioService {

    Navio get(Serializable id)

    List<Navio> list(Map args)

    Long count()

    void delete(Serializable id)

    Navio save(Navio navio)

}