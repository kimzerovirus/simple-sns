import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
//    kotlin("kapt") version "1.7.21" //Querydsl
}

group = "me.kzv"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    // Querydsl 추가
//    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
//    kapt("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
//    kapt("jakarta.annotation:jakarta.annotation-api")
//    kapt("jakarta.persistence:jakarta.persistence-api")

    // 조회용 쿼리 Querydsl -> JdbcTemplate
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    
    // jwt 토큰
    implementation(group = "io.jsonwebtoken", name = "jjwt-api", version = "0.11.2")
    runtimeOnly(group = "io.jsonwebtoken", name = "jjwt-impl", version = "0.11.2")
    runtimeOnly(group = "io.jsonwebtoken", name = "jjwt-jackson", version = "0.11.2")
}
    
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
