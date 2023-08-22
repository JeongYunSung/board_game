plugins {
    id("jys.spring-convention")
    id("org.jetbrains.kotlin.plugin.jpa")
}

jysAllOpen {
    annotations(
        "javax.persistence.Entity",
        "javax.persistence.Embeddable",
        "javax.persistence.MappedSuperClass"
    )
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}