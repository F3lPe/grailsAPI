package api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FrotaController {

    FrotaService frotaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond frotaService.list(params), model:[frotaCount: frotaService.count()]
    }

    def show(Long id) {
        respond frotaService.get(id)
    }

    def create() {
        respond new Frota(params)
    }

    def save(Frota frota) {
        if (frota == null) {
            notFound()
            return
        }

        try {
            frotaService.save(frota)
        } catch (ValidationException e) {
            respond frota.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'frota.label', default: 'Frota'), frota.id])
                redirect frota
            }
            '*' { respond frota, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond frotaService.get(id)
    }

    def update(Frota frota) {
        if (frota == null) {
            notFound()
            return
        }

        try {
            frotaService.save(frota)
        } catch (ValidationException e) {
            respond frota.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'frota.label', default: 'Frota'), frota.id])
                redirect frota
            }
            '*'{ respond frota, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        frotaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'frota.label', default: 'Frota'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'frota.label', default: 'Frota'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
