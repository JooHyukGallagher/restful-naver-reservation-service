package me.weekbelt.reservation.web.controller;

import com.google.common.net.HttpHeaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("전시 상품 목록을 4개씩 두번째 페이지 조회")
    @Test
    public void getProducts() throws Exception {

        FieldDescriptor[] productList = new FieldDescriptor[]{
                fieldWithPath("id").description("상품 아이디"),
                fieldWithPath("categoryId").description("카테고리 아이디"),
                fieldWithPath("displayInfoId").description("해당 상품의 전시 정보 아이디"),
                fieldWithPath("name").description("카테고리 명칭"),
                fieldWithPath("description").description("상품 짧은 설명"),
                fieldWithPath("content").description("상품 상세 설명"),
                fieldWithPath("event").description("해당 상품의 이벤트"),
                fieldWithPath("openingHours").description("전시 상품의 오픈 시간"),
                fieldWithPath("placeName").description("전시 장소 이름"),
                fieldWithPath("placeLot").description("전시 장소 위치"),
                fieldWithPath("placeStreet").description("전시 장소 상세 정보"),
                fieldWithPath("tel").description("전시 상품 문의 전화번호"),
                fieldWithPath("homepage").description("전시 상품 홈페이지"),
                fieldWithPath("email").description("전시 상품 문의 이메일"),
                fieldWithPath("createDate").description("전시 상품 생성 날짜"),
                fieldWithPath("modifyDate").description("전시 상품 수정 날짜"),
                fieldWithPath("fileId").description("상품 이미지 아이디"),
                fieldWithPath("_links.self.href").description("현재 상품 정보 링크")
        };

        String requestUri = "/api/v1/displayinfos";
        mockMvc.perform(get(requestUri)
                .param("categoryId", "1")
                .param("page", "1")
                .param("size", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("product-list",
                        links(
                                linkWithRel("self").description("현재 페이지 전시상품 목록"),
                                linkWithRel("first").description("첫 번째 페이지 전시상품 목록"),
                                linkWithRel("prev").description("이전 페이지 전시상품 목록"),
                                linkWithRel("next").description("다음 페이지 전시상품 목록"),
                                linkWithRel("last").description("마지막 페이지 전시상품 목록"),
                                linkWithRel("profile").description("해당 API 문서")
                        ),
                        requestParameters(
                                parameterWithName("categoryId").description("카테고리 아이디"),
                                parameterWithName("page").description("전시상품 목록 페이지"),
                                parameterWithName("size").description("한 페이지에 보여줄 전시상품 개수")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-Type 헤더")
                        ),
                        responseFields(
                                fieldWithPath("_embedded.productDtoList").description("상품 목록"),
                                fieldWithPath("_links.first.href").description("첫 번째 페이지 전시상품 목록"),
                                fieldWithPath("_links.prev.href").description("이전 페이지 전시상품 목록"),
                                fieldWithPath("_links.self.href").description("현재 페이지 전시상품 목록"),
                                fieldWithPath("_links.next.href").description("다음 페이지 전시상품 목록"),
                                fieldWithPath("_links.last.href").description("마지막 페이지 전시상품 목록"),
                                fieldWithPath("_links.profile.href").description("해당 API 문서"),
                                fieldWithPath("page.size").description("한 페이지의 전시상품 목록 개수"),
                                fieldWithPath("page.totalElements").description("해당 카테고리의 전체 전시상품 목록 개수"),
                                fieldWithPath("page.totalPages").description("해당 카테고리의 상품목록 페이지 수"),
                                fieldWithPath("page.number").description("현재 페이지(0부터 시작)")
                        ).andWithPrefix("_embedded.productDtoList[].", productList)
                ));
    }

}