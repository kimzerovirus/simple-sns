package me.kzv.simpleboard.domain.img.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUploadImg is a Querydsl query type for UploadImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUploadImg extends EntityPathBase<UploadImg> {

    private static final long serialVersionUID = -2046592139L;

    public static final QUploadImg uploadImg = new QUploadImg("uploadImg");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgNm = createString("imgNm");

    public final EnumPath<ImgType> imgType = createEnum("imgType", ImgType.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final StringPath originImgNm = createString("originImgNm");

    public QUploadImg(String variable) {
        super(UploadImg.class, forVariable(variable));
    }

    public QUploadImg(Path<? extends UploadImg> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUploadImg(PathMetadata metadata) {
        super(UploadImg.class, metadata);
    }

}

