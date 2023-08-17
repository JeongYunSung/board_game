rootProject.name = "JeongYunSung"

"omok".includeModules()

fun String.includeModules() {
    val files = mutableListOf<String>()

    findModules(files, rootProject.projectDir.canonicalPath + "/$this", 3)
    files.forEach {
        include(":$this:$it")
    }
}

fun findModules(files: MutableList<String>, path: String, depth: Int) {
    if (depth == 0)
        return

    val listFile = File(path).listFiles() ?: return

    for (file in listFile) {
        if (file.isFile() && file.name == "build.gradle.kts") {
            files.add(file.parentFile.name)
            continue
        }
        findModules(files, file.canonicalPath, depth - 1)
    }
}