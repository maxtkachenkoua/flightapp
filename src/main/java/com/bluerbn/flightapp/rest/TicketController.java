package com.bluerbn.flightapp.rest;

import com.bluerbn.flightapp.service.TicketService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @ApiOperation(value = "Get ticket status",
            notes = "User Provide TicketId(Numeric) and return response (boolean) whether the ticket is " +
                    "available or not (the response will determine upon your predefined static data)", response = Boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Auction returned")
    })
    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isTicketAvailable(@Valid @PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketService.isTicketAvailable(ticketId));
    }

}
