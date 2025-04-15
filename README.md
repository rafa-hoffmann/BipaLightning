## Build tools & versions used

- Kotlin
- Jetpack Compose
- Retrofit
- Koin
- JUnit
- Turbine
- Coroutines
- Flow
- Kotlin Datetime
- Kotlin Serialization

## Steps to run the app

Open the project with Android Studio and run the ":app" configuration

## What areas of the app did you focus on?

I've focused most on the architecture and modularization, following clean architecture and MVVM +
Repository, so the app can be easily maintainable and scalable. Also, I've used the latest
recommended approaches by Google,
such as single activity pattern and usage of Jetpack Compose.

## What was the reason for your focus? What problems were you trying to solve?

I've tried to show my knowledge of Android, so that the project is easy to understand and, at the
same time, robust enough so that the core approaches can be easily adapted to be used in a large
app.

## How long did you spend on this project?

Around 3-4 hours.

## Did you make any trade-offs for this project? What would you have done differently with more time?

With more time, I think the test coverage can be improved, adding unit tests for the network module,
to test the serialization of a mocked json and using Mockk to test different results on reloading
events.
Also, as the project grows, it would be good to create gradle plugins, so we can have a single point
setting up all build gradle configurations, such as compile sdk version and dependencies.

## What do you think is the weakest part of your project?

Definitely the UI. It's using all default Material3 components, only the colors were changed.

## Is there any other information you’d like us to know?

Not really, it was a good test to show a lot of what I know about Android and software development
in general.