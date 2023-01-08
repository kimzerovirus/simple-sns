package me.kzv.simpleboard.domain.tag

import me.kzv.simpleboard.domain.tag.entity.Tag
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class TagService(
    private val tagRepository: TagRepository,
) {
    fun getTagListByBoardId(boardId: Long){

    }

    @Transactional
    fun createNotExistTag(tagNames: Set<String>): List<Tag> = tagRepository.saveAll(findNotExistTag(tagNames))

    private fun findNotExistTag(tagNames: Set<String>): List<Tag> {
        val existTags = tagRepository.findByNameIn(tagNames)
        val existTagNames = existTags.map { it.name }
        val tagList = existTags.toMutableList()
        tagNames.forEach { if(!existTagNames.contains(it)) tagList.add(Tag(it)) }
        return tagList
    }
}