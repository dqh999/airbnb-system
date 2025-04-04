package com.airbnb.listing_service.command.api;

import com.airbnb.listing_service.command.command.CreateListingCommand;
import com.airbnb.listing_service.command.model.ListingRequestModel;
import com.dqhdev.global_error_handler.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/listings")
@RequiredArgsConstructor
public class ListingCommandController {
    private final CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addListing(@RequestBody ListingRequestModel requestModel) {
        CreateListingCommand command = new CreateListingCommand(
                requestModel.getOwnerId(),
                requestModel.getTitle(),
                requestModel.getDescription(),
                requestModel.getPrice(),
                requestModel.getAddress()
        );
        var response = commandGateway.sendAndWait(command);
        return ApiResponse.<String>build()
                .withData("response")
                .toEntity();
    }
}
