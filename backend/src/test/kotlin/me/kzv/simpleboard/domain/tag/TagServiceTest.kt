package me.kzv.simpleboard.domain.tag

import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.domain.tag.entity.Tag
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class TagServiceTest{
    @Autowired lateinit var tagService: TagService
    @Autowired lateinit var tagRepository: TagRepository

    @BeforeEach
    fun create(){
        tagRepository.save(Tag("#해시~% 태그"))
    }

    @Test
    fun `해시태그 특수문자 공백 제거 테스트`() {
        val tag = tagRepository.findByIdOrNull(1) ?: throw EntityNotFoundException()
        assertThat(tag.name).isEqualTo("해시태그")
    }

    @Test
    fun `새로운 해시태그만 저장`() {
        //given
        val tagNames = mutableSetOf("해시태그","새로운태그1","새로운태그2","해시태그")
        //when
        val tags = tagService.createNotExistTag(tagNames)

        for (tag in tags) {
            println(tag.name)
        }

        //then
        assertThat(tags.size).isEqualTo(3)
    }
}