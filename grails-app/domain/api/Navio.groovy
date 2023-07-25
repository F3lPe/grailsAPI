package api

import grails.rest.Resource
@Resource(uri='/navio', formats=['json', 'xml'])

class Navio {
 Double valor_atual
 String nome

   static constraints = {
        valor_atual matches: /^(\d+\.?\d*|\.\d+)$/
    }     
}
