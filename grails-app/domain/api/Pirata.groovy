package api
import grails.rest.Resource

@Resource(uri='/pirata', formats=['json'])

class Pirata {
    String nome
    String data_nascimento
    TipoPirata tipo

    static belongsTo = [navio_tripulacao: Navio]
    
    enum TipoPirata {
        capitão,
        navegador,
        marujo,
        cozinheiro,
    }       

    static constraints = {
        data_nascimento blank: false
        nome blank: false
    }
}
