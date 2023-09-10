# DogBreeds - Clean Architecture and MVVM
This simple project probably doesn't need this overengineering, it is just an example of clean architecture and MVVM pattern written in kotlin.
No template was used on this project.

![Alt text](README_FILES/clean-architecture-own-layers.png?raw=true "Clean Architecture Layers")

## Layers
* **Presentation Layer (MVVM)** = Contains all the Android UI related code (activities, fragments, views) and view models.
* **Use Cases Layer** = These are mainly the actions that the user can trigger. They are called by the presentation layer and they will execute the business logic.
* **Domain Layer** = These are the rules of your business.
* **Data Layer (Repositoy Pattern)** = Contains the abstract definition of the different data sources, and how they should be used.
* **Framework Layer** = Contains the implementation of the different data sources.

### Interaction between layers
![Alt text](README_FILES/clean-architecture-own-layers.png?raw=true "Layer interaction")

## Architecture concepts used here
* Clean Architecture https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
* Repository Pattern https://developer.android.com/codelabs/basic-android-kotlin-training-repository-pattern#3
* MVVM https://medium.com/@ami0275/mvvm-clean-architecture-pattern-in-android-with-use-cases-eff7edc2ef76
* Dependency Injection https://developer.android.com/training/dependency-injection
* Unidirectional Data Flow https://developer.android.com/jetpack/compose/architecture#:~:text=A%20unidirectional%20data%20flow%20(UDF,that%20store%20and%20change%20state