package me.kzv.core.worldcupmodel.domain

import jakarta.persistence.*
import me.kzv.core.support.exception.SimpleError
import me.kzv.core.support.exception.SimpleException
import me.kzv.core.support.jpa.BaseAggregateRoot

@Entity
@Table(
    name = "worldcupmodel"
)
class WorldCupModel(

    /** 모델 url */
    @Column(nullable = false)
    val url: String,
) : BaseAggregateRoot<WorldCupModel>() {

    /** 모델 유형 */
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var modelType: ModelType = findType()

    private fun findType(): ModelType {
        val modelSource = this.url.lowercase()

        return when {
            modelSource.contains("jpg") -> ModelType.IMG
            modelSource.contains("jpeg") -> ModelType.IMG
            modelSource.contains("png") -> ModelType.IMG
            modelSource.contains("gif") -> ModelType.IMG
            modelSource.contains("youtube") -> ModelType.YOUTUBE
            modelSource.contains("imgur") -> ModelType.IMGUR
            modelSource.contains("gfycat") -> ModelType.GFYCAT
            else -> throw SimpleException(SimpleError.UNKNOWN_MODEL_TYPE)
        }
    }
}
