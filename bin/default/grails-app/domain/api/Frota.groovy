package api
import grails.rest.Resource

@Resource(uri='/frota', formats=['json', 'xml'])
class Frota {
    int id
    String nome 
      
    static hasMany = [lista_navios: Navio]

    static constraints = {
        nome blank : false
        id blank : false     
        lista_navios blank: true   
    }
}
