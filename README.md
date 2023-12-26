Sample project represeting a bug which occurs in multi-NavHost android app architecture. To reproduce the bug quickly click the in-app "back" button twice on the Screen 2.2 and Screen 2.1

To fix the bug you can either:
- switch to "AppNewNavGraph" in the MainActivity
- disable navigation animations by uncommenting lines 27 and 28 in the AppNavGraph.kt 
- switch to 2.6.0 version of the navigation-compose library in app build.gradle
