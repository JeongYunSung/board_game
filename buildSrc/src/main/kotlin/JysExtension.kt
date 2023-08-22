import org.gradle.api.Action
import org.gradle.api.plugins.ExtensionAware
import org.gradle.testing.base.TestingExtension
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension

internal fun org.gradle.api.Project.`jysAllOpen`(configure: Action<AllOpenExtension>): Unit =
    (this as ExtensionAware).extensions.configure("allOpen", configure)