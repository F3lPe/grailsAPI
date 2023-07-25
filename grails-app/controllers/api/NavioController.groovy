package api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NavioController {

    NavioService navioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond navioService.list(params), model:[navioCount: navioService.count()]
    }

    def show(Long id) {
        respond navioService.get(id)
    }

    def create() {
        respond new Navio(params)
    }

    def save(Navio navio) {
        if (navio == null) {
            notFound()
            return
        }

        try {
            navioService.save(navio)
        } catch (ValidationException e) {
            respond navio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'navio.label', default: 'Navio'), navio.id])
                redirect navio
            }
            '*' { respond navio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond navioService.get(id)
    }

    def update(Navio navio) {
        if (navio == null) {
            notFound()
            return
        }

        try {
            navioService.save(navio)
        } catch (ValidationException e) {
            respond navio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'navio.label', default: 'Navio'), navio.id])
                redirect navio
            }
            '*'{ respond navio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        navioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message')
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'navio.label', default: 'Navio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
