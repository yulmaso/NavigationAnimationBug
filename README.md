Sample project represeting a bug which occurs in multi-NavHost android navigation architecture project. To reproduce the bug quickly click the in-app "back" button twice on the Screen 2.2 and Screen 2.1. Instead of the Screen 1.1 you will see a blank screen which is unexpected. Notice that doubleclicking on the system "back" button doesn't lead to the same effect.

To fix the bug you can either:
- switch to "AppNewNavGraph" in the MainActivity which contains only single NavHost and uses navigation() extension function to build nested graph
- disable navigation animations by uncommenting lines 27 and 28 in the AppNavGraph.kt 
- downgrade to 2.6.0 version of the navigation-compose library in app build.gradle
  
[bug.webm](https://github.com/yulmaso/NavigationAnimationBug/assets/26647205/8260a6d5-cd1f-430a-a080-00f846eafd2b)
