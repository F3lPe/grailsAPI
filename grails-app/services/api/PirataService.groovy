package api

import grails.gorm.services.Service

@Service(Pirata)
interface PirataService {

    Pirata get(Serializable id)

    List<Pirata> list(Map args)

    Long count()

    void delete(Serializable id)

    Pirata save(Pirata pirata)

}