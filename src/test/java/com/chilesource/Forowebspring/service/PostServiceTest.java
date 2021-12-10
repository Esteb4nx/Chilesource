package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.model.Post;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PostServiceTest {

    @Autowired
    PostService postService; // inyección de dependencia

    @Nested
    class Consulta_obtiene_publicaciones {

        @DisplayName("Por id categoría existente")
        @ParameterizedTest(name = "Por ejemplo, {0} es una id válida.")
        @ValueSource(ints = {1, 2, 3})
        void by_category_id(int id) {
            assertNotNull(postService.findAllByCategoryId(id));
        }

        @DisplayName("Por categoría y por fecha descendente")
        @RepeatedTest(3)
        void by_category_id_ordered_by_date_desc() {
            ArrayList<Post> allLatest = (ArrayList<Post>) postService.findAllByCategoryIdOrderByDateDesc(1);
            Post first = allLatest.get(0);
            Post second = allLatest.get(1);
            assertTrue(first.getDate().getTime() > second.getDate().getTime());
        }

        @DisplayName("Por autor y ordenados fecha ascendente")
        @Test
        void by_author_id_ordered_by_date_asc() {
            ArrayList<Post> firstPosts = (ArrayList<Post>) postService.findAllByAuthorIdOrderByDateAsc(1);
            Post first = (Post) firstPosts.get(0);
            Post second = (Post) firstPosts.get(1);
            for (Post post :
                    firstPosts) {
                System.out.println(post.getDate().getTime());
            }
            assertTrue(first.getDate().getTime() < second.getDate().getTime());
        }
    }

    @Nested
    class Consulta_falla_por_id_categoria {

        @DisplayName("errónea")
        @ParameterizedTest(name = "Por ejemplo, {0} es una id incorrecta")
        @MethodSource("invalidIdProvider")
        void by_bad_category_id(int id) {
            assertThrows(java.lang.IllegalArgumentException.class, () -> postService.findAllByCategoryId(id));
        }

        @DisplayName("errónea y ordenado por fecha desc.")
        @ParameterizedTest(name = "Por ejemplo, {0} es una id incorrecta")
        @MethodSource("invalidIdProvider")
        void by_bad_category_id_ordered_by_date_desc(int id) {
            assertThrows(java.lang.IllegalArgumentException.class, () -> postService.findAllByCategoryIdOrderByDateDesc(id));
        }

        @DisplayName("errónea y ordenado por fecha asc.")
        @ParameterizedTest(name = "Por ejemplo, {0} es una id incorrecta")
        @MethodSource("invalidIdProvider")
        void by_bad_author_id_ordered_by_date_asc(int id) {
            assertThrows(java.lang.IllegalArgumentException.class, () -> postService.findAllByAuthorIdOrderByDateAsc(id));
        }

        static Stream<Integer> invalidIdProvider() {
            return Stream.of(-1, -2, -2147483647);
        }
    }




}