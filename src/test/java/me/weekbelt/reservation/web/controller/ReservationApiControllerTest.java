package me.weekbelt.reservation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
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
        String requestUri = "/api/v1/comments";
        mockMvc.perform(get(requestUri)
                .param("productId", "1")
                .param("page", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("page").exists())
                .andExpect(jsonPath("_embedded.reservationUserCommentDtoList").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andDo(document("comment-list"))
//        .andExpect(jsonPath("_embedded.links.profile").exists())
        ;
    }
}