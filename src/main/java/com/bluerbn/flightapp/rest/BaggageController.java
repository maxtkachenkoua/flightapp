package com.bluerbn.flightapp.rest;

import com.bluerbn.flightapp.service.BaggageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/baggage")
public class BaggageController {

    private final BaggageService baggageService;

    @Autowired
    public BaggageController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @ApiOperation(value = "Baggage check in",
            notes = "Provide baggage check in service. " +
                    "User provide Destination Id(Numeric) and baggage Id(String). " +
                    "Return answer if the checkin succeeded (boolean)", response = Boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Action status returned")
    })
    @RequestMapping(value = "/{destinationId}/{baggageId}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> isTicketAvailable(@PathVariable("destinationId") @NotNull Long destinationId,
                                                     @PathVariable @NotBlank @Size(min = 10, max = 10) String baggageId) {
        return ResponseEntity.ok(baggageService.checkIn(destinationId, baggageId));
    }

}
