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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PromotionApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("프로모션 상품 목록 조회")
    @Test
    public void promotions() throws Exception {
        FieldDescriptor[] promotionList = new FieldDescriptor[]{
                fieldWithPath("id").description("프로모션 식별 아이디"),
                fieldWithPath("productId").description("상품 식별 아이디"),
                fieldWithPath("categoryId").description("카테고리 식별 아이디"),
                fieldWithPath("displayInfoId").description("전시 상품 식별 아이디"),
                fieldWithPath("categoryName").description("카테고리명"),
                fieldWithPath("description").description("상품 설명"),
                fieldWithPath("fileId").description("상품 메인사진 식별 아이디")
        };

        String requestUri = "/api/v1/promotions";
        mockMvc.perform(get(requestUri))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("promotion-list",
                        links(
                                linkWithRel("self").description("현재 링크"),
                                linkWithRel("profile").description("프로모션목록 API 문서 링크")
                        ),
                        responseFields(
                                fieldWithPath("_embedded.promotionDtoList").description("프로모션 상품 목록"),
                                fieldWithPath("_links.self.href").description("현재 링크"),
                                fieldWithPath("_links.profile.href").description("프로모션목록 API 문서 링크"),
                                fieldWithPath("_embedded.promotionDtoList[]._links.self.href").description("현재 링크")
                        ).andWithPrefix("_embedded.promotionDtoList[]", promotionList)));
    }
}