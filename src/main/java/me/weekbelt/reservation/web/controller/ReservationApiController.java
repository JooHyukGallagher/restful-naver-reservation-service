package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.service.ReservationUserCommentService;
import me.weekbelt.reservation.web.form.reservationUserComment.ReservationUserCommentDto;
import me.weekbelt.reservation.web.form.reservationUserComment.ReservationUserCommentResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ReservationApiController {

    private final ReservationUserCommentService reservationUserCommentService;

    @GetMapping("/v1/comments")
    public ResponseEntity<?> commentsV2(@RequestParam Long productId,
                                        @PageableDefault(size = 5) Pageable pageable,
                                        PagedResourcesAssembler<ReservationUserCommentDto> assembler) {
        Page<ReservationUserCommentDto> reservationUserComments = reservationUserCommentService
                .findReservationUserCommentDtoList(productId, pageable);

        PagedModel<EntityModel<ReservationUserCommentDto>> pageModels = assembler.toModel(reservationUserComments,
                reservationUserComment -> ReservationUserCommentResponseModel.of(reservationUserComment,
                linkTo(ReservationApiController.class).slash(reservationUserComment.getId()).withSelfRel()));

        return ResponseEntity.ok(pageModels);
    }
}
