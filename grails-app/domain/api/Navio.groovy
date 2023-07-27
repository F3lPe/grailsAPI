package api

import grails.rest.Resource
@Resource(uri='/navio', formats=['json'])

 class Navio {
 Double valor_atual
 String nome

 static hasMany = [frotas: Frota, tripulacao: Pirata]
 static belongsTo = [Frota]

   static constraints = {
        valor_atual matches: /^(\d+\.?\d*|\.\d+)$/
        
    }      
}
