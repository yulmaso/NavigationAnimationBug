Sample project representing a bug which occurs in multi-NavHost android navigation architecture project. To reproduce the bug quickly click the in-app "back" button twice on the Screen 2.2 and Screen 2.1. Instead of the Screen 1.1 you will see a blank screen which is unexpected. Notice that doubleclicking on the system "back" button doesn't lead to the same effect.

To get around the bug you can either:
- disable enterTransition and exitTransition for all NavHosts
- downgrade to 2.6.0 version of the navigation-compose library
- switch to navigation() extension function to build nested graphs instead of using nested NavHost
  
[bug.webm](https://github.com/yulmaso/NavigationAnimationBug/assets/26647205/8260a6d5-cd1f-430a-a080-00f846eafd2b)
