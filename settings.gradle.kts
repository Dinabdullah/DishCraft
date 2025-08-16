pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DishCraft"
include(":app")
include(":feature_home")
include(":feature_details")
include(":feature_favourite")
include(":feature_auth")
include(":core_ui")
include(":core_network")
include(":feature_home:home_ui")

include(":feature_home:home_data")
include(":feature_details:details_ui")

include(":feature_details:details_data")
include(":feature_favourite:favourite_ui")

include(":feature_favourite:favourite_data")
include(":feature_auth:auth_ui")

include(":feature_auth:auth_data")

include(":feature_auth:auth_domain")
include(":feature_details:details_domain")
include(":feature_favourite:favourite_domain")
include(":feature_home:home_domain")
include(":sharedPreferences")
