package api
import grails.rest.Resource

@Resource(uri='/frota', formats=['json', 'xml'])
class Frota {
    String nome 
     
    static hasMany = [navios: Navio]

    static constraints = {
        nome blank : false 
    }
}
