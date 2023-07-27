package api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PirataController {

    PirataService pirataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pirataService.list(params), model:[pirataCount: pirataService.count()]
    }

    def show(Long id) {
        respond pirataService.get(id)
    }

    def create() {
        respond new Pirata(params)
    }

    def save(Pirata pirata) {
        if (pirata == null) {
            notFound()
            return
        }

        try {
            pirataService.save(pirata)
        } catch (ValidationException e) {
            respond pirata.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pirata.label', default: 'Pirata'), pirata.id])
                redirect pirata
            }
            '*' { respond pirata, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pirataService.get(id)
    }

    def update(Pirata pirata) {
        if (pirata == null) {
            notFound()
            return
        }

        try {
            pirataService.save(pirata)
        } catch (ValidationException e) {
            respond pirata.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pirata.label', default: 'Pirata'), pirata.id])
                redirect pirata
            }
            '*'{ respond pirata, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pirataService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pirata.label', default: 'Pirata'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pirata.label', default: 'Pirata'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
