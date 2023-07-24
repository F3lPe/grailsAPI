package api

import grails.gorm.services.Service

@Service(Frota)
interface FrotaService {

    Frota get(Serializable id)

    List<Frota> list(Map args)

    Long count()

    void delete(Serializable id)

    Frota save(Frota frota)

}