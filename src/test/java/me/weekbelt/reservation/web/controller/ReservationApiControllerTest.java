package me.weekbelt.reservation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ReservationApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("상품 평 댓글 목록을 5개씩 3번째 페이지 조회")
    @Test
    public void getComments() throws Exception {
        FieldDescriptor[] reservationUserCommentDtoList = new FieldDescriptor[]{
                fieldWithPath("id").description("상품 리뷰 식별 아이디"),
                fieldWithPath("productId").description("상품 식별 아이디"),
                fieldWithPath("reservationInfoId").description("예약 정보 식별 아이디"),
                fieldWithPath("score").description("상품 리뷰 평점"),
                fieldWithPath("reservationEmail").description("예약자의 이메일"),
                fieldWithPath("comment").description("상품 평"),
                fieldWithPath("createDate").description("리뷰 생성일"),
                fieldWithPath("modifyDate").description("리뷰 수정일"),
                fieldWithPath("reservationUserCommentImages").description("리뷰 이미지 리스트"),
                fieldWithPath("reservationUserCommentImages[].id").description("상품 리뷰이미지 식별자 아이디"),
                fieldWithPath("reservationUserCommentImages[].reservationInfoId").description("예약 정보 식별 아이디"),
                fieldWithPath("reservationUserCommentImages[].reservationUserCommentId").description("상품 리뷰 식별 아이디"),
                fieldWithPath("reservationUserCommentImages[].fileId").description("이미지 파일 식별 아이디"),
                fieldWithPath("reservationUserCommentImages[].fileName").description("이미지 이름"),
                fieldWithPath("reservationUserCommentImages[].saveFileName").description("이미지 경로"),
                fieldWithPath("reservationUserCommentImages[].contentType").description("이미지 타입(png, jpeg, jpg)"),
                fieldWithPath("reservationUserCommentImages[].deleteFlag").description("이미지 삭제 여부"),
                fieldWithPath("reservationUserCommentImages[].createDate").description("이미지 생성일"),
                fieldWithPath("reservationUserCommentImages[].modifyDate").description("이미지 수정일")
        };

        String requestUri = "/api/v1/comments";
        mockMvc.perform(get(requestUri)
                .param("productId", "1")
                .param("page", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("comment-list",
                        links(
                                linkWithRel("first").description("상품 리뷰 리스트 첫 페이지 링크"),
                                linkWithRel("prev").description("상품 리뷰 리스트 이전 페이지 링크"),
                                linkWithRel("self").description("상품 리뷰 리스트 현재 페이지 링크"),
                                linkWithRel("last").description("상품 리뷰 리스트 마지막 페이지 링크"),
                                linkWithRel("profile").description("상품 리뷰 리스트 API 문서 링크")
                        ),
                        responseFields(
                                fieldWithPath("_embedded.reservationUserCommentDtoList").description("상품 리뷰 리스트"),
                                fieldWithPath("_links.first.href").description("상품 리뷰 리스트 첫 페이지 링크"),
                                fieldWithPath("_links.prev.href").description("상품 리뷰 리스트 이전 페이지 링크"),
                                fieldWithPath("_links.self.href").description("상품 리뷰 리스트 현재 페이지 링크"),
                                fieldWithPath("_links.last.href").description("상품 리뷰 리스트 마지막 페이지 링크"),
                                fieldWithPath("_links.profile.href").description("상품 리뷰 리스트 API 문서 링크"),
                                fieldWithPath("page.size").description("한 페이지의 상품 리뷰 수"),
                                fieldWithPath("page.totalElements").description("전체 상품 리뷰 수"),
                                fieldWithPath("page.totalPages").description("전체 상품 리뷰 페이지 수"),
                                fieldWithPath("page.number").description("현재 페이지 인덱스"))
                        .andWithPrefix("_embedded.reservationUserCommentDtoList[].",reservationUserCommentDtoList))
                );
    }
}